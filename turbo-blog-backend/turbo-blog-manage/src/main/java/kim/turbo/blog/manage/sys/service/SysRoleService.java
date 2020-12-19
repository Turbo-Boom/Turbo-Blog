package kim.turbo.blog.manage.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.entity.sys.SysRole;

import java.util.List;
import java.util.Map;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:43
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 批量删除
     * @param roleIds
     */
    void deleteBatch(Integer[] roleIds);

    /**
     * 查询roleId
     * @param createUserId
     * @return
     */
    List<Integer> queryRoleIdList(Integer createUserId);
}
