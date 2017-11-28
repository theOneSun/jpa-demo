package com.example.demo.dao;

import com.example.demo.domain.HighStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author sunjian.
 */
public interface HighStudentRepository extends JpaRepository<HighStudent,String>
{
    @Modifying
    @Transactional
    @Query("UPDATE HighStudent SET math_teacher_id = NULL WHERE math_teacher_id = ?1")
    int setMathTeacherIdNull(String teacherId);

    List<HighStudent> findByName(String name);
}
