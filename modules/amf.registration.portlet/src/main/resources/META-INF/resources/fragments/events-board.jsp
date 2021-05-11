<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<%
    String tabIndex = ParamUtil.getString(request, "tabIndex");
    String selectedTab = String.valueOf(request.getAttribute("selectedTab")) == null ?
            String.valueOf(renderRequest.getPortletSession().getAttribute("selectedTab"))
            : String.valueOf(request.getAttribute("selectedTab"));
    PortletURL iteratorURL = renderResponse.createRenderURL();
%>

<div class="container-fluid-1280">
    <b><liferay-ui:message key="amf-registration.caption"/></b>
    <liferay-ui:tabs names="Profile,All,Registration,Login"
                     tabsValues="Profile,All,Registration,Login"
                     param="tabIndex"
                     url="<%=iteratorURL.toString()%>"
                     value='<%=tabIndex%>'
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