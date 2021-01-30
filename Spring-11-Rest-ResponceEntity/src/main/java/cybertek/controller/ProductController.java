package cybertek.controller;

import cybertek.entity.Product;
import cybertek.entity.ResponseWrapper;
import cybertek.service.ProductService;
import lombok.Getter;
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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping(value="")
    public ResponseEntity<List<Product>>getProducts(){
        HttpHeaders responceHeaders=new HttpHeaders();
        responceHeaders.set("Version","KariV1");
        responceHeaders.set("Operation","Get List");
        return ResponseEntity
                .ok().headers(responceHeaders)
                .body(productService.getProducts());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>>deleteProduct(@PathVariable("id") Long id){
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set("Version","KariV1");
        responseHeaders.set("Operation","Delete");

        List<Product>list=productService.delete(id);
        return new ResponseEntity<>(list,responseHeaders,HttpStatus.OK);
    }

    @PostMapping(value="")
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
