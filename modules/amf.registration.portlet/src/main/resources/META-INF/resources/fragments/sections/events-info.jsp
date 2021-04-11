<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%@ page import="com.amf.registration.portlet.constants.MVCCommandNames" %>

<portlet:renderURL var="viewDetails">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_DISPLAY_EVENTS%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
    <portlet:param name="amfUserId" value="${amfUser.amfUserId}"/>
</portlet:renderURL>
<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <liferay-ui:search-container total="<%=0%>"
                                 var="searchContainer"
                                 delta="1"
                                 deltaConfigurable="true"
                                 emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">
        <liferay-ui:search-container-results results="${amfUsers}"/>
        <liferay-ui:search-container-row className="com.amf.registration.model.AMFUser" modelVar="amfUser"
                                         keyProperty="userId">
            <liferay-ui:search-container-column-text name="Date" property="lastLoginDate"/>
            <liferay-ui:search-container-column-text name="User ID" property="combinedUserInfo"/>
            <liferay-ui:search-container-column-text name="IP Address" property="lastLoginIP"/>
            <liferay-ui:search-container-column-text name="Event Type" property="eventStatus"/>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>
</div>