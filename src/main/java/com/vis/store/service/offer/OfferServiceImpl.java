package com.vis.store.service.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.offer.OfferDAO;
import stationary.store.model.Offer;

import java.util.List;


@Service
public class OfferServiceImpl implements OfferService {


    @Autowired
    private OfferDAO offerDAO;

    @Override
    @Transactional
    public List<Offer> getOffers() {
        return offerDAO.getOffers();
    }

    @Override
    @Transactional
    public void saveOffer(Offer offer) {
        offerDAO.saveOffer(offer);
    }

    @Override
    @Transactional
    public Offer getOffer(int id) {
        return offerDAO.getOffer(id);
    }

    @Override
    @Transactional
    public void deleteOffer(int id) {
        offerDAO.deleteOffer(id);
    }

}





