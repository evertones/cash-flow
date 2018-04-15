package org.evertones.controller.modules.product;

import org.evertones.controller.BaseController;
import org.evertones.model.modules.product.Product;
import org.evertones.persistence.modules.product.ProductRepository;
import org.evertones.persistence.modules.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController extends BaseController {

    private ProductRepository productRepository;
    private ProductService    productService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());

        return "product/edit";
    }

    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        Product product = productRepository.findOne(id);
        model.addAttribute("product", product);
        model.addAttribute("productComponents", product.getComponents());


        List<Double> price = new ArrayList<Double>();
        List<Double> priceWithDiscount = new ArrayList<Double>();

        product.getComponents().forEach(component -> {
            //Product p = productRepository.findOne()
            price.add(component.getQuantity() * component.getComponent().getPrice());
            priceWithDiscount.add(component.getPrice());
        });

        Double totalPrice = price.stream().mapToDouble(value -> value).sum();
        Double discountPrice = priceWithDiscount.stream().mapToDouble(value -> value).sum();

        System.out.println("Total Price: " + price.stream().mapToDouble(value -> value).sum());
        System.out.println("Total Price with Discount: " + priceWithDiscount.stream().mapToDouble(value -> value).sum());

        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);

        model.addAttribute("totalPrice", nf.format(totalPrice));
        model.addAttribute("discountPrice", nf.format(discountPrice));



        return "product/edit";
    }
    /*
    Client client = clientRepository.findOne(id);
        model.addAttribute("clientModels", client.getModels());
        model.addAttribute("client", client);
    */

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String submit(Product product, RedirectAttributes attributes) {
        productService.save(product);

        // TODO: 1) Get the default locale; 2) add values for CSS classes in an Enum
        attributes.addFlashAttribute("flashMessage", messageSource.getMessage("module.general.saveSuccess.message", null, DEFAULT_LOCALE));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:add/%s", product.getId().toString());
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(name = "id") Integer id) {
        productRepository.delete(id);
        return "redirect:../list";
    }

}
