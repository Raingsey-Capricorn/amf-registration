<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:renderURL var="detailsURL">
    <liferay-ui:param name="mvcRenderCommandName" value="<%=AMFNewsletterCommandNames.DETAILS%>"/>
    <liferay-ui:param name="issueNumber" value="${issueNumber}"/>
</portlet:renderURL>

<div class="container-fluid-adjust">
    <c:forEach items="${amfIssues}"
               var="issue"
               varStatus="loop">

        <liferay-ui:panel-container markupView="lexicon">
            <liferay-ui:panel title="${issue.issueDateFormatAsMonth}" cssClass="issue-month-tab-title">
                <ul style="list-style-type: none;">

                    <liferay-ui:search-container
                            total="${amfIssueCount}"
                            cssClass="issue-month-tab-container"
                            deltaConfigurable="true"
                            emptyResultsMessage="Oops. There Are No Issue To Display, Come back next time">
                        <clay:link href="${detailsURL}"
                                   label="Issue #${issue.formattedIssueDateTitle}"
                                   cssClass="issue-release-title"
                        />

                        <liferay-ui:search-container-results results="${issue.issuesWithinMonth}"/>
                        <li>
                            <liferay-ui:search-container-row className="com.amf.newsletter.model.AMFIssue"
                                                             modelVar="issue"
                                                             keyProperty="title">
                                <liferay-aui:search-container-column-text>
                                    <ul style="list-style-type:none">
                                        <c:forEach items="${issue.AMFArticles}" var="article" varStatus="loop">
                                            <li>
                                                <clay:link href=""
                                                           label="${article.title}"
                                                           cssClass="article-title"
                                                />
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </liferay-aui:search-container-column-text>
                            </liferay-ui:search-container-row>
                        </li>

                        <liferay-ui:search-iterator markupView="lexicon" paginate="false"/>
                    </liferay-ui:search-container>

                </ul>
            </liferay-ui:panel>
        </liferay-ui:panel-container>

    </c:forEach>
</div>