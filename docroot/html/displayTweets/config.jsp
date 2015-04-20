<%@page import="com.rcs.constants.DisplayTweetSettingsConstant"%>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>

<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ page import="javax.portlet.PortletPreferences"%>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<%
	String currentURL = PortalUtil.getCurrentURL(request);

	PortletPreferences preferences = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request,
			"portletResource");

	if (portletResource != null) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);
	}

	String NumberOfTweetsToLoop_cfg = GetterUtil
			.getString(portletPreferences.getValue(DisplayTweetSettingsConstant.NUMBEROFTWEETSTOLOOP, ""));
	String DelayInTweetsToLoop_cfg = GetterUtil
			.getString(portletPreferences.getValue(
					DisplayTweetSettingsConstant.DELAYINTWEETSTOLOOP, ""));
	String OpenElement_cfg = GetterUtil.getString(portletPreferences
			.getValue(DisplayTweetSettingsConstant.OPENELEMENT, ""));
	String CloseElement_cfg = GetterUtil.getString(portletPreferences
			.getValue(DisplayTweetSettingsConstant.CLOSEELEMENT, ""));
	String TemplatePerTweet_cfg = GetterUtil
			.getString(portletPreferences.getValue(DisplayTweetSettingsConstant.TEMPLATEPERTWEET,
					""));

	if (NumberOfTweetsToLoop_cfg == "") {
		NumberOfTweetsToLoop_cfg = DisplayTweetSettingsConstant.DEFAULT_NUMBEROFTWEETSTOLOOP;
	}
	if (DelayInTweetsToLoop_cfg == "") {
		DelayInTweetsToLoop_cfg = DisplayTweetSettingsConstant.DEFAULT_DELAYINTWEETSTOLOOP;
	}
	if (OpenElement_cfg == "") {
		OpenElement_cfg = DisplayTweetSettingsConstant.DEFAULT_OPENELEMENT;
	}
	if (CloseElement_cfg == "") {
		CloseElement_cfg = DisplayTweetSettingsConstant.DEFAULT_CLOSEELEMENT;
	}
	if (TemplatePerTweet_cfg == "") {
		TemplatePerTweet_cfg = DisplayTweetSettingsConstant.DEFAULT_TEMPLATEPERTWEET;
	}

	String AskPin = (String) renderRequest.getAttribute("AskPin");
	
	String localNumberLoop=LanguageUtil.get(pageContext,"Number.of.tweets.to.loop");
	String localDelayLoop=LanguageUtil.get(pageContext,"Delay.in.milliseconds.in.tweets.to.loop");
%>
<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:input name="preferences--NumberOfTweetsToLoop--" type="number"
		min="1"
		value="<%=NumberOfTweetsToLoop_cfg%>" 
		label="<%=localNumberLoop%>"
		id="<portlet:namespace/><%=NumberOfTweetsToLoop_cfg%>">
		<aui:validator name="min">1</aui:validator>
	</aui:input>
	<aui:input name="preferences--DelayInTweetsToLoop--" type="number"
		min="1000"	
		value="<%=DelayInTweetsToLoop_cfg%>"
		label="<%=localDelayLoop%>"
		id="<portlet:namespace/><%=DelayInTweetsToLoop_cfg%>">
		<aui:validator name="min">1000</aui:validator>
	</aui:input>
	
	<aui:input name="preferences--OpenElement--" type="textarea" rows="5" cols="100"
		value="<%=OpenElement_cfg%>" />
	<aui:input name="preferences--CloseElement--" type="textarea" rows="5" cols="100"
		value="<%=CloseElement_cfg%>" />
	<aui:input name="preferences--TemplatePerTweet--" type="textarea" rows="5" cols="100"
	    value="<%=TemplatePerTweet_cfg%>" />
		
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="reset" />
	</aui:button-row>
</aui:form>






