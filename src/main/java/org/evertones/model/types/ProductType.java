package org.evertones.model.types;

public enum ProductType {

    COMPONENT(0),
    COST(1),
    PRODUCT(2);

    ProductType(Integer value) {
        this.value = value;
    }

    private Integer value;
    private String phrase;

    public Integer getValue() {
        return this.value;
    }

    public String getPhrase() {
        switch(this) {
            case COMPONENT: return "module.product.type.component.label";
            case COST:      return "module.product.type.cost.label";
            case PRODUCT:   return "module.product.type.product.label";
            default:
                throw new IllegalArgumentException(String.format("Phrase for {%s} is not supported", this));
        }
    }

    public static ProductType findProductTypeByIntegerValue(Integer value) {
        switch(value) {
            case 0: return ProductType.COMPONENT;
            case 1: return ProductType.COST;
            case 2: return ProductType.PRODUCT;
            default:
                throw new IllegalArgumentException(String.format("Product Type value for {%s} is not supported", value));
        }
    }

}
