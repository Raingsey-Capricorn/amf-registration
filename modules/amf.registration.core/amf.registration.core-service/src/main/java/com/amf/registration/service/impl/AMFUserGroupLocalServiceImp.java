package com.amf.registration.service.impl;

import com.amf.registration.service.AMFUserGroupService;
import com.amf.registration.service.AMFUserGroupServiceUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author       : Raingsey
 * @project-name : amf-registration
 * @package-name : com.amf.registration.service.impl
 * @email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * @crated-date  : 5/10/2021
 */
@Component(
        property = "model.class.name=com.liferay.portal.kernel.model.UserGroup"
)
public class AMFUserGroupLocalServiceImp implements AMFUserGroupService {

    /**
     * @return
     * @throws NoSuchUserGroupException
     */
    @Override
    public long getAMFUserGroupId() throws NoSuchUserGroupException {
        try {
            return (long) userGroupLocalService.dynamicQuery(
                    userGroupLocalService.dynamicQuery()
                            .add(RestrictionsFactoryUtil.conjunction()
                                    .add(RestrictionsFactoryUtil.eq("name", "AMF-Community")))
                            .setProjection(ProjectionFactoryUtil.groupProperty("userGroupId"))
            ).stream().findFirst().orElseThrow(NoSuchUserGroupException::new);
        } catch (NoSuchUserGroupException e) {
            throw new NoSuchUserGroupException(AMFUserGroupServiceUtil.MESSAGE);
        }
    }

    @Reference
    private UserGroupLocalService userGroupLocalService;
}
