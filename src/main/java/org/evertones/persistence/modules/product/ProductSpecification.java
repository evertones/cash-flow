package org.evertones.persistence.modules.product;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.modules.product.QProduct;
import org.evertones.model.types.ProductType;

public class ProductSpecification {

    static BooleanExpression queryProductTypeNotProduct() {
        return QProduct.product.productType.ne(ProductType.PRODUCT);
    }
}
