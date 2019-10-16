package com.example.demo.speedcompare;

import com.example.demo.SecurityJpaApplication;
import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author sunjian.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SecurityJpaApplication.class)
public class InsertSpeedComPare {

    @Autowired
    private UserRepository userRepository;

    private int size = 10000;

    @Test
    @Transactional
    public void testUpdate(){
        final User user = new User();
        user.setName("更新");
        user.setUserCode("oooo");
//        userRepository.updateByCode(user.getName(),user.getUserCode());
        final int i = userRepository.updateByCode(user);
        System.out.println("更新的数据量:"+i);
    }

    /*@Test
    public void compare() {
        for (int i = 0; i < size; i++) {
            final User user = new User();
            user.setId(UUID.randomUUID()
                           .toString());
            user.setName("test" + i);
            user.setCode(String.valueOf(i));
        }
        final List<User> userList = tempUser();
        userRepository.save(userList);
    }

    private List<User> tempUser() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final User user = new User();
            user.setName("temp" + i);
            user.setCode(String.valueOf(i));
            userList.add(user);
        }
        return userList;
    }*/

}
