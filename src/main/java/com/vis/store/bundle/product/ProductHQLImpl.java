package com.vis.store.bundle.product;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductHQLImpl implements ProductHQL {

    @PersistenceContext
    private EntityManager entityManager;

    Session session;

    @Override
    public List<Long> getBestSellers() {
        // get the current hibernate session

        session = entityManager.unwrap(Session.class);


        String query = "select p.id from Product p " +
                "join p.orders po on po.product.id=p.id " +
                "group by p.id order by sum(po.quantity) desc ";


        Query<Long> theQuery;

        theQuery = session.createQuery(query, Long.class);

        List<Long> result = theQuery
                .getResultList();


        return result;
    }
}
