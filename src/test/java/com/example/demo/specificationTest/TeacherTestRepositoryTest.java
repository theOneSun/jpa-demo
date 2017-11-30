package com.example.demo.specificationTest;

import com.example.demo.SecurityJpaApplication;
import com.example.demo.dao.TestTeacherRepository;
import com.example.demo.domain.MathTeacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by sj on 2017/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityJpaApplication.class)
public class TeacherTestRepositoryTest {
    @Resource
    private TestTeacherRepository testTeacherRepository;

    @Test
    public void testFindByName() throws Exception {
        Specification<MathTeacher> mathTeacherSpecification = teacherCalled();
        System.out.println(mathTeacherSpecification);
    }

    public Specification<MathTeacher> teacherCalled(){
        return new Specification<MathTeacher>() {
            @Override
            public Predicate toPredicate(Root<MathTeacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"),"王老师");
            }
        };
    }
}
