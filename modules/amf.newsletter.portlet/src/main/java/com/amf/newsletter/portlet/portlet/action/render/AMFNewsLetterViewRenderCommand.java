package com.amf.newsletter.portlet.portlet.action.render;

import com.amf.newsletter.constants.AMFNewsletterCommandNames;
import com.amf.newsletter.constants.AMFNewsletterPortletKeys;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author : Raingsey
 * @project-name : amf-registration
 * @package-name : com.amf.newsletter.portlet.action.render
 * @email : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * @crated-date : 5/12/2021
 */
@Component(
        property = {
                "javax.portlet.name=" + AMFNewsletterPortletKeys.AMFNEWSLETTER,
                "mvc.command.name=/",
                "mvc.command.name=" + AMFNewsletterCommandNames.VIEW
        },
        service = MVCRenderCommand.class
)
public class AMFNewsLetterViewRenderCommand implements MVCRenderCommand {


    /**
     * @param renderRequest
     * @param renderResponse
     * @return
     * @throws PortletException
     */
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        System.out.println(AMFArticleLocalServiceUtil.getSampleAMFArticles());
        return "/view.jsp";
    }
}
