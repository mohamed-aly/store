package com.vis.store.service.address;


import com.vis.store.model.Address;

import java.util.Set;

public interface AddressService {

    Address save(Address address);

    Address findById(Long l);

    Set<Address> findAll();

    void deleteById(Long idToDelete);

}
