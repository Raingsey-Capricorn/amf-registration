<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<div class="container-fluid-1280">
    <liferay-ui:search-container
            total="${amfEventCount}"
            deltaConfigurable="true"
            emptyResultsMessage="Oops. There Are No Users To Display, Please add Users">

        <%--        iteratorURL="<%=iteratorURL%>"--%>

        <liferay-ui:search-container-results results="${amfEvents}"/>
        <liferay-ui:search-container-row className="com.amf.newsletter.model.AMFArticle"
                                         modelVar="amfEvent"
                                         keyProperty="amfEventLogId">

            <liferay-ui:search-container-column-text>
                <clay:link href="" label="Why people keep tracking new tech?"/>
                <clay:link href="" label="Why people keep tracking new tech?"/>
                <clay:link href="" label="Why people keep tracking new tech?"/>
                <clay:link href="" label="Why people keep tracking new tech?"/>
            </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator markupView="lexicon" paginate="true"/>
    </liferay-ui:search-container>
</div>