package com.amf.registration.portlet.internal.security.permission.resource;

import com.amf.registration.model.AMFUser;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true
        , service = AMFRegistrationPermission.class
)
public class AMFRegistrationPermission {

    /**
     * @param permissionChecker
     * @param amfUser
     * @param actionId
     * @return
     * @throws PortalException
     */
    public static boolean contains(
            PermissionChecker permissionChecker,
            AMFUser amfUser,
            String actionId) throws PortalException {

        return amfUserModelResourcePermission.contains(
                permissionChecker, amfUser, actionId);
    }

    @Reference(
            target = "(model.class.name=com.amf.registration.model.AMFUser)",
            unbind = "-"
    )
    protected void setEntryModelPermission(
            ModelResourcePermission<AMFUser> modelResourcePermission) {
        amfUserModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<AMFUser> amfUserModelResourcePermission;
}
