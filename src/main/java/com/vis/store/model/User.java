package com.vis.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "user")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_type_id")
    @JsonBackReference
    private UserType userType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number1")
    private String phoneNumber1;

    @Column(name = "phone_number2")
    private String phoneNumber2;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<OrderDetails> ordersDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public User(Long id, String firstName, String lastName, Set<Address> addresses) {
        this.setId(id);
        this.firstName=firstName;
        this.lastName=lastName;
        this.addresses=addresses;
    }


}
