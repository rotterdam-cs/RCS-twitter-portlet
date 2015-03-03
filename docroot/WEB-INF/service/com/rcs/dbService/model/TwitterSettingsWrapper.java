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
 * This class is a wrapper for {@link TwitterSettings}.
 * </p>
 *
 * @author rcs
 * @see TwitterSettings
 * @generated
 */
public class TwitterSettingsWrapper implements TwitterSettings,
	ModelWrapper<TwitterSettings> {
	public TwitterSettingsWrapper(TwitterSettings twitterSettings) {
		_twitterSettings = twitterSettings;
	}

	@Override
	public Class<?> getModelClass() {
		return TwitterSettings.class;
	}

	@Override
	public String getModelClassName() {
		return TwitterSettings.class.getName();
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
		attributes.put("applicationName", getApplicationName());
		attributes.put("consumerKey", getConsumerKey());
		attributes.put("consumerKeySecret", getConsumerKeySecret());
		attributes.put("accessToken", getAccessToken());
		attributes.put("accessTokenSecret", getAccessTokenSecret());

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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String applicationName = (String)attributes.get("applicationName");

		if (applicationName != null) {
			setApplicationName(applicationName);
		}

		String consumerKey = (String)attributes.get("consumerKey");

		if (consumerKey != null) {
			setConsumerKey(consumerKey);
		}

		String consumerKeySecret = (String)attributes.get("consumerKeySecret");

		if (consumerKeySecret != null) {
			setConsumerKeySecret(consumerKeySecret);
		}

		String accessToken = (String)attributes.get("accessToken");

		if (accessToken != null) {
			setAccessToken(accessToken);
		}

		String accessTokenSecret = (String)attributes.get("accessTokenSecret");

		if (accessTokenSecret != null) {
			setAccessTokenSecret(accessTokenSecret);
		}
	}

	/**
	* Returns the primary key of this twitter settings.
	*
	* @return the primary key of this twitter settings
	*/
	@Override
	public long getPrimaryKey() {
		return _twitterSettings.getPrimaryKey();
	}

	/**
	* Sets the primary key of this twitter settings.
	*
	* @param primaryKey the primary key of this twitter settings
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_twitterSettings.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this twitter settings.
	*
	* @return the group ID of this twitter settings
	*/
	@Override
	public long getGroupId() {
		return _twitterSettings.getGroupId();
	}

	/**
	* Sets the group ID of this twitter settings.
	*
	* @param groupId the group ID of this twitter settings
	*/
	@Override
	public void setGroupId(long groupId) {
		_twitterSettings.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this twitter settings.
	*
	* @return the company ID of this twitter settings
	*/
	@Override
	public long getCompanyId() {
		return _twitterSettings.getCompanyId();
	}

	/**
	* Sets the company ID of this twitter settings.
	*
	* @param companyId the company ID of this twitter settings
	*/
	@Override
	public void setCompanyId(long companyId) {
		_twitterSettings.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this twitter settings.
	*
	* @return the user ID of this twitter settings
	*/
	@Override
	public long getUserId() {
		return _twitterSettings.getUserId();
	}

	/**
	* Sets the user ID of this twitter settings.
	*
	* @param userId the user ID of this twitter settings
	*/
	@Override
	public void setUserId(long userId) {
		_twitterSettings.setUserId(userId);
	}

	/**
	* Returns the user uuid of this twitter settings.
	*
	* @return the user uuid of this twitter settings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettings.getUserUuid();
	}

	/**
	* Sets the user uuid of this twitter settings.
	*
	* @param userUuid the user uuid of this twitter settings
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_twitterSettings.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this twitter settings.
	*
	* @return the user name of this twitter settings
	*/
	@Override
	public java.lang.String getUserName() {
		return _twitterSettings.getUserName();
	}

	/**
	* Sets the user name of this twitter settings.
	*
	* @param userName the user name of this twitter settings
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_twitterSettings.setUserName(userName);
	}

	/**
	* Returns the create date of this twitter settings.
	*
	* @return the create date of this twitter settings
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _twitterSettings.getCreateDate();
	}

	/**
	* Sets the create date of this twitter settings.
	*
	* @param createDate the create date of this twitter settings
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_twitterSettings.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this twitter settings.
	*
	* @return the modified date of this twitter settings
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _twitterSettings.getModifiedDate();
	}

	/**
	* Sets the modified date of this twitter settings.
	*
	* @param modifiedDate the modified date of this twitter settings
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_twitterSettings.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the application name of this twitter settings.
	*
	* @return the application name of this twitter settings
	*/
	@Override
	public java.lang.String getApplicationName() {
		return _twitterSettings.getApplicationName();
	}

	/**
	* Sets the application name of this twitter settings.
	*
	* @param applicationName the application name of this twitter settings
	*/
	@Override
	public void setApplicationName(java.lang.String applicationName) {
		_twitterSettings.setApplicationName(applicationName);
	}

	/**
	* Returns the consumer key of this twitter settings.
	*
	* @return the consumer key of this twitter settings
	*/
	@Override
	public java.lang.String getConsumerKey() {
		return _twitterSettings.getConsumerKey();
	}

	/**
	* Sets the consumer key of this twitter settings.
	*
	* @param consumerKey the consumer key of this twitter settings
	*/
	@Override
	public void setConsumerKey(java.lang.String consumerKey) {
		_twitterSettings.setConsumerKey(consumerKey);
	}

	/**
	* Returns the consumer key secret of this twitter settings.
	*
	* @return the consumer key secret of this twitter settings
	*/
	@Override
	public java.lang.String getConsumerKeySecret() {
		return _twitterSettings.getConsumerKeySecret();
	}

	/**
	* Sets the consumer key secret of this twitter settings.
	*
	* @param consumerKeySecret the consumer key secret of this twitter settings
	*/
	@Override
	public void setConsumerKeySecret(java.lang.String consumerKeySecret) {
		_twitterSettings.setConsumerKeySecret(consumerKeySecret);
	}

	/**
	* Returns the access token of this twitter settings.
	*
	* @return the access token of this twitter settings
	*/
	@Override
	public java.lang.String getAccessToken() {
		return _twitterSettings.getAccessToken();
	}

	/**
	* Sets the access token of this twitter settings.
	*
	* @param accessToken the access token of this twitter settings
	*/
	@Override
	public void setAccessToken(java.lang.String accessToken) {
		_twitterSettings.setAccessToken(accessToken);
	}

	/**
	* Returns the access token secret of this twitter settings.
	*
	* @return the access token secret of this twitter settings
	*/
	@Override
	public java.lang.String getAccessTokenSecret() {
		return _twitterSettings.getAccessTokenSecret();
	}

	/**
	* Sets the access token secret of this twitter settings.
	*
	* @param accessTokenSecret the access token secret of this twitter settings
	*/
	@Override
	public void setAccessTokenSecret(java.lang.String accessTokenSecret) {
		_twitterSettings.setAccessTokenSecret(accessTokenSecret);
	}

	@Override
	public boolean isNew() {
		return _twitterSettings.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_twitterSettings.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _twitterSettings.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_twitterSettings.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _twitterSettings.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _twitterSettings.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_twitterSettings.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _twitterSettings.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_twitterSettings.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_twitterSettings.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_twitterSettings.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TwitterSettingsWrapper((TwitterSettings)_twitterSettings.clone());
	}

	@Override
	public int compareTo(TwitterSettings twitterSettings) {
		return _twitterSettings.compareTo(twitterSettings);
	}

	@Override
	public int hashCode() {
		return _twitterSettings.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<TwitterSettings> toCacheModel() {
		return _twitterSettings.toCacheModel();
	}

	@Override
	public TwitterSettings toEscapedModel() {
		return new TwitterSettingsWrapper(_twitterSettings.toEscapedModel());
	}

	@Override
	public TwitterSettings toUnescapedModel() {
		return new TwitterSettingsWrapper(_twitterSettings.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _twitterSettings.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _twitterSettings.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_twitterSettings.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TwitterSettingsWrapper)) {
			return false;
		}

		TwitterSettingsWrapper twitterSettingsWrapper = (TwitterSettingsWrapper)obj;

		if (Validator.equals(_twitterSettings,
					twitterSettingsWrapper._twitterSettings)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TwitterSettings getWrappedTwitterSettings() {
		return _twitterSettings;
	}

	@Override
	public TwitterSettings getWrappedModel() {
		return _twitterSettings;
	}

	@Override
	public void resetOriginalValues() {
		_twitterSettings.resetOriginalValues();
	}

	private TwitterSettings _twitterSettings;
}