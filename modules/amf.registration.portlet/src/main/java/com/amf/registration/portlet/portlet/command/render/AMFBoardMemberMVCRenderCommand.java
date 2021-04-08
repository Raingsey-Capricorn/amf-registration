package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.portlet.display.context.AMFToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.AMF_VIEW_MEMBERS
        },
        service = MVCRenderCommand.class
)
public class AMFBoardMemberMVCRenderCommand implements MVCRenderCommand {
    /**
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortletException
     */
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        AMFToolbarDisplayContext displayContext = new AMFToolbarDisplayContext(
                portal.getHttpServletRequest(renderRequest),
                portal.getLiferayPortletRequest(renderRequest),
                portal.getLiferayPortletResponse(renderResponse)
        );
        addAMFUserListAttribute(renderRequest);
        renderRequest.setAttribute("toolbarDisplayContext", displayContext);
        return "/view.jsp";
    }

    /**
     * @param renderRequest
     */
    private void addAMFUserListAttribute(RenderRequest renderRequest) {
        int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;
        List<User> users = UserLocalServiceUtil.getUsers(start, end);//getAMFUsersByKeywords(themeDisplay.getScopeGroupId(), keywords, start, end, comparator);
        renderRequest.setAttribute("users", users);
        renderRequest.setAttribute("userCount", users.size());
    }

    @Reference
    private Portal portal;
}
