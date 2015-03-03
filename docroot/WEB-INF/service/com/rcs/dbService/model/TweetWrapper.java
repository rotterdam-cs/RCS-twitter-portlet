/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.dbService.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tweet}.
 * </p>
 *
 * @author rcs
 * @see Tweet
 * @generated
 */
public class TweetWrapper implements Tweet, ModelWrapper<Tweet> {
	public TweetWrapper(Tweet tweet) {
		_tweet = tweet;
	}

	@Override
	public Class<?> getModelClass() {
		return Tweet.class;
	}

	@Override
	public String getModelClassName() {
		return Tweet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("removed", getRemoved());
		attributes.put("tweetId", getTweetId());
		attributes.put("tweetIdStr", getTweetIdStr());
		attributes.put("tweetCreatedAt", getTweetCreatedAt());
		attributes.put("tweetRetweeted", getTweetRetweeted());
		attributes.put("tweetRetweetCount", getTweetRetweetCount());
		attributes.put("tweetText", getTweetText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Boolean modifiedDate = (Boolean)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean removed = (Boolean)attributes.get("removed");

		if (removed != null) {
			setRemoved(removed);
		}

		Long tweetId = (Long)attributes.get("tweetId");

		if (tweetId != null) {
			setTweetId(tweetId);
		}

		String tweetIdStr = (String)attributes.get("tweetIdStr");

		if (tweetIdStr != null) {
			setTweetIdStr(tweetIdStr);
		}

		Date tweetCreatedAt = (Date)attributes.get("tweetCreatedAt");

		if (tweetCreatedAt != null) {
			setTweetCreatedAt(tweetCreatedAt);
		}

		Boolean tweetRetweeted = (Boolean)attributes.get("tweetRetweeted");

		if (tweetRetweeted != null) {
			setTweetRetweeted(tweetRetweeted);
		}

		Integer tweetRetweetCount = (Integer)attributes.get("tweetRetweetCount");

		if (tweetRetweetCount != null) {
			setTweetRetweetCount(tweetRetweetCount);
		}

		String tweetText = (String)attributes.get("tweetText");

		if (tweetText != null) {
			setTweetText(tweetText);
		}
	}

	/**
	* Returns the primary key of this tweet.
	*
	* @return the primary key of this tweet
	*/
	@Override
	public com.rcs.dbService.service.persistence.TweetPK getPrimaryKey() {
		return _tweet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tweet.
	*
	* @param primaryKey the primary key of this tweet
	*/
	@Override
	public void setPrimaryKey(
		com.rcs.dbService.service.persistence.TweetPK primaryKey) {
		_tweet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this tweet.
	*
	* @return the group ID of this tweet
	*/
	@Override
	public long getGroupId() {
		return _tweet.getGroupId();
	}

	/**
	* Sets the group ID of this tweet.
	*
	* @param groupId the group ID of this tweet
	*/
	@Override
	public void setGroupId(long groupId) {
		_tweet.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this tweet.
	*
	* @return the company ID of this tweet
	*/
	@Override
	public long getCompanyId() {
		return _tweet.getCompanyId();
	}

	/**
	* Sets the company ID of this tweet.
	*
	* @param companyId the company ID of this tweet
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tweet.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tweet.
	*
	* @return the user ID of this tweet
	*/
	@Override
	public long getUserId() {
		return _tweet.getUserId();
	}

	/**
	* Sets the user ID of this tweet.
	*
	* @param userId the user ID of this tweet
	*/
	@Override
	public void setUserId(long userId) {
		_tweet.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tweet.
	*
	* @return the user uuid of this tweet
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tweet.getUserUuid();
	}

	/**
	* Sets the user uuid of this tweet.
	*
	* @param userUuid the user uuid of this tweet
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tweet.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tweet.
	*
	* @return the user name of this tweet
	*/
	@Override
	public java.lang.String getUserName() {
		return _tweet.getUserName();
	}

	/**
	* Sets the user name of this tweet.
	*
	* @param userName the user name of this tweet
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tweet.setUserName(userName);
	}

	/**
	* Returns the create date of this tweet.
	*
	* @return the create date of this tweet
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tweet.getCreateDate();
	}

	/**
	* Sets the create date of this tweet.
	*
	* @param createDate the create date of this tweet
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tweet.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this tweet.
	*
	* @return the modified date of this tweet
	*/
	@Override
	public boolean getModifiedDate() {
		return _tweet.getModifiedDate();
	}

	/**
	* Returns <code>true</code> if this tweet is modified date.
	*
	* @return <code>true</code> if this tweet is modified date; <code>false</code> otherwise
	*/
	@Override
	public boolean isModifiedDate() {
		return _tweet.isModifiedDate();
	}

	/**
	* Sets whether this tweet is modified date.
	*
	* @param modifiedDate the modified date of this tweet
	*/
	@Override
	public void setModifiedDate(boolean modifiedDate) {
		_tweet.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the removed of this tweet.
	*
	* @return the removed of this tweet
	*/
	@Override
	public boolean getRemoved() {
		return _tweet.getRemoved();
	}

	/**
	* Returns <code>true</code> if this tweet is removed.
	*
	* @return <code>true</code> if this tweet is removed; <code>false</code> otherwise
	*/
	@Override
	public boolean isRemoved() {
		return _tweet.isRemoved();
	}

	/**
	* Sets whether this tweet is removed.
	*
	* @param removed the removed of this tweet
	*/
	@Override
	public void setRemoved(boolean removed) {
		_tweet.setRemoved(removed);
	}

	/**
	* Returns the tweet ID of this tweet.
	*
	* @return the tweet ID of this tweet
	*/
	@Override
	public long getTweetId() {
		return _tweet.getTweetId();
	}

	/**
	* Sets the tweet ID of this tweet.
	*
	* @param tweetId the tweet ID of this tweet
	*/
	@Override
	public void setTweetId(long tweetId) {
		_tweet.setTweetId(tweetId);
	}

	/**
	* Returns the tweet ID str of this tweet.
	*
	* @return the tweet ID str of this tweet
	*/
	@Override
	public java.lang.String getTweetIdStr() {
		return _tweet.getTweetIdStr();
	}

	/**
	* Sets the tweet ID str of this tweet.
	*
	* @param tweetIdStr the tweet ID str of this tweet
	*/
	@Override
	public void setTweetIdStr(java.lang.String tweetIdStr) {
		_tweet.setTweetIdStr(tweetIdStr);
	}

	/**
	* Returns the tweet created at of this tweet.
	*
	* @return the tweet created at of this tweet
	*/
	@Override
	public java.util.Date getTweetCreatedAt() {
		return _tweet.getTweetCreatedAt();
	}

	/**
	* Sets the tweet created at of this tweet.
	*
	* @param tweetCreatedAt the tweet created at of this tweet
	*/
	@Override
	public void setTweetCreatedAt(java.util.Date tweetCreatedAt) {
		_tweet.setTweetCreatedAt(tweetCreatedAt);
	}

	/**
	* Returns the tweet retweeted of this tweet.
	*
	* @return the tweet retweeted of this tweet
	*/
	@Override
	public boolean getTweetRetweeted() {
		return _tweet.getTweetRetweeted();
	}

	/**
	* Returns <code>true</code> if this tweet is tweet retweeted.
	*
	* @return <code>true</code> if this tweet is tweet retweeted; <code>false</code> otherwise
	*/
	@Override
	public boolean isTweetRetweeted() {
		return _tweet.isTweetRetweeted();
	}

	/**
	* Sets whether this tweet is tweet retweeted.
	*
	* @param tweetRetweeted the tweet retweeted of this tweet
	*/
	@Override
	public void setTweetRetweeted(boolean tweetRetweeted) {
		_tweet.setTweetRetweeted(tweetRetweeted);
	}

	/**
	* Returns the tweet retweet count of this tweet.
	*
	* @return the tweet retweet count of this tweet
	*/
	@Override
	public int getTweetRetweetCount() {
		return _tweet.getTweetRetweetCount();
	}

	/**
	* Sets the tweet retweet count of this tweet.
	*
	* @param tweetRetweetCount the tweet retweet count of this tweet
	*/
	@Override
	public void setTweetRetweetCount(int tweetRetweetCount) {
		_tweet.setTweetRetweetCount(tweetRetweetCount);
	}

	/**
	* Returns the tweet text of this tweet.
	*
	* @return the tweet text of this tweet
	*/
	@Override
	public java.lang.String getTweetText() {
		return _tweet.getTweetText();
	}

	/**
	* Sets the tweet text of this tweet.
	*
	* @param tweetText the tweet text of this tweet
	*/
	@Override
	public void setTweetText(java.lang.String tweetText) {
		_tweet.setTweetText(tweetText);
	}

	@Override
	public boolean isNew() {
		return _tweet.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tweet.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tweet.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tweet.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tweet.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tweet.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tweet.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tweet.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tweet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tweet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tweet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TweetWrapper((Tweet)_tweet.clone());
	}

	@Override
	public int compareTo(com.rcs.dbService.model.Tweet tweet) {
		return _tweet.compareTo(tweet);
	}

	@Override
	public int hashCode() {
		return _tweet.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.dbService.model.Tweet> toCacheModel() {
		return _tweet.toCacheModel();
	}

	@Override
	public com.rcs.dbService.model.Tweet toEscapedModel() {
		return new TweetWrapper(_tweet.toEscapedModel());
	}

	@Override
	public com.rcs.dbService.model.Tweet toUnescapedModel() {
		return new TweetWrapper(_tweet.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tweet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tweet.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tweet.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TweetWrapper)) {
			return false;
		}

		TweetWrapper tweetWrapper = (TweetWrapper)obj;

		if (Validator.equals(_tweet, tweetWrapper._tweet)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Tweet getWrappedTweet() {
		return _tweet;
	}

	@Override
	public Tweet getWrappedModel() {
		return _tweet;
	}

	@Override
	public void resetOriginalValues() {
		_tweet.resetOriginalValues();
	}

	private Tweet _tweet;
}