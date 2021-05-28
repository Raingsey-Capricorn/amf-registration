<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%
	final String dynamicTabName = "2021,2020,2019,2018";
%>

<div class="container-fluid-1280">
	<b><liferay-ui:message key="amfnewsletter.caption"/></b>
	<liferay-ui:tabs names="<%=dynamicTabName%>"
					 tabsValues="<%=dynamicTabName%>"
					 param="tabIndex"
					 type="pills">

		<liferay-ui:section>
			<%@ include file="fragments/sections/issue-summary.jsp" %>
		</liferay-ui:section>

		<liferay-ui:section>
			<%--            <%@ include file="sections/events-info.jsp" %>--%>
		</liferay-ui:section>

		<liferay-ui:section>
			<%--            <%@ include file="sections/registration-info.jsp" %>--%>
		</liferay-ui:section>

		<liferay-ui:section>
			<%--            <%@ include file="sections/login-info.jsp" %>--%>
		</liferay-ui:section>

	</liferay-ui:tabs>

</div>