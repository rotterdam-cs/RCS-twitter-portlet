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

package com.rcs.dbservice.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.dbservice.model.TwitterSettings;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TwitterSettings in entity cache.
 *
 * @author rcs
 * @see TwitterSettings
 * @generated
 */
public class TwitterSettingsCacheModel implements CacheModel<TwitterSettings>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", applicationName=");
		sb.append(applicationName);
		sb.append(", consumerKey=");
		sb.append(consumerKey);
		sb.append(", consumerKeySecret=");
		sb.append(consumerKeySecret);
		sb.append(", accessToken=");
		sb.append(accessToken);
		sb.append(", accessTokenSecret=");
		sb.append(accessTokenSecret);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TwitterSettings toEntityModel() {
		TwitterSettingsImpl twitterSettingsImpl = new TwitterSettingsImpl();

		twitterSettingsImpl.setGroupId(groupId);
		twitterSettingsImpl.setCompanyId(companyId);
		twitterSettingsImpl.setUserId(userId);

		if (userName == null) {
			twitterSettingsImpl.setUserName(StringPool.BLANK);
		}
		else {
			twitterSettingsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			twitterSettingsImpl.setCreateDate(null);
		}
		else {
			twitterSettingsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			twitterSettingsImpl.setModifiedDate(null);
		}
		else {
			twitterSettingsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (applicationName == null) {
			twitterSettingsImpl.setApplicationName(StringPool.BLANK);
		}
		else {
			twitterSettingsImpl.setApplicationName(applicationName);
		}

		if (consumerKey == null) {
			twitterSettingsImpl.setConsumerKey(StringPool.BLANK);
		}
		else {
			twitterSettingsImpl.setConsumerKey(consumerKey);
		}

		if (consumerKeySecret == null) {
			twitterSettingsImpl.setConsumerKeySecret(StringPool.BLANK);
		}
		else {
			twitterSettingsImpl.setConsumerKeySecret(consumerKeySecret);
		}

		if (accessToken == null) {
			twitterSettingsImpl.setAccessToken(StringPool.BLANK);
		}
		else {
			twitterSettingsImpl.setAccessToken(accessToken);
		}

		if (accessTokenSecret == null) {
			twitterSettingsImpl.setAccessTokenSecret(StringPool.BLANK);
		}
		else {
			twitterSettingsImpl.setAccessTokenSecret(accessTokenSecret);
		}

		twitterSettingsImpl.resetOriginalValues();

		return twitterSettingsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		applicationName = objectInput.readUTF();
		consumerKey = objectInput.readUTF();
		consumerKeySecret = objectInput.readUTF();
		accessToken = objectInput.readUTF();
		accessTokenSecret = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (applicationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationName);
		}

		if (consumerKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consumerKey);
		}

		if (consumerKeySecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(consumerKeySecret);
		}

		if (accessToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accessToken);
		}

		if (accessTokenSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accessTokenSecret);
		}
	}

	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String applicationName;
	public String consumerKey;
	public String consumerKeySecret;
	public String accessToken;
	public String accessTokenSecret;
}