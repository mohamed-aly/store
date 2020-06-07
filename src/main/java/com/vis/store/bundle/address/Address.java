package com.vis.store.bundle.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Getter
@Setter
@Entity
@Table(name = "address")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Address extends BaseEntity {

    @Column(name = "building")
    private int buildingNumber;

    @Column(name = "apartment")
    private int apartmentNumber;

    @Column(name = "street_details")
    private String streetDetails;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "special_marque")
    private String specialMarque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
