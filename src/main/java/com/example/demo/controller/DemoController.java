package com.example.demo.controller;

import com.example.demo.dao.HighStudentRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.HighStudent;
import com.example.demo.domain.Person;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author sunjian.
 */
@RestController
@Slf4j
public class DemoController
{

    @Resource
    private PersonRepository personRepository;

    @Resource
    private HighStudentRepository highStudentRepository;

    @RequestMapping("nameAddress")
    public Person getPersonByNameAndAddress(String name, String address){
        return personRepository.findByNameAndAddress(name, address);
    }

    @RequestMapping("address")
    public List<Person> getByAddress(String address){
        return personRepository.findByAddress(address);
    }

    @RequestMapping("add/high")
    public HighStudent saveHighStudent(String name,String researchSupervisor){
        HighStudent highStudent = new HighStudent(UUID.randomUUID()
                                                      .toString()
                                                      .replaceAll("-", ""), name, "001", null);
        return highStudentRepository.save(highStudent);
    }

    @Autowired
    private UserRepository userRepository;
    @GetMapping("updateTest")
    @Transactional
    public int updateTest(){
        final User user = new User();
        user.setName("更新");
        user.setUserCode("hehe");
        final int i = userRepository.updateByCode(user);
        log.info("更新的数据量:"+i);
        return i;
    }
}
