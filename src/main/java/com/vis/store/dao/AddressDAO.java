package com.vis.store.dao;


import com.vis.store.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address, Long> {

}
