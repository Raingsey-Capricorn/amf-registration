package com.amf.registration.portlet.internal.security.permission.resource;

import com.amf.registration.constant.AMFRegistrationConstants;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 */
@Component(
        immediate = true,
        service = AMFRegistrationTopLevelPermission.class
)
public class AMFRegistrationTopLevelPermission {

    /**
     * @param permissionChecker
     * @param groupId
     * @param actionId
     * @return
     */
    public static boolean contains(
            PermissionChecker permissionChecker,
            long groupId,
            String actionId) {

        return portletResourcePermission.contains(permissionChecker, groupId, actionId);
    }

    @Reference(
            target = "(resource.name=" + AMFRegistrationConstants.RESOURCE_NAME + ")",
            unbind = "-"
    )
    protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {
        AMFRegistrationTopLevelPermission.portletResourcePermission = portletResourcePermission;
    }

    private static PortletResourcePermission portletResourcePermission;
}
