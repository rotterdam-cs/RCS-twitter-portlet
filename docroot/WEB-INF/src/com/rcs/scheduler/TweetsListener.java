package com.rcs.scheduler;

import java.util.Date;
import java.util.List;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.rcs.dbService.model.Tweet;
import com.rcs.dbService.model.TwitterSettings;
import com.rcs.dbService.service.TweetLocalServiceUtil;
import com.rcs.dbService.service.TwitterSettingsLocalServiceUtil;
import com.rcs.dbService.service.persistence.TweetPK;

public class TweetsListener implements MessageListener {
	private static final Log LOGGER = LogFactoryUtil
			.getLog(TweetsListener.class);

	/**
	 * Job that we need to run on scheduler
	 */

	public void receive(Message arg0) throws MessageListenerException {

		LOGGER.info("Inside TweetsListener");

		try {
			List<TwitterSettings> twitterSettings;
			Integer tweetCount = TwitterSettingsLocalServiceUtil
					.getTwitterSettingsesCount();
			twitterSettings = TwitterSettingsLocalServiceUtil
					.getTwitterSettingses(0, tweetCount);

			for (TwitterSettings twitterSetting : twitterSettings) {

				Long groupId = twitterSetting.getGroupId();
				String consumerKey = twitterSetting.getConsumerKey();
				String consumerKeySecret = twitterSetting
						.getConsumerKeySecret();
				String accessToken = twitterSetting.getAccessToken();
				String accessTokenSecret = twitterSetting
						.getAccessTokenSecret();

				if (consumerKey != null && consumerKeySecret != null
						&& accessToken != null && accessTokenSecret != null

						&& consumerKey != "" && consumerKeySecret != ""
						&& accessToken != "" && accessTokenSecret != "") {
					try {
						getTimeLine(groupId, consumerKey, consumerKeySecret,
								accessToken, accessTokenSecret);
					} catch (TwitterException e) {
						LOGGER.error("Connection to Twitter failed for site "
								+ groupId + " "
								+ twitterSetting.getApplicationName()
								+ " exceptioncode: " + e.getExceptionCode()
								+ " due to:");

						if (e.exceededRateLimitation() == true) {
							LOGGER.error("Rate limit exceeded.");
						} else if (e.isErrorMessageAvailable() == true) {
							LOGGER.info("Twitterexception");
							LOGGER.error(e.getErrorMessage());
						} else {
							LOGGER.info("NO Twitterexception");
							e.getExceptionCode();
						}

					}
				}
			}
		} catch (SystemException e1) {
			LOGGER.info("No Twitter settings are configured. Please configure them in site administration settings.");
		}

	}

	private void getTimeLine(Long groupId, String consumerKey,
			String consumerKeySecret, String accessToken,
			String accessTokenSecret) throws TwitterException {

		TwitterFactory factory = new TwitterFactory();
		twitter4j.Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerKeySecret);
		AccessToken accessTokenToken = new AccessToken(accessToken,
				accessTokenSecret);
		twitter.setOAuthAccessToken(accessTokenToken);

		LOGGER.info("Twitter successfully set AccessToken for group: "
				+ groupId);

		long userId = twitter.getId();

		ResponseList<Status> statuses = twitter.getUserTimeline(userId);

		for (Status status : statuses) {
			Long id = status.getId();
			TweetPK tweetPK = new TweetPK(groupId, id);
			try {
				Tweet tweet = TweetLocalServiceUtil.getTweet(tweetPK);
				if (tweet != null) {
					// Update not implemented
				}
			} catch (Exception e) {
				LOGGER.info("Create:" + id);

				// create tweet persistence object
				Tweet tweet = TweetLocalServiceUtil.createTweet(tweetPK);

				String txt = status.getText();

				if (txt == null || txt.length() <= 0) {
					txt = "_";
				} else if (txt.length() > 200) {
					txt = txt.substring(0, 200);
				}

				// fill the data in persistence object
				tweet.setTweetId(id);
				tweet.setTweetCreatedAt(status.getCreatedAt());
				tweet.setTweetIdStr(status.getUser().getName());
				tweet.setTweetRetweetCount(status.getRetweetCount());
				tweet.setTweetRetweeted(status.isRetweeted());
				tweet.setTweetText(txt);

				/*
				 * @TODO find out how to fill these audit fields the are
				 * mandatory for the marketplace. Long companyId = null; Long
				 * userId = null; String userName = null;
				 * 
				 * companyId = PortalUtil.getCompanyId(); userId =
				 * PortalUtil.getUserId(actionRequest); userName =
				 * PortalUtil.getUserName(twitterSettings);
				 * 
				 * tweet.setCompanyId(companyId); tweet.setUserId(userId);
				 * tweet.setUserName(userName);
				 */

				tweet.setCreateDate(new Date());
				tweet.setRemoved(false);

				// Add settings persistence object to database table
				try {
					tweet = TweetLocalServiceUtil.addTweet(tweet);
				} catch (SystemException e1) {
					LOGGER.error("Create database object failed");
					e1.printStackTrace();
				}
			}
		}
	}

}