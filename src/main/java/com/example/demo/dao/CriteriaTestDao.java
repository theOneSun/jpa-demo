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
    public List<MathTeacher> findByCriteria(List<String> nameList){
        /*MathTeacher teacher = new MathTeacher();
        teacher.setName(studentNameList.get(0));*/

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MathTeacher> query = criteriaBuilder.createQuery(MathTeacher.class);
        Root<MathTeacher> teacherRoot = query.from(MathTeacher.class);
//        Predicate condition = qb.gt(p.get(Person_.age), 20);
        //todo 熟悉criteria用法和restrictions的用法
        Predicate predicate =  null;
        List<Predicate> predicateList = new ArrayList<>();
        CriteriaBuilder.In<String> in = criteriaBuilder.in(teacherRoot.get(MathTeacher_.name));
        for (String teacherName : nameList)
        {
//            predicate = criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), teacherName);
            //predicate = criteriaBuilder.or(criteriaBuilder.equal(teacherRoot.get(MathTeacher_.name), teacherName));
            in.value(teacherName);
//            predicateList.add(criteriaBuilder.in(in));
            //query.where(predicate);
        }
        predicateList.add(criteriaBuilder.in(in));
        query.where(predicateList.toArray(new Predicate[predicateList.size()]));

        TypedQuery<MathTeacher> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
