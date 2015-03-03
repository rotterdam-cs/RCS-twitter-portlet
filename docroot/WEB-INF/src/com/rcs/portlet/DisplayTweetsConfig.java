package com.rcs.portlet;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;


/**
 *
 *
 */
public class DisplayTweetsConfig extends DefaultConfigurationAction {
	
    @Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse) throws Exception {
       
/*      
        PortletPreferences prefs = actionRequest.getPreferences();
        
    	String NumberOfTweetsToLoop = prefs.getValue(DisplayTweetSettingsConstant.NUMBEROFTWEETSTOLOOP,"");
    	String DelayInTweetsToLoop = prefs.getValue(DisplayTweetSettingsConstant.DELAYINTWEETSTOLOOP, "");
    	String OpenElement = prefs.getValue(DisplayTweetSettingsConstant.OPENELEMENT, "");
    	String CloseElement = prefs.getValue(DisplayTweetSettingsConstant.CLOSEELEMENT,"");
    	String TemplatePerTweet = prefs.getValue(DisplayTweetSettingsConstant.TEMPLATEPERTWEET,"");
    	
    	logger.info("NumberOfTweetsToLoop :" + NumberOfTweetsToLoop);
    	logger.info("DelayInTweetsToLoop :" + DelayInTweetsToLoop);
    	logger.info("OpenElement :" + OpenElement);
    	logger.info("CloseElement :" + CloseElement);
    	logger.info("TemplatePerTweet :" + TemplatePerTweet);
  */      
      	super.processAction(portletConfig, actionRequest, actionResponse);
              
    }

}

