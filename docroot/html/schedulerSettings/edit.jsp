<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@page import="com.rcs.constants.TwitterSettingsConstant"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page import="com.rcs.constants.SchedulerSettingsConstant"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:defineObjects />

<liferay-ui:success key="schedulerSettings-update-success"
	message="schedulerSettings-update-success" />
<liferay-ui:error key="schedulerSettings-update-error"
	message="schedulerSettings-update-error" />


<%
	String cron = (String) renderRequest.getAttribute(SchedulerSettingsConstant.CRON);
	Integer minutes = Integer.valueOf(cron);

	String localSchedulerIntervalInMinutes = LanguageUtil.get(pageContext,"Scheduler.trigger.interval.in.minutes");

%>

<portlet:actionURL var="startSchedulerURL" name="startScheduler">
	<portlet:param name="jspPage" value="/html/schedulerSettings/edit.jsp" />
</portlet:actionURL>

<aui:form action="<%=startSchedulerURL%>" method="post">

	<aui:input name="<%=SchedulerSettingsConstant.CRON%>" type="number"
		label="<%=localSchedulerIntervalInMinutes %>"
		id="<portlet:namespace/><%=SchedulerSettingsConstant.CRON%>"
		value="<%=minutes%>">
		<aui:validator  name="custom"  errorMessage="Please enter 0 to stop scheduler or a positive number to set trigger interval." >
			function (val, fieldNode, ruleValue) {
				var result = false;
				if (val >=0) {
					result = true;
				}
				return result;
			}
		</aui:validator>
	</aui:input>

	<aui:button type="submit" name="startScheduler" id="startScheduler"
		value="Save" />
	<aui:button type="reset" value="">
	 </aui:button>	
</aui:form>
