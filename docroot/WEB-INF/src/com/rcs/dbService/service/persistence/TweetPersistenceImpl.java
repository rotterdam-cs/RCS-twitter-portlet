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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.dbService.NoSuchTweetException;
import com.rcs.dbService.model.Tweet;
import com.rcs.dbService.model.impl.TweetImpl;
import com.rcs.dbService.model.impl.TweetModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tweet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rcs
 * @see TweetPersistence
 * @see TweetUtil
 * @generated
 */
public class TweetPersistenceImpl extends BasePersistenceImpl<Tweet>
	implements TweetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TweetUtil} to access the tweet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TweetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, TweetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, TweetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, TweetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, TweetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			TweetModelImpl.GROUPID_COLUMN_BITMASK |
			TweetModelImpl.TWEETCREATEDAT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tweets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tweets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tweet> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tweet> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Tweet> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Tweet> list = (List<Tweet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tweet tweet : list) {
				if ((groupId != tweet.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TWEET_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TweetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Tweet>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tweet>(list);
				}
				else {
					list = (List<Tweet>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Tweet findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = fetchByGroupId_First(groupId, orderByComparator);

		if (tweet != null) {
			return tweet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTweetException(msg.toString());
	}

	/**
	 * Returns the first tweet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tweet, or <code>null</code> if a matching tweet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tweet> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tweet findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = fetchByGroupId_Last(groupId, orderByComparator);

		if (tweet != null) {
			return tweet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTweetException(msg.toString());
	}

	/**
	 * Returns the last tweet in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tweet, or <code>null</code> if a matching tweet could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Tweet> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tweet[] findByGroupId_PrevAndNext(TweetPK tweetPK, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = findByPrimaryKey(tweetPK);

		Session session = null;

		try {
			session = openSession();

			Tweet[] array = new TweetImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, tweet, groupId,
					orderByComparator, true);

			array[1] = tweet;

			array[2] = getByGroupId_PrevAndNext(session, tweet, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tweet getByGroupId_PrevAndNext(Session session, Tweet tweet,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TWEET_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TweetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tweet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tweet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tweets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Tweet tweet : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tweet);
		}
	}

	/**
	 * Returns the number of tweets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tweets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TWEET_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "tweet.id.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDTWEETID =
		new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, TweetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdTweetId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDTWEETID =
		new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, TweetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdTweetId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TweetModelImpl.GROUPID_COLUMN_BITMASK |
			TweetModelImpl.TWEETID_COLUMN_BITMASK |
			TweetModelImpl.TWEETCREATEDAT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDTWEETID = new FinderPath(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupIdTweetId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the tweets where groupId = &#63; and tweetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tweetId the tweet ID
	 * @return the matching tweets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tweet> findByGroupIdTweetId(long groupId, long tweetId)
		throws SystemException {
		return findByGroupIdTweetId(groupId, tweetId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tweet> findByGroupIdTweetId(long groupId, long tweetId,
		int start, int end) throws SystemException {
		return findByGroupIdTweetId(groupId, tweetId, start, end, null);
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
	@Override
	public List<Tweet> findByGroupIdTweetId(long groupId, long tweetId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDTWEETID;
			finderArgs = new Object[] { groupId, tweetId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDTWEETID;
			finderArgs = new Object[] {
					groupId, tweetId,
					
					start, end, orderByComparator
				};
		}

		List<Tweet> list = (List<Tweet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tweet tweet : list) {
				if ((groupId != tweet.getGroupId()) ||
						(tweetId != tweet.getTweetId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TWEET_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDTWEETID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDTWEETID_TWEETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TweetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tweetId);

				if (!pagination) {
					list = (List<Tweet>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tweet>(list);
				}
				else {
					list = (List<Tweet>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Tweet findByGroupIdTweetId_First(long groupId, long tweetId,
		OrderByComparator orderByComparator)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = fetchByGroupIdTweetId_First(groupId, tweetId,
				orderByComparator);

		if (tweet != null) {
			return tweet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tweetId=");
		msg.append(tweetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTweetException(msg.toString());
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
	@Override
	public Tweet fetchByGroupIdTweetId_First(long groupId, long tweetId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Tweet> list = findByGroupIdTweetId(groupId, tweetId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tweet findByGroupIdTweetId_Last(long groupId, long tweetId,
		OrderByComparator orderByComparator)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = fetchByGroupIdTweetId_Last(groupId, tweetId,
				orderByComparator);

		if (tweet != null) {
			return tweet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", tweetId=");
		msg.append(tweetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTweetException(msg.toString());
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
	@Override
	public Tweet fetchByGroupIdTweetId_Last(long groupId, long tweetId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupIdTweetId(groupId, tweetId);

		if (count == 0) {
			return null;
		}

		List<Tweet> list = findByGroupIdTweetId(groupId, tweetId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Tweet[] findByGroupIdTweetId_PrevAndNext(TweetPK tweetPK,
		long groupId, long tweetId, OrderByComparator orderByComparator)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = findByPrimaryKey(tweetPK);

		Session session = null;

		try {
			session = openSession();

			Tweet[] array = new TweetImpl[3];

			array[0] = getByGroupIdTweetId_PrevAndNext(session, tweet, groupId,
					tweetId, orderByComparator, true);

			array[1] = tweet;

			array[2] = getByGroupIdTweetId_PrevAndNext(session, tweet, groupId,
					tweetId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tweet getByGroupIdTweetId_PrevAndNext(Session session,
		Tweet tweet, long groupId, long tweetId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TWEET_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDTWEETID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDTWEETID_TWEETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TweetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(tweetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tweet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Tweet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tweets where groupId = &#63; and tweetId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param tweetId the tweet ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdTweetId(long groupId, long tweetId)
		throws SystemException {
		for (Tweet tweet : findByGroupIdTweetId(groupId, tweetId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tweet);
		}
	}

	/**
	 * Returns the number of tweets where groupId = &#63; and tweetId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param tweetId the tweet ID
	 * @return the number of matching tweets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdTweetId(long groupId, long tweetId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDTWEETID;

		Object[] finderArgs = new Object[] { groupId, tweetId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TWEET_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDTWEETID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDTWEETID_TWEETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(tweetId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDTWEETID_GROUPID_2 = "tweet.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDTWEETID_TWEETID_2 = "tweet.id.tweetId = ?";

	public TweetPersistenceImpl() {
		setModelClass(Tweet.class);
	}

	/**
	 * Caches the tweet in the entity cache if it is enabled.
	 *
	 * @param tweet the tweet
	 */
	@Override
	public void cacheResult(Tweet tweet) {
		EntityCacheUtil.putResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetImpl.class, tweet.getPrimaryKey(), tweet);

		tweet.resetOriginalValues();
	}

	/**
	 * Caches the tweets in the entity cache if it is enabled.
	 *
	 * @param tweets the tweets
	 */
	@Override
	public void cacheResult(List<Tweet> tweets) {
		for (Tweet tweet : tweets) {
			if (EntityCacheUtil.getResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
						TweetImpl.class, tweet.getPrimaryKey()) == null) {
				cacheResult(tweet);
			}
			else {
				tweet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tweets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TweetImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TweetImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tweet.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tweet tweet) {
		EntityCacheUtil.removeResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetImpl.class, tweet.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Tweet> tweets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tweet tweet : tweets) {
			EntityCacheUtil.removeResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
				TweetImpl.class, tweet.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tweet with the primary key. Does not add the tweet to the database.
	 *
	 * @param tweetPK the primary key for the new tweet
	 * @return the new tweet
	 */
	@Override
	public Tweet create(TweetPK tweetPK) {
		Tweet tweet = new TweetImpl();

		tweet.setNew(true);
		tweet.setPrimaryKey(tweetPK);

		return tweet;
	}

	/**
	 * Removes the tweet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tweetPK the primary key of the tweet
	 * @return the tweet that was removed
	 * @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet remove(TweetPK tweetPK)
		throws NoSuchTweetException, SystemException {
		return remove((Serializable)tweetPK);
	}

	/**
	 * Removes the tweet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tweet
	 * @return the tweet that was removed
	 * @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet remove(Serializable primaryKey)
		throws NoSuchTweetException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Tweet tweet = (Tweet)session.get(TweetImpl.class, primaryKey);

			if (tweet == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTweetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tweet);
		}
		catch (NoSuchTweetException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Tweet removeImpl(Tweet tweet) throws SystemException {
		tweet = toUnwrappedModel(tweet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tweet)) {
				tweet = (Tweet)session.get(TweetImpl.class,
						tweet.getPrimaryKeyObj());
			}

			if (tweet != null) {
				session.delete(tweet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tweet != null) {
			clearCache(tweet);
		}

		return tweet;
	}

	@Override
	public Tweet updateImpl(com.rcs.dbService.model.Tweet tweet)
		throws SystemException {
		tweet = toUnwrappedModel(tweet);

		boolean isNew = tweet.isNew();

		TweetModelImpl tweetModelImpl = (TweetModelImpl)tweet;

		Session session = null;

		try {
			session = openSession();

			if (tweet.isNew()) {
				session.save(tweet);

				tweet.setNew(false);
			}
			else {
				session.merge(tweet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TweetModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tweetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tweetModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { tweetModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((tweetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDTWEETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tweetModelImpl.getOriginalGroupId(),
						tweetModelImpl.getOriginalTweetId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDTWEETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDTWEETID,
					args);

				args = new Object[] {
						tweetModelImpl.getGroupId(), tweetModelImpl.getTweetId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDTWEETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDTWEETID,
					args);
			}
		}

		EntityCacheUtil.putResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
			TweetImpl.class, tweet.getPrimaryKey(), tweet);

		return tweet;
	}

	protected Tweet toUnwrappedModel(Tweet tweet) {
		if (tweet instanceof TweetImpl) {
			return tweet;
		}

		TweetImpl tweetImpl = new TweetImpl();

		tweetImpl.setNew(tweet.isNew());
		tweetImpl.setPrimaryKey(tweet.getPrimaryKey());

		tweetImpl.setGroupId(tweet.getGroupId());
		tweetImpl.setCompanyId(tweet.getCompanyId());
		tweetImpl.setUserId(tweet.getUserId());
		tweetImpl.setUserName(tweet.getUserName());
		tweetImpl.setCreateDate(tweet.getCreateDate());
		tweetImpl.setModifiedDate(tweet.isModifiedDate());
		tweetImpl.setRemoved(tweet.isRemoved());
		tweetImpl.setTweetId(tweet.getTweetId());
		tweetImpl.setTweetIdStr(tweet.getTweetIdStr());
		tweetImpl.setTweetCreatedAt(tweet.getTweetCreatedAt());
		tweetImpl.setTweetRetweeted(tweet.isTweetRetweeted());
		tweetImpl.setTweetRetweetCount(tweet.getTweetRetweetCount());
		tweetImpl.setTweetText(tweet.getTweetText());

		return tweetImpl;
	}

	/**
	 * Returns the tweet with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tweet
	 * @return the tweet
	 * @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTweetException, SystemException {
		Tweet tweet = fetchByPrimaryKey(primaryKey);

		if (tweet == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTweetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tweet;
	}

	/**
	 * Returns the tweet with the primary key or throws a {@link com.rcs.dbService.NoSuchTweetException} if it could not be found.
	 *
	 * @param tweetPK the primary key of the tweet
	 * @return the tweet
	 * @throws com.rcs.dbService.NoSuchTweetException if a tweet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet findByPrimaryKey(TweetPK tweetPK)
		throws NoSuchTweetException, SystemException {
		return findByPrimaryKey((Serializable)tweetPK);
	}

	/**
	 * Returns the tweet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tweet
	 * @return the tweet, or <code>null</code> if a tweet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Tweet tweet = (Tweet)EntityCacheUtil.getResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
				TweetImpl.class, primaryKey);

		if (tweet == _nullTweet) {
			return null;
		}

		if (tweet == null) {
			Session session = null;

			try {
				session = openSession();

				tweet = (Tweet)session.get(TweetImpl.class, primaryKey);

				if (tweet != null) {
					cacheResult(tweet);
				}
				else {
					EntityCacheUtil.putResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
						TweetImpl.class, primaryKey, _nullTweet);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TweetModelImpl.ENTITY_CACHE_ENABLED,
					TweetImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tweet;
	}

	/**
	 * Returns the tweet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tweetPK the primary key of the tweet
	 * @return the tweet, or <code>null</code> if a tweet with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Tweet fetchByPrimaryKey(TweetPK tweetPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)tweetPK);
	}

	/**
	 * Returns all the tweets.
	 *
	 * @return the tweets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Tweet> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Tweet> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Tweet> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Tweet> list = (List<Tweet>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TWEET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TWEET;

				if (pagination) {
					sql = sql.concat(TweetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tweet>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Tweet>(list);
				}
				else {
					list = (List<Tweet>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tweets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Tweet tweet : findAll()) {
			remove(tweet);
		}
	}

	/**
	 * Returns the number of tweets.
	 *
	 * @return the number of tweets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TWEET);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the tweet persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.dbService.model.Tweet")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Tweet>> listenersList = new ArrayList<ModelListener<Tweet>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Tweet>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TweetImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TWEET = "SELECT tweet FROM Tweet tweet";
	private static final String _SQL_SELECT_TWEET_WHERE = "SELECT tweet FROM Tweet tweet WHERE ";
	private static final String _SQL_COUNT_TWEET = "SELECT COUNT(tweet) FROM Tweet tweet";
	private static final String _SQL_COUNT_TWEET_WHERE = "SELECT COUNT(tweet) FROM Tweet tweet WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tweet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Tweet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Tweet exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TweetPersistenceImpl.class);
	private static Tweet _nullTweet = new TweetImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Tweet> toCacheModel() {
				return _nullTweetCacheModel;
			}
		};

	private static CacheModel<Tweet> _nullTweetCacheModel = new CacheModel<Tweet>() {
			@Override
			public Tweet toEntityModel() {
				return _nullTweet;
			}
		};
}