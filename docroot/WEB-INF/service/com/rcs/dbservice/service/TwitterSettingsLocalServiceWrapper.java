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

package com.rcs.dbservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TwitterSettingsLocalService}.
 *
 * @author rcs
 * @see TwitterSettingsLocalService
 * @generated
 */
public class TwitterSettingsLocalServiceWrapper
	implements TwitterSettingsLocalService,
		ServiceWrapper<TwitterSettingsLocalService> {
	public TwitterSettingsLocalServiceWrapper(
		TwitterSettingsLocalService twitterSettingsLocalService) {
		_twitterSettingsLocalService = twitterSettingsLocalService;
	}

	/**
	* Adds the twitter settings to the database. Also notifies the appropriate model listeners.
	*
	* @param twitterSettings the twitter settings
	* @return the twitter settings that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.TwitterSettings addTwitterSettings(
		com.rcs.dbservice.model.TwitterSettings twitterSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.addTwitterSettings(twitterSettings);
	}

	/**
	* Creates a new twitter settings with the primary key. Does not add the twitter settings to the database.
	*
	* @param groupId the primary key for the new twitter settings
	* @return the new twitter settings
	*/
	@Override
	public com.rcs.dbservice.model.TwitterSettings createTwitterSettings(
		long groupId) {
		return _twitterSettingsLocalService.createTwitterSettings(groupId);
	}

	/**
	* Deletes the twitter settings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the twitter settings
	* @return the twitter settings that was removed
	* @throws PortalException if a twitter settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.TwitterSettings deleteTwitterSettings(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.deleteTwitterSettings(groupId);
	}

	/**
	* Deletes the twitter settings from the database. Also notifies the appropriate model listeners.
	*
	* @param twitterSettings the twitter settings
	* @return the twitter settings that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.TwitterSettings deleteTwitterSettings(
		com.rcs.dbservice.model.TwitterSettings twitterSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.deleteTwitterSettings(twitterSettings);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _twitterSettingsLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.dbservice.model.TwitterSettings fetchTwitterSettings(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.fetchTwitterSettings(groupId);
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
	public com.rcs.dbservice.model.TwitterSettings getTwitterSettings(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.getTwitterSettings(groupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rcs.dbservice.model.TwitterSettings> getTwitterSettingses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.getTwitterSettingses(start, end);
	}

	/**
	* Returns the number of twitter settingses.
	*
	* @return the number of twitter settingses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTwitterSettingsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.getTwitterSettingsesCount();
	}

	/**
	* Updates the twitter settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param twitterSettings the twitter settings
	* @return the twitter settings that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.dbservice.model.TwitterSettings updateTwitterSettings(
		com.rcs.dbservice.model.TwitterSettings twitterSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _twitterSettingsLocalService.updateTwitterSettings(twitterSettings);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _twitterSettingsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_twitterSettingsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _twitterSettingsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TwitterSettingsLocalService getWrappedTwitterSettingsLocalService() {
		return _twitterSettingsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTwitterSettingsLocalService(
		TwitterSettingsLocalService twitterSettingsLocalService) {
		_twitterSettingsLocalService = twitterSettingsLocalService;
	}

	@Override
	public TwitterSettingsLocalService getWrappedService() {
		return _twitterSettingsLocalService;
	}

	@Override
	public void setWrappedService(
		TwitterSettingsLocalService twitterSettingsLocalService) {
		_twitterSettingsLocalService = twitterSettingsLocalService;
	}

	private TwitterSettingsLocalService _twitterSettingsLocalService;
}