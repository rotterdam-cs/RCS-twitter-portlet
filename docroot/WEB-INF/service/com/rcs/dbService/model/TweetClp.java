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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rcs.dbService.service.ClpSerializer;
import com.rcs.dbService.service.TweetLocalServiceUtil;
import com.rcs.dbService.service.persistence.TweetPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rcs
 */
public class TweetClp extends BaseModelImpl<Tweet> implements Tweet {
	public TweetClp() {
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
	public TweetPK getPrimaryKey() {
		return new TweetPK(_groupId, _tweetId);
	}

	@Override
	public void setPrimaryKey(TweetPK primaryKey) {
		setGroupId(primaryKey.groupId);
		setTweetId(primaryKey.tweetId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new TweetPK(_groupId, _tweetId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((TweetPK)primaryKeyObj);
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

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tweetRemoteModel, groupId);
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

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tweetRemoteModel, companyId);
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

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tweetRemoteModel, userId);
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

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_tweetRemoteModel, userName);
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

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_tweetRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public boolean isModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(boolean modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", boolean.class);

				method.invoke(_tweetRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRemoved() {
		return _removed;
	}

	@Override
	public boolean isRemoved() {
		return _removed;
	}

	@Override
	public void setRemoved(boolean removed) {
		_removed = removed;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setRemoved", boolean.class);

				method.invoke(_tweetRemoteModel, removed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTweetId() {
		return _tweetId;
	}

	@Override
	public void setTweetId(long tweetId) {
		_tweetId = tweetId;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setTweetId", long.class);

				method.invoke(_tweetRemoteModel, tweetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTweetIdStr() {
		return _tweetIdStr;
	}

	@Override
	public void setTweetIdStr(String tweetIdStr) {
		_tweetIdStr = tweetIdStr;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setTweetIdStr", String.class);

				method.invoke(_tweetRemoteModel, tweetIdStr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTweetCreatedAt() {
		return _tweetCreatedAt;
	}

	@Override
	public void setTweetCreatedAt(Date tweetCreatedAt) {
		_tweetCreatedAt = tweetCreatedAt;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setTweetCreatedAt", Date.class);

				method.invoke(_tweetRemoteModel, tweetCreatedAt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTweetRetweeted() {
		return _tweetRetweeted;
	}

	@Override
	public boolean isTweetRetweeted() {
		return _tweetRetweeted;
	}

	@Override
	public void setTweetRetweeted(boolean tweetRetweeted) {
		_tweetRetweeted = tweetRetweeted;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setTweetRetweeted",
						boolean.class);

				method.invoke(_tweetRemoteModel, tweetRetweeted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTweetRetweetCount() {
		return _tweetRetweetCount;
	}

	@Override
	public void setTweetRetweetCount(int tweetRetweetCount) {
		_tweetRetweetCount = tweetRetweetCount;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setTweetRetweetCount",
						int.class);

				method.invoke(_tweetRemoteModel, tweetRetweetCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTweetText() {
		return _tweetText;
	}

	@Override
	public void setTweetText(String tweetText) {
		_tweetText = tweetText;

		if (_tweetRemoteModel != null) {
			try {
				Class<?> clazz = _tweetRemoteModel.getClass();

				Method method = clazz.getMethod("setTweetText", String.class);

				method.invoke(_tweetRemoteModel, tweetText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTweetRemoteModel() {
		return _tweetRemoteModel;
	}

	public void setTweetRemoteModel(BaseModel<?> tweetRemoteModel) {
		_tweetRemoteModel = tweetRemoteModel;
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

		Class<?> remoteModelClass = _tweetRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tweetRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TweetLocalServiceUtil.addTweet(this);
		}
		else {
			TweetLocalServiceUtil.updateTweet(this);
		}
	}

	@Override
	public Tweet toEscapedModel() {
		return (Tweet)ProxyUtil.newProxyInstance(Tweet.class.getClassLoader(),
			new Class[] { Tweet.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TweetClp clone = new TweetClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRemoved(getRemoved());
		clone.setTweetId(getTweetId());
		clone.setTweetIdStr(getTweetIdStr());
		clone.setTweetCreatedAt(getTweetCreatedAt());
		clone.setTweetRetweeted(getTweetRetweeted());
		clone.setTweetRetweetCount(getTweetRetweetCount());
		clone.setTweetText(getTweetText());

		return clone;
	}

	@Override
	public int compareTo(Tweet tweet) {
		int value = 0;

		value = DateUtil.compareTo(getTweetCreatedAt(),
				tweet.getTweetCreatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TweetClp)) {
			return false;
		}

		TweetClp tweet = (TweetClp)obj;

		TweetPK primaryKey = tweet.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

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
		sb.append(", removed=");
		sb.append(getRemoved());
		sb.append(", tweetId=");
		sb.append(getTweetId());
		sb.append(", tweetIdStr=");
		sb.append(getTweetIdStr());
		sb.append(", tweetCreatedAt=");
		sb.append(getTweetCreatedAt());
		sb.append(", tweetRetweeted=");
		sb.append(getTweetRetweeted());
		sb.append(", tweetRetweetCount=");
		sb.append(getTweetRetweetCount());
		sb.append(", tweetText=");
		sb.append(getTweetText());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.rcs.dbService.model.Tweet");
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
			"<column><column-name>removed</column-name><column-value><![CDATA[");
		sb.append(getRemoved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetId</column-name><column-value><![CDATA[");
		sb.append(getTweetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetIdStr</column-name><column-value><![CDATA[");
		sb.append(getTweetIdStr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetCreatedAt</column-name><column-value><![CDATA[");
		sb.append(getTweetCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetRetweeted</column-name><column-value><![CDATA[");
		sb.append(getTweetRetweeted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetRetweetCount</column-name><column-value><![CDATA[");
		sb.append(getTweetRetweetCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tweetText</column-name><column-value><![CDATA[");
		sb.append(getTweetText());
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
	private boolean _modifiedDate;
	private boolean _removed;
	private long _tweetId;
	private String _tweetIdStr;
	private Date _tweetCreatedAt;
	private boolean _tweetRetweeted;
	private int _tweetRetweetCount;
	private String _tweetText;
	private BaseModel<?> _tweetRemoteModel;
	private Class<?> _clpSerializerClass = com.rcs.dbService.service.ClpSerializer.class;
}