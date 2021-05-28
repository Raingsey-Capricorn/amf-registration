package com.amf.registration.service;

import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

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
public class AMFUserGroupServiceUtil {
        public static final String MESSAGE = "amfUserGroupMissing";
        /**
         *
         * @return
         * @throws NoSuchUserGroupException
         */
        public static long getAMFUserGroupId() throws NoSuchUserGroupException {
                return getService().getAMFUserGroupId();
        }

        /**
         * @return
         * @throws NoSuchUserGroupException
         */
        public static boolean isAMFUserGroupExiting() throws NoSuchUserGroupException {
                return getService().getAMFUserGroupId() > 0;
        }

        private static AMFUserGroupService getService() {
                return _serviceTracker.getService();
        }

        private static ServiceTracker<AMFUserGroupService, AMFUserGroupService> _serviceTracker;

        static {
                Bundle bundle = FrameworkUtil.getBundle(AMFUserGroupService.class);
                ServiceTracker<AMFUserGroupService, AMFUserGroupService> serviceTracker = new ServiceTracker<AMFUserGroupService, AMFUserGroupService>(
                                bundle.getBundleContext(), AMFUserGroupService.class, null);
                serviceTracker.open();
                _serviceTracker = serviceTracker;
        }
}
