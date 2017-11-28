package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunjian.
 */
public interface UserRepository extends JpaRepository<User,String>
{
}
