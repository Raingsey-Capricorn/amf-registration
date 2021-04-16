package com.amf.registration.internal.security.permission.resource.definition;

import com.amf.registration.constant.AMFRegistrationConstants;
import com.amf.registration.model.AMFUser;
import com.amf.registration.model.AMFUserModel;
import com.amf.registration.service.AMFUserLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Consumer;

@Component(
        immediate = true,
        service = ModelResourcePermissionDefinition.class
)
public class AMFRegistrationModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<AMFUser> {
    /**
     * @param amfUserID
     * @return
     * @throws PortalException
     */
    public AMFUser getModel(long amfUserID) throws PortalException {
        return amfUserLocalService.getAMFUser(amfUserID);
    }

    @Override
    public Class<AMFUser> getModelClass() {
        return AMFUser.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(AMFUser amfUser) {
        return amfUser.getAmfUserId();
    }

    @Override
    public void registerModelResourcePermissionLogics(
            ModelResourcePermission<AMFUser> modelResourcePermission,
            Consumer<ModelResourcePermissionLogic<AMFUser>> modelResourcePermissionLogicConsumer) {
        modelResourcePermissionLogicConsumer.accept(
                new StagedModelPermissionLogic<>(
                        stagingPermission,
                        "com_amf_registration_portlet_AMFRegistrationPortlet",
                        AMFUserModel::getAmfUserId
                )
        );
    }

    @Reference
    private AMFUserLocalService amfUserLocalService;

    @Reference(target = "(resource.name=" + AMFRegistrationConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission portletResourcePermission;

    @Reference
    private StagingPermission stagingPermission;
}
