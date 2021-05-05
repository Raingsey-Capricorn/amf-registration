package com.amf.registration.event;

import com.amf.registration.exception.NoSuchAMFEventLogException;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

/**
 * project-name : amf-registration
 * package-name : com.amf.registration.portlet.portlet.command.action
 * author       : Pisethraingsey SUON
 * email        : pisethraingsey.suon@gs.liferay.com, raingsey@glean.net
 * crated-date  : 4/12/2021
 */
@Component(
        immediate = true,
        property = {
                "key=login.events.post"
        },
        service = LifecycleAction.class
)
public class PostLoginEvent implements LifecycleAction {
    /**
     * @param lifecycleEvent
     * @throws ActionException
     */
    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
        try {
            User loggedInUser = userService.getCurrentUser();
            if (loggedInUser.getRoles().stream().noneMatch(desc -> desc.getName().equals("Administrator")) &&
                    UserGroupLocalServiceUtil.getUserGroup(
                            Arrays.stream(loggedInUser.getUserGroupIds()).findFirst().orElseThrow(NoSuchAMFEventLogException::new))
                            .getName().equalsIgnoreCase("amf-community")) {

                AMFEventLogLocalServiceUtil.addAMFEventLog(loggedInUser);
            }
        } catch (PortalException e) {
            SessionErrors.add(lifecycleEvent.getRequest(), "serviceErrorDetails", e.getMessage());
        }
    }

    @Reference
    private UserService userService;
}
