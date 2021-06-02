<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:renderURL var="detailsURL">
    <liferay-ui:param name="mvcRenderCommandName" value="<%=AMFNewsletterCommandNames.DETAILS%>"/>
    <liferay-ui:param name="issueNumber" value="${issueNumber}"/>
</portlet:renderURL>
<%
    String issueNumber = null;
%>
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
                            <h6 class="issue-release-title">
                                Issue #<%=amfAMFIssue.getFormattedIssueDateTitle()%>
                            </h6>


                            <%--<input:renderURL  onClick="function click(e){
                                alert(e);
                            }">
                                <%=amfAMFIssue.getTitle()%>
                            </input:ren>--%>

                            <a <%--href="${detailsURL}"--%> onclick=


                                <%--"<%= issueNumber= String.valueOf(amfAMFIssue.getIssueNumber())%>"--%> ></a>
                            <aui:button
                                    onClick="alert(e);"><%=amfAMFIssue.getTitle()%>
                            </aui:button>



                            <ul>
                                <c:forEach items="${amfAMFArticles}"
                                           var="article" varStatus="loop">
                                    <li>
                                        <clay:link href="${detailsURL}"
                                                   label="${article.title}"
                                                   cssClass="article-title"
                                        />
                                    </li>
                                </c:forEach>
                            </ul>

                        </liferay-aui:search-container-column-text>
                    </liferay-ui:search-container-row>
                    <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
                </liferay-ui:search-container>

            </liferay-ui:panel>
        </liferay-ui:panel-container>

    </c:forEach>
</div>