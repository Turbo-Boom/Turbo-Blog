package kim.turbo.blog.manage.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import kim.turbo.blog.entity.sys.SysRoleMenu;

import java.util.List;

/**
 * 服务类
 *
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:42
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {


    void saveOrUpdate(Integer roleId, List<Integer> menuIdList);

    List<Integer> queryMenuIdList(Integer roleId);

    void deleteBatchByRoleId(Integer[] roleIds);

}
