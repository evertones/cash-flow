package org.evertones.persistence.modules.product;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.modules.product.QProduct;

public class ProductSpecification {

    static BooleanExpression queryProductByName(String name) {
        return QProduct.product.name.containsIgnoreCase(name);
    }
}
