package com.vis.store.bundle.address;


import com.vis.store.bundle.address.Address;

import java.util.Set;

public interface AddressService {

    Address save(Address address);

    Address findById(Long l);

    Set<Address> findAll();

    void deleteById(Long idToDelete);

}
