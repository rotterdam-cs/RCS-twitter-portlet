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

import com.rcs.dbService.model.TwitterSettings;

import java.util.List;

/**
 * The persistence utility for the twitter settings service. This utility wraps {@link TwitterSettingsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rcs
 * @see TwitterSettingsPersistence
 * @see TwitterSettingsPersistenceImpl
 * @generated
 */
public class TwitterSettingsUtil {
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
	public static void clearCache(TwitterSettings twitterSettings) {
		getPersistence().clearCache(twitterSettings);
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
	public static List<TwitterSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TwitterSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TwitterSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TwitterSettings update(TwitterSettings twitterSettings)
		throws SystemException {
		return getPersistence().update(twitterSettings);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TwitterSettings update(TwitterSettings twitterSettings,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(twitterSettings, serviceContext);
	}

	/**
	* Returns the twitter settings where groupId = &#63; or throws a {@link com.rcs.dbService.NoSuchTwitterSettingsException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching twitter settings
	* @throws com.rcs.dbService.NoSuchTwitterSettingsException if a matching twitter settings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings findBybyGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException {
		return getPersistence().findBybyGroupId(groupId);
	}

	/**
	* Returns the twitter settings where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching twitter settings, or <code>null</code> if a matching twitter settings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings fetchBybyGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyGroupId(groupId);
	}

	/**
	* Returns the twitter settings where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching twitter settings, or <code>null</code> if a matching twitter settings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings fetchBybyGroupId(
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyGroupId(groupId, retrieveFromCache);
	}

	/**
	* Removes the twitter settings where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the twitter settings that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings removeBybyGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException {
		return getPersistence().removeBybyGroupId(groupId);
	}

	/**
	* Returns the number of twitter settingses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyGroupId(groupId);
	}

	/**
	* Caches the twitter settings in the entity cache if it is enabled.
	*
	* @param twitterSettings the twitter settings
	*/
	public static void cacheResult(
		com.rcs.dbService.model.TwitterSettings twitterSettings) {
		getPersistence().cacheResult(twitterSettings);
	}

	/**
	* Caches the twitter settingses in the entity cache if it is enabled.
	*
	* @param twitterSettingses the twitter settingses
	*/
	public static void cacheResult(
		java.util.List<com.rcs.dbService.model.TwitterSettings> twitterSettingses) {
		getPersistence().cacheResult(twitterSettingses);
	}

	/**
	* Creates a new twitter settings with the primary key. Does not add the twitter settings to the database.
	*
	* @param groupId the primary key for the new twitter settings
	* @return the new twitter settings
	*/
	public static com.rcs.dbService.model.TwitterSettings create(long groupId) {
		return getPersistence().create(groupId);
	}

	/**
	* Removes the twitter settings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings that was removed
	* @throws com.rcs.dbService.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings remove(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException {
		return getPersistence().remove(groupId);
	}

	public static com.rcs.dbService.model.TwitterSettings updateImpl(
		com.rcs.dbService.model.TwitterSettings twitterSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(twitterSettings);
	}

	/**
	* Returns the twitter settings with the primary key or throws a {@link com.rcs.dbService.NoSuchTwitterSettingsException} if it could not be found.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings
	* @throws com.rcs.dbService.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings findByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException {
		return getPersistence().findByPrimaryKey(groupId);
	}

	/**
	* Returns the twitter settings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings, or <code>null</code> if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.dbService.model.TwitterSettings fetchByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(groupId);
	}

	/**
	* Returns all the twitter settingses.
	*
	* @return the twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.TwitterSettings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the twitter settingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TwitterSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of twitter settingses
	* @param end the upper bound of the range of twitter settingses (not inclusive)
	* @return the range of twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.TwitterSettings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the twitter settingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.dbService.model.impl.TwitterSettingsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of twitter settingses
	* @param end the upper bound of the range of twitter settingses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.dbService.model.TwitterSettings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the twitter settingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of twitter settingses.
	*
	* @return the number of twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TwitterSettingsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TwitterSettingsPersistence)PortletBeanLocatorUtil.locate(com.rcs.dbService.service.ClpSerializer.getServletContextName(),
					TwitterSettingsPersistence.class.getName());

			ReferenceRegistry.registerReference(TwitterSettingsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TwitterSettingsPersistence persistence) {
	}

	private static TwitterSettingsPersistence _persistence;
}