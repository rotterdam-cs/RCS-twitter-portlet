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

package com.rcs.dbService.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.dbService.model.Tweet;

/**
 * The persistence interface for the tweet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rcs
 * @see TweetPersistenceImpl
 * @see TweetUtil
 * @generated
 */
public interface TweetPersistence extends BasePersistence<Tweet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TweetUtil} to access the tweet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tweets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tweets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TweetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tweets
	* @param end the upper bound of the range of tweets (not inclusive)
	* @return the range of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tweets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TweetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of tweets
	* @param end the upper bound of the range of tweets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Returns the first tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Returns the last tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tweets before and after the current tweet in the ordered set where groupId = &#63;.
	*
	* @param tweetPK the primary key of the current tweet
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet[] findByGroupId_PrevAndNext(
		com.rcs.dbService.service.persistence.TweetPK tweetPK, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Removes all the tweets where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tweets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tweets where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @return the matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findByGroupIdTweetId(
		long groupId, long tweetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tweets where groupId = &#63; and tweetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TweetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param start the lower bound of the range of tweets
	* @param end the upper bound of the range of tweets (not inclusive)
	* @return the range of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findByGroupIdTweetId(
		long groupId, long tweetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tweets where groupId = &#63; and tweetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TweetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param start the lower bound of the range of tweets
	* @param end the upper bound of the range of tweets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findByGroupIdTweetId(
		long groupId, long tweetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet findByGroupIdTweetId_First(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Returns the first tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet fetchByGroupIdTweetId_First(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet findByGroupIdTweetId_Last(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Returns the last tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet fetchByGroupIdTweetId_Last(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tweets before and after the current tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param tweetPK the primary key of the current tweet
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet[] findByGroupIdTweetId_PrevAndNext(
		com.rcs.dbService.service.persistence.TweetPK tweetPK, long groupId,
		long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Removes all the tweets where groupId = &#63; and tweetId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdTweetId(long groupId, long tweetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tweets where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @return the number of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdTweetId(long groupId, long tweetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tweet in the entity cache if it is enabled.
	*
	* @param tweet the tweet
	*/
	public void cacheResult(com.rcs.dbService.model.Tweet tweet);

	/**
	* Caches the tweets in the entity cache if it is enabled.
	*
	* @param tweets the tweets
	*/
	public void cacheResult(
		java.util.List<com.rcs.dbService.model.Tweet> tweets);

	/**
	* Creates a new tweet with the primary key. Does not add the tweet to the database.
	*
	* @param tweetPK the primary key for the new tweet
	* @return the new tweet
	*/
	public com.rcs.dbService.model.Tweet create(
		com.rcs.dbService.service.persistence.TweetPK tweetPK);

	/**
	* Removes the tweet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tweetPK the primary key of the tweet
	* @return the tweet that was removed
	* @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet remove(
		com.rcs.dbService.service.persistence.TweetPK tweetPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	public com.rcs.dbService.model.Tweet updateImpl(
		com.rcs.dbService.model.Tweet tweet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tweet with the primary key or throws a {@link com.rcs.dbService.NoSuchTweetException} if it could not be found.
	*
	* @param tweetPK the primary key of the tweet
	* @return the tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet findByPrimaryKey(
		com.rcs.dbService.service.persistence.TweetPK tweetPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException;

	/**
	* Returns the tweet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tweetPK the primary key of the tweet
	* @return the tweet, or <code>null</code> if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.Tweet fetchByPrimaryKey(
		com.rcs.dbService.service.persistence.TweetPK tweetPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tweets.
	*
	* @return the tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tweets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TweetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tweets
	* @param end the upper bound of the range of tweets (not inclusive)
	* @return the range of tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tweets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TweetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tweets
	* @param end the upper bound of the range of tweets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tweets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.Tweet> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tweets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tweets.
	*
	* @return the number of tweets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}