package com.amf.registration.service;

import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.annotation.versioning.ProviderType;

/**
 * @author       : Raingsey
 * @project-name : amf-registration
 * @package-name : com.amf.registration.service
 * @email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * @crated-date  : 5/10/2021
 */
@ProviderType
@Transactional(
        isolation = Isolation.PORTAL,
        rollbackFor = {
                PortalException.class,
                SystemException.class,
                NoSuchUserGroupException.class
        }
)
public interface AMFUserGroupService {
        public long getAMFUserGroupId() throws NoSuchUserGroupException;
}
