package cn.pjmike.Blog.service;

import cn.pjmike.Blog.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void registerUser() throws Exception {
        User user = new User();
        user.setUsername("pjmike");
        user.setPassword("123456");
        userService.registerUser(user);
        Assert.assertNotNull(userService.findUserByName(user.getUsername()));
    }

    @Test
    public void findUserByName() throws Exception {
    }

    @Test
    public void verifyUser() throws Exception {
        User user = new User();
        user.setUsername("pjmike");
        user.setPassword("123456");
        System.out.println(userService.verifyUser(user));
    }

}