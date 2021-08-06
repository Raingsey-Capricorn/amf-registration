package com.amf.newsletter.portlet.portlet.action.render;

import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.portlet.constants.AMFNewsletterCommandNames;
import com.amf.newsletter.portlet.constants.AMFNewsletterPortletKeys;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;
import com.amf.newsletter.service.AMFIssueLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Date;
import java.util.List;

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
        List<AMFIssue> amfAMFIssues = AMFIssueLocalServiceUtil.getAMFIssuesWithinYear(new Date());
        renderRequest.setAttribute("amfIssues", amfAMFIssues);
        renderRequest.setAttribute("amfIssueCount", amfAMFIssues.size());
        return "/view.jsp";
    }

}