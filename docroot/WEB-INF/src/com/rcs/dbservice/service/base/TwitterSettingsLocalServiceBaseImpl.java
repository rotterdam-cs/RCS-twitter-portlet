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

package com.rcs.dbservice.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rcs.dbservice.model.TwitterSettings;
import com.rcs.dbservice.service.TwitterSettingsLocalService;
import com.rcs.dbservice.service.persistence.TweetPersistence;
import com.rcs.dbservice.service.persistence.TwitterSettingsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the twitter settings local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rcs.dbservice.service.impl.TwitterSettingsLocalServiceImpl}.
 * </p>
 *
 * @author rcs
 * @see com.rcs.dbservice.service.impl.TwitterSettingsLocalServiceImpl
 * @see com.rcs.dbservice.service.TwitterSettingsLocalServiceUtil
 * @generated
 */
public abstract class TwitterSettingsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TwitterSettingsLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rcs.dbservice.service.TwitterSettingsLocalServiceUtil} to access the twitter settings local service.
	 */

	/**
	 * Adds the twitter settings to the database. Also notifies the appropriate model listeners.
	 *
	 * @param twitterSettings the twitter settings
	 * @return the twitter settings that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TwitterSettings addTwitterSettings(TwitterSettings twitterSettings)
		throws SystemException {
		twitterSettings.setNew(true);

		return twitterSettingsPersistence.update(twitterSettings);
	}

	/**
	 * Creates a new twitter settings with the primary key. Does not add the twitter settings to the database.
	 *
	 * @param groupId the primary key for the new twitter settings
	 * @return the new twitter settings
	 */
	@Override
	public TwitterSettings createTwitterSettings(long groupId) {
		return twitterSettingsPersistence.create(groupId);
	}

	/**
	 * Deletes the twitter settings with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the twitter settings
	 * @return the twitter settings that was removed
	 * @throws PortalException if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TwitterSettings deleteTwitterSettings(long groupId)
		throws PortalException, SystemException {
		return twitterSettingsPersistence.remove(groupId);
	}

	/**
	 * Deletes the twitter settings from the database. Also notifies the appropriate model listeners.
	 *
	 * @param twitterSettings the twitter settings
	 * @return the twitter settings that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TwitterSettings deleteTwitterSettings(
		TwitterSettings twitterSettings) throws SystemException {
		return twitterSettingsPersistence.remove(twitterSettings);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TwitterSettings.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return twitterSettingsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.TwitterSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return twitterSettingsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbservice.model.impl.TwitterSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return twitterSettingsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return twitterSettingsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return twitterSettingsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public TwitterSettings fetchTwitterSettings(long groupId)
		throws SystemException {
		return twitterSettingsPersistence.fetchByPrimaryKey(groupId);
	}

	/**
	 * Returns the twitter settings with the primary key.
	 *
	 * @param groupId the primary key of the twitter settings
	 * @return the twitter settings
	 * @throws PortalException if a twitter settings with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TwitterSettings getTwitterSettings(long groupId)
		throws PortalException, SystemException {
		return twitterSettingsPersistence.findByPrimaryKey(groupId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return twitterSettingsPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<TwitterSettings> getTwitterSettingses(int start, int end)
		throws SystemException {
		return twitterSettingsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of twitter settingses.
	 *
	 * @return the number of twitter settingses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTwitterSettingsesCount() throws SystemException {
		return twitterSettingsPersistence.countAll();
	}

	/**
	 * Updates the twitter settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param twitterSettings the twitter settings
	 * @return the twitter settings that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TwitterSettings updateTwitterSettings(
		TwitterSettings twitterSettings) throws SystemException {
		return twitterSettingsPersistence.update(twitterSettings);
	}

	/**
	 * Returns the tweet local service.
	 *
	 * @return the tweet local service
	 */
	public com.rcs.dbservice.service.TweetLocalService getTweetLocalService() {
		return tweetLocalService;
	}

	/**
	 * Sets the tweet local service.
	 *
	 * @param tweetLocalService the tweet local service
	 */
	public void setTweetLocalService(
		com.rcs.dbservice.service.TweetLocalService tweetLocalService) {
		this.tweetLocalService = tweetLocalService;
	}

	/**
	 * Returns the tweet remote service.
	 *
	 * @return the tweet remote service
	 */
	public com.rcs.dbservice.service.TweetService getTweetService() {
		return tweetService;
	}

	/**
	 * Sets the tweet remote service.
	 *
	 * @param tweetService the tweet remote service
	 */
	public void setTweetService(
		com.rcs.dbservice.service.TweetService tweetService) {
		this.tweetService = tweetService;
	}

	/**
	 * Returns the tweet persistence.
	 *
	 * @return the tweet persistence
	 */
	public TweetPersistence getTweetPersistence() {
		return tweetPersistence;
	}

	/**
	 * Sets the tweet persistence.
	 *
	 * @param tweetPersistence the tweet persistence
	 */
	public void setTweetPersistence(TweetPersistence tweetPersistence) {
		this.tweetPersistence = tweetPersistence;
	}

	/**
	 * Returns the twitter settings local service.
	 *
	 * @return the twitter settings local service
	 */
	public com.rcs.dbservice.service.TwitterSettingsLocalService getTwitterSettingsLocalService() {
		return twitterSettingsLocalService;
	}

	/**
	 * Sets the twitter settings local service.
	 *
	 * @param twitterSettingsLocalService the twitter settings local service
	 */
	public void setTwitterSettingsLocalService(
		com.rcs.dbservice.service.TwitterSettingsLocalService twitterSettingsLocalService) {
		this.twitterSettingsLocalService = twitterSettingsLocalService;
	}

	/**
	 * Returns the twitter settings remote service.
	 *
	 * @return the twitter settings remote service
	 */
	public com.rcs.dbservice.service.TwitterSettingsService getTwitterSettingsService() {
		return twitterSettingsService;
	}

	/**
	 * Sets the twitter settings remote service.
	 *
	 * @param twitterSettingsService the twitter settings remote service
	 */
	public void setTwitterSettingsService(
		com.rcs.dbservice.service.TwitterSettingsService twitterSettingsService) {
		this.twitterSettingsService = twitterSettingsService;
	}

	/**
	 * Returns the twitter settings persistence.
	 *
	 * @return the twitter settings persistence
	 */
	public TwitterSettingsPersistence getTwitterSettingsPersistence() {
		return twitterSettingsPersistence;
	}

	/**
	 * Sets the twitter settings persistence.
	 *
	 * @param twitterSettingsPersistence the twitter settings persistence
	 */
	public void setTwitterSettingsPersistence(
		TwitterSettingsPersistence twitterSettingsPersistence) {
		this.twitterSettingsPersistence = twitterSettingsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rcs.dbservice.model.TwitterSettings",
			twitterSettingsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rcs.dbservice.model.TwitterSettings");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TwitterSettings.class;
	}

	protected String getModelClassName() {
		return TwitterSettings.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = twitterSettingsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rcs.dbservice.service.TweetLocalService.class)
	protected com.rcs.dbservice.service.TweetLocalService tweetLocalService;
	@BeanReference(type = com.rcs.dbservice.service.TweetService.class)
	protected com.rcs.dbservice.service.TweetService tweetService;
	@BeanReference(type = TweetPersistence.class)
	protected TweetPersistence tweetPersistence;
	@BeanReference(type = com.rcs.dbservice.service.TwitterSettingsLocalService.class)
	protected com.rcs.dbservice.service.TwitterSettingsLocalService twitterSettingsLocalService;
	@BeanReference(type = com.rcs.dbservice.service.TwitterSettingsService.class)
	protected com.rcs.dbservice.service.TwitterSettingsService twitterSettingsService;
	@BeanReference(type = TwitterSettingsPersistence.class)
	protected TwitterSettingsPersistence twitterSettingsPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TwitterSettingsLocalServiceClpInvoker _clpInvoker = new TwitterSettingsLocalServiceClpInvoker();
}