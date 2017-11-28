package com.example.demo.dao;

import com.example.demo.domain.MathTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunjian.
 */
public interface MathTeacherRepository extends JpaRepository<MathTeacher,String>
{
    MathTeacher findByName(String name);
}
