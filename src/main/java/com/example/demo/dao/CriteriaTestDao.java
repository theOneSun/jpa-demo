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

    //根据名字的集合查找
    public List<MathTeacher> findByNameList(List<String> nameList){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MathTeacher> query = criteriaBuilder.createQuery(MathTeacher.class);
        Root<MathTeacher> teacherRoot = query.from(MathTeacher.class);

        Predicate predicate = null;
        for (String name : nameList)
        {
            if (predicate==null){
                //第一次进来
                predicate = criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), name);
            }else{
                predicate = criteriaBuilder.or(predicate,criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), name));
            }
        }
        /*Predicate predicate1 = criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), nameList.get(0));
        Predicate predicate2 = criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), nameList.get(1));
        Predicate predicate = criteriaBuilder.or(predicate1, predicate2);*/
        query.where(predicate);
        TypedQuery<MathTeacher> queryTeacher = entityManager.createQuery(query);

        return queryTeacher.getResultList();
    }
}
