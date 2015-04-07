package com.rcs.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

// import org.apache.log4j.Logger;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.constants.TwitterSettingsConstant;
import com.rcs.dbservice.model.TwitterSettings;
import com.rcs.dbservice.service.TwitterSettingsLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class TwitterSettings
 */
public class TwitterSetting extends MVCPortlet {

	private static final Log logger = LogFactoryUtil
			.getLog(TwitterSetting.class);

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		renderResponse.setContentType("text/html");

		Long groupId = themeDisplay.getScopeGroupId();

		String siteName = LanguageUtil.get(themeDisplay.getLocale(), "Unkown");
		try { 
			siteName = themeDisplay.getSiteGroupName();
		} catch (PortalException e) {
			siteName = LanguageUtil.get(themeDisplay.getLocale(), "Unkown");
		} catch (SystemException e) {
			siteName = LanguageUtil.get(themeDisplay.getLocale(), "Unkown");
		}
		TwitterSettings twitterSettings;
		try {  
  
			twitterSettings = TwitterSettingsLocalServiceUtil
					.getTwitterSettings(groupId);

			if (twitterSettings != null) {
				renderRequest.setAttribute(
						TwitterSettingsConstant.TWITTERSETTINGS,
						twitterSettings);
			}
		} catch (PortalException e1) {
			SessionMessages.add(renderRequest, "twitterSettings-create-info");
		} catch (SystemException e1) {
			SessionMessages.add(renderRequest, "twitterSettings-create-info");
		}
		renderRequest.setAttribute("siteName", siteName);

		super.doView(renderRequest, renderResponse);
	}

	public void doAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Long groupId = themeDisplay.getScopeGroupId();

		Boolean doDelete = ParamUtil.getBoolean(actionRequest, "delete");

		if (doDelete != null && doDelete == true) {
			deleteSettings(actionRequest, actionResponse, groupId, themeDisplay);
		} else {
			saveSettings(actionRequest, actionResponse, groupId, themeDisplay);
		}

	}

	private void deleteSettings(ActionRequest actionRequest,
			ActionResponse actionResponse, Long groupId,
			ThemeDisplay themeDisplay) throws IOException, PortletException {
		TwitterSettings twitterSettings = null;

		try {
			twitterSettings = TwitterSettingsLocalServiceUtil
					.getTwitterSettings(groupId);
			if (twitterSettings != null) {
				// clear settings in persistence
				TwitterSettingsLocalServiceUtil.clearService();

				// delete settings in database
				twitterSettings = TwitterSettingsLocalServiceUtil
						.deleteTwitterSettings(twitterSettings);
				if (twitterSettings != null) {
					// adding success message
					SessionMessages.add(actionRequest,
							"twitterSettings-delete-success");
					logger.info("settings have been deleted successfylly");
				} else {
					SessionErrors.add(actionRequest,
							"twitterSettings-delete-error");
					logger.info("There is an Erron in delete settings");
				}
			}
		} catch (PortalException e1) {
			SessionErrors.add(actionRequest, "twitterSettings-delete-error");
			logger.info("There is an erron in delete settings");
		} catch (SystemException e1) {
			SessionErrors.add(actionRequest, "twitterSettings-delete-error");
			logger.info("There is an erron in delete settings");
		}
		String siteName = "Unknown";
		try {
			siteName = themeDisplay.getSiteGroupName();
		} catch (PortalException e) {
			siteName = "Unknown";
		} catch (SystemException e) {
			siteName = "Unknown";
		}
		actionRequest.setAttribute("siteName", siteName);
	}

	private void saveSettings(ActionRequest actionRequest,
			ActionResponse actionResponse, Long groupId,
			ThemeDisplay themeDisplay) throws IOException, PortletException {

		TwitterSettings twitterSettings = null;

		String applicationName = actionRequest.getParameter("applicationName");
		String consumerKey = actionRequest
				.getParameter(TwitterSettingsConstant.CONSUMERKEY);
		String consumerKeySecret = actionRequest
				.getParameter(TwitterSettingsConstant.CONSUMERKEYSECRET);
		String accessToken = actionRequest
				.getParameter(TwitterSettingsConstant.ACCESSTOKEN);
		String accessTokenSecret = actionRequest
				.getParameter(TwitterSettingsConstant.ACCESSTOKENSECRET);
		try {
			twitterSettings = TwitterSettingsLocalServiceUtil
					.getTwitterSettings(groupId);
			if (twitterSettings != null) {
				// update settings in persistence
				setTwitterSettings(twitterSettings, themeDisplay, consumerKey,
						consumerKeySecret, accessToken, accessTokenSecret,
						applicationName);
				// write to database
				twitterSettings = TwitterSettingsLocalServiceUtil
						.updateTwitterSettings(twitterSettings);

				if (twitterSettings != null) {
					// adding success message
					SessionMessages.add(actionRequest,
							"twitterSettings-update-success");
					logger.info("settings have been added successfylly");
				} else {
					SessionErrors.add(actionRequest,
							"twitterSettings-update-error");
					logger.info("There is an error in update settings");
				}
			} else {
				SessionErrors
						.add(actionRequest, "twitterSettings-update-error");
			}

		} catch (Exception e) {
			logger.info("Settings not found, create now");

			// create settings persistence object
			twitterSettings = TwitterSettingsLocalServiceUtil
					.createTwitterSettings(groupId);

			// fill the data in persistence object
			setTwitterSettings(twitterSettings, themeDisplay, consumerKey,
					consumerKeySecret, accessToken, accessTokenSecret,
					applicationName);

			// logging
			twitterSettings.setCreateDate(new Date());

			// Add settings persistence object to database table
			try {
				twitterSettings = TwitterSettingsLocalServiceUtil
						.addTwitterSettings(twitterSettings);
				SessionMessages.add(actionRequest.getPortletSession(),
						"twitterSettings-create-success");
			} catch (SystemException e1) {
				SessionErrors
						.add(actionRequest, "twitterSettings-create-error");
				logger.info("create settings failed");
				e1.printStackTrace();
			}

		}
		actionRequest.setAttribute(TwitterSettingsConstant.TWITTERSETTINGS,
				twitterSettings);

	}

	private void setTwitterSettings(TwitterSettings twitterSettings,
			ThemeDisplay themeDisplay, String consumerKey,
			String consumerKeySecret, String accessToken,
			String accessTokenSecret, String applicationName) {
		twitterSettings.setApplicationName(applicationName);
		twitterSettings.setConsumerKey(consumerKey);
		twitterSettings.setConsumerKeySecret(consumerKeySecret);
		twitterSettings.setAccessToken(accessToken);
		twitterSettings.setAccessTokenSecret(accessTokenSecret);

		twitterSettings.setCompanyId(themeDisplay.getCompanyId());
		twitterSettings.setUserId(themeDisplay.getUserId());
		twitterSettings.setUserName(themeDisplay.getUser().getFullName());
		twitterSettings.setModifiedDate(new Date());
	}
}