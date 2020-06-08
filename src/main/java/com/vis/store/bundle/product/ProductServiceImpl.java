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
    private final ProductHQL productHQL;

    public ProductServiceImpl(ProductDAO productDAO, ProductHQL productHQL) {
        this.productDAO=productDAO;
        this.productHQL = productHQL;
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
    @Transactional
    public Set<Long> getBestSellers() {
        log.debug("I'm in the product service");

        Set<Long> productSet = new HashSet<>();
        productHQL.getBestSellers().iterator().forEachRemaining(productSet::add);

        return productSet;
    }

    @Override
    public List<Long> findBest() {
        return productDAO.findBest();
    }

    @Override
    public Set<Product> findBestByID() {
        return productDAO.findBestAll();
    }
}





