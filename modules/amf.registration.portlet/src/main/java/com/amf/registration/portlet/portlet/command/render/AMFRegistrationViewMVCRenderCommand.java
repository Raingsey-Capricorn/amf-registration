package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.portlet.display.context.AMFToolbarDisplayContext;
import com.amf.registration.service.AMFUserLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.HashMap;

/**
 * project-name : amf-registration
 * package-name : com.amf.registration.portlet.portlet.command
 * author       : Pisethraingsey SUON
 * email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * crated-date  : 4/18/2021
 */
@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=/",
                "mvc.command.name=" + MVCCommandNames.AMF_SEARCH_MEMBERS
        },
        service = MVCRenderCommand.class
)
public class AMFRegistrationViewMVCRenderCommand implements MVCRenderCommand {
    /**
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortletException
     */
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        LiferayPortletRequest liferayPortletRequest = portal.getLiferayPortletRequest(renderRequest);
        LiferayPortletResponse liferayPortletResponse = portal.getLiferayPortletResponse(renderResponse);
        AMFToolbarDisplayContext displayContext = new AMFToolbarDisplayContext(
                portal.getHttpServletRequest(renderRequest),
                liferayPortletRequest,
                liferayPortletResponse
        );
        renderRequest.setAttribute("displayContext", displayContext);
        addAMFUsersToDisplay(renderRequest);
        return "/search.jsp";
    }

    /**
     * @param renderRequest
     */
    private void addAMFUsersToDisplay(RenderRequest renderRequest) {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;
        Integer postalCode = ParamUtil.getInteger(renderRequest, "keywords");

        HashMap<String, Object> amfUserHashMap = AMFUserLocalServiceUtil.getAMFUserBaseOnPostalCode(themeDisplay.getScopeGroupId(), postalCode, start, end);
        renderRequest.setAttribute("amfUsers", amfUserHashMap.get("amfUsers"));
        renderRequest.setAttribute("amfUserCount", amfUserHashMap.get("amfUserCount"));

    }

    @Reference
    private Portal portal;

}
