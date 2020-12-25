package kim.turbo.blog.manage.sys.controller;

import kim.turbo.blog.common.Result;
import kim.turbo.blog.common.base.AbstractController;
import kim.turbo.blog.common.constants.SysConstants;
import kim.turbo.blog.common.util.PageUtils;
import kim.turbo.blog.common.validator.ValidatorUtils;
import kim.turbo.blog.entity.sys.SysRole;
import kim.turbo.blog.manage.sys.service.SysRoleMenuService;
import kim.turbo.blog.manage.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:36
 */
@RestController
@RequestMapping("/admin/sys/role")
public class SysRoleController extends AbstractController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 分页查询角色列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public Result list(@RequestParam Map<String, Object> params){
        //如果不是超级管理员，则只查询自己创建的角色列表
        if(!SysConstants.SUPER_ADMIN.equals(getUserId())){
            params.put("createUserId", getUserId());
        }

        PageUtils page = sysRoleService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 角色列表
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:role:select")
    public Result select(){
        Map<String, Object> map = new HashMap<>();

        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if(!SysConstants.SUPER_ADMIN.equals(getUserId())){
            map.put("createUserId", getUserId());
        }
        Collection<SysRole> list = sysRoleService.listByMap(map);
        return Result.ok().put("list", list);
    }

    /**
     * 保存角色信息
     * @param role
     * @return
     */
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public Result save(@RequestBody SysRole role){
        ValidatorUtils.validateEntity(role);

        role.setCreateUserId(getUserId());
        sysRoleService.save(role);

        return Result.ok();
    }

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    @PutMapping("/update")
    @RequiresPermissions("sys:role:update")
    public Result update(@RequestBody SysRole role){
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(getUserId());

        sysRoleService.updateById(role);

        return Result.ok();
    }

    /**
     * 获取角色信息
     * @param roleId
     * @return
     */
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public Result info(@PathVariable Integer roleId){
        SysRole role = sysRoleService.getById(roleId);
        List<Integer> menuIdList=sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);
        return Result.ok().put("role",role);
    }

    /**
     * 删除角色信息
     * @param roleIds
     * @return
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public Result delete(@RequestBody Integer[] roleIds){
        sysRoleService.deleteBatch(roleIds);

        return Result.ok();
    }
}
