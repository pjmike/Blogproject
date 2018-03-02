package cn.pjmike.Blog.web.shiro;

import cn.pjmike.Blog.web.Jwt.JwtToken;
import cn.pjmike.Blog.exception.ResourceNotFoundException;
import cn.pjmike.Blog.service.UserService;
import com.auth0.jwt.interfaces.Claim;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 自定义Realm
 *
 * @author pjmike
 * @create 2018-02-08 15:06
 **/
@Component
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    /**
     * 必须重写该方法，不然shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 检测用户的权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 验证用户的身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取token
        String token = (String) authenticationToken.getCredentials();
        if (token == null) {
            throw new ResourceNotFoundException("您还没有登录");
        }
        Map<String, Claim> map = null;
        try {
            map = JwtToken.verifyToken(token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //拿用户的id
        Long userid = map.get("userid").asLong();
        if (userid == null) {
            throw new ResourceNotFoundException("失败");
        }
        if (userService.findUserById(userid) == null) {
            throw new ResourceNotFoundException("没有该用户");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
