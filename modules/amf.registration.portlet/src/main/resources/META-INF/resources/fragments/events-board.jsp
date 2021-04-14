<%@ include file="/META-INF/resources/init.jsp" %>
<%@ taglib prefix="liferay" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <liferay-ui:tabs names="Profile,All,Registration,Login"
                     tabsValues="Profile,All,Registration,Login"
                     refresh="false"
                     type="pills">

        <liferay-ui:section>
            <%@ include file="sections/profile-info.jsp" %>
        </liferay-ui:section>

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