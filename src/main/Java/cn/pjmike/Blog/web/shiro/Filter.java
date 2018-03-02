package cn.pjmike.Blog.web.shiro;

import cn.pjmike.Blog.exception.ResourceNotFoundException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 使用shiro进行验证
 *
 * @author pjmike
 * @create 2018-02-08 15:23
 **/
public class Filter extends BasicHttpAuthenticationFilter{
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //获取Authorization字段
        String authorization = httpServletRequest.getHeader("Authorization");
        if (authorization != null) {
            JWTToken token = new JWTToken(authorization);
            getSubject(request,response).login(token);
            return true;
        } else {
            throw new ResourceNotFoundException("未授权");
        }
    }
}
