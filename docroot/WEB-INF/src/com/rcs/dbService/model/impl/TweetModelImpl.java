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

package com.rcs.dbService.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rcs.dbService.model.Tweet;
import com.rcs.dbService.model.TweetModel;
import com.rcs.dbService.model.TweetSoap;
import com.rcs.dbService.service.persistence.TweetPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Tweet service. Represents a row in the &quot;twitter_Tweet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rcs.dbService.model.TweetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TweetImpl}.
 * </p>
 *
 * @author rcs
 * @see TweetImpl
 * @see com.rcs.dbService.model.Tweet
 * @see com.rcs.dbService.model.TweetModel
 * @generated
 */
@JSON(strict = true)
public class TweetModelImpl extends BaseModelImpl<Tweet> implements TweetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tweet model instance should use the {@link com.rcs.dbService.model.Tweet} interface instead.
	 */
	public static final String TABLE_NAME = "twitter_Tweet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.BOOLEAN },
			{ "removed", Types.BOOLEAN },
			{ "tweetId", Types.BIGINT },
			{ "tweetIdStr", Types.VARCHAR },
			{ "tweetCreatedAt", Types.TIMESTAMP },
			{ "tweetRetweeted", Types.BOOLEAN },
			{ "tweetRetweetCount", Types.INTEGER },
			{ "tweetText", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table twitter_Tweet (groupId LONG not null,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate BOOLEAN,removed BOOLEAN,tweetId LONG not null,tweetIdStr VARCHAR(75) null,tweetCreatedAt DATE null,tweetRetweeted BOOLEAN,tweetRetweetCount INTEGER,tweetText VARCHAR(200) null,primary key (groupId, tweetId))";
	public static final String TABLE_SQL_DROP = "drop table twitter_Tweet";
	public static final String ORDER_BY_JPQL = " ORDER BY tweet.tweetCreatedAt DESC";
	public static final String ORDER_BY_SQL = " ORDER BY twitter_Tweet.tweetCreatedAt DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rcs.dbService.model.Tweet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rcs.dbService.model.Tweet"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rcs.dbService.model.Tweet"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long TWEETID_COLUMN_BITMASK = 2L;
	public static long TWEETCREATEDAT_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Tweet toModel(TweetSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Tweet model = new TweetImpl();

		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setRemoved(soapModel.getRemoved());
		model.setTweetId(soapModel.getTweetId());
		model.setTweetIdStr(soapModel.getTweetIdStr());
		model.setTweetCreatedAt(soapModel.getTweetCreatedAt());
		model.setTweetRetweeted(soapModel.getTweetRetweeted());
		model.setTweetRetweetCount(soapModel.getTweetRetweetCount());
		model.setTweetText(soapModel.getTweetText());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Tweet> toModels(TweetSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Tweet> models = new ArrayList<Tweet>(soapModels.length);

		for (TweetSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rcs.dbService.model.Tweet"));

	public TweetModelImpl() {
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

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
	@Override
	public long getTweetId() {
		return _tweetId;
	}

	@Override
	public void setTweetId(long tweetId) {
		_columnBitmask |= TWEETID_COLUMN_BITMASK;

		if (!_setOriginalTweetId) {
			_setOriginalTweetId = true;

			_originalTweetId = _tweetId;
		}

		_tweetId = tweetId;
	}

	public long getOriginalTweetId() {
		return _originalTweetId;
	}

	@JSON
	@Override
	public String getTweetIdStr() {
		if (_tweetIdStr == null) {
			return StringPool.BLANK;
		}
		else {
			return _tweetIdStr;
		}
	}

	@Override
	public void setTweetIdStr(String tweetIdStr) {
		_tweetIdStr = tweetIdStr;
	}

	@JSON
	@Override
	public Date getTweetCreatedAt() {
		return _tweetCreatedAt;
	}

	@Override
	public void setTweetCreatedAt(Date tweetCreatedAt) {
		_columnBitmask = -1L;

		_tweetCreatedAt = tweetCreatedAt;
	}

	@JSON
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
	}

	@JSON
	@Override
	public int getTweetRetweetCount() {
		return _tweetRetweetCount;
	}

	@Override
	public void setTweetRetweetCount(int tweetRetweetCount) {
		_tweetRetweetCount = tweetRetweetCount;
	}

	@JSON
	@Override
	public String getTweetText() {
		if (_tweetText == null) {
			return StringPool.BLANK;
		}
		else {
			return _tweetText;
		}
	}

	@Override
	public void setTweetText(String tweetText) {
		_tweetText = tweetText;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Tweet toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Tweet)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TweetImpl tweetImpl = new TweetImpl();

		tweetImpl.setGroupId(getGroupId());
		tweetImpl.setCompanyId(getCompanyId());
		tweetImpl.setUserId(getUserId());
		tweetImpl.setUserName(getUserName());
		tweetImpl.setCreateDate(getCreateDate());
		tweetImpl.setModifiedDate(getModifiedDate());
		tweetImpl.setRemoved(getRemoved());
		tweetImpl.setTweetId(getTweetId());
		tweetImpl.setTweetIdStr(getTweetIdStr());
		tweetImpl.setTweetCreatedAt(getTweetCreatedAt());
		tweetImpl.setTweetRetweeted(getTweetRetweeted());
		tweetImpl.setTweetRetweetCount(getTweetRetweetCount());
		tweetImpl.setTweetText(getTweetText());

		tweetImpl.resetOriginalValues();

		return tweetImpl;
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

		if (!(obj instanceof Tweet)) {
			return false;
		}

		Tweet tweet = (Tweet)obj;

		TweetPK primaryKey = tweet.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		TweetModelImpl tweetModelImpl = this;

		tweetModelImpl._originalGroupId = tweetModelImpl._groupId;

		tweetModelImpl._setOriginalGroupId = false;

		tweetModelImpl._originalTweetId = tweetModelImpl._tweetId;

		tweetModelImpl._setOriginalTweetId = false;

		tweetModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Tweet> toCacheModel() {
		TweetCacheModel tweetCacheModel = new TweetCacheModel();

		tweetCacheModel.groupId = getGroupId();

		tweetCacheModel.companyId = getCompanyId();

		tweetCacheModel.userId = getUserId();

		tweetCacheModel.userName = getUserName();

		String userName = tweetCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tweetCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tweetCacheModel.createDate = createDate.getTime();
		}
		else {
			tweetCacheModel.createDate = Long.MIN_VALUE;
		}

		tweetCacheModel.modifiedDate = getModifiedDate();

		tweetCacheModel.removed = getRemoved();

		tweetCacheModel.tweetId = getTweetId();

		tweetCacheModel.tweetIdStr = getTweetIdStr();

		String tweetIdStr = tweetCacheModel.tweetIdStr;

		if ((tweetIdStr != null) && (tweetIdStr.length() == 0)) {
			tweetCacheModel.tweetIdStr = null;
		}

		Date tweetCreatedAt = getTweetCreatedAt();

		if (tweetCreatedAt != null) {
			tweetCacheModel.tweetCreatedAt = tweetCreatedAt.getTime();
		}
		else {
			tweetCacheModel.tweetCreatedAt = Long.MIN_VALUE;
		}

		tweetCacheModel.tweetRetweeted = getTweetRetweeted();

		tweetCacheModel.tweetRetweetCount = getTweetRetweetCount();

		tweetCacheModel.tweetText = getTweetText();

		String tweetText = tweetCacheModel.tweetText;

		if ((tweetText != null) && (tweetText.length() == 0)) {
			tweetCacheModel.tweetText = null;
		}

		return tweetCacheModel;
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

	private static ClassLoader _classLoader = Tweet.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Tweet.class };
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private boolean _modifiedDate;
	private boolean _removed;
	private long _tweetId;
	private long _originalTweetId;
	private boolean _setOriginalTweetId;
	private String _tweetIdStr;
	private Date _tweetCreatedAt;
	private boolean _tweetRetweeted;
	private int _tweetRetweetCount;
	private String _tweetText;
	private long _columnBitmask;
	private Tweet _escapedModel;
}