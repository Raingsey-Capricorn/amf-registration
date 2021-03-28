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

import com.amf.registration.model.AMFUser;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AMFUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AMFUserLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.amf.registration.service.impl.AMFUserLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the amf user local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AMFUserLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the amf user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFUser addAMFUser(AMFUser amfUser);

	/**
	 * @param themeDisplay
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param gender
	 * @param birthDate
	 * @param password
	 * @param confirmedPassword
	 * @param homePhone
	 * @param mobilePhone
	 * @param addressLineOne
	 * @param addressLineTwo
	 * @param city
	 * @param regionId
	 * @param zip
	 * @param securityQuestion
	 * @param securityAnswer
	 * @param acceptedTOU
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	public AMFUser addAMFUser(
			ThemeDisplay themeDisplay, String userName, String firstName,
			String lastName, String emailAddress, String gender, Date birthDate,
			String password, String confirmedPassword, String homePhone,
			String mobilePhone, String addressLineOne, String addressLineTwo,
			String city, String regionId, String zip, String securityQuestion,
			String securityAnswer, String acceptedTOU,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param amfUserId the primary key for the new amf user
	 * @return the new amf user
	 */
	@Transactional(enabled = false)
	public AMFUser createAMFUser(long amfUserId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the amf user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AMFUser deleteAMFUser(AMFUser amfUser);

	/**
	 * Deletes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AMFUser deleteAMFUser(long amfUserId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFUser fetchAMFUser(long amfUserId);

	/**
	 * Returns the amf user matching the UUID and group.
	 *
	 * @param uuid the amf user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFUser fetchAMFUserByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the amf user with the primary key.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFUser getAMFUser(long amfUserId) throws PortalException;

	/**
	 * @param groupId
	 * @param userName
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAMFUserByUserName(long groupId, String userName);

	/**
	 * Returns the amf user matching the UUID and group.
	 *
	 * @param uuid the amf user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf user
	 * @throws PortalException if a matching amf user could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFUser getAMFUserByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of amf users
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFUser> getAMFUsers(int start, int end);

	/**
	 * @param groupId
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFUser> getAMFUsersByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<AMFUser> orderByComparator);

	/**
	 * Returns all the amf users matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf users
	 * @param companyId the primary key of the company
	 * @return the matching amf users, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFUser> getAMFUsersByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of amf users matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf users
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching amf users, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFUser> getAMFUsersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFUser> orderByComparator);

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAMFUsersCount();

	/**
	 * @param groupId
	 * @param userName
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAMFUsersCountByKeywords(long groupId, String userName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isUserNameUnique();

	/**
	 * Updates the amf user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFUser updateAMFUser(AMFUser amfUser);

}