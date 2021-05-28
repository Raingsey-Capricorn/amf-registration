<%@ include file="/init.jsp" %>

<portlet:renderURL var="registerURL">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_REGISTER%>"/>
</portlet:renderURL>

<portlet:renderURL var="searchURL">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_CLEAR_SEARCH%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
</portlet:renderURL>

<div class="amf-search-container">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <div id="search-panel">
        <label>Enter US Zip</label>
        <clay:management-toolbar
                itemsTotal="${amfUserCount}"
                searchContainerId="${postalSearchContainer}"
                clearResultsURL="${searchURL}"
                selectable="<%=false%>"
                id="amf-user-search-input"
        />
        <aui:button name="submitButton" value="Register" onClick="${registerURL}"/>
    </div>

    <liferay-ui:search-container
            emptyResultsMessage="no-entry"
            id="postalSearchContainer"
            iteratorURL="${portletURL}"
            total="${amfUserCount}">

        <liferay-ui:search-container-results results="${amfUsers}"/>
        <liferay-ui:search-container-row className="com.amf.registration.model.AMFUser"
                                         modelVar="amfUser">
            <liferay-ui:search-container-column-text name="User-Info" property="combinedUserInfo"/>
            <liferay-ui:search-container-column-text name="Email" property="emailAddress"/>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>

    </liferay-ui:search-container>
</div>
