package com.vis.store.bundle.product;


import java.util.Set;

public interface ProductService {

    Set<Product> findAll();

    Set<Product> findBestSellers();

}
