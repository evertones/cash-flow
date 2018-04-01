package org.evertones.model.converter;

import org.evertones.model.types.ProductType;
import org.evertones.model.types.Sex;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductTypeAttributeConverter implements AttributeConverter<ProductType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductType value) {
        return (value == null ? null : value.getValue());
    }

    @Override
    public ProductType convertToEntityAttribute(Integer value) {
        return (value == null ? null : ProductType.findProductTypeByIntegerValue(value));
    }

}
