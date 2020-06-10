package com.vis.store.bundle.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.address.Address;
import com.vis.store.bundle.cart.Cart;
import com.vis.store.bundle.orderDetails.OrderDetails;
import com.vis.store.bundle.userType.UserType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
    @JsonBackReference(value="userType-user")
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
    @NotEmpty(message = "Email is required.")
    @Email
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "Password is required.")
    private String password;

    @Transient
    private String passwordConfirmation;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value="address-user")
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value="orderDetails-user")
    private Set<OrderDetails> ordersDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [email=" + email + "]";
    }

}
