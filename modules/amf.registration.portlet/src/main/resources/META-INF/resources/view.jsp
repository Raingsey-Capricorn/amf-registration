<%@ include file="/init.jsp" %>
<%@ taglib prefix="liferay" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ page import="com.amf.registration.portlet.constants.MVCCommandNames" %>

<portlet:renderURL var="viewDetails">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_VIEW_MEMBER_INFO%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
    <portlet:param name="amfUserId" value="${entry.amfUserId}"/>
</portlet:renderURL>

<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>'
                        key="error.assignment-service-error"/>
</liferay-ui:error>
<liferay-ui:success key="amfUserAdded" message="amfUser-added-successfully"/>
<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <clay:management-toolbar
            disabled="${false}"
            itemsTotal="${0}"
            searchContainerId="amfUserEntries"
            selectable="${true}"
            displayContext="${toolbarDisplayContext}"
    />

    <liferay-ui:search-container
            emptyResultsMessage="no-entry"
            id="amfUserEntries"
            iteratorURL="${portletURL}"
            total="${amfUserCount}">
        <liferay-ui:search-container-results results="${amfUsers}"/>
        <liferay-ui:search-container-row
                className="com.amf.registration.model.AMFUser"
                modelVar="entry">
            <liferay-ui:search-container-column-user
                    showDetails="<%=false%>"
                    userId="<%=entry.getUserId()%>"
            />
            <liferay-ui:search-container-column-text colspan="<%=3%>">
                <h5 class="text-default">
                    <liferay-ui:message arguments="<%=new String[] {entry.getUserName(), entry.getGender()}%>"
                                        key="x-modified-x-ago"/>
                </h5>
                <h4><aui:a
                        href="${viewDetails}">${String.format("%s - %s", entry.getFirstName(), entry.getLastName())}</aui:a>
                </h4>
            </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator
                displayStyle="${toolbarDisplayContext.getDisplayStyle()}"
                markupView="lexicon"
        />

    </liferay-ui:search-container>
</div>