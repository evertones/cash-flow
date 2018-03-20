package org.evertones.api;

import org.evertones.controller.BaseController;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.modules.product.Product;
import org.evertones.persistence.modules.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductRestController extends BaseController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ResponseEntity<SuggestionBoxDto> list(String query) {
        SuggestionBoxDto suggestionBoxDto = new SuggestionBoxDto<ClientDetails>();
        suggestionBoxDto.setQuery("QUERY_PRODUCTS");

        List<SimpleEntityDto> items = new ArrayList<SimpleEntityDto>();

        if (query != null && query.length() >= 3) {
            List<Product> products = productService.findAllBy(query);
            products.forEach(product ->
                    items.add(new SimpleEntityDto(product.getId(), product.getName()))
            );

            suggestionBoxDto.setSuggestions(items);
        }

        return ResponseEntity.ok(suggestionBoxDto);
    }

}
