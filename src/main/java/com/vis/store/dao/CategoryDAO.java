package com.vis.store.dao;

import com.vis.store.model.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryDAO extends CrudRepository<Category, Long> {

}
