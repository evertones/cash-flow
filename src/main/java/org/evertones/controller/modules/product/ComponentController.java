package org.evertones.controller.modules.product;

import org.evertones.controller.BaseController;
import org.evertones.model.modules.product.Component;
import org.evertones.model.modules.product.Product;
import org.evertones.persistence.modules.product.ComponentRepository;
import org.evertones.persistence.modules.product.ComponentService;
import org.evertones.persistence.modules.product.ProductRepository;
import org.evertones.persistence.modules.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/product/component")
public class ComponentController extends BaseController {

    private ProductRepository productRepository;
    private ProductService productService;
    private ComponentRepository componentRepository;
    private ComponentService componentService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setComponentRepository(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Autowired
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }

    //
//    @RequestMapping(path = "/list", method = RequestMethod.GET)
//    public String list(Model model) {
//        model.addAttribute("products", productRepository.findAll());
//        return "product/list";
//    }
//
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
//    public String add(Model model) {
//        model.addAttribute("product", new Product());
//
//        return "product/edit";
//    }

    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {

        // Product that will add its components
        Product product = productRepository.findOne(id);
        model.addAttribute("product", product);

        // Component that will be created
        model.addAttribute("component", new Component().setProduct(product));

        // Products to be list in the dropdown
        model.addAttribute("products", productService.findAllNotProduct());

        return "product/component/edit";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String submit(Component component, RedirectAttributes attributes) {
        // Sync with database
        component.setProduct(productRepository.findOne(component.getProduct().getId()));
        componentService.save(component);

        // TODO: add values for CSS classes in an Enum
        attributes.addFlashAttribute("flashMessage",
                messageSource.getMessage("module.general.saveSuccess.message", null, DEFAULT_LOCALE));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:add/%s", component.getProduct().getId().toString());
    }
//
//    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
//    public String delete(Model model, @PathVariable(name = "id") Integer id) {
//        productRepository.delete(id);
//        return "redirect:../list";
//    }

}
