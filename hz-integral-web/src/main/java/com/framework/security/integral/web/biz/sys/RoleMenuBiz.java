package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.exception.BaseException;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.sys.MenuMapper;
import com.framework.security.integral.core.dao.sys.RoleMenuMapper;
import com.framework.security.integral.core.model.sys.Menu;
import com.framework.security.integral.core.model.sys.RoleMenu;
import com.framework.security.integral.core.vo.RoleMenuVO;
import com.framework.security.integral.core.vo.RoleUserVO;
import com.framework.security.integral.web.vo.MenuVO;
import com.framework.security.integral.web.vo.PermissionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author gaoxu
 */
@Service
@Slf4j
public class RoleMenuBiz extends BaseBiz<RoleMenuMapper, RoleMenu> {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleUserBiz roleUserBiz;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private MenuBiz menuBiz;

    /**
     * 查询未赋权菜单 展示树形
     *
     * @return
     */
    public ObjectRestResponse selectNoPermissionMenu() {

        List<Menu> menus = menuMapper.selectAll();
        List<MenuVO> menuVOS = menuBiz.buildTree(menus);
        return ObjectRestResponse.success(menuVOS);
    }

    /**
     * 查询已赋权菜单
     *
     * @return
     */
    public ObjectRestResponse selectPermissionMenu(Integer id) {

        // 查询该角色已赋权的菜单
        List<PermissionVO> menusByRole = getMenusByRole(id);

        return ObjectRestResponse.success(menusByRole);
    }

    /**
     * 赋权
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ObjectRestResponse insertPermission(Integer id, String menus) {

        log.info("菜单赋权的角色id：{} ； 赋权的菜单id：{}", id, menus);
        // 赋权 无需判空处理
        // 首先删除该角色下的所有菜单权限
        String[] split = menus.split(",");
        Example example = new Example(RoleMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", id);
        criteria.andIn("menuId", Arrays.asList(split));
        roleMenuMapper.deleteByExample(example);
        // 然后重新添加 批量添加

        List<RoleMenu> roleMenus = new ArrayList<>();
        for (String s : split) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(id);
            roleMenu.setMenuId(Integer.valueOf(s));
            roleMenus.add(roleMenu);
        }
        Integer integer = roleMenuMapper.batchInsertRoleMenu(roleMenus);
        return ObjectRestResponse.success();
    }


    public List<PermissionVO> selectMenusByRoleId(String userName) {

        RoleUserVO roleUserVO = roleUserBiz.selectRoleByUserName(userName);
        List<PermissionVO> menusByRole = getMenusByRole(roleUserVO.getRoleId());
        return menusByRole;
    }

    /**
     * 根据角色id 获得已赋权菜单
     *
     * @param id
     * @return
     */
    public List<PermissionVO> getMenusByRole(Integer id) {

        List<RoleMenuVO> menusByRole = mapper.getMenusByRole(id);
        log.info("{}", menusByRole.toString());
        List<Integer> collect = Optional.ofNullable(menusByRole).orElse(null).stream()
                .map(RoleMenuVO::getMenuId).collect(Collectors.toList());

        if (collect == null || collect.size() <= 0) {
            return null;
        }

        // 根据菜单集合查询数据
        Example example = new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", collect);
        List<Menu> menus = menuMapper.selectByExample(example);

        List<PermissionVO> permissions = getPermissions(menus);
        List<PermissionVO> resultList = setPermissions(permissions, 0);
        return resultList;
    }

    /**
     * 转换菜单
     *
     * @param menus
     * @return
     */
    private List<PermissionVO> getPermissions(List<Menu> menus) {
        List<PermissionVO> permissionVOS = new ArrayList<>();
        Optional.ofNullable(menus).orElse(null).forEach(menu -> {
            PermissionVO permissionVO = new PermissionVO();
            permissionVO.setId(menu.getId());
            permissionVO.setParentId(menu.getParentId());
            permissionVO.setTitle(menu.getTitle());
            permissionVO.setLabel(menu.getTitle());
            permissionVO.setIndex(menu.getName());
            permissionVO.setIcon(menu.getIoc());
            permissionVOS.add(permissionVO);
        });
        return permissionVOS;
    }

    /**
     * 生成树型
     *
     * @param permissionVOS
     * @param root
     * @return
     */
    public List<PermissionVO> setPermissions(List<PermissionVO> permissionVOS, Object root) {

        List<PermissionVO> trees = new ArrayList<PermissionVO>();

        for (PermissionVO permissionVO : permissionVOS) {

            if (root.equals(permissionVO.getParentId())) {
                trees.add(permissionVO);
            }
            List<PermissionVO> result = new ArrayList<>();
            for (PermissionVO it : permissionVOS) {

                if (it.getParentId().equals(permissionVO.getId())) {

                    result.add(it);
                    permissionVO.setChildren(result);
                }
            }
        }
        return trees;
    }
}
