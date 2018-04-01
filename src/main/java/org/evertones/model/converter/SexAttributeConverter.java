package org.evertones.model.converter;

import org.evertones.model.types.Sex;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SexAttributeConterter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex value) {
        return (value == null ? null : value.getValue());
    }

    @Override
    public Sex convertToEntityAttribute(String value) {
        return (value == null || value.isEmpty() ? null : Sex.findSexByStringValue(value));
    }

}
