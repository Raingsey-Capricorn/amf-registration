package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.model.AMFEventLog;
import com.amf.registration.model.AMFUser;
import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.portlet.constants.PageConstants;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        String tabIndex = ParamUtil.getString(renderRequest, "tabIndex").toLowerCase(Locale.ROOT);
        List<AMFEventLog> eventLogs = new ArrayList<>();
        try {
            User loggedInUser = userService.getCurrentUser();
            boolean adminFlag = loggedInUser.getRoles().get(0).getDescriptiveName().equals("Administrator");
            switch (tabIndex) {
                case PageConstants.TAB_PROFILE:
                    if (!adminFlag) {
                        AMFUser amfUser = AMFUserLocalServiceUtil.getAMFUserByGroupUserAndUserName(loggedInUser.getGroupId(), loggedInUser.getUserId(), loggedInUser.getScreenName());
                        renderRequest.setAttribute("amfUser", amfUser);
                    }
                    break;

                case PageConstants.TAB_ALL:
                    if (adminFlag) {
                        eventLogs.addAll(AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), EventStatus.ALL, start, end));
                    } else {
                        eventLogs.addAll(AMFEventLogLocalServiceUtil.getAMFEventLogs(start, end));
                    }
                    setRequestAttribute(renderRequest, eventLogs);
                    break;

                case PageConstants.TAB_REGISTRATION:
                    if (adminFlag) {
                        eventLogs.addAll(AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), EventStatus.REGISTER, start, end));
                    } else {
                        eventLogs.addAll(AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), loggedInUser.getUserId(), EventStatus.REGISTER, start, end));
                    }
                    setRequestAttribute(renderRequest, eventLogs);
                    break;

                case PageConstants.TAB_LOGIN:
                    if (adminFlag) {
                        eventLogs.addAll(AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), EventStatus.LOGIN, start, end));
                    } else {
                        eventLogs.addAll(AMFEventLogLocalServiceUtil.getAMFEventLogBy(loggedInUser.getGroupId(), loggedInUser.getUserId(), EventStatus.LOGIN, start, end));
                    }
                    setRequestAttribute(renderRequest, eventLogs);
                    break;
            }

            return "/fragments/events-board.jsp";
        } catch (PortalException pe) {
            return "";
        }
    }

    /**
     * @param renderRequest
     * @param eventLogs
     */
    private void setRequestAttribute(RenderRequest renderRequest, List<AMFEventLog> eventLogs) {
        renderRequest.setAttribute("amfEvents", eventLogs);
        renderRequest.setAttribute("amfEventCount", eventLogs.size());
    }


    @Reference
    private UserService userService;

    @Reference
    AMFUserLocalService service;

    @Reference
    private RegionService regionService;
}
