package kim.turbo.blog.auth.service;

import kim.turbo.blog.entity.sys.SysUser;
import kim.turbo.blog.entity.sys.SysUserToken;

import java.util.Set;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:52
 */
public interface ShiroService {

    /**
     * 获取用户的所有权限
     * @param userId
     * @return
     */
    Set<String> getUserPermissions(Integer userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    SysUser queryUser(Integer userId);

    /**
     * 续期
     * @param userId
     * @param accessToken
     */
    void refreshToken(Integer userId, String accessToken);
}
