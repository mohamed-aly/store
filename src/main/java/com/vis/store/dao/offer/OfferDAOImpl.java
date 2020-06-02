package com.vis.store.dao.offer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import stationary.store.model.Offer;

import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> getOffers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Offer> offerQuery = currentSession.createQuery("from Offer", Offer.class);
        
        List<Offer> offers = offerQuery.getResultList();

        return offers;
    }

    @Override
    public void saveOffer(Offer offer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(offer);
    }

    @Override
    public Offer getOffer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Offer offer = currentSession.get(Offer.class, id);

        return offer;
    }

    @Override
    public void deleteOffer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Offer where id=:offerId");
        query.setParameter("offerId", id);

        query.executeUpdate();
    }
}







