<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>

<%@page import="com.rcs.dbservice.service.TweetLocalServiceUtil"%>
<%@page import="com.rcs.dbservice.model.Tweet"%>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.rcs.constants.DisplayTweetSettingsConstant"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Load the jQuery library from Google Apps -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script>

<portlet:defineObjects />

<%
	PortletPreferences prefs = renderRequest.getPreferences();

	String jsonTweetList = (String) renderRequest.getAttribute("jsonTweetList");
	Integer delayInTweetsToLoop = (Integer)renderRequest.getAttribute("delayInTweetsToLoop");
	Integer numberOfTweetsToLoop = (Integer)renderRequest.getAttribute("numberOfTweetsToLoop");
	String openElement = (String)renderRequest.getAttribute("openElement");
	String closeElement = (String)renderRequest.getAttribute("closeElement");
%>

<div id="<portlet:namespace/>tweetDisplay" class="container-fluid">
	<%=openElement%>
	<div id="<portlet:namespace/>tweetPlaceHolder"></div>
	<%=closeElement%>
</div>

<script type="text/javascript">
	
	
	var Counter = 0;
	var TweetLoop;
	var TweetList = '';
	
	<% if (jsonTweetList != "") { %>
		TweetList = ${jsonTweetList};
	<% } %>
	
	function tweetLoop() {

		var TweetListElement = TweetList[Counter];
		
		if (TweetListElement != undefined) {
			document.getElementById("<portlet:namespace/>tweetPlaceHolder").innerHTML = TweetListElement;
		}
		
		Counter = Counter + 1;
		if (Counter == ${numberOfTweetsToLoop}) {
			Counter = 0;
		}
	}
	

	function stopTweetLoop() {
	    clearInterval(TweetLoop);
	}		

	$(document).ready( function() {

 		// it keeps on running while, e.g., in configuration screen
		stopTweetLoop();
			
        // Trigger first loop because we do not want to wait till first interval is passed
   	    tweetLoop();
        
		TweetLoop = setInterval(function() {
			tweetLoop()
		}, ${delayInTweetsToLoop})
			
	})
	
</script>
