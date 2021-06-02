package com.amf.newsletter.configure;

import com.liferay.dynamic.data.mapping.annotations.*;

@DDMForm
@DDMFormLayout(
        paginationMode = com.liferay.dynamic.data.mapping.model.DDMFormLayout.SINGLE_PAGE_MODE,
        value = {
                @DDMFormLayoutPage({
                        @DDMFormLayoutRow({
                                @DDMFormLayoutColumn(
                                        size = 12,
                                        value = {
                                                "imageCheckToken", "imageDefaultUseInitials",
                                                "imageMaxSize"
                                        }
                                )
                        }),
                        @DDMFormLayoutRow({
                                @DDMFormLayoutColumn(
                                        size = 6, value = "imageMaxHeight"
                                ),
                                @DDMFormLayoutColumn(size = 6, value = "imageMaxWidth")
                        })
                })
        }
)
public interface CustomDDMConfigurationForm {
    @DDMFormField(
            label = "%label-key-for-field-1",
            tip = "%description-key-for-field-1",
            properties = {
                    "placeholder=%enter-a-value",
                    "tooltip=%some-tooltip-text"
            }
    )
    public String[] textArrayValues();

    @DDMFormField(
            label = "%date",
            tip = "%date-description",
            type = "date")
    public String date();

    @DDMFormField(
            label = "%select",
            optionLabels = {"%foo", "%bar"},
            optionValues = {"foo", "bar"},
            type = "select")
    public String select();

    @DDMFormField(
            label = "%numeric",
            properties = {
                    "placeholder=%milliseconds",
                    "tooltip=%enter-an-integer-between-1000-and-30000"
            },
            validationErrorMessage = "%please-enter-an-integer-between-1000-and-30000-milliseconds",
            validationExpression = "(numeric >= 1000) && (numeric <= 30000)",
            type = "numeric")
    public String numeric();

    @DDMFormField(
            label = "%checkbox",
            properties = "showAsSwitcher=true")
    public boolean checkbox();

}
