package com.vis.store.dao.offer;

import stationary.store.model.Offer;

import java.util.List;

public interface OfferDAO {

    List<Offer> getOffers();

    void saveOffer(Offer Offer);

    Offer getOffer(int id);

    void deleteOffer(int id);

}
