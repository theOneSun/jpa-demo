package com.example.demo.criteriaTest;

import com.example.demo.SecurityJpaApplication;
import com.example.demo.dao.CriteriaTestDao;
import com.example.demo.domain.MathTeacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityJpaApplication.class)
public class CriteriaTest
{
    @Resource
    private CriteriaTestDao criteriaTestDao;

    @Test
    public void testFindByName() throws Exception
    {
        List<String> nameList = new ArrayList<>();
//        nameList.add("Guardiola");
//        nameList.add("Mourinho");
        MathTeacher result = criteriaTestDao.findByCriteria("Guardiola");
        System.out.println(result);
    }

    @Test
    public void testFindByList() throws Exception
    {
        List<String> nameList = new ArrayList<>();
        nameList.add("Guardiola");
        nameList.add("Mourinho");
        List<MathTeacher> resultList = criteriaTestDao.findByNameList(nameList);
        resultList.forEach(System.out::println);

    }
}
