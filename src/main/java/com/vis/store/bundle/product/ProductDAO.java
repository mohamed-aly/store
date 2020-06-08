package com.vis.store.bundle.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface ProductDAO extends CrudRepository<Product, Long> {

    @Query(" select p From Product p join fetch p.imageUrl")
    Iterable<Product> findAll();

    @Query(" select p.id from Product p join p.orders po on po.product.id=p.id " +
            "group by p.id order by sum(po.quantity) desc")
    List<Long> findBest();

    @Query("select p.id from Product p " +
            "join p.orders po on po.product.id=p.id " +
            "group by p.id order by sum(po.quantity) desc ")
    Set<Product> findBestAll();

    @Query("select p from Product p join fetch p.imageUrl where p.id IN (:id)")
    Set<Product> findAllById(@Param("id") List<Long> ids);

}
