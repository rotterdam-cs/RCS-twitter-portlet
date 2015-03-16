<%-- <%@page import="java.io.OutputStream"%> --%>
<%-- <%@page import="com.sun.org.apache.xml.internal.serialize.Printer"%> --%>
<%-- <%@page import="java.io.Writer"%> --%>

<%-- <%@page import="java.util.List"%> --%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%-- <%@page import="javax.portlet.PortletPreferences"%> --%>
<%-- <%@page import="com.liferay.portal.theme.ThemeDisplay"%> --%>
<%-- <%@page import="com.liferay.portal.kernel.util.WebKeys"%> --%>

<%@page
	import="com.rcs.dbService.service.TwitterSettingsLocalServiceUtil"%>
<%@page import="com.rcs.dbService.model.TwitterSettings"%>
<%@page import="com.rcs.constants.TwitterSettingsConstant"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%-- <%@page import="com.liferay.portal.theme.ThemeDisplay" %> --%>
<%-- <%@page import="javax.portlet.GenericPortlet" %> --%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	if (SessionMessages.contains(renderRequest,
	"twitterSettings-create-info")) {
%>
<liferay-ui:message key="twitterSettings-create-info"/>
<%
	}
%>

<liferay-ui:success key="twitterSettings-create-success"
	message="twitterSettings-create-success" />
<liferay-ui:success key="twitterSettings-update-success"
	message="twitterSettings-update-success" />
<liferay-ui:success key="twitterSettings-delete-succes"
	message="twitterSettings-delete-succes" />
<liferay-ui:error key="twitterSettings-create-error"
	message="twitterSettings-create-error" />
<liferay-ui:error key="twitterSettings-update-error"
	message="twitterSettings-update-error" />
<liferay-ui:error key="twitterSettings-delete-error"
	message="twitterSettings-delete-error" />

<%
	String siteName = "";
	String applicationName = "";	
	String consumerKey = "";
	String consumerKeySecret = "";
	String accessToken = "";
	String accessTokenSecret = "";
	Boolean deleteDisabled = true;

	if (renderRequest.getAttribute("siteName")!=null) {
		siteName = (String) renderRequest.getAttribute("siteName");
	}
		
	applicationName = siteName;
	
	TwitterSettings twitterSettings = (TwitterSettings) renderRequest
	.getAttribute(TwitterSettingsConstant.TWITTERSETTINGS);

	if (twitterSettings != null) {
		if (twitterSettings.getApplicationName()!=null) {
	applicationName = twitterSettings.getApplicationName();
		} else {
	applicationName = siteName;
		}
		consumerKey = twitterSettings.getConsumerKey();
		consumerKeySecret = twitterSettings.getConsumerKeySecret();
		accessToken = twitterSettings.getAccessToken();
		accessTokenSecret = twitterSettings.getAccessTokenSecret();
		deleteDisabled = false;
	}


	String localTwitterApplicationName = LanguageUtil.get(pageContext,"twitter.application.name");
	String localTwitterApplicationNameHelp = LanguageUtil.get(pageContext,"twitter.application.name.help");
	String localTwitterGeneralHelp = LanguageUtil.get(pageContext,"twitter.general.help");

%>

<portlet:actionURL var="TwitterSettingsURL" name="doAction">
</portlet:actionURL>

<script>
function Delete() {
	AUI().use('node', function(A) {
		A.one('#<portlet:namespace/>delete').set('value', "true");
	});
}
</script>

<aui:form action="<%=TwitterSettingsURL%>"
	name="<portlet:namespace/>settingsForm"
	id="<portlet:namespace/>settingsForm" method="post">

	<input name="<portlet:namespace/>delete"
		id="<portlet:namespace/>delete" type="hidden" value="false">
    

	<aui:input name="applicationName" type="text"
	    title="<%=localTwitterApplicationNameHelp%>"
		label="<%=localTwitterApplicationName%>" 
		value="<%=applicationName%>">
		<aui:validator name="required" />
	</aui:input>

	<aui:input name="<%=TwitterSettingsConstant.CONSUMERKEY%>" type="text"
		title="<%=localTwitterGeneralHelp %>"
		value="<%=consumerKey%>">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="<%=TwitterSettingsConstant.CONSUMERKEYSECRET%>"
		title="<%=localTwitterGeneralHelp %>"
		type="text" value="<%=consumerKeySecret%>">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="<%=TwitterSettingsConstant.ACCESSTOKEN%>" type="text"
		title="<%=localTwitterGeneralHelp %>"
		value="<%=accessToken%>">
		<aui:validator name="required" />
	</aui:input>
	<aui:input name="<%=TwitterSettingsConstant.ACCESSTOKENSECRET%>"
		title="<%=localTwitterGeneralHelp %>"
		type="text" value="<%=accessTokenSecret%>">
		<aui:validator name="required" />
	</aui:input>
	<aui:fieldset column="false">
		<aui:button-row>
			<aui:button type="submit" name="<portlet:namespace/>save"
				value="Save" />

			<aui:button type="submit" name="<portlet:namespace/>delete"
				onclick="Delete()" value="Delete" disabled="<%=deleteDisabled%>" />

			<aui:button type="reset" value="">
			</aui:button>
		</aui:button-row>
	</aui:fieldset>
</aui:form>

