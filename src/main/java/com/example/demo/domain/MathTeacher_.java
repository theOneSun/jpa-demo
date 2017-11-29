package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Set;

/**
 * @author sunjian.
 */
@StaticMetamodel(MathTeacher.class)
public class MathTeacher_
{
    public static volatile SingularAttribute<MathTeacher,String> id;
    public static volatile SingularAttribute<MathTeacher,String> name;
    public static volatile SingularAttribute<MathTeacher,String> studentSet;
}
