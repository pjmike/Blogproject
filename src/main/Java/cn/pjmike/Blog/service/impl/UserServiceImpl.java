package cn.pjmike.Blog.service.impl;

import cn.pjmike.Blog.dao.UserDao;
import cn.pjmike.Blog.domain.User;
import cn.pjmike.Blog.service.UserService;
import cn.pjmike.Blog.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pjmike
 * @create 2018-02-04 17:19
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void registerUser(User user) {
        //对密码进行md5加密
        String md5Pwd = Md5Util.getMD5(user.getPassword());
        user.setPassword(md5Pwd);
        //插入用户
        userDao.addUser(user);
    }
    @Override
    public User findUserByName(String name) {
        //通过用户名查找用户
        User user = userDao.findUserByName(name);
        return user;
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User verifyUser(User user) {
        String md5pwd = Md5Util.getMD5(user.getPassword());
        User result = userDao.findUser(user.getUsername(), md5pwd);
        return result;
    }

    @Override
    public User upLoadUserIcon(Long id,String IconName) {
        userDao.updateUserIcon(id,IconName);
        return userDao.findUserById(id);
    }
}
