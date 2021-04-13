package com.amf.registration.event;

import com.amf.registration.model.AMFEventLog;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.amf.registration.utilities.EventStatus;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
            AMFEventLog eventLogForCurrentUser = AMFEventLogLocalServiceUtil.getAmfEventLogByGroupAndUser(loggedInUser.getGroupId(), loggedInUser.getUserId());
            eventLogForCurrentUser.setLastLoginDate(loggedInUser.getLastLoginDate());
            eventLogForCurrentUser.setStatus(EventStatus.LOGIN);
            eventLogForCurrentUser.setLastLoginIP(loggedInUser.getLastLoginIP());
            AMFEventLogLocalServiceUtil.updateAMFEventLog(eventLogForCurrentUser);
        } catch (PortalException e) {

        }
    }

    @Reference
    private UserService userService;
}
