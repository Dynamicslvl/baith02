package baith2.Controller;

import baith2.Product.Product;
import baith2.repository.ProducRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class ProductController {
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
    @Autowired
    private ProducRepository producRepository;
    
    @GetMapping("/products")
    public String getProduct(Model model) {
        List<Product> productList = producRepository.findAll();
        model.addAttribute("listProduct", productList);
        return "product";
    }
    
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(name = "id") String code, Model model){
        Product product= producRepository.findByCode(code);
        model.addAttribute("productEdit", product);
        return "edit";
    }
    @PostMapping(value = "/update")
    public String updateProduct(@ModelAttribute("productEdit") Product product){
        producRepository.save(product);
        System.out.println(product.toString());
        return "redirect:/products";
    }
    
    @GetMapping("/addProduct")
    public String showAddProduct(Model model){
        model.addAttribute("newProduct", new Product());
        return "addproduct";
    }
    @PostMapping(value = "/add")
    public String addProduct(@ModelAttribute("newProduct") Product product){
    	System.out.println(product.toString());
        producRepository.save(product);
        return "redirect:/products";
    }
    
    @GetMapping("/delete/{id}")
    public String findProduct(Model model, @PathVariable(name = "id") String code) {
        Product product = producRepository.findByCode(code);
        System.out.println(product.toString());
        model.addAttribute("productDelete", product);
        return "delete";
    }
    @PostMapping(value = "/delete/{id}")
    public String deleteProduct(@ModelAttribute("productDelete") Product product) {
    	System.out.println(product.toString());
        
        return "redirect:/products";
    }
}
