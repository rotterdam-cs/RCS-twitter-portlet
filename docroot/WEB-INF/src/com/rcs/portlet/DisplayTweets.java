package com.rcs.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rcs.constants.DisplayTweetSettingsConstant;
import com.rcs.dbservice.model.Tweet;
import com.rcs.dbservice.service.TweetLocalServiceUtil;

/**
 * Portlet implementation class DisplayTweets
 */
public class DisplayTweets extends MVCPortlet {

	private static final Log logger = LogFactoryUtil
			.getLog(DisplayTweets.class);

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Long groupId = themeDisplay.getScopeGroupId();

		javax.portlet.PortletPreferences prefs = renderRequest.getPreferences();

		Integer delayInTweetsToLoop = Integer.valueOf((String) prefs.getValue(
				DisplayTweetSettingsConstant.DELAYINTWEETSTOLOOP,
				DisplayTweetSettingsConstant.DEFAULT_DELAYINTWEETSTOLOOP));

		String openElement = (String) prefs.getValue(
				DisplayTweetSettingsConstant.OPENELEMENT,
				DisplayTweetSettingsConstant.DEFAULT_OPENELEMENT);

		String closeElement = (String) prefs.getValue(
				DisplayTweetSettingsConstant.CLOSEELEMENT,
				DisplayTweetSettingsConstant.DEFAULT_CLOSEELEMENT);

		Integer numberOfTweetsToLoop = Integer.valueOf((String) prefs.getValue(
				DisplayTweetSettingsConstant.NUMBEROFTWEETSTOLOOP,
				DisplayTweetSettingsConstant.DEFAULT_NUMBEROFTWEETSTOLOOP));

		String templatePerTweet = (String) prefs.getValue(
				DisplayTweetSettingsConstant.TEMPLATEPERTWEET,
				DisplayTweetSettingsConstant.DEFAULT_TEMPLATEPERTWEET);

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
				.forClass(Tweet.class);
		dynamicQuery.add(PropertyFactoryUtil.forName("primaryKey.groupId").eq(
				groupId));
		Order defaultOrder = OrderFactoryUtil.desc("tweetCreatedAt");
		dynamicQuery.addOrder(defaultOrder);
		dynamicQuery.setLimit(0, numberOfTweetsToLoop);

		List<Tweet> twitterList = null;
		Integer tweetsCount = 0;
		try {
			twitterList = TweetLocalServiceUtil.dynamicQuery(dynamicQuery);
			tweetsCount = twitterList.size();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		if (tweetsCount > numberOfTweetsToLoop) {
			numberOfTweetsToLoop = tweetsCount;
		}

		List<String> tweetList = new ArrayList<String>();
		String template;
		for (Tweet twitter : twitterList) {
			template = templatePerTweet.replace("{text}",
					twitter.getTweetText());
			template = template.replace("{posted_by}", twitter.getTweetIdStr());

			@SuppressWarnings("deprecation")
			String year = String
					.valueOf(twitter.getTweetCreatedAt().getYear() + 1900);
			@SuppressWarnings("deprecation")
			String month = String.valueOf(twitter.getTweetCreatedAt()
					.getMonth() + 1);
			@SuppressWarnings("deprecation")
			String day = String.valueOf(twitter.getTweetCreatedAt().getDate());
			@SuppressWarnings("deprecation")
			String time = String.valueOf(twitter.getTweetCreatedAt().getHours()
					+ ":" + twitter.getTweetCreatedAt().getMinutes());

			template = template.replace("{posted_on_year}", year);
			template = template.replace("{posted_on_month}", month);
			template = template.replace("{posted_on_day}", day);
			template = template.replace("{posted_on_time}", time);

			tweetList.add(template);
		}

		ObjectMapper mapper = new ObjectMapper();

		String jsonTweetList = "";
		try {
			if (tweetList != null && tweetList.size() >0) {
				jsonTweetList = mapper.writeValueAsString(tweetList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		renderRequest.setAttribute("jsonTweetList", jsonTweetList);

		renderRequest
				.setAttribute("numberOfTweetsToLoop", numberOfTweetsToLoop);
		renderRequest.setAttribute("delayInTweetsToLoop", delayInTweetsToLoop);
		renderRequest.setAttribute("openElement", openElement);
		renderRequest.setAttribute("closeElement", closeElement);

		super.doView(renderRequest, renderResponse);
	}

}
