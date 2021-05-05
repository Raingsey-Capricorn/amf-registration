package com.amf.registration.internal.security.permission.resource.definition;

import com.amf.registration.constant.AMFRegistrationConstants;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        service = PortletResourcePermissionDefinition.class
)
public class AMFRegistrationPortletResourcePermissionDefinition implements PortletResourcePermissionDefinition {
    /**
     * @return
     */
    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
        return new PortletResourcePermissionLogic[]{
                new StagedPortletPermissionLogic(
                        stagingPermission,
                        "com_amf_registration_portlet_AMFRegistrationPortlet"
                )
        };
    }

    /**
     * @return
     */
    @Override
    public String getResourceName() {
        return AMFRegistrationConstants.RESOURCE_NAME;
    }

    @Reference
    private StagingPermission stagingPermission;
}
