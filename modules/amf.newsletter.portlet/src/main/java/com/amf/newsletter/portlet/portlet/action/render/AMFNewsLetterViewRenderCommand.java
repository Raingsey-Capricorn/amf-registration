package com.amf.newsletter.portlet.portlet.action.render;

import com.amf.newsletter.model.AMFArticle;
import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.portlet.constants.AMFNewsletterCommandNames;
import com.amf.newsletter.portlet.constants.AMFNewsletterPortletKeys;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;
import com.amf.newsletter.service.AMFIssueLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

        List<AMFIssue> amfAMFIssues = AMFIssueLocalServiceUtil.getSampleAMFAmfIssues();

        AMFArticle articleOne = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleOne.setIssueNumber(new Random().nextInt(100));
        articleOne.setAuthor("Mc Andre");
        articleOne.setContent("Content-test-one");
        articleOne.setTitle("Example Title #1");
        articleOne.setNew(true);

        AMFArticle articleTwo = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleTwo.setIssueNumber(new Random().nextInt(100));
        articleTwo.setAuthor("Mc Andre");
        articleTwo.setContent("Content-test-one");
        articleTwo.setTitle("Example Title #2");
        articleTwo.setNew(true);

        AMFArticle articleThree = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleThree.setIssueNumber(new Random().nextInt(100));
        articleThree.setAuthor("Mc Andre");
        articleThree.setContent("Content-test-three");
        articleThree.setTitle("Example Title #3");
        articleThree.setNew(true);

        AMFArticle articleFour = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleFour.setIssueNumber(new Random().nextInt(100));
        articleFour.setAuthor("Mc Andre");
        articleFour.setContent("Content-test-one");
        articleFour.setTitle("Example Title #4");
        articleFour.setNew(true);

        AMFArticle articleFive = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleFive.setIssueNumber(new Random().nextInt(100));
        articleFive.setAuthor("Mc Andre");
        articleFive.setContent("Content-test-one");
        articleFive.setTitle("Example Title #5");
        articleFive.setNew(true);

        AMFArticle articleSix = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleSix.setIssueNumber(new Random().nextInt(100));
        articleSix.setAuthor("Mc Andre");
        articleSix.setContent("Content-test-three");
        articleSix.setTitle("Example Title #6");
        articleSix.setNew(true);

        renderRequest.setAttribute("amfAMFIssues", amfAMFIssues);
        renderRequest.setAttribute("amfAMFArticles", Arrays.asList(articleOne, articleTwo, articleThree, articleFour));
        renderRequest.setAttribute("amfAMFIssueCount", amfAMFIssues.size());
        return "/view.jsp";
    }
}
