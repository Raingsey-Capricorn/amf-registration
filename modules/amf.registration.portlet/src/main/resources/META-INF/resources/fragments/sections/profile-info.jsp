<%@ include file="/META-INF/resources/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:renderURL var="profileInfo">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_EDIT%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
    <portlet:param name="amfUserId" value="${amfUser.amfUserId}"/>
</portlet:renderURL>

<liferay-frontend:user-vertical-card
        url="${profileInfo}"
        cssClass="profile-card"
        userId="<%= user.getUserId() %>"
        title="<%= user.getFullName() %>"
        subtitle="<%= user.getEmailAddress() %>"
        actionJsp="/META-INF/resources/fragments/sections/registration-info.jsp">
    <liferay-frontend:vertical-card-header>
        <liferay-ui:message
                arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - user.getLastLoginDate().getTime(), true) %>"
                key="x-ago"
                translateArguments="<%= false %>"
        />
    </liferay-frontend:vertical-card-header>
</liferay-frontend:user-vertical-card>
