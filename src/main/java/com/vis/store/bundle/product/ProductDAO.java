package com.vis.store.bundle.product;

import com.vis.store.bundle.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Long> {

    Iterable<Product> findAll();

}
