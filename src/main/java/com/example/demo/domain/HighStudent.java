package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author sunjian.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HighStudent
{
    @Id
    @Column(name = "id",length = 32)
    private String id;
    private String name;
    @Column(length = 20)
    private String number;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH })
    private MathTeacher mathTeacher;

    public HighStudent(String id, String name, String number)
    {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "HighStudent{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", number='" + number + '\'' + ", mathTeacher=" + mathTeacher.getName() + '}';
    }
}
