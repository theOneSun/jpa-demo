package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author sunjian.
 */
@Entity
@NamedQuery(name = "Person.withNameAndAddressNamedQuery", query = "select p from Person p where p.name=?1 and p.address=?2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person
{
    @Id
    @Column(length = 32)
    private String id;
    private String name;
    private Integer age;
    private String address;
}
