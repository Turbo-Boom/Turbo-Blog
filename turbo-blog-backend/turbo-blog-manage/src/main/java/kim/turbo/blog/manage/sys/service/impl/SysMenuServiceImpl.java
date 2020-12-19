package kim.turbo.blog.manage.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.turbo.blog.common.constants.SysConstants;
import kim.turbo.blog.common.enums.MenuTypeEnum;
import kim.turbo.blog.common.util.MapUtils;
import kim.turbo.blog.entity.sys.SysMenu;
import kim.turbo.blog.mapper.sys.SysMenuMapper;
import kim.turbo.blog.manage.sys.service.SysMenuService;
import kim.turbo.blog.manage.sys.service.SysRoleMenuService;
import kim.turbo.blog.manage.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author turbo
 * @email turbo-boom@outlook.com
 * @date 2020-12-19 01:45
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    /**
     * 获取用户的所有菜单
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> listUserMenu(Integer userId) {
        //系统管理员，拥有最高权限
        if(SysConstants.SUPER_ADMIN.equals(userId)){
            return getAllMenuList(null);
        }
        //用户菜单列表
        List<Integer> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    private List<SysMenu> getAllMenuList(List<Integer> menuIdList) {
        //查询用户所属所有目录
        List<SysMenu> menuList = queryListParentId(0, menuIdList);
        //递归生成特定格式的菜单列表
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }
    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<Integer> menuIdList){
        List<SysMenu> subMenuList = new ArrayList<>();

        for(SysMenu entity : menuList){
            //目录
            if(entity.getType() == MenuTypeEnum.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }

        return subMenuList;
    }

    /**
     * 根据父菜单，查询子菜单(用于鉴权)
     *
     * @param parentId   父菜单ID
     * @param menuIdList 用户菜单ID
     */
    @Override
    public List<SysMenu> queryListParentId(Integer parentId, List<Integer> menuIdList) {
        List<SysMenu> menuList = queryListParentId(parentId);
        if(menuIdList == null){
            return menuList;
        }

        List<SysMenu> userMenuList = new ArrayList<>();
        for(SysMenu menu : menuList){
            if(menuIdList.contains(menu.getMenuId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    @Override
    public List<SysMenu> queryListParentId(Integer parentId) {
        return baseMapper.queryListParentId(parentId);
    }

    /**
     * 获取不包含按钮的菜单列表
     */
    @Override
    public List<SysMenu> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

    /**
     * 获取用户菜单列表
     *
     * @param userId
     */
    @Override
    public List<SysMenu> getUserMenuList(Integer userId) {
        //系统管理员，拥有最高权限
        if(SysConstants.SUPER_ADMIN.equals(userId)){
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<Integer> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    /**
     * 删除
     *
     * @param menuId
     */
    @Override
    public void delete(Integer menuId) {
        //删除菜单
        baseMapper.deleteById(menuId);
        //删除菜单与角色关联
        sysRoleMenuService.removeByMap(new MapUtils().put("menu_id",menuId));
    }



}
