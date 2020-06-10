package com.vis.store.bundle.userType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user_type")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserType extends BaseEntity {

    @Column(name = "user_type")
    private String userType;

    @OneToMany(mappedBy = "userType",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference(value="userType-user")
    private Set<User> users;
}
