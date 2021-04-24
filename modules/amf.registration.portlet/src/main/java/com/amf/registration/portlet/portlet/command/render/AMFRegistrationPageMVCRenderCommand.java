package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * project-name : amf-registration
 * package-name : com.amf.registration.portlet.portlet.command.render
 * author       : Pisethraingsey SUON
 * email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * crated-date  : 4/23/2021
 */
@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.AMF_REGISTER
        },
        service = MVCRenderCommand.class
)
public class AMFRegistrationPageMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/fragments/registration.jsp";
    }
}