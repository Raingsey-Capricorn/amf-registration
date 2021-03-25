package com.amf.registration.portlet.display.context;

import com.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.amf.registration.portlet.constants.MVCCommandNames;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AMFToolbarDisplayContext extends BaseManagementToolbarDisplayContext {
    /**
     * @param httpServletRequest
     * @param liferayPortletRequest
     * @param liferayPortletResponse
     */
    public AMFToolbarDisplayContext(HttpServletRequest httpServletRequest, LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse);
        portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
        themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
    }

    @Override
    public CreationMenu getCreationMenu() {
        return new CreationMenu() {{
            addDropdownItem(
                    dropdownItem -> {
                        dropdownItem.setHref(
                                liferayPortletResponse.createRenderURL(),
                                "mvcRenderCommandName",
                                MVCCommandNames.AMF_REGISTER,
                                "redirect",
                                currentURLObj.toString());
                        dropdownItem.setLabel(LanguageUtil.get(liferayPortletRequest.getHttpServletRequest(), "user-register"));
                    }
            );
        }};
    }

    @Override
    public String getSearchActionURL() {
        PortletURL portletURL = liferayPortletResponse.createRenderURL();
        portletURL.setProperty("mvcRenderCommandName", MVCCommandNames.AMF_VIEW_MEMBERS);
        String navigation = ParamUtil.getString(
                liferayPortletRequest.getHttpServletRequest(),
                "navigation",
                "entries"
        );
        portletURL.setParameter("navigation", navigation);
        portletURL.setParameter("orderByCol", getOrderByCol());
        portletURL.setParameter("orderByType", getOrderByType());
        return portletURL.toString();
    }

    @Override
    public List<ViewTypeItem> getViewTypeItems() {
        PortletURL portletURL = liferayPortletResponse.createRenderURL();
        portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.AMF_VIEW_MEMBERS);
        int delta = ParamUtil.getInteger(liferayPortletRequest.getHttpServletRequest(), SearchContainer.DEFAULT_DELTA_PARAM);

        portletURL.setParameter("delta", String.valueOf(Math.max(delta, 0)));
        String orderByCol = ParamUtil.getString(liferayPortletRequest.getHttpServletRequest(), "orderByCol", "userName");
        String orderByType = ParamUtil.getString(liferayPortletRequest.getHttpServletRequest(), "orderByType", "asc");
        portletURL.setParameter("orderByCol", orderByCol);
        portletURL.setParameter("orderByType", orderByType);
        int cur = ParamUtil.getInteger(liferayPortletRequest.getHttpServletRequest(), SearchContainer.DEFAULT_CUR_PARAM);
        portletURL.setParameter("cur", String.valueOf(Math.max(cur, 0)));
        return new ViewTypeItemList(portletURL, getDisplayStyle()) {
            {
                addCardViewTypeItem();
                addListViewTypeItem();
                addTableViewTypeItem();
            }
        };
    }

    @Override
    protected List<DropdownItem> getOrderByDropdownItems() {
        return new DropdownItemList() {{
            add(dropdownItem -> {
                dropdownItem.setActive("userName".equals(getOrderByCol()));
                dropdownItem.setHref(getCurrentSortingURL(), "orderByCol", "userName");
                dropdownItem.setLabel(LanguageUtil.get(liferayPortletRequest.getHttpServletRequest(), "userName"));
            });
            add(dropdownItem -> {
                dropdownItem.setActive("createDate".equals(getOrderByCol()));
                dropdownItem.setHref(getCurrentSortingURL(), "orderByCol", "createDate");
                dropdownItem.setLabel(LanguageUtil.get(liferayPortletRequest.getHttpServletRequest(), "create-date"));
            });
        }};
    }

    /**
     * @return
     * @throws PortletException
     */
    private PortletURL getCurrentSortingURL() throws PortletException {
        PortletURL sortingURL = PortletURLUtil.clone(currentURLObj, liferayPortletResponse);
        sortingURL.setParameter("mvcRenderCommandName", MVCCommandNames.AMF_VIEW_MEMBERS);
        sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");
        String keywords = ParamUtil.getString(liferayPortletRequest.getHttpServletRequest(), "keywords");
        if (Validator.isNotNull(keywords)) {
            sortingURL.setParameter("keywords", keywords);
        }
        return sortingURL;
    }

    /**
     * @return
     */
    public String getDisplayStyle() {
        String displayStyle = ParamUtil.getString(liferayPortletRequest.getHttpServletRequest(), "displayStyle");
        if (Validator.isNull(displayStyle)) {
            displayStyle = portalPreferences.getValue(AMFRegistrationPortletKeys.AMF_REGISTRATION, "amf-display-style", "descriptive");
        } else {
            portalPreferences.setValue(AMFRegistrationPortletKeys.AMF_REGISTRATION, "amf-display-style", displayStyle);
            request.setAttribute(WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
        }
        return displayStyle;
    }

    @Override
    public String getClearResultsURL() {
        return getSearchActionURL();
    }

    @Override
    public String getOrderByCol() {
        return ParamUtil.getString(liferayPortletRequest.getHttpServletRequest(), "orderByCol", "userName");
    }

    @Override
    public String getOrderByType() {
        return ParamUtil.getString(liferayPortletRequest.getHttpServletRequest(), "orderByType", "asc");
    }


    private final PortalPreferences portalPreferences;
    private final ThemeDisplay themeDisplay;

}
