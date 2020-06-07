package com.vis.store.bundle.category;

import com.vis.store.bundle.category.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryDAO extends CrudRepository<Category, Long> {

}
