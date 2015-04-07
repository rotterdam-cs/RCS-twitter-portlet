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

package com.rcs.dbservice.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author rcs
 * @generated
 */
public class TweetPK implements Comparable<TweetPK>, Serializable {
	public long groupId;
	public long tweetId;

	public TweetPK() {
	}

	public TweetPK(long groupId, long tweetId) {
		this.groupId = groupId;
		this.tweetId = tweetId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}

	@Override
	public int compareTo(TweetPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (groupId < pk.groupId) {
			value = -1;
		}
		else if (groupId > pk.groupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (tweetId < pk.tweetId) {
			value = -1;
		}
		else if (tweetId > pk.tweetId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof TweetPK)) {
			return false;
		}

		TweetPK pk = (TweetPK)obj;

		if ((groupId == pk.groupId) && (tweetId == pk.tweetId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(groupId) + String.valueOf(tweetId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("tweetId");
		sb.append(StringPool.EQUAL);
		sb.append(tweetId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}