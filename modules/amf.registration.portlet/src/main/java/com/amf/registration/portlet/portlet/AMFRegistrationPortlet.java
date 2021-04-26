package com.amf.registration.portlet.portlet;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author       : Pisethraingsey SUON
 * @project-name : amf-registration
 * @package-name : com.amf.registration.portlet.portlet.command.action
 * @email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * @crated-date  : 03/25/2021
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AMFRegistration",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/search.jsp",
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AMFRegistrationPortlet extends MVCPortlet {
}