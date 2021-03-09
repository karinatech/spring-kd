package com.cybertek.serviceImplementation;

import com.cybertek.entity.Product;
import com.cybertek.repo.ProductRepo;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {

        return productRepo.findAll();
    }

    @Override
    public List<Product> delete(Long id) {
         productRepo.deleteById(id);
        return productRepo.findAll();
    }

    @Override
    public List<Product> updateProduct(Long id, Product product) {
    Product obj = productRepo.findById(id).get();
    obj.setName(product.getName());
    productRepo.save(obj);
    return productRepo.findAll();


    }

    @Override
    public List<Product> createProduct(Product product) {
     productRepo.save(product);
     return productRepo.findAll();
    }

    @Override
    public Product getProduct(Long id) {
   return productRepo.findById(id).get();
    }
}
