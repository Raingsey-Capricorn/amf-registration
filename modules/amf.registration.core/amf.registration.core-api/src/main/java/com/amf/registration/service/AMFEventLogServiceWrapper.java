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

package com.amf.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMFEventLogService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogService
 * @generated
 */
public class AMFEventLogServiceWrapper
	implements AMFEventLogService, ServiceWrapper<AMFEventLogService> {

	public AMFEventLogServiceWrapper(AMFEventLogService amfEventLogService) {
		_amfEventLogService = amfEventLogService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfEventLogService.getOSGiServiceIdentifier();
	}

	@Override
	public AMFEventLogService getWrappedService() {
		return _amfEventLogService;
	}

	@Override
	public void setWrappedService(AMFEventLogService amfEventLogService) {
		_amfEventLogService = amfEventLogService;
	}

	private AMFEventLogService _amfEventLogService;

}