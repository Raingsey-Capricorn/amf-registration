<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%@ page import="com.amf.registration.portlet.constants.MVCCommandNames" %>

<portlet:renderURL var="profileInfo">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_EDIT%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
    <portlet:param name="amfUserId" value="${amfUser.amfUserId}"/>
</portlet:renderURL>

<%--
<div class="container-fluid-1280">
<aui:container cssClass="tbar-item">
    <h1>${user.screenName}</h1>
    <h2><liferay-ui:message key="mafUser-information"/></h2>
    <div class="user-metadata">
        <dl>
            <dt><liferay-ui:message key="created"/></dt>
            <dd>${user.createDate}</dd>
            <dt><liferay-ui:message key="emailAddress"/></dt>
            <dd>${user.emailAddress}</dd>
            &lt;%&ndash;<dt><liferay-ui:message key="address"/></dt>
            <dd>${user.address}</dd>&ndash;%&gt;
            <dt><liferay-ui:message key="modifiedDate"/></dt>
            <dd>${user.modifiedDate}</dd>
        </dl>
    </div>
</aui:container>
</div>
--%>

<liferay-frontend:user-vertical-card
        url="${profileInfo}"
        cssClass="profile-card"
        userId="<%= user.getUserId() %>"
        title="<%= user.getFullName() %>"
        subtitle="<%= user.getEmailAddress() %>"
        actionJsp="/META-INF/resources/fragments/sections/registration-info.jsp"
>
    <liferay-frontend:vertical-card-header>
        <liferay-ui:message
                arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - user.getLastLoginDate().getTime(), true) %>"
                key="x-ago"
                translateArguments="<%= false %>"
        />
    </liferay-frontend:vertical-card-header>
</liferay-frontend:user-vertical-card>
