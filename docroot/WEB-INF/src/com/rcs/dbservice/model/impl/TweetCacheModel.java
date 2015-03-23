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

import com.rcs.dbservice.model.Tweet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tweet in entity cache.
 *
 * @author rcs
 * @see Tweet
 * @generated
 */
public class TweetCacheModel implements CacheModel<Tweet>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

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
		sb.append(", removed=");
		sb.append(removed);
		sb.append(", tweetId=");
		sb.append(tweetId);
		sb.append(", tweetIdStr=");
		sb.append(tweetIdStr);
		sb.append(", tweetCreatedAt=");
		sb.append(tweetCreatedAt);
		sb.append(", tweetRetweeted=");
		sb.append(tweetRetweeted);
		sb.append(", tweetRetweetCount=");
		sb.append(tweetRetweetCount);
		sb.append(", tweetText=");
		sb.append(tweetText);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tweet toEntityModel() {
		TweetImpl tweetImpl = new TweetImpl();

		tweetImpl.setGroupId(groupId);
		tweetImpl.setCompanyId(companyId);
		tweetImpl.setUserId(userId);

		if (userName == null) {
			tweetImpl.setUserName(StringPool.BLANK);
		}
		else {
			tweetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tweetImpl.setCreateDate(null);
		}
		else {
			tweetImpl.setCreateDate(new Date(createDate));
		}

		tweetImpl.setModifiedDate(modifiedDate);
		tweetImpl.setRemoved(removed);
		tweetImpl.setTweetId(tweetId);

		if (tweetIdStr == null) {
			tweetImpl.setTweetIdStr(StringPool.BLANK);
		}
		else {
			tweetImpl.setTweetIdStr(tweetIdStr);
		}

		if (tweetCreatedAt == Long.MIN_VALUE) {
			tweetImpl.setTweetCreatedAt(null);
		}
		else {
			tweetImpl.setTweetCreatedAt(new Date(tweetCreatedAt));
		}

		tweetImpl.setTweetRetweeted(tweetRetweeted);
		tweetImpl.setTweetRetweetCount(tweetRetweetCount);

		if (tweetText == null) {
			tweetImpl.setTweetText(StringPool.BLANK);
		}
		else {
			tweetImpl.setTweetText(tweetText);
		}

		tweetImpl.resetOriginalValues();

		return tweetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readBoolean();
		removed = objectInput.readBoolean();
		tweetId = objectInput.readLong();
		tweetIdStr = objectInput.readUTF();
		tweetCreatedAt = objectInput.readLong();
		tweetRetweeted = objectInput.readBoolean();
		tweetRetweetCount = objectInput.readInt();
		tweetText = objectInput.readUTF();
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
		objectOutput.writeBoolean(modifiedDate);
		objectOutput.writeBoolean(removed);
		objectOutput.writeLong(tweetId);

		if (tweetIdStr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tweetIdStr);
		}

		objectOutput.writeLong(tweetCreatedAt);
		objectOutput.writeBoolean(tweetRetweeted);
		objectOutput.writeInt(tweetRetweetCount);

		if (tweetText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tweetText);
		}
	}

	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public boolean modifiedDate;
	public boolean removed;
	public long tweetId;
	public String tweetIdStr;
	public long tweetCreatedAt;
	public boolean tweetRetweeted;
	public int tweetRetweetCount;
	public String tweetText;
}