package com.example.demo.controller;

import com.example.demo.dao.HighStudentRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.HighStudent;
import com.example.demo.domain.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author sunjian.
 */
@RestController
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
}
