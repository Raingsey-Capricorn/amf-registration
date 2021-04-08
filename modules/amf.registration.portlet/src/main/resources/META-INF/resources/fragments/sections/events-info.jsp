<%@ include file="/META-INF/resources/init.jsp" %>
<%@ taglib prefix="liferay" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ page import="com.amf.registration.portlet.constants.MVCCommandNames" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>

<portlet:renderURL var="viewDetails">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_DISPLAY_EVENTS%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
    <portlet:param name="amfUserId" value="${entry.amfUserId}"/>
</portlet:renderURL>
<%
    String eventType = user.getLastLoginDate() == null ? "Register" : "Login";
    String lastLoginDate = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").format(user.getLastLoginDate());
%>
<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <liferay-ui:search-container total="<%=0%>"
                                 var="searchContainer"
                                 delta="1"
                                 deltaConfigurable="true"
                                 emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

        <liferay-ui:search-container-results
                results="${users}"/>
        <%--                results="<%=ListUtil.subList(users, searchContainer.getStart(),searchContainer.getEnd())%>"/>--%>

        <liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" modelVar="user"
                                         keyProperty="userId">
            <liferay-ui:search-container-column-text name="Date" value="<%= lastLoginDate %>"/>
            <liferay-ui:search-container-column-text name="User ID" property="screenName"/>
            <liferay-ui:search-container-column-text name="IP Address" property="lastLoginIP"/>
            <liferay-ui:search-container-column-text name="Event Type" value="<%= eventType %>"/>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator/>

    </liferay-ui:search-container>
</div>