<%@ include file="/META-INF/resources/init.jsp" %>

<%
    AMFIssue amfIssue = (AMFIssue) request.getAttribute("amfIssue");
    String issueDate = amfIssue.getFormattedIssueDateTitle();
    String issueTitle = amfIssue.getTitle();
    String authors = amfIssue.getByLines().stream().collect(Collectors.joining(", "));
    String issueDescription = amfIssue.getDescription();
%>

<div class="container-fluid-1280">
    <h3 class="issue-release-title">
        Issue #<%=issueDate%>
    </h3>
    <h1 class="issue-title"><%=issueTitle%>
    </h1>
    <clay:label label="<%=authors%>"
                cssClass="issue-release-title"/>
    <p><%=issueDescription%>
    </p>

    <c:forEach items="<%=amfIssue.getAMFArticles()%>"
               var="article"
               varStatus="loop">
        <h3 class="issue-release-title" id="${article.amfArticleId}">${article.title}</h3>
        <p style="margin-left: 40px">${article.content}</p>
    </c:forEach>

</div>
<script>
    AUI().ready(function () {
        document.getElementById(sessionStorage.getItem('articleId')).scrollIntoView();
    });
</script>