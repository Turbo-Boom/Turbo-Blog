package kim.turbo.blog.auth.service;

import java.awt.image.BufferedImage;

/**
 * 验证码类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 02:46
 */


public interface SysCaptchaService {

    /**
     * 获取验证码
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证验证码
     * @param uuid
     * @param code
     * @return
     */
    boolean validate(String uuid, String code);
}

