<%@ taglib prefix="liferay-aui" uri="http://liferay.com/tld/ui" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.amf.newsletter.service.AMFArticleLocalServiceUtil" %>
<%@ page import="com.amf.newsletter.model.AMFIssue" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%
    List<AMFIssue> amfIssues = (List<AMFIssue>) request.getAttribute("amfAMFIssues");
%>

<div class="container-fluid-1280">
    <clay:label label="<%=new SimpleDateFormat("MMMM").format(amfIssues.get(0).getIssuedDate())%>"/>
    <liferay-ui:search-container
            total="${amfAMFIssueCount}"
            deltaConfigurable="true"
            emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">
        <liferay-ui:search-container-results results="${amfAMFIssues}"/>
        <liferay-ui:search-container-row className="com.amf.newsletter.model.AMFIssue"
                                         modelVar="amfAMFIssue"
                                         keyProperty="amfAMFIssueLogId">
            <liferay-aui:search-container-column-text>
                <h4 class="issue-release-title">Issue #
                    <%=String.format("%d, %s", amfAMFIssue.getIssueNumber(), new SimpleDateFormat("MMM dd, yyyy").format(amfAMFIssue.getIssuedDate()))%>
                </h4>
                <c:forEach
                        items="${amfAMFArticles}"
                        var="article" varStatus="loop">
                    <h4 class="issue-release-title">${article.title}</h4>
                </c:forEach>
            </liferay-aui:search-container-column-text>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
    </liferay-ui:search-container>
</div>