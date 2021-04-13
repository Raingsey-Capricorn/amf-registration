<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<div class="container-fluid-1280">
    <aui:container cssClass="tbar-item">
        <h1>${user.screenName}</h1>
        <h2><liferay-ui:message key="mafUser-information"/></h2>
        <div class="user-metadata">
            <dl>
                <dt><liferay-ui:message key="created"/></dt>
                <dd>${user.createDate}</dd>

                <dt><liferay-ui:message key="created-by"/></dt>
                <dd>${user.emailAddress}</dd>

                <dt><liferay-ui:message key="company-id"/></dt>
                <dd>${duser.companyId}</dd>

                <dt><liferay-ui:message key="address"/></dt>
                <dd>${user.address}</dd>

                <dt><liferay-ui:message key="state"/></dt>
                <dd>${user.state}</dd>

                <dt><liferay-ui:message key="modifiedDate"/></dt>
                <dd>${user.modifiedDate}</dd>
            </dl>
        </div>
    </aui:container>
</div>