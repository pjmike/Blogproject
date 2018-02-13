package cn.pjmike.Blog.service;

import cn.pjmike.Blog.domain.User;

/**
 * @author pjmike
 * @create 2018-02-04 17:17
 **/
public interface UserService {
    /**
     * 注册用户，注册成功返回true,失败返回false
     *
     * @param user
     * @return
     */
    void registerUser(User user);

    /**
     * 通过用户名查找用户
     *
     * @param name
     * @return
     */
    User findUserByName(String name);

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 验证用户登录
     *
     * @param user
     * @return
     */
    User verifyUser(User user);

    /**
     * 上传用户头像
     *
     * @param IconName
     * @param id
     * @return
     */
    User upLoadUserIcon(Long id, String IconName);
}
