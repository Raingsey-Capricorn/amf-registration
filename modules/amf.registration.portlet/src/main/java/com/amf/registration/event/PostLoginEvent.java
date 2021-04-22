package com.amf.registration.event;

import com.amf.registration.service.AMFEventLogLocalServiceUtil;
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
            if (loggedInUser.getRoles().get(0).getDescriptiveName().equals("User")) {
                AMFEventLogLocalServiceUtil.addAMFEventLog(userService.getCurrentUser());
            }
        } catch (PortalException e) {

        }
    }

    @Reference
    private UserService userService;
}
