package com.amf.registration.portlet.portlet.command.render;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.AMF_VIEW_MEMBER_INFO
        },
        service = MVCRenderCommand.class
)
public class AMFUserProfileInfoMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long amfUserId = ParamUtil.getLong(renderRequest, "amfUserId", 0);
        try {
            User user = UserLocalServiceUtil.getUser(amfUserId);
/*            DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("EEEEE, MMMMM dd, yyyy", renderRequest.getLocale());
            renderRequest.setAttribute("amfUser", amfUser);
            renderRequest.setAttribute("eventTime", dateFormat.format(amfUser.getCreateDate()));
            renderRequest.setAttribute("screenName", amfUser.getCompanyId());
            renderRequest.setAttribute("ipAddress", dateFormat.format(amfUser.getModifiedDate()));
            renderRequest.setAttribute("eventType", dateFormat.format(amfUser.getModifiedDate()));*/
            PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
            String redirect = renderRequest.getParameter("redirect");
            portletDisplay.setShowBackIcon(true);
            portletDisplay.setURLBack(redirect);
            return "/fragments/view-details.jsp";
        } catch (PortalException pe) {
            throw new PortletException(pe);
        }
    }

}
