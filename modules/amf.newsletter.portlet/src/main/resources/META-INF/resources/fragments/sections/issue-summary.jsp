<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:renderURL var="detailsURL">
    <liferay-ui:param name="mvcRenderCommandName" value="<%=AMFNewsletterCommandNames.DETAILS%>"/>
</portlet:renderURL>

<div class="container-fluid-adjust">
    <c:forEach items="${amfIssues}"
               var="issue"
               varStatus="loop">

        <liferay-ui:panel-container accordion="false"
                                    extended="false">

            <liferay-ui:panel title="${issue.issueDateFormatAsMonth}" cssClass="issue-month-tab-title">
                <ul style="list-style-type:none; padding-left: 0;">
                    <liferay-ui:search-container
                            total="${amfIssueCount}"
                            cssClass="issue-month-tab-container"
                            deltaConfigurable="true"
                            emptyResultsMessage="Oops. There Are No Issue To Display, Come back next time">

                        <aui:form action="${detailsURL}" method="post">
                            <aui:button id="issueLink"
                                        type="submit"
                                        cssClass="issue-release-title"
                                        value="Issue #${issue.formattedIssueDateTitle}"
                            />
                            <aui:input name="issueId"
                                       type="hidden"
                                       value="${issue.amfIssueId}"
                            />
                            <liferay-ui:search-container-results results="${issue.issuesWithinMonth}"/>
                            <li class="hello-hello">
                                <liferay-ui:search-container-row className="com.amf.newsletter.model.AMFIssue"
                                                                 modelVar="issue"
                                                                 keyProperty="title">
                                    <liferay-aui:search-container-column-text>
                                        <ul style="list-style-type:none; padding-left: 0;">
                                            <c:forEach items="${issue.AMFArticles}" var="article" varStatus="loop">
                                                <li>
                                                    <aui:input name="articleId"
                                                               type="hidden"
                                                               value="${article.amfArticleId}"
                                                    />
                                                    <aui:button id="articleLink"
                                                                type="submit"
                                                                cssClass="article-title"
                                                                value="${article.title}"
                                                    />
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </liferay-aui:search-container-column-text>
                                </liferay-ui:search-container-row>
                            </li>
                            <liferay-ui:search-iterator markupView="lexicon" paginate="false"/>
                        </aui:form>
                    </liferay-ui:search-container>
                </ul>
            </liferay-ui:panel>
        </liferay-ui:panel-container>
    </c:forEach>
</div>










