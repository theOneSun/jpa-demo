package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author sunjian.
 */
public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
//    @Query(value = "update User u set u.name = :username where u.userCode = :userCode")
//    void updateByCode(@Param("username") String username,@Param("userCode")String userCode);
    @Query(value = "update User u set u.name = :#{#user.name} where u.userCode = :#{#user.userCode}")
    int updateByCode(@Param("user") User user);
}
