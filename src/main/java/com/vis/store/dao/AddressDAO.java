package com.vis.store.dao;


import com.vis.store.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressDAO extends CrudRepository<Address, Long> {

}
