package cn.pjmike.Blog.interceptor;

import cn.pjmike.Blog.Jwt.JwtToken;
import cn.pjmike.Blog.domain.User;
import cn.pjmike.Blog.exception.ResourceNotFoundException;
import cn.pjmike.Blog.service.UserService;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 使用拦截器对请求进行验证拦截
 *
 * @author pjmike
 * @create 2018-02-07 20:23
 **/
//@Component
public class MyInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从请求头里拿token
        String token = request.getHeader("Authorization");
        //对token进行空判断
        if (token == null) {
            throw new ResourceNotFoundException("用户未登录，请登录");
        }
        //验证token是否过期
        if (JwtToken.verifyTokenTime(token)) {
            throw new ResourceNotFoundException("token已过期，请重新登录");
        }
        //验证token的用户userid
        Map<String, Claim> map = JwtToken.verifyToken(token);
        Long userid = map.get("userid").asLong();
        User user = userService.findUserById(userid);
        //判断是否存在该用户
        if (user == null) {
            throw new ResourceNotFoundException("用户不存在");
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
