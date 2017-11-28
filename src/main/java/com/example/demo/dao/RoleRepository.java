package com.example.demo.dao;

import com.example.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunjian.
 */
public interface RoleRepository extends JpaRepository<Role,String>
{
}
