package com.vis.store.dao;

import com.vis.store.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Long> {

}
