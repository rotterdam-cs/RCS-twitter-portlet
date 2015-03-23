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

import com.rcs.dbservice.NoSuchTwitterSettingsException;
import com.rcs.dbservice.model.TwitterSettings;
import com.rcs.dbservice.model.impl.TwitterSettingsImpl;
import com.rcs.dbservice.model.impl.TwitterSettingsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the twitter settings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rcs
 * @see TwitterSettingsPersistence
 * @see TwitterSettingsUtil
 * @generated
 */
public class TwitterSettingsPersistenceImpl extends BasePersistenceImpl<TwitterSettings>
	implements TwitterSettingsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TwitterSettingsUtil} to access the twitter settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TwitterSettingsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsModelImpl.FINDER_CACHE_ENABLED,
			TwitterSettingsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsModelImpl.FINDER_CACHE_ENABLED,
			TwitterSettingsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_BYGROUPID = new FinderPath(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsModelImpl.FINDER_CACHE_ENABLED,
			TwitterSettingsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBybyGroupId", new String[] { Long.class.getName() },
			TwitterSettingsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYGROUPID = new FinderPath(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the twitter settings where groupId = &#63; or throws a {@link com.rcs.dbservice.NoSuchTwitterSettingsException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching twitter settings
	 * @throws com.rcs.dbservice.NoSuchTwitterSettingsException if a matching twitter settings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings findBybyGroupId(long groupId)
		throws NoSuchTwitterSettingsException, SystemException {
		TwitterSettings twitterSettings = fetchBybyGroupId(groupId);

		if (twitterSettings == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTwitterSettingsException(msg.toString());
		}

		return twitterSettings;
	}

	/**
	 * Returns the twitter settings where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching twitter settings, or <code>null</code> if a matching twitter settings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings fetchBybyGroupId(long groupId)
		throws SystemException {
		return fetchBybyGroupId(groupId, true);
	}

	/**
	 * Returns the twitter settings where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching twitter settings, or <code>null</code> if a matching twitter settings could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings fetchBybyGroupId(long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYGROUPID,
					finderArgs, this);
		}

		if (result instanceof TwitterSettings) {
			TwitterSettings twitterSettings = (TwitterSettings)result;

			if ((groupId != twitterSettings.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TWITTERSETTINGS_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				List<TwitterSettings> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYGROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TwitterSettingsPersistenceImpl.fetchBybyGroupId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TwitterSettings twitterSettings = list.get(0);

					result = twitterSettings;

					cacheResult(twitterSettings);

					if ((twitterSettings.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYGROUPID,
							finderArgs, twitterSettings);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYGROUPID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TwitterSettings)result;
		}
	}

	/**
	 * Removes the twitter settings where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the twitter settings that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings removeBybyGroupId(long groupId)
		throws NoSuchTwitterSettingsException, SystemException {
		TwitterSettings twitterSettings = findBybyGroupId(groupId);

		return remove(twitterSettings);
	}

	/**
	 * Returns the number of twitter settingses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching twitter settingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYGROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TWITTERSETTINGS_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_BYGROUPID_GROUPID_2 = "twitterSettings.groupId = ?";

	public TwitterSettingsPersistenceImpl() {
		setModelClass(TwitterSettings.class);
	}

	/**
	 * Caches the twitter settings in the entity cache if it is enabled.
	 *
	 * @param twitterSettings the twitter settings
	 */
	@Override
	public void cacheResult(TwitterSettings twitterSettings) {
		EntityCacheUtil.putResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsImpl.class, twitterSettings.getPrimaryKey(),
			twitterSettings);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYGROUPID,
			new Object[] { twitterSettings.getGroupId() }, twitterSettings);

		twitterSettings.resetOriginalValues();
	}

	/**
	 * Caches the twitter settingses in the entity cache if it is enabled.
	 *
	 * @param twitterSettingses the twitter settingses
	 */
	@Override
	public void cacheResult(List<TwitterSettings> twitterSettingses) {
		for (TwitterSettings twitterSettings : twitterSettingses) {
			if (EntityCacheUtil.getResult(
						TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
						TwitterSettingsImpl.class,
						twitterSettings.getPrimaryKey()) == null) {
				cacheResult(twitterSettings);
			}
			else {
				twitterSettings.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all twitter settingses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TwitterSettingsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TwitterSettingsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the twitter settings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TwitterSettings twitterSettings) {
		EntityCacheUtil.removeResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsImpl.class, twitterSettings.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(twitterSettings);
	}

	@Override
	public void clearCache(List<TwitterSettings> twitterSettingses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TwitterSettings twitterSettings : twitterSettingses) {
			EntityCacheUtil.removeResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
				TwitterSettingsImpl.class, twitterSettings.getPrimaryKey());

			clearUniqueFindersCache(twitterSettings);
		}
	}

	protected void cacheUniqueFindersCache(TwitterSettings twitterSettings) {
		if (twitterSettings.isNew()) {
			Object[] args = new Object[] { twitterSettings.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYGROUPID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYGROUPID, args,
				twitterSettings);
		}
		else {
			TwitterSettingsModelImpl twitterSettingsModelImpl = (TwitterSettingsModelImpl)twitterSettings;

			if ((twitterSettingsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BYGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { twitterSettings.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYGROUPID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYGROUPID, args,
					twitterSettings);
			}
		}
	}

	protected void clearUniqueFindersCache(TwitterSettings twitterSettings) {
		TwitterSettingsModelImpl twitterSettingsModelImpl = (TwitterSettingsModelImpl)twitterSettings;

		Object[] args = new Object[] { twitterSettings.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGROUPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYGROUPID, args);

		if ((twitterSettingsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BYGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] { twitterSettingsModelImpl.getOriginalGroupId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYGROUPID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYGROUPID, args);
		}
	}

	/**
	 * Creates a new twitter settings with the primary key. Does not add the twitter settings to the database.
	 *
	 * @param groupId the primary key for the new twitter settings
	 * @return the new twitter settings
	 */
	@Override
	public TwitterSettings create(long groupId) {
		TwitterSettings twitterSettings = new TwitterSettingsImpl();

		twitterSettings.setNew(true);
		twitterSettings.setPrimaryKey(groupId);

		return twitterSettings;
	}

	/**
	 * Removes the twitter settings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the twitter settings
	 * @return the twitter settings that was removed
	 * @throws com.rcs.dbservice.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings remove(long groupId)
		throws NoSuchTwitterSettingsException, SystemException {
		return remove((Serializable)groupId);
	}

	/**
	 * Removes the twitter settings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the twitter settings
	 * @return the twitter settings that was removed
	 * @throws com.rcs.dbservice.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings remove(Serializable primaryKey)
		throws NoSuchTwitterSettingsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TwitterSettings twitterSettings = (TwitterSettings)session.get(TwitterSettingsImpl.class,
					primaryKey);

			if (twitterSettings == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTwitterSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(twitterSettings);
		}
		catch (NoSuchTwitterSettingsException nsee) {
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
	protected TwitterSettings removeImpl(TwitterSettings twitterSettings)
		throws SystemException {
		twitterSettings = toUnwrappedModel(twitterSettings);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(twitterSettings)) {
				twitterSettings = (TwitterSettings)session.get(TwitterSettingsImpl.class,
						twitterSettings.getPrimaryKeyObj());
			}

			if (twitterSettings != null) {
				session.delete(twitterSettings);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (twitterSettings != null) {
			clearCache(twitterSettings);
		}

		return twitterSettings;
	}

	@Override
	public TwitterSettings updateImpl(
		com.rcs.dbservice.model.TwitterSettings twitterSettings)
		throws SystemException {
		twitterSettings = toUnwrappedModel(twitterSettings);

		boolean isNew = twitterSettings.isNew();

		Session session = null;

		try {
			session = openSession();

			if (twitterSettings.isNew()) {
				session.save(twitterSettings);

				twitterSettings.setNew(false);
			}
			else {
				session.merge(twitterSettings);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TwitterSettingsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
			TwitterSettingsImpl.class, twitterSettings.getPrimaryKey(),
			twitterSettings);

		clearUniqueFindersCache(twitterSettings);
		cacheUniqueFindersCache(twitterSettings);

		return twitterSettings;
	}

	protected TwitterSettings toUnwrappedModel(TwitterSettings twitterSettings) {
		if (twitterSettings instanceof TwitterSettingsImpl) {
			return twitterSettings;
		}

		TwitterSettingsImpl twitterSettingsImpl = new TwitterSettingsImpl();

		twitterSettingsImpl.setNew(twitterSettings.isNew());
		twitterSettingsImpl.setPrimaryKey(twitterSettings.getPrimaryKey());

		twitterSettingsImpl.setGroupId(twitterSettings.getGroupId());
		twitterSettingsImpl.setCompanyId(twitterSettings.getCompanyId());
		twitterSettingsImpl.setUserId(twitterSettings.getUserId());
		twitterSettingsImpl.setUserName(twitterSettings.getUserName());
		twitterSettingsImpl.setCreateDate(twitterSettings.getCreateDate());
		twitterSettingsImpl.setModifiedDate(twitterSettings.getModifiedDate());
		twitterSettingsImpl.setApplicationName(twitterSettings.getApplicationName());
		twitterSettingsImpl.setConsumerKey(twitterSettings.getConsumerKey());
		twitterSettingsImpl.setConsumerKeySecret(twitterSettings.getConsumerKeySecret());
		twitterSettingsImpl.setAccessToken(twitterSettings.getAccessToken());
		twitterSettingsImpl.setAccessTokenSecret(twitterSettings.getAccessTokenSecret());

		return twitterSettingsImpl;
	}

	/**
	 * Returns the twitter settings with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the twitter settings
	 * @return the twitter settings
	 * @throws com.rcs.dbservice.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTwitterSettingsException, SystemException {
		TwitterSettings twitterSettings = fetchByPrimaryKey(primaryKey);

		if (twitterSettings == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTwitterSettingsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return twitterSettings;
	}

	/**
	 * Returns the twitter settings with the primary key or throws a {@link com.rcs.dbservice.NoSuchTwitterSettingsException} if it could not be found.
	 *
	 * @param groupId the primary key of the twitter settings
	 * @return the twitter settings
	 * @throws com.rcs.dbservice.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings findByPrimaryKey(long groupId)
		throws NoSuchTwitterSettingsException, SystemException {
		return findByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns the twitter settings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the twitter settings
	 * @return the twitter settings, or <code>null</code> if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TwitterSettings twitterSettings = (TwitterSettings)EntityCacheUtil.getResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
				TwitterSettingsImpl.class, primaryKey);

		if (twitterSettings == _nullTwitterSettings) {
			return null;
		}

		if (twitterSettings == null) {
			Session session = null;

			try {
				session = openSession();

				twitterSettings = (TwitterSettings)session.get(TwitterSettingsImpl.class,
						primaryKey);

				if (twitterSettings != null) {
					cacheResult(twitterSettings);
				}
				else {
					EntityCacheUtil.putResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
						TwitterSettingsImpl.class, primaryKey,
						_nullTwitterSettings);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TwitterSettingsModelImpl.ENTITY_CACHE_ENABLED,
					TwitterSettingsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return twitterSettings;
	}

	/**
	 * Returns the twitter settings with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupId the primary key of the twitter settings
	 * @return the twitter settings, or <code>null</code> if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings fetchByPrimaryKey(long groupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns all the twitter settingses.
	 *
	 * @return the twitter settingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TwitterSettings> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the twitter settingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.TwitterSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of twitter settingses
	 * @param end the upper bound of the range of twitter settingses (not inclusive)
	 * @return the range of twitter settingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TwitterSettings> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the twitter settingses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.TwitterSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of twitter settingses
	 * @param end the upper bound of the range of twitter settingses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of twitter settingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TwitterSettings> findAll(int start, int end,
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

		List<TwitterSettings> list = (List<TwitterSettings>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TWITTERSETTINGS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TWITTERSETTINGS;

				if (pagination) {
					sql = sql.concat(TwitterSettingsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TwitterSettings>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TwitterSettings>(list);
				}
				else {
					list = (List<TwitterSettings>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the twitter settingses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TwitterSettings twitterSettings : findAll()) {
			remove(twitterSettings);
		}
	}

	/**
	 * Returns the number of twitter settingses.
	 *
	 * @return the number of twitter settingses
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

				Query q = session.createQuery(_SQL_COUNT_TWITTERSETTINGS);

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
	 * Initializes the twitter settings persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.dbservice.model.TwitterSettings")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TwitterSettings>> listenersList = new ArrayList<ModelListener<TwitterSettings>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TwitterSettings>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TwitterSettingsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TWITTERSETTINGS = "SELECT twitterSettings FROM TwitterSettings twitterSettings";
	private static final String _SQL_SELECT_TWITTERSETTINGS_WHERE = "SELECT twitterSettings FROM TwitterSettings twitterSettings WHERE ";
	private static final String _SQL_COUNT_TWITTERSETTINGS = "SELECT COUNT(twitterSettings) FROM TwitterSettings twitterSettings";
	private static final String _SQL_COUNT_TWITTERSETTINGS_WHERE = "SELECT COUNT(twitterSettings) FROM TwitterSettings twitterSettings WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "twitterSettings.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TwitterSettings exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TwitterSettings exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TwitterSettingsPersistenceImpl.class);
	private static TwitterSettings _nullTwitterSettings = new TwitterSettingsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TwitterSettings> toCacheModel() {
				return _nullTwitterSettingsCacheModel;
			}
		};

	private static CacheModel<TwitterSettings> _nullTwitterSettingsCacheModel = new CacheModel<TwitterSettings>() {
			@Override
			public TwitterSettings toEntityModel() {
				return _nullTwitterSettings;
			}
		};
}