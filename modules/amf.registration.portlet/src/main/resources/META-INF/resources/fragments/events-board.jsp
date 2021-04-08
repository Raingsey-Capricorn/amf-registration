<%@ include file="/META-INF/resources/init.jsp" %>
<%@ taglib prefix="liferay" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ page import="com.amf.registration.portlet.constants.MVCCommandNames" %>

<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <liferay-ui:tabs names="All,Registration,Login" refresh="false" tabsValues="All,Registration,Login">
        <liferay-ui:section>
            <%@ include file="sections/events-info.jsp" %>
        </liferay-ui:section>
        <liferay-ui:section>
            <%@ include file="sections/registration-info.jsp" %>
        </liferay-ui:section>
        <liferay-ui:section>
            <%@ include file="sections/login-info.jsp" %>
        </liferay-ui:section>
    </liferay-ui:tabs>
</div>