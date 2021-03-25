<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">
    <aui:container cssClass="tbar-item">
        <h1>${amfUser.userName}</h1>
        <h2><liferay-ui:message key="mafUser-information"/></h2>
        <div class="amfUser-metadata">
            <dl>
                <dt><liferay-ui:message key="created"/></dt>
                <dd>${amfUser.createDate}</dd>

                <dt><liferay-ui:message key="created-by"/></dt>
                <dd>${amfUser.emailAddress}</dd>

                <dt><liferay-ui:message key="company-id"/></dt>
                <dd>${damfUser.companyId}</dd>

                <dt><liferay-ui:message key="address"/></dt>
                <dd>${amfUser.address}</dd>

                <dt><liferay-ui:message key="state"/></dt>
                <dd>${amfUser.state}</dd>

                <dt><liferay-ui:message key="modifiedDate"/></dt>
                <dd>${amfUser.modifiedDate}</dd>
            </dl>
        </div>
    </aui:container>
</div>