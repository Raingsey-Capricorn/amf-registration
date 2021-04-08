package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * This render command will switch the view for user and admin
 */
@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.AMF_DISPLAY_EVENT_REGISTRATION
        },
        service = MVCRenderCommand.class
)
public class AMFBoardEventRegistrationMVCRenderCommand implements MVCRenderCommand {
    /**
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortletException
     */
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        //Todo : this will be user the permission check for admin and user
//        if (((ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY)).isSignedIn()) {
        int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
        int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;
        List<User> users = UserLocalServiceUtil.getUsers(start, end);
        renderRequest.setAttribute("users", users);
        renderRequest.setAttribute("userCount", users.size());
        return "/fragments/events-board.jsp";
//        }
    }

}
