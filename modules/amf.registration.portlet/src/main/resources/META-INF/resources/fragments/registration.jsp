<%@ include file="../init.jsp" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.amf.registration.portlet.constants.MVCCommandNames" %>

<portlet:renderURL var="regionalListsURL">
    <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.AMF_REGIONS_INFO%>"/>
    <portlet:param name="redirect" value="${currentURL}"/>
    <portlet:param name="regionId" value="${region.regionId}"/>
</portlet:renderURL>

<portlet:actionURL var="registerMembershipURL" name="<%=MVCCommandNames.AMF_ADD %>">
    <portlet:param name="redirect" value="${param.redirect}"/>
</portlet:actionURL>

<div class="container-fluid-1280">
    <liferay-ui:error key="serviceErrorDetails">
        <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>'
                            key="error.registration-service-error"/>
    </liferay-ui:error>
    <liferay-ui:error key="amfUserGroupMissing" message="error.amf-usergroup-not-available"/>
    <liferay-ui:error key="invalidUserName" message="error.field-duplicate-username"/>
    <liferay-ui:error key="zipCodeInvalid" message="error.field-zipcode"/>
    <liferay-ui:error key="stateInvalid" message="error.field-address"/>
    <liferay-ui:error key="cityInvalid" message="error.field-address"/>
    <liferay-ui:error key="addressInvalid" message="error.field-address"/>
    <liferay-ui:error key="confirmationPasswordMismatch" message="error.field-password-confirmation"/>
    <liferay-ui:error key="invalidPassword" message="error.field-password"/>
    <liferay-ui:error key="invalidAge" message="error.field-birth-date"/>
    <liferay-ui:error key="invalidEmail" message="error.field-email"/>
    <liferay-ui:error key="invalidUserNameMap" message="error.field-user-name"/>
    <liferay-ui:error key="invalidLastName" message="error.field-last-name"/>
    <liferay-ui:error key="invalidFirstName" message="error.field-first-name" focusField="firstName"/>

    <h2><liferay-ui:message key="amf-registration.caption"/></h2>
    <h4 style="text-decoration: underline"><liferay-ui:message key="eligibility-country"/></h4>
    <aui:model-context bean="${amfUser}" model="${userClass}"/>
    <aui:form action="${registerMembershipURL}" name="fm" method="post">

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset label="Basic Info">
                <aui:row>
                    <aui:col width="50">
                        <aui:input name="firstName" type="text">
                            <aui:validator name="alpha" errorMessage="error.field-first-name"/>
                        </aui:input>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="lastName" type="text">
                            <aui:validator name="alpha" errorMessage="error.field-last-name"/>
                        </aui:input>
                    </aui:col>
                </aui:row>
                <aui:row>
                    <aui:col width="50">
                        <aui:input name="emailAddress" type="email">
                            <aui:validator name="email" errorMessage="error.field-email"/>
                        </aui:input>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="userName" type="text">
                            <aui:validator name="required" errorMessage="error.field-user-name"/>
                            <aui:validator name="custom" errorMessage="error.field-duplicate-username"/>
                        </aui:input>
                    </aui:col>
                </aui:row>
                <aui:row>
                    <aui:col width="50">
                        <p class="costume-control-label-gender">Gender</p>
                        <aui:field-wrapper required="true">
                            <aui:input value="female" label="Female" name="gender" type="radio"/>
                            <aui:input value="male" label="Male" name="gender" type="radio" checked="true"/>
                        </aui:field-wrapper>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="date_of_birth" label="Date of Birth" required="true" type="date" pattern="\d*">
                            <aui:validator name="date" errorMessage="error.field-birth-date"/>
                        </aui:input>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="password" type="password">
                            <aui:validator name="required" errorMessage="error.field-password"/>
                        </aui:input>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="confirmedPassword" label="Password Confirmation"
                                   type="password">
                            <aui:validator name="required" errorMessage="error.field-password-confirmation"/>
                        </aui:input>
                    </aui:col>
                </aui:row>
            </aui:fieldset>
        </aui:fieldset-group>

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset label="Phone">
                <aui:row>
                    <aui:col width="50">
                        <aui:input name="homePhone" type="number" maxlength="10" pattern="\d*"/>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="mobilePhone" type="number" maxlength="10" pattern="\d*"/>
                    </aui:col>
                </aui:row>
            </aui:fieldset>
        </aui:fieldset-group>

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset label="Billing Address (US-Only)">
                <aui:row>
                    <aui:col width="50">
                        <aui:input name="address" type="text" max="255">
                            <aui:validator name="required" errorMessage="error.field-address"/>
                        </aui:input>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="address2" type="text" max="255"/>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="city" type="text" max="255">
                            <aui:validator name="required" errorMessage="error.field-address"/>
                        </aui:input>
                    </aui:col>
                    <aui:col width="50">
                        <aui:select name="region"
                                    label="State/Region"
                                    required="true"
                                    showRequiredLabel="true"
                                    showEmptyOption="true"
                                    value="${regionalListsURL}">
                            <aui:validator name="number" errorMessage="error.field-zipcode"/>
                            <c:forEach items="${regions}" var="region" varStatus="loop">
                                <aui:option value="${region.regionId}">${region.name}</aui:option>
                            </c:forEach>
                        </aui:select>
                    </aui:col>
                    <aui:col width="50">
                        <aui:input name="zip" type="number" maxlength="5" pattern="\d*" required="true">
                            <aui:validator name="maxLength" errorMessage="error.field-zipcode">5</aui:validator>
                            <aui:validator name="number" errorMessage="error.field-zipcode"/>
                        </aui:input>
                    </aui:col>
                </aui:row>
            </aui:fieldset>
        </aui:fieldset-group>

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset label="Misc.">
                <aui:row>
                    <aui:col width="50">
                        <aui:select name="securityQuestion" label="Security Question">
                            <aui:option value="What is your mother's maiden name?"
                                        label="What is your mother's maiden name?"/>
                            <aui:option value="What is the make of your first car?"
                                        label="What is the make of your first car?"/>
                            <aui:option value="What is your high school mascot?"
                                        label="What is your high school mascot?"/>
                            <aui:option value="Who is your favorite actor?" label="Who is your favorite actor?"/>
                        </aui:select>
                    </aui:col>
                </aui:row>
                <aui:row>
                    <aui:col>
                        <aui:input name="securityAnswer" type="text" required="true" label="Security Answer">
                            <aui:validator name="required" errorMessage="error.field-security-answer"/>
                        </aui:input>
                    </aui:col>
                </aui:row>
                <aui:row>
                    <aui:col>
                        <span class="panel-title">Terms of Use</span>
                        <aui:input name="acceptedTou"
                                   label="I have read understand and agree with the Terms of Use governing my access to and use of the Acme Movie Fanatics web site."
                                   type="checkbox"
                                   required="true">
                            <aui:validator name="required" errorMessage="error.field-tou-answer"/>
                        </aui:input>
                    </aui:col>
                </aui:row>
            </aui:fieldset>
        </aui:fieldset-group>

        <aui:button-row>
            <aui:button name="submitButton" type="submit" value="Register"/>
        </aui:button-row>

    </aui:form>
</div>