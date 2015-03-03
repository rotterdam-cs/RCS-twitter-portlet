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

import com.rcs.dbService.model.TwitterSettings;

/**
 * The persistence interface for the twitter settings service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rcs
 * @see TwitterSettingsPersistenceImpl
 * @see TwitterSettingsUtil
 * @generated
 */
public interface TwitterSettingsPersistence extends BasePersistence<TwitterSettings> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TwitterSettingsUtil} to access the twitter settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the twitter settings where groupId = &#63; or throws a {@link com.rcs.dbService.NoSuchTwitterSettingsException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching twitter settings
	* @throws com.rcs.dbService.NoSuchTwitterSettingsException if a matching twitter settings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings findBybyGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException;

	/**
	* Returns the twitter settings where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching twitter settings, or <code>null</code> if a matching twitter settings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings fetchBybyGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the twitter settings where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching twitter settings, or <code>null</code> if a matching twitter settings could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings fetchBybyGroupId(
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the twitter settings where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the twitter settings that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings removeBybyGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException;

	/**
	* Returns the number of twitter settingses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the twitter settings in the entity cache if it is enabled.
	*
	* @param twitterSettings the twitter settings
	*/
	public void cacheResult(
		com.rcs.dbService.model.TwitterSettings twitterSettings);

	/**
	* Caches the twitter settingses in the entity cache if it is enabled.
	*
	* @param twitterSettingses the twitter settingses
	*/
	public void cacheResult(
		java.util.List<com.rcs.dbService.model.TwitterSettings> twitterSettingses);

	/**
	* Creates a new twitter settings with the primary key. Does not add the twitter settings to the database.
	*
	* @param groupId the primary key for the new twitter settings
	* @return the new twitter settings
	*/
	public com.rcs.dbService.model.TwitterSettings create(long groupId);

	/**
	* Removes the twitter settings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings that was removed
	* @throws com.rcs.dbService.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings remove(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException;

	public com.rcs.dbService.model.TwitterSettings updateImpl(
		com.rcs.dbService.model.TwitterSettings twitterSettings)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the twitter settings with the primary key or throws a {@link com.rcs.dbService.NoSuchTwitterSettingsException} if it could not be found.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings
	* @throws com.rcs.dbService.NoSuchTwitterSettingsException if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings findByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.dbService.NoSuchTwitterSettingsException;

	/**
	* Returns the twitter settings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings, or <code>null</code> if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.dbService.model.TwitterSettings fetchByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the twitter settingses.
	*
	* @return the twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.dbService.model.TwitterSettings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.dbService.model.TwitterSettings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rcs.dbService.model.TwitterSettings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the twitter settingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of twitter settingses.
	*
	* @return the number of twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}