package cn.pjmike.Blog.web.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author pjmike
 * @create 2018-02-08 14:56
 **/
public class JWTToken implements AuthenticationToken{
    /**
     * 密钥
     */
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
