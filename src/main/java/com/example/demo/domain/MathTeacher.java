package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author sunjian.
 */
@Entity
//@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MathTeacher
{
    @Id
    @Column(length = 32)
    private String id;
    @Column(length = 20)
    private String name;
    //一对多
    @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE }, mappedBy = "mathTeacher")
    private Set<HighStudent> studentSet;
}
