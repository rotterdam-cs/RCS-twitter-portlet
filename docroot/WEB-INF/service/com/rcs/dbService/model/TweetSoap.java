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

import com.rcs.dbService.service.persistence.TweetPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rcs.dbService.service.http.TweetServiceSoap}.
 *
 * @author rcs
 * @see com.rcs.dbService.service.http.TweetServiceSoap
 * @generated
 */
public class TweetSoap implements Serializable {
	public static TweetSoap toSoapModel(Tweet model) {
		TweetSoap soapModel = new TweetSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRemoved(model.getRemoved());
		soapModel.setTweetId(model.getTweetId());
		soapModel.setTweetIdStr(model.getTweetIdStr());
		soapModel.setTweetCreatedAt(model.getTweetCreatedAt());
		soapModel.setTweetRetweeted(model.getTweetRetweeted());
		soapModel.setTweetRetweetCount(model.getTweetRetweetCount());
		soapModel.setTweetText(model.getTweetText());

		return soapModel;
	}

	public static TweetSoap[] toSoapModels(Tweet[] models) {
		TweetSoap[] soapModels = new TweetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TweetSoap[][] toSoapModels(Tweet[][] models) {
		TweetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TweetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TweetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TweetSoap[] toSoapModels(List<Tweet> models) {
		List<TweetSoap> soapModels = new ArrayList<TweetSoap>(models.size());

		for (Tweet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TweetSoap[soapModels.size()]);
	}

	public TweetSoap() {
	}

	public TweetPK getPrimaryKey() {
		return new TweetPK(_groupId, _tweetId);
	}

	public void setPrimaryKey(TweetPK pk) {
		setGroupId(pk.groupId);
		setTweetId(pk.tweetId);
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

	public boolean getModifiedDate() {
		return _modifiedDate;
	}

	public boolean isModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(boolean modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getRemoved() {
		return _removed;
	}

	public boolean isRemoved() {
		return _removed;
	}

	public void setRemoved(boolean removed) {
		_removed = removed;
	}

	public long getTweetId() {
		return _tweetId;
	}

	public void setTweetId(long tweetId) {
		_tweetId = tweetId;
	}

	public String getTweetIdStr() {
		return _tweetIdStr;
	}

	public void setTweetIdStr(String tweetIdStr) {
		_tweetIdStr = tweetIdStr;
	}

	public Date getTweetCreatedAt() {
		return _tweetCreatedAt;
	}

	public void setTweetCreatedAt(Date tweetCreatedAt) {
		_tweetCreatedAt = tweetCreatedAt;
	}

	public boolean getTweetRetweeted() {
		return _tweetRetweeted;
	}

	public boolean isTweetRetweeted() {
		return _tweetRetweeted;
	}

	public void setTweetRetweeted(boolean tweetRetweeted) {
		_tweetRetweeted = tweetRetweeted;
	}

	public int getTweetRetweetCount() {
		return _tweetRetweetCount;
	}

	public void setTweetRetweetCount(int tweetRetweetCount) {
		_tweetRetweetCount = tweetRetweetCount;
	}

	public String getTweetText() {
		return _tweetText;
	}

	public void setTweetText(String tweetText) {
		_tweetText = tweetText;
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
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
}