package com.vis.store.dao;

import com.vis.store.model.Package;
import org.springframework.data.repository.CrudRepository;

public interface ClassifiedProductDAO extends CrudRepository<Package, Long> {


}
