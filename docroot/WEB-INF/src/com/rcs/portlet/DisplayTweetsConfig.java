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
       
    	super.processAction(portletConfig, actionRequest, actionResponse);
              
    }

}

