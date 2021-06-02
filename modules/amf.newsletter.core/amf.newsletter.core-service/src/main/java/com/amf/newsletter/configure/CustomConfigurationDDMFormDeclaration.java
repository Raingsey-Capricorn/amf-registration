package com.amf.newsletter.configure;

import com.liferay.configuration.admin.definition.ConfigurationDDMFormDeclaration;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = "configurationPid=com.amf.newsletter.configure.CustomDDMConfigurationForm",
        service = CustomConfigurationDDMFormDeclaration.class
)
public class CustomConfigurationDDMFormDeclaration implements ConfigurationDDMFormDeclaration {
    /**
     * @return
     */
    @Override
    public Class<?> getDDMFormClass() {
        return CustomDDMConfigurationForm.class;
    }
}
