<%@ taglib prefix="liferay-aui" uri="http://liferay.com/tld/ui" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.amf.newsletter.model.AMFIssue" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<div class="container-fluid-adjust">
    <c:forEach items="${amfAMFIssues}"
               var="issue"
               varStatus="loop">
        <liferay-ui:panel-container accordion="true" extended="true">
            <liferay-ui:panel title="${issue.issueDateFormatAsMonth}" cssClass="issue-month-tab-title">

                <liferay-ui:search-container
                        total="${amfAMFIssueCount}"
                        cssClass="issue-month-tab-container"
                        deltaConfigurable="true"
                        emptyResultsMessage="Oops. There Are No Articel To Display, Come back next time">
                    <liferay-ui:search-container-results results="${amfAMFIssues}"/>
                    <liferay-ui:search-container-row className="com.amf.newsletter.model.AMFIssue"
                                                     modelVar="amfAMFIssue"
                                                     keyProperty="amfAMFIssueLogId">
                        <liferay-aui:search-container-column-text>
                            <h6 class="issue-release-title">Issue #<%=amfAMFIssue.getFormattedIssueDateTitle()%></h6>
                            <h2 class="issue-title"><%=amfAMFIssue.getTitle()%></h2>
                            <c:forEach items="${amfAMFArticles}"
                                       var="article" varStatus="loop">
                                <h5 class="article-title">${article.title}</h5>
                            </c:forEach>
                        </liferay-aui:search-container-column-text>
                    </liferay-ui:search-container-row>
                    <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
                </liferay-ui:search-container>
            </liferay-ui:panel>
        </liferay-ui:panel-container>

    </c:forEach>
</div>