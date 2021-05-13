<%@ taglib prefix="liferay-aui" uri="http://liferay.com/tld/ui" %>
<%@ page import="com.amf.newsletter.model.AMFIssue" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%
    List<AMFIssue> amfIssues = (List<AMFIssue>) request.getAttribute("amfAMFIssues");
%>

<div class="container-fluid-adjust">
    <liferay-ui:panel-container accordion="true" extended="true">
        <liferay-ui:panel title="<%=new SimpleDateFormat("MMMM").format(amfIssues.get(0).getIssuedDate())%>"
                          cssClass="issue-month-tab-title">
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
                        <h6 class="issue-release-title">Issue #
                            <%=String.format("%d, %s", amfAMFIssue.getIssueNumber(), new SimpleDateFormat("MMM dd, yyyy").format(amfAMFIssue.getIssuedDate()))%>
                        </h6>
                        <c:forEach
                                items="${amfAMFArticles}"
                                var="article" varStatus="loop">
                            <h5 class="article-title">${article.title}</h5>
                        </c:forEach>
                    </liferay-aui:search-container-column-text>
                </liferay-ui:search-container-row>
                <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
            </liferay-ui:search-container>
        </liferay-ui:panel>
    </liferay-ui:panel-container>
</div>