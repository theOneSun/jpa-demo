package com.example.demo.cascadeTest;

import com.example.demo.SecurityJpaApplication;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author sunjian.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityJpaApplication.class)
public class RoleAndUserTest
{
    @Resource
    private UserRepository userRepository;

    @Test
    public void testCascadeRemove()
    {
        User user = userRepository.findOne("175627");
        if (ObjectUtils.isEmpty(user))
        {
            System.out.println("无数据");
        } else
        {
            userRepository.delete(user);
        }
    }
}
