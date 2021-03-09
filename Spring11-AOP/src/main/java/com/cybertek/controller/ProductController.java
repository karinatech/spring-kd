package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    Logger logger= LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public List<Product>getProducts(){
     List<Product> list=productService.getProducts();
        return list;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>>deleteProduct(@PathVariable("id") Long id){
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set("Version","KariV1");
        responseHeaders.set("Operation","Delete");

        List<Product> list=productService.delete(id);
        return new ResponseEntity<>(list,responseHeaders,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Product>>createProduct(@RequestBody Product product){
        List<Product>set = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).header("Veersion","KariV1")
                .header("Operation","Create").body(set);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<List<Product>>updateProoduct(@PathVariable("id") Long id,@RequestBody Product product){
        MultiValueMap<String,String>map = new LinkedMultiValueMap<>();
        map.add("Varsion","KariV1");
        map.add("Operation","Update");
        List<Product>list=productService.updateProduct(id,product);

        return new ResponseEntity<>(list,map,HttpStatus.OK);
    }
    @GetMapping("/read")
public ResponseEntity<ResponseWrapper>readAllProodducts(){
        return ResponseEntity.ok(new ResponseWrapper("Products successfully retrieved",productService.getProducts()));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper>deleteeProduct(@PathVariable("id") long id){

        return ResponseEntity.ok(new ResponseWrapper("Product seccessfully deleted"));
    }
    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper>deleteProduct2(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("Product Successfully deleted"));
    }
}
