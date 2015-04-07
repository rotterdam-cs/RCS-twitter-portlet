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

package com.rcs.dbservice.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rcs.dbservice.service.ClpSerializer;
import com.rcs.dbservice.service.TwitterSettingsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rcs
 */
public class TwitterSettingsClp extends BaseModelImpl<TwitterSettings>
	implements TwitterSettings {
	public TwitterSettingsClp() {
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
	public long getPrimaryKey() {
		return _groupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_twitterSettingsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_twitterSettingsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_twitterSettingsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_twitterSettingsRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_twitterSettingsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_twitterSettingsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationName() {
		return _applicationName;
	}

	@Override
	public void setApplicationName(String applicationName) {
		_applicationName = applicationName;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationName",
						String.class);

				method.invoke(_twitterSettingsRemoteModel, applicationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConsumerKey() {
		return _consumerKey;
	}

	@Override
	public void setConsumerKey(String consumerKey) {
		_consumerKey = consumerKey;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerKey", String.class);

				method.invoke(_twitterSettingsRemoteModel, consumerKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConsumerKeySecret() {
		return _consumerKeySecret;
	}

	@Override
	public void setConsumerKeySecret(String consumerKeySecret) {
		_consumerKeySecret = consumerKeySecret;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setConsumerKeySecret",
						String.class);

				method.invoke(_twitterSettingsRemoteModel, consumerKeySecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccessToken() {
		return _accessToken;
	}

	@Override
	public void setAccessToken(String accessToken) {
		_accessToken = accessToken;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setAccessToken", String.class);

				method.invoke(_twitterSettingsRemoteModel, accessToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccessTokenSecret() {
		return _accessTokenSecret;
	}

	@Override
	public void setAccessTokenSecret(String accessTokenSecret) {
		_accessTokenSecret = accessTokenSecret;

		if (_twitterSettingsRemoteModel != null) {
			try {
				Class<?> clazz = _twitterSettingsRemoteModel.getClass();

				Method method = clazz.getMethod("setAccessTokenSecret",
						String.class);

				method.invoke(_twitterSettingsRemoteModel, accessTokenSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTwitterSettingsRemoteModel() {
		return _twitterSettingsRemoteModel;
	}

	public void setTwitterSettingsRemoteModel(
		BaseModel<?> twitterSettingsRemoteModel) {
		_twitterSettingsRemoteModel = twitterSettingsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _twitterSettingsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_twitterSettingsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TwitterSettingsLocalServiceUtil.addTwitterSettings(this);
		}
		else {
			TwitterSettingsLocalServiceUtil.updateTwitterSettings(this);
		}
	}

	@Override
	public TwitterSettings toEscapedModel() {
		return (TwitterSettings)ProxyUtil.newProxyInstance(TwitterSettings.class.getClassLoader(),
			new Class[] { TwitterSettings.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TwitterSettingsClp clone = new TwitterSettingsClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setApplicationName(getApplicationName());
		clone.setConsumerKey(getConsumerKey());
		clone.setConsumerKeySecret(getConsumerKeySecret());
		clone.setAccessToken(getAccessToken());
		clone.setAccessTokenSecret(getAccessTokenSecret());

		return clone;
	}

	@Override
	public int compareTo(TwitterSettings twitterSettings) {
		long primaryKey = twitterSettings.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TwitterSettingsClp)) {
			return false;
		}

		TwitterSettingsClp twitterSettings = (TwitterSettingsClp)obj;

		long primaryKey = twitterSettings.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", applicationName=");
		sb.append(getApplicationName());
		sb.append(", consumerKey=");
		sb.append(getConsumerKey());
		sb.append(", consumerKeySecret=");
		sb.append(getConsumerKeySecret());
		sb.append(", accessToken=");
		sb.append(getAccessToken());
		sb.append(", accessTokenSecret=");
		sb.append(getAccessTokenSecret());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.rcs.dbservice.model.TwitterSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationName</column-name><column-value><![CDATA[");
		sb.append(getApplicationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerKey</column-name><column-value><![CDATA[");
		sb.append(getConsumerKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerKeySecret</column-name><column-value><![CDATA[");
		sb.append(getConsumerKeySecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessToken</column-name><column-value><![CDATA[");
		sb.append(getAccessToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessTokenSecret</column-name><column-value><![CDATA[");
		sb.append(getAccessTokenSecret());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicationName;
	private String _consumerKey;
	private String _consumerKeySecret;
	private String _accessToken;
	private String _accessTokenSecret;
	private BaseModel<?> _twitterSettingsRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.dbservice.service.ClpSerializer.class;
}