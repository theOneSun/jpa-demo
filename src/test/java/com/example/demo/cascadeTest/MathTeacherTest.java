package com.example.demo.cascadeTest;

import com.example.demo.SecurityJpaApplication;
import com.example.demo.dao.HighStudentRepository;
import com.example.demo.dao.MathTeacherRepository;
import com.example.demo.domain.HighStudent;
import com.example.demo.domain.MathTeacher;
import com.example.demo.util.UUIDUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.jpa.internal.EntityManagerFactoryImpl;
import org.hibernate.jpa.internal.EntityManagerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author sunjian.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityJpaApplication.class)
public class MathTeacherTest
{
    @Resource
    private MathTeacherRepository mathTeacherRepository;

    @Resource
    private HighStudentRepository studentRepository;

    @Test
    public void testAddTeacher(){
        Set<MathTeacher> teacherSet = new HashSet<>();
//        teacherSet.add(new MathTeacher(UUID.randomUUID().toString().replaceAll("-",""),"高老师",null));
//        teacherSet.add(new MathTeacher(UUID.randomUUID().toString().replaceAll("-",""),"赵老师",null));
        teacherSet.add(new MathTeacher(UUID.randomUUID().toString().replaceAll("-",""),"王老师",null));
        List<MathTeacher> list = mathTeacherRepository.save(teacherSet);
        System.out.println("添加了:  "+list.size());
    }

    @Test
    public void testStudentCascadeAdd()
    {
        MathTeacher teacher = mathTeacherRepository.findByName("王老师");
        HighStudent student = new HighStudent(UUIDUtils.getUUID(), "hehe2", "0912", teacher);
        studentRepository.save(student);
    }

    @Test
    //测试删除一的一方
    public void testDeleteOne() throws Exception
    {
        MathTeacher teacher = mathTeacherRepository.findByName("王老师");
        int i = studentRepository.setMathTeacherIdNull(teacher.getId());
        System.out.println("修改了"+i+"条");
        mathTeacherRepository.delete(teacher);
    }


    @Test
    //测试级联添加
    public void testCascadeAdd() throws Exception
    {
        MathTeacher teacher = new MathTeacher(UUIDUtils.getUUID(),"Cruyff",null);
        Set<HighStudent> studentSet = new HashSet<>();
        studentSet.add(new HighStudent(UUIDUtils.getUUID(),"Messi","124112",teacher));
        studentSet.add(new HighStudent(UUIDUtils.getUUID(),"Iniesta","182736",teacher));
        studentSet.add(new HighStudent(UUIDUtils.getUUID(),"Xavi","185412",teacher));
        teacher.setStudentSet(studentSet);
//        List<HighStudent> studentList = studentRepository.save(studentSet);
//        System.out.println("插入了"+studentList.size()+"个学生");
        mathTeacherRepository.save(teacher);
    }

    //测试删除多的一方
    @Test
    public void testDeleteMany() throws Exception
    {
        List<HighStudent> resultList = studentRepository.findByName("Xavi");
        HighStudent highStudent = resultList.get(0);
        studentRepository.delete(highStudent);
    }

    //测试保存多的一方
    @Test
    public void testSaveMany() throws Exception
    {
        MathTeacher teacher1 = new MathTeacher(UUIDUtils.getUUID(),"Guardiola",null);
        MathTeacher teacher2 = new MathTeacher(UUIDUtils.getUUID(),"Mourinho",null);
        HighStudent highStudent1 = new HighStudent(UUIDUtils.getUUID(),"Pique","3",teacher1);
        HighStudent highStudent2 = new HighStudent(UUIDUtils.getUUID(),"Ramos","4",teacher2);
        List<HighStudent> list = new ArrayList<>();
        list.add(highStudent1);
        list.add(highStudent2);
        studentRepository.save(list);
    }


}
