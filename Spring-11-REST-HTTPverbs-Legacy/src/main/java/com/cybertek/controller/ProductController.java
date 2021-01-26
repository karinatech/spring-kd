package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }
    @RequestMapping(value = "/products")
    public @ResponseBody List<Product>geetProducts(){
        return productService.getProducts();
    }
}
