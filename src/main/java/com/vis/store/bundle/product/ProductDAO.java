package com.vis.store.bundle.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface ProductDAO extends CrudRepository<Product, Long> {


    @Query(" select p From Product p left join fetch p.imageUrl")
    Set<Product> findAll();

    @Query("select p.id from Product p " +
            "join p.orders po "+
            "where po.product.id=p.id " +
            "group by p order by sum(po.quantity) desc ")
    Long[] findBestSellersIds();


    @Query("select p from Product p " +
            "left join fetch p.imageUrl " +
            "where p.id in (:ids)")
    Set<Product> findBestSellers(@Param("ids") Long[] ids);

    @Query("select p from Product p " +
            "left join fetch p.imageUrl " +
            "join p.orders po "+
            "where po.product.id=p.id " +
            "group by p order by sum(po.quantity) desc ")
    Set<Product> findBestSellers();

}
