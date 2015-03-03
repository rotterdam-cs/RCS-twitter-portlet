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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rcs.dbService.service.http.TwitterSettingsServiceSoap}.
 *
 * @author rcs
 * @see com.rcs.dbService.service.http.TwitterSettingsServiceSoap
 * @generated
 */
public class TwitterSettingsSoap implements Serializable {
	public static TwitterSettingsSoap toSoapModel(TwitterSettings model) {
		TwitterSettingsSoap soapModel = new TwitterSettingsSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApplicationName(model.getApplicationName());
		soapModel.setConsumerKey(model.getConsumerKey());
		soapModel.setConsumerKeySecret(model.getConsumerKeySecret());
		soapModel.setAccessToken(model.getAccessToken());
		soapModel.setAccessTokenSecret(model.getAccessTokenSecret());

		return soapModel;
	}

	public static TwitterSettingsSoap[] toSoapModels(TwitterSettings[] models) {
		TwitterSettingsSoap[] soapModels = new TwitterSettingsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TwitterSettingsSoap[][] toSoapModels(
		TwitterSettings[][] models) {
		TwitterSettingsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TwitterSettingsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TwitterSettingsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TwitterSettingsSoap[] toSoapModels(
		List<TwitterSettings> models) {
		List<TwitterSettingsSoap> soapModels = new ArrayList<TwitterSettingsSoap>(models.size());

		for (TwitterSettings model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TwitterSettingsSoap[soapModels.size()]);
	}

	public TwitterSettingsSoap() {
	}

	public long getPrimaryKey() {
		return _groupId;
	}

	public void setPrimaryKey(long pk) {
		setGroupId(pk);
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getApplicationName() {
		return _applicationName;
	}

	public void setApplicationName(String applicationName) {
		_applicationName = applicationName;
	}

	public String getConsumerKey() {
		return _consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		_consumerKey = consumerKey;
	}

	public String getConsumerKeySecret() {
		return _consumerKeySecret;
	}

	public void setConsumerKeySecret(String consumerKeySecret) {
		_consumerKeySecret = consumerKeySecret;
	}

	public String getAccessToken() {
		return _accessToken;
	}

	public void setAccessToken(String accessToken) {
		_accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return _accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		_accessTokenSecret = accessTokenSecret;
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicationName;
	private String _consumerKey;
	private String _consumerKeySecret;
	private String _accessToken;
	private String _accessTokenSecret;
}