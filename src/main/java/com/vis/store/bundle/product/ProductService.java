package com.vis.store.bundle.product;


import com.vis.store.bundle.product.Product;

import java.util.Set;

public interface ProductService {

    Set<Product> findAll();

    Set<Product> findBestSellers();

}
