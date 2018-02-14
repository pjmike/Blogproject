package cn.pjmike.Blog.controller;

import cn.pjmike.Blog.Jwt.JwtToken;
import cn.pjmike.Blog.domain.User;
import cn.pjmike.Blog.exception.NullException;
import cn.pjmike.Blog.exception.ResourceNotFoundException;
import cn.pjmike.Blog.service.UserService;
import cn.pjmike.Blog.util.ResponseResult;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author pjmike
 * @create 2018-02-04 17:20
 **/
@RestController
@Api(value = "LoginController", description = "登录注册API")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "注册", notes = "注册用户",
            httpMethod = "POST", response = ResponseResult.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @PostMapping(value = "/signup")
    public ResponseResult<Object> signup(@RequestBody User user) {

        ResponseResult<Object> responseResult = new ResponseResult<Object>();
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new NullException("输入的用户名或者密码为空");
        }
        if (userService.findUserByName(user.getUsername()) != null) {
            throw new ResourceNotFoundException("该用户名已存在");
        }
        //注册用户
        userService.registerUser(user);
        responseResult.setMsg("注册成功");
        responseResult.setStatus(0);
        return responseResult;
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "登录", notes = "登录用户",
            httpMethod = "POST", response = ResponseResult.class, produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @PostMapping(value = "/signin")
    public ResponseResult<Object> signin(@RequestBody User user, HttpServletResponse response) throws UnsupportedEncodingException {
        ResponseResult<Object> result = new ResponseResult<Object>();
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new NullException("输入的用户名或者密码为空");
        }
        //验证用户信息
        User resultUser = userService.verifyUser(user);
        if (resultUser == null) {
            throw new ResourceNotFoundException("用户名或密码错误");
        }
        //获取token
        String token = JwtToken.createToken(resultUser.getId());
        //将token设置在头信息里
        response.addHeader("Authorization", token);
        result.setStatus(0);
        result.setMsg("登录成功");
        return result;
    }
}
