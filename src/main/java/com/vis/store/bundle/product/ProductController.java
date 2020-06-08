package com.vis.store.bundle.product;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Set<Product> getProducts() {
        Set<Product> productServiceAll = productService.findAll();
        return productServiceAll;
    }

    @GetMapping("/bestSellers")
    public Set<Product> getBestSellers() {
        return productService.findBestSellers();
    }

}
