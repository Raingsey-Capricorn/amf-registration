package com.amf.newsletter.model.listener;

import com.amf.newsletter.exception.NoSuchAMFArticleException;
import com.amf.newsletter.exception.NoSuchAMFIssueException;
import com.amf.newsletter.model.AMFArticle;
import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.model.impl.AMFArticleCacheModel;
import com.amf.newsletter.model.impl.AMFIssueCacheModel;
import com.amf.newsletter.service.AMFArticleLocalService;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;
import com.amf.newsletter.service.AMFIssueLocalService;
import com.amf.newsletter.service.AMFIssueLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import lombok.SneakyThrows;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component(
        immediate = true,
        service = ModelListener.class
)
public class JournalStructureModelListener extends BaseModelListener<JournalArticle> {

    /**
     * @param model
     * @throws ModelListenerException
     */
    @Override
    public void onBeforeUpdate(JournalArticle model) throws ModelListenerException {

        User loggedInUser = null;
        try {
            loggedInUser = userService.getCurrentUser();
        } catch (PortalException e) {
            e.printStackTrace();
        }

        if (model.getDDMStructure().getFieldNames().contains("issueFormEntry")) {
            saveDataToAMFIssue(model, loggedInUser);
        } else if (model.getDDMStructure().getFieldNames().contains("articleFormEntry")) {
            saveDataToAMFArticle(model, loggedInUser);
        }

    }

    /**
     * @param model
     * @param loggedInUser
     */
    @SneakyThrows
    private void saveDataToAMFArticle(JournalArticle model, User loggedInUser) {
        AMFArticle amfArticle = null;
        int issueNumber = 0;
        int order = 0;
        String title = "";
        String author = "";
        String content = "";

        for (String fieldName : model.getDDMStructure().getFieldNames()) {
            try {
                Document document = SAXReaderUtil.read(model.getContentByLocale(Locale.ENGLISH.toString()));
                fieldName = fieldName.replace(" ", "").trim();
                fieldName = Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);
                if (AMFArticleCacheModel.class.getDeclaredField(fieldName) != null && fieldName.equals("title")) {
                    title = document.selectSingleNode("/root/dynamic-element[@name='title']/dynamic-content").getText();
                }
                if (AMFArticleCacheModel.class.getDeclaredField(fieldName) != null && fieldName.equals("issueNumber")) {
                    issueNumber = Integer.parseInt(document.selectSingleNode("/root/dynamic-element[@name='issueNumber']/dynamic-content").getText());
                }
                if (AMFArticleCacheModel.class.getDeclaredField(fieldName) != null && fieldName.equals("order")) {
                    order = Integer.parseInt(document.selectSingleNode("/root/dynamic-element[@name='order']/dynamic-content").getText());
                }
                if (AMFArticleCacheModel.class.getDeclaredField(fieldName) != null && fieldName.equals("author")) {
                    author = document.selectSingleNode("/root/dynamic-element[@name='author']/dynamic-content").getText();
                }
                if (AMFArticleCacheModel.class.getDeclaredField(fieldName) != null && fieldName.equals("description")) {
                    content = document.selectSingleNode("/root/dynamic-element[@name='content']/dynamic-content").getText();
                }
            } catch (Exception e) {

            }
        }
        try {
            if (getAMFArticleByIssueNumber(issueNumber, Integer.parseInt(model.getArticleResource().getArticleId())) != null) {
                amfArticle = getAMFArticleByIssueNumber(issueNumber, Integer.parseInt(model.getArticleResource().getArticleId()));
                amfArticle.setModifiedDate(new Date());
                amfArticle.setCompanyId(loggedInUser.getCompanyId());
                amfArticle.setUserId(loggedInUser.getUserId());
                amfArticle.setUserName(loggedInUser.getScreenName());
                amfArticle.setIssueNumber(issueNumber);
                amfArticle.setAuthor(author);
                amfArticle.setOrder(order);
                amfArticle.setTitle(title);
                amfArticle.setContent(content);
                AMFArticleLocalServiceUtil.updateAMFArticle(amfArticle);
            }
        } catch (NoSuchAMFArticleException e) {
            amfArticle = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
            amfArticle.setModifiedDate(new Date());
            amfArticle.setJournalId(Long.parseLong(model.getArticleResource().getArticleId()));
            amfArticle.setCompanyId(loggedInUser.getCompanyId());
            amfArticle.setUserId(loggedInUser.getUserId());
            amfArticle.setUserName(loggedInUser.getScreenName());
            amfArticle.setIssueNumber(issueNumber);
            amfArticle.setAuthor(author);
            amfArticle.setOrder(order);
            amfArticle.setTitle(title);
            amfArticle.setContent(content);
            AMFArticleLocalServiceUtil.addAMFArticle(amfArticle);
        }

        try {
            AMFIssue exitingAMFIssue = getAMFIssueByIssueNumber(amfArticle.getIssueNumber());
            AMFArticleLocalServiceUtil.addAMFIssueAMFArticle(exitingAMFIssue.getAmfIssueId(), amfArticle);
        } catch (Exception e) {

        }
    }

    /**
     * @param model
     * @param loggedInUser
     */
    @SneakyThrows
    private void saveDataToAMFIssue(JournalArticle model, User loggedInUser) {
        AMFIssue amfIssue;
        int issueNumber = 0;
        String title = "";
        Date issueDate = null;
        String description = "";

        for (String fieldName : model.getDDMStructure().getFieldNames()) {
            try {
                Document document = SAXReaderUtil.read(model.getContentByLocale(Locale.ENGLISH.toString()));
                fieldName = fieldName.replace(" ", "").trim();
                final String fName = Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);

                if (AMFIssueCacheModel.class.getDeclaredField(fName) != null && fName.equals("title")) {
                    title = document.selectSingleNode("/root/dynamic-element[@name='title']/dynamic-content").getText();
                }
                if (AMFIssueCacheModel.class.getDeclaredField(fName) != null && fName.equals("issueNumber")) {
                    issueNumber = Integer.parseInt(document.selectSingleNode("/root/dynamic-element[@name='issueNumber']/dynamic-content").getText());
                }
                if (AMFIssueCacheModel.class.getDeclaredField(fName) != null && fName.equals("issueDate")) {
                    issueDate = new SimpleDateFormat("dd-mm-yyyy").parse(document.selectSingleNode("/root/dynamic-element[@name='issueDate']/dynamic-content").getText());
                }
                if (AMFIssueCacheModel.class.getDeclaredField(fName) != null && fName.equals("description")) {
                    description = document.selectSingleNode("/root/dynamic-element[@name='description']/dynamic-content").getText();
                }
            } catch (Exception e) {
                //need to deal with ByLine
//                e.printStackTrace();
            }
        }

        try {
            if (getAMFIssueByIssueNumberAndJournalID(issueNumber, Integer.parseInt(model.getArticleResource().getArticleId())) != null) {
                amfIssue = getAMFIssueByIssueNumberAndJournalID(issueNumber, Integer.parseInt(model.getArticleResource().getArticleId()));
                amfIssue.setModifiedDate(new Date());
                amfIssue.setCompanyId(loggedInUser.getCompanyId());
                amfIssue.setGroupId(loggedInUser.getGroupId());
                amfIssue.setUserGroupId(loggedInUser.getGroupId());
                amfIssue.setUserId(loggedInUser.getUserId());
                amfIssue.setUserName(loggedInUser.getScreenName());
                amfIssue.setIssueNumber(issueNumber);
                amfIssue.setIssueDate(issueDate);
                amfIssue.setTitle(title);
                amfIssue.setDescription(description);
                AMFIssueLocalServiceUtil.updateAMFIssue(amfIssue);
            }
        } catch (NoSuchAMFIssueException e) {
            amfIssue = AMFIssueLocalServiceUtil.createAMFIssue(CounterLocalServiceUtil.increment(AMFIssue.class.getName()));
            amfIssue.setModifiedDate(new Date());
            amfIssue.setJournalId(Integer.parseInt(model.getArticleResource().getArticleId()));
            amfIssue.setJournalId(Long.parseLong(model.getArticleResource().getArticleId()));
            amfIssue.setCompanyId(loggedInUser.getCompanyId());
            amfIssue.setGroupId(loggedInUser.getGroupId());
            amfIssue.setUserGroupId(loggedInUser.getGroupId());
            amfIssue.setUserId(loggedInUser.getUserId());
            amfIssue.setUserName(loggedInUser.getScreenName());
            amfIssue.setIssueNumber(issueNumber);
            amfIssue.setIssueDate(issueDate);
            amfIssue.setTitle(title);
            amfIssue.setDescription(description);
            AMFIssueLocalServiceUtil.addAMFIssue(amfIssue);
        }

    }

    /**
     * @param issueNumber
     * @return
     * @throws NoSuchAMFIssueException
     */
    public AMFIssue getAMFIssueByIssueNumberAndJournalID(int issueNumber, int journalId) throws NoSuchAMFIssueException {
        return (AMFIssue) amfIssueLocalService.dynamicQuery(amfIssueLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("issueNumber", issueNumber))
                .add(RestrictionsFactoryUtil.eq("journalId", (long) journalId))
        ).stream().findFirst().orElseThrow(NoSuchAMFIssueException::new);

    }

    /**
     * @param issueNumber
     * @return
     * @throws NoSuchAMFIssueException
     */
    public AMFIssue getAMFIssueByIssueNumber(int issueNumber) throws NoSuchAMFIssueException {
        return (AMFIssue) amfIssueLocalService.dynamicQuery(amfIssueLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("issueNumber", issueNumber))
        ).stream().findFirst().orElseThrow(NoSuchAMFIssueException::new);

    }

    /**
     * @param issueNumber
     * @param journalId
     * @return
     * @throws NoSuchAMFIssueException
     */
    public AMFArticle getAMFArticleByIssueNumber(int issueNumber, int journalId) throws NoSuchAMFArticleException {
        return (AMFArticle) amfArticleLocalService.dynamicQuery(amfArticleLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.eq("issueNumber", issueNumber))
                .add(RestrictionsFactoryUtil.eq("journalId", (long) (journalId)))
        ).stream().findFirst().orElseThrow(NoSuchAMFArticleException::new);
    }

    @Reference
    private AMFIssueLocalService amfIssueLocalService;

    @Reference
    private AMFArticleLocalService amfArticleLocalService;

    @Reference
    private UserService userService;

}
