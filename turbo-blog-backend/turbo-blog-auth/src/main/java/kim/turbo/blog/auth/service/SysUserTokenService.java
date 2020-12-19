package kim.turbo.blog.auth.service;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.entity.sys.SysUserToken;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:54
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     * @param userId
     * @return
     */
    Result createToken(Integer userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 退出登录
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}

