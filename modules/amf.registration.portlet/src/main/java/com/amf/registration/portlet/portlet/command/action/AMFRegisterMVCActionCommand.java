package com.amf.registration.portlet.portlet.command.action;

import com.amf.registration.exception.AMFUserValidationException;
import com.amf.registration.model.AMFUser;
import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.amf.registration.service.AMFUserService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.text.SimpleDateFormat;

@Component(
        property = {
                "javax.portlet.name=" + AMFRegistrationPortletKeys.AMF_REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.AMF_ADD
        },
        service = MVCActionCommand.class
)
public class AMFRegisterMVCActionCommand extends BaseMVCActionCommand {
    /**
     * @param actionRequest
     * @param actionResponse
     * @return
     * @throws PortletException
     */
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(AMFUser.class.getName(), actionRequest);
        try {
            amfUserService.addAMFUser(
                    themeDisplay,
                    ParamUtil.getString(actionRequest, "userName"),
                    ParamUtil.getString(actionRequest, "firstName"),
                    ParamUtil.getString(actionRequest, "lastName"),
                    ParamUtil.getString(actionRequest, "emailAddress"),
                    ParamUtil.getString(actionRequest, "gender"),
                    new SimpleDateFormat("yyyy-mm-dd").parse(ParamUtil.getString(actionRequest, "date_of_birth")),
                    ParamUtil.getString(actionRequest, "password"),
                    ParamUtil.getString(actionRequest, "confirmedPassword"),
                    ParamUtil.getString(actionRequest, "homePhone"),
                    ParamUtil.getString(actionRequest, "mobilePhone"),
                    ParamUtil.getString(actionRequest, "address"),
                    ParamUtil.getString(actionRequest, "address2"),
                    ParamUtil.getString(actionRequest, "city"),
                    ParamUtil.getString(actionRequest, "region"),
                    ParamUtil.getString(actionRequest, "zip"),
                    ParamUtil.getString(actionRequest, "securityQuestion"),
                    ParamUtil.getString(actionRequest, "securityAnswer"),
                    ParamUtil.getString(actionRequest, "acceptedTou"),
                    serviceContext
            );
            SessionMessages.add(actionRequest, "amfUserAdded");
            sendRedirect(actionRequest, actionResponse);
        } catch (AMFUserValidationException validationException) {
            validationException.getErrors().forEach(error -> SessionErrors.add(actionRequest, error));
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.AMF_REGISTER);
        } catch (PortalException e) {
            SessionErrors.add(actionRequest, "serviceErrorDetails", e.getMessage());
            actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.AMF_REGISTER);
        }

    }

    @Reference
    private AMFUserService amfUserService;
}
