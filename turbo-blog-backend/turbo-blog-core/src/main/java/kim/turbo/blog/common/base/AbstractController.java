package kim.turbo.blog.common.base;

import kim.turbo.blog.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 *
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020/12/19 1:01 上午
 * @version v1.0.0
 */
public class AbstractController {

    protected SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId(){
        return getUser().getUserId();
    }
}
