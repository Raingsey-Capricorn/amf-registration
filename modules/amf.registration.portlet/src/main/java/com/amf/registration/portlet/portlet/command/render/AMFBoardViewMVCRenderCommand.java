package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.model.AMFUser;
import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.portlet.constants.PageConstants;
import com.amf.registration.service.AMFUserLocalService;
import com.amf.registration.service.AMFUserLocalServiceUtil;
import com.amf.registration.utilities.EventStatus;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * project-name : amf-registration
 * package-name : com.amf.registration.portlet.portlet.command.action
 * author       : Pisethraingsey SUON
 * email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * crated-date  : 4/09/2021
 */
@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=/",
                "mvc.command.name=" + MVCCommandNames.AMF_DISPLAY_EVENTS,
        },
        service = MVCRenderCommand.class
)
public class AMFBoardViewMVCRenderCommand implements MVCRenderCommand {
    /**
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortletException
     */
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        if (((ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY)).isSignedIn()) {
            return displayEventBoard(renderRequest);
        } else {
            renderRequest.setAttribute("regions", regionService.getRegions(19));
            return "/fragments/registration.jsp";
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

        try {
            User loggedInUser = userService.getCurrentUser();
            List<AMFUser> amfUsers = AMFUserLocalServiceUtil.getAMFUsers(start, end);

            String tabIndex = ParamUtil.getString(renderRequest, "tabIndex").toLowerCase(Locale.ROOT);
            switch (tabIndex) {
                case PageConstants.TAB_PROFILE:
                    AMFUser amfUser = AMFUserLocalServiceUtil.getAMFUserByGroupUserAndUserName(loggedInUser.getGroupId(), loggedInUser.getUserId(), loggedInUser.getScreenName());
                    renderRequest.setAttribute("amfUser", amfUser);
                    break;

                case PageConstants.TAB_ALL:
                    renderRequest.setAttribute("amfUsers", amfUsers);
                    renderRequest.setAttribute("amfUserCount", amfUsers.size());
                    break;

                case PageConstants.TAB_REGISTRATION:
                    renderRequest.setAttribute("amfUsers",
                            amfUsers.stream().filter(user -> user.getEventStatus().equalsIgnoreCase(EventStatus.REGISTER)).collect(Collectors.toList()));
                    renderRequest.setAttribute("amfUserCount", amfUsers.size());
                    break;

                case PageConstants.TAB_LOGIN:
                    renderRequest.setAttribute("amfUsers",
                            amfUsers.stream().filter(user -> user.getEventStatus().equalsIgnoreCase(EventStatus.LOGIN)).collect(Collectors.toList()));
                    renderRequest.setAttribute("amfUserCount", amfUsers.size());
                    break;
            }

            return "/fragments/events-board.jsp";
        } catch (PortalException pe) {
            return "";
        }


    }

    @Reference
    private UserService userService;

    @Reference
    AMFUserLocalService service;

    @Reference
    private RegionService regionService;
}
