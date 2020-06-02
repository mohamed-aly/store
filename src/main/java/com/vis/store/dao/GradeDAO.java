package com.vis.store.dao;

import com.vis.store.model.Grade;
import org.springframework.data.repository.CrudRepository;


public interface GradeDAO extends CrudRepository<Grade, Long> {

}
