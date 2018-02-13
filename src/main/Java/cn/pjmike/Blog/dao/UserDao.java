package cn.pjmike.Blog.dao;

import cn.pjmike.Blog.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author pjmike
 * @create 2018-02-04 11:19
 **/
public interface UserDao {
    /**
     * 通过用户名查找用户
     *
     * @param username
     * @return
     */
    User findUserByName(String username);

    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 通过密码和用户名来查询
     *
     * @param username
     * @param password
     * @return
     */
    User findUser(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 上传用户头像
     *
     * @param IconName
     * @return
     */
    int updateUserIcon(@Param("id")Long id, @Param("IconName") String IconName);

}
