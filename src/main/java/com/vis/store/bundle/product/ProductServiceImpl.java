package com.vis.store.bundle.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;


    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO=productDAO;
    }

    @Override
    @Transactional
    public Set<Product> findAll() {
        log.debug("I'm in the product service");

        Set<Product> productSet = new HashSet<>();
        productDAO.findAll().iterator().forEachRemaining(productSet::add);

        return productSet;
    }


    @Override
    public Set<Product> findBestSellers() {
        return productDAO.findBestSellers();
    }
}





