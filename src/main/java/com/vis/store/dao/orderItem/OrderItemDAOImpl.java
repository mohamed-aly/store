package com.vis.store.dao.orderItem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.model.OrderItem;
import stationary.store.model.Product;

import javax.persistence.EntityGraph;
import java.util.List;

@Repository
public class OrderItemDAOImpl implements OrderItemDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<OrderItem> getOrderItems() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<OrderItem> theQuery =
                currentSession.createQuery("from OrderItem",
                        OrderItem.class);

        // execute query and get result list
        List<OrderItem> OrderItems = theQuery.getResultList();

        // return the results
        return OrderItems;
    }


    @Override
    public void saveOrderItem(OrderItem theOrderItem) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the OrderItem ... finally LOL
        currentSession.saveOrUpdate(theOrderItem);

    }

    @Override
    public OrderItem getOrderItem(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        OrderItem theOrderItem = currentSession.get(OrderItem.class, theId);

        return theOrderItem;
    }

    @Override
    public void deleteOrderItem(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from OrderItem where id=:orderItemId");
        theQuery.setParameter("orderItemId", theId);

        theQuery.executeUpdate();
    }

    /////////

    @Override
    public List<Product> getBestSellers(Integer limit) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        EntityGraph<Product> graph = currentSession.createEntityGraph(Product.class);

        graph.addAttributeNodes("offers");
        graph.addAttributeNodes("patches");
        graph.addAttributeNodes("imageUrl");

        String query = "select distinct p from Product p " +
                "left join p.orders po " +
                "where p.productId in (select oi.product.productId from OrderItem oi) " +
                "group by p.productId " +
                "order by sum(po.quantity) desc";


        Query<Product> theQuery = currentSession.createQuery(query, Product.class);

        if (limit == null) {
            limit = 5;
        }

        // execute query and get result list
        List<Product> items = theQuery
                .setMaxResults(limit)
                .setHint("javax.persistence.loadgraph", graph)
                .getResultList();

        return items;
    }
}
