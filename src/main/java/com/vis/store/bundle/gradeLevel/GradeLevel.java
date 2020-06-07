package com.vis.store.bundle.gradeLevel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.grade.Grade;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "grade_level")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GradeLevel extends BaseEntity {

    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "gradeLevel",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    private List<Grade> grades;


}
