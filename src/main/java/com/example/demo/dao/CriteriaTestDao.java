package com.example.demo.dao;

import com.example.demo.domain.MathTeacher;
import com.example.demo.domain.MathTeacher_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
@Repository
public class CriteriaTestDao
{
    @PersistenceContext
    private EntityManager entityManager;

    //根据条件查找
    public MathTeacher findByCriteria(String name)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MathTeacher> query = criteriaBuilder.createQuery(MathTeacher.class);
        Root<MathTeacher> teacherRoot = query.from(MathTeacher.class);
        //todo 熟悉criteria用法和restrictions的用法
        Predicate predicate = criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), name);
        query.where(predicate);
        TypedQuery<MathTeacher> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}
