package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.model.AMFUser;
import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.service.AMFUserLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * project-name : amf-registration
 * package-name : com.amf.registration.portlet.portlet.command.action
 * author       : Pisethraingsey SUON
 * email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * crated-date  : 03/25/2021
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.AMF_EDIT
        },
        service = MVCRenderCommand.class
)
public class AMFUserProfileInfoMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            User loggedInUser = userService.getCurrentUser();
            AMFUser amfUser = AMFUserLocalServiceUtil.getAMFUserByGroupUserAndUserName(loggedInUser.getGroupId(), loggedInUser.getUserId(), loggedInUser.getScreenName());
            renderRequest.setAttribute("amfUser", amfUser);
            return "/fragments/registration.jsp";
        } catch (PortalException pe) {
            throw new PortletException(pe);
        }
    }

    @Reference
    private UserService userService;

}
