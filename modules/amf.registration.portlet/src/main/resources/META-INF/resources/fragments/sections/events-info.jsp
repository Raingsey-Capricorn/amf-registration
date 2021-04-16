<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <liferay-ui:search-container total="${amfEventCount}"
                                 iteratorURL="${current}"
                                 var="searchContainer"
                                 deltaParam="10"

                                 deltaConfigurable="true"
                                 emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">
<%--        delta="10"--%>
        <liferay-ui:search-container-results results="${amfEvents}"/>
        <liferay-ui:search-container-row className="com.amf.registration.model.AMFEventLog"
                                         modelVar="amfEvent"
                                         keyProperty="amfEventLogId">
            <liferay-ui:search-container-column-text name="Date" property="lastLoginDate"/>
            <liferay-ui:search-container-column-text name="User ID" property="combinedUserInfo"/>
            <liferay-ui:search-container-column-text name="IP Address" property="lastLoginIP"/>
            <liferay-ui:search-container-column-text name="Event Type" property="status"/>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
    </liferay-ui:search-container>
</div>