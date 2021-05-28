package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.exception.AMFUserValidationException;
import com.amf.registration.model.AMFUser;
import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.portlet.constants.PageConstants;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.amf.registration.service.AMFUserGroupServiceUtil;
import com.amf.registration.service.AMFUserLocalServiceUtil;
import com.amf.registration.utilities.EventStatus;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import lombok.SneakyThrows;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.HashMap;

/**
 * @project-name : amf-registration
 * @package-name : com.amf.registration.portlet.portlet.command.action
 * @author       : Pisethraingsey SUON
 * @email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * @crated-date  : 4/09/2021
 */
@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=/",
                "mvc.command.name=" + MVCCommandNames.AMF_DISPLAY_EVENTS,
                "mvc.command.name=" + MVCCommandNames.AMF_SEARCH_MEMBERS,
                "mvc.command.name=" + MVCCommandNames.AMF_CLEAR_SEARCH
        },
        service = MVCRenderCommand.class
)
public class AMFBoardViewMVCRenderCommand implements MVCRenderCommand {

    private String currentTabIndex = "";

    /**
     * This render method determines which page to be displayed based on sign-in status
     *
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortletException
     */
    @SneakyThrows
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        if (themeDisplay.isSignedIn()) {
            return displayEventBoard(renderRequest);
        } else {
            addAMFUsersToDisplay(renderRequest);
            return "/search.jsp";
        }
    }

    /**
     * @param renderRequest
     * @return
     */
    private String displayEventBoard(RenderRequest renderRequest) {

        int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;

        String selectedTab = ParamUtil.getString(renderRequest, "tabIndex");
        if (selectedTab != null && !selectedTab.isEmpty()) {
            currentTabIndex = selectedTab;
            renderRequest.getPortletSession().setAttribute("selectedTab", selectedTab);
        } else {
            selectedTab = (String) renderRequest.getPortletSession().getAttribute("selectedTab");
            renderRequest.setAttribute("selectedTab", selectedTab);
        }
        HashMap<String, Object> objectHashMap = new HashMap<>();
        try {
            User loggedInUser = userService.getCurrentUser();
            boolean isAdministrator = loggedInUser.getRoles().stream().anyMatch(role -> role.getName().equals("AMF_Superuser") || role.getName().equals("Administrator"));

            if (isAdministrator) {
                try{
                    boolean userGroupExiting = AMFUserGroupServiceUtil.isAMFUserGroupExiting();
                }catch (NoSuchUserGroupException e){
                    SessionErrors.add(renderRequest, "amfUserGroupMissing", AMFUserGroupServiceUtil.MESSAGE);
                }
            }

            switch (currentTabIndex) {

                case PageConstants.TAB_PROFILE:
                    if (!isAdministrator) {
                        AMFUser amfUser = AMFUserLocalServiceUtil.getAMFUserByGroupUserAndUserName(loggedInUser.getGroupId(), loggedInUser.getUserId(), loggedInUser.getScreenName());
                        renderRequest.setAttribute("amfUser", amfUser);
                    }
                    break;

                case PageConstants.TAB_ALL:
                    if (isAdministrator) {
                        objectHashMap = AMFEventLogLocalServiceUtil.getAMFEventLogs(loggedInUser.getGroupId(), start, end);
                    } else {
                        objectHashMap = AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), loggedInUser.getUserId(), EventStatus.ALL, start, end);
                    }
                    break;

                case PageConstants.TAB_REGISTRATION:
                    if (isAdministrator) {
                        objectHashMap = AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), EventStatus.REGISTER, start, end);
                    } else {
                        objectHashMap = AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), loggedInUser.getUserId(), EventStatus.REGISTER, start, end);
                    }
                    break;

                case PageConstants.TAB_LOGIN:
                    if (isAdministrator) {
                        objectHashMap = AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), EventStatus.LOGIN, start, end);
                    } else {
                        objectHashMap = AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), loggedInUser.getUserId(), EventStatus.LOGIN, start, end);
                    }
                    break;
            }

            renderRequest.setAttribute("amfEvents", objectHashMap.get("eventLogs"));
            renderRequest.setAttribute("amfEventCount", objectHashMap.get("total"));
            renderRequest.setAttribute("selectedTab", currentTabIndex);
            return "/fragments/events-board.jsp";
        } catch (PortalException pe) {
            return "/fragments/events-board.jsp";
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            return "/fragments/events-board.jsp";
        }
    }

    /**
     * @param renderRequest
     */
    private void addAMFUsersToDisplay(RenderRequest renderRequest) {

        int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;
        long postalCode = ParamUtil.getLong(renderRequest, "keywords");

        HashMap<String, Object> amfUserHashMap = AMFUserLocalServiceUtil.getAMFUserBaseOnPostalCode(postalCode, start, end);
        renderRequest.setAttribute("amfUsers", amfUserHashMap.get("amfUsers"));
        renderRequest.setAttribute("amfUserCount", amfUserHashMap.get("amfUserCount"));

    }

    @Reference
    private UserService userService;

}
