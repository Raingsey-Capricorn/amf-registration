package com.amf.newsletters.portlet.portlet;

import com.amf.newsletters.portlet.constants.AMFNewsLettersPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author       : Pisethraingsey SUON
 * @project-name : amf-registration
 * @package-name : com.amf.newsletters.portlet.constants
 * @email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * @crated-date  : 4/28/2021 - 8:50 AM
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AMFNewsletters",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AMFNewsLettersPortletKeys.AMFNEWSLETTERS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AMFNewsLettersPortlet extends MVCPortlet {
}