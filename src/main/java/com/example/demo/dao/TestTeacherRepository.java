package com.example.demo.dao;

import com.example.demo.domain.MathTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by sj on 2017/11/29.
 */
public interface TestTeacherRepository extends JpaRepository<MathTeacher, String>, JpaSpecificationExecutor<MathTeacher> {
}
