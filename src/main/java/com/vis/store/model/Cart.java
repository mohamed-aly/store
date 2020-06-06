package com.vis.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Cart extends BaseEntity {

    @Column(name="last_update")
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    @JsonManagedReference
    private Set<CartItem> cartItems;

}
