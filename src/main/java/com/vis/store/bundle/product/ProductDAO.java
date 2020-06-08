package com.vis.store.bundle.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface ProductDAO extends CrudRepository<Product, Long> {


    @Query(" select p From Product p join fetch p.imageUrl")
    Iterable<Product> findAll();


    @Query("select p from Product p " +
            "join p.orders po on po.product.id=p.id " +
            "group by p order by sum(po.quantity) desc ")
    Set<Product> findBestSellers();

}
