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

package com.rcs.dbService.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.rcs.dbService.service.ClpSerializer;
import com.rcs.dbService.service.TweetLocalServiceUtil;
import com.rcs.dbService.service.TweetServiceUtil;
import com.rcs.dbService.service.TwitterSettingsLocalServiceUtil;
import com.rcs.dbService.service.TwitterSettingsServiceUtil;

/**
 * @author rcs
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			TweetLocalServiceUtil.clearService();

			TweetServiceUtil.clearService();
			TwitterSettingsLocalServiceUtil.clearService();

			TwitterSettingsServiceUtil.clearService();
		}
	}
}