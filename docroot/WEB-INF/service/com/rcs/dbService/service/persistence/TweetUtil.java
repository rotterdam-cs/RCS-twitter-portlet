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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.dbService.model.Tweet;

import java.util.List;

/**
 * The persistence utility for the tweet service. This utility wraps {@link TweetPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rcs
 * @see TweetPersistence
 * @see TweetPersistenceImpl
 * @generated
 */
public class TweetUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Tweet tweet) {
		getPersistence().clearCache(tweet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Tweet> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tweet> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tweet> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Tweet update(Tweet tweet) throws SystemException {
		return getPersistence().update(tweet);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Tweet update(Tweet tweet, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tweet, serviceContext);
	}

	/**
	* Returns all the tweets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.Tweet> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.rcs.dbService.model.Tweet> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.rcs.dbService.model.Tweet> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last tweet in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.rcs.dbService.model.Tweet[] findByGroupId_PrevAndNext(
		TweetPK tweetPK, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(tweetPK, groupId,
			orderByComparator);
	}

	/**
	* Removes all the tweets where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of tweets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the tweets where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @return the matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.Tweet> findByGroupIdTweetId(
		long groupId, long tweetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdTweetId(groupId, tweetId);
	}

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
	public static java.util.List<com.rcs.dbService.model.Tweet> findByGroupIdTweetId(
		long groupId, long tweetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdTweetId(groupId, tweetId, start, end);
	}

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
	public static java.util.List<com.rcs.dbService.model.Tweet> findByGroupIdTweetId(
		long groupId, long tweetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdTweetId(groupId, tweetId, start, end,
			orderByComparator);
	}

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
	public static com.rcs.dbService.model.Tweet findByGroupIdTweetId_First(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence()
				   .findByGroupIdTweetId_First(groupId, tweetId,
			orderByComparator);
	}

	/**
	* Returns the first tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet fetchByGroupIdTweetId_First(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdTweetId_First(groupId, tweetId,
			orderByComparator);
	}

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
	public static com.rcs.dbService.model.Tweet findByGroupIdTweetId_Last(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence()
				   .findByGroupIdTweetId_Last(groupId, tweetId,
			orderByComparator);
	}

	/**
	* Returns the last tweet in the ordered set where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tweet, or <code>null</code> if a matching tweet could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet fetchByGroupIdTweetId_Last(
		long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdTweetId_Last(groupId, tweetId,
			orderByComparator);
	}

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
	public static com.rcs.dbService.model.Tweet[] findByGroupIdTweetId_PrevAndNext(
		TweetPK tweetPK, long groupId, long tweetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence()
				   .findByGroupIdTweetId_PrevAndNext(tweetPK, groupId, tweetId,
			orderByComparator);
	}

	/**
	* Removes all the tweets where groupId = &#63; and tweetId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdTweetId(long groupId, long tweetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdTweetId(groupId, tweetId);
	}

	/**
	* Returns the number of tweets where groupId = &#63; and tweetId = &#63;.
	*
	* @param groupId the group ID
	* @param tweetId the tweet ID
	* @return the number of matching tweets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdTweetId(long groupId, long tweetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdTweetId(groupId, tweetId);
	}

	/**
	* Caches the tweet in the entity cache if it is enabled.
	*
	* @param tweet the tweet
	*/
	public static void cacheResult(com.rcs.dbService.model.Tweet tweet) {
		getPersistence().cacheResult(tweet);
	}

	/**
	* Caches the tweets in the entity cache if it is enabled.
	*
	* @param tweets the tweets
	*/
	public static void cacheResult(
		java.util.List<com.rcs.dbService.model.Tweet> tweets) {
		getPersistence().cacheResult(tweets);
	}

	/**
	* Creates a new tweet with the primary key. Does not add the tweet to the database.
	*
	* @param tweetPK the primary key for the new tweet
	* @return the new tweet
	*/
	public static com.rcs.dbService.model.Tweet create(TweetPK tweetPK) {
		return getPersistence().create(tweetPK);
	}

	/**
	* Removes the tweet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tweetPK the primary key of the tweet
	* @return the tweet that was removed
	* @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet remove(TweetPK tweetPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence().remove(tweetPK);
	}

	public static com.rcs.dbService.model.Tweet updateImpl(
		com.rcs.dbService.model.Tweet tweet)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tweet);
	}

	/**
	* Returns the tweet with the primary key or throws a {@link com.rcs.dbService.NoSuchTweetException} if it could not be found.
	*
	* @param tweetPK the primary key of the tweet
	* @return the tweet
	* @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet findByPrimaryKey(
		TweetPK tweetPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTweetException {
		return getPersistence().findByPrimaryKey(tweetPK);
	}

	/**
	* Returns the tweet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tweetPK the primary key of the tweet
	* @return the tweet, or <code>null</code> if a tweet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.Tweet fetchByPrimaryKey(
		TweetPK tweetPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tweetPK);
	}

	/**
	* Returns all the tweets.
	*
	* @return the tweets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.Tweet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rcs.dbService.model.Tweet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rcs.dbService.model.Tweet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tweets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tweets.
	*
	* @return the number of tweets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TweetPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TweetPersistence)PortletBeanLocatorUtil.locate(com.rcs.dbService.service.ClpSerializer.getServletContextName(),
					TweetPersistence.class.getName());

			ReferenceRegistry.registerReference(TweetUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TweetPersistence persistence) {
	}

	private static TweetPersistence _persistence;
}