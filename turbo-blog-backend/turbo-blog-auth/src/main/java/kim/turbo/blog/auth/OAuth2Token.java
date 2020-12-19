package kim.turbo.blog.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Shiro 认证类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:48
 */

public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
