package com.amf.newsletter.model.listener;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import org.osgi.service.component.annotations.Component;

@Component(service = ModelListener.class)
public class DDMStructureListener extends BaseModelListener<DDMStructure> {
    @Override
    public void onBeforeUpdate(DDMStructure model) throws ModelListenerException {
        System.out.println();
    }
}
