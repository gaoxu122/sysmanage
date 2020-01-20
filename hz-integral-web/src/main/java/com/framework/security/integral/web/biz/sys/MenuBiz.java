package com.framework.security.integral.web.biz.sys;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.util.TreeUtil;
import com.framework.security.integral.core.dao.sys.MenuMapper;
import com.framework.security.integral.core.model.sys.Menu;
import com.framework.security.integral.web.constant.ReturnCode;
import com.framework.security.integral.web.exception.MenuException;
import com.framework.security.integral.web.vo.MenuVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-11 15:57
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MenuBiz extends BaseBiz<MenuMapper, Menu> {

    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    public ObjectRestResponse insertMenu(Menu menu) {

        // 判断入参
        if (StringUtils.isBlank(menu.getTitle()) || StringUtils.isBlank(menu.getPath())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }

        try {
            // 插入数据
            mapper.insert(menu);
        } catch (Exception e) {
            throw new MenuException(ReturnCode.INSERT_FAILED.getMsg(), ReturnCode.INSERT_FAILED.getCode());
        }
        return ObjectRestResponse.success();
    }

    /**
     * 更新菜单
     *
     * @param menu
     * @return
     */
    public ObjectRestResponse updateMenu(Menu menu) {

        if (StringUtils.isBlank(menu.getTitle()) || StringUtils.isBlank(menu.getPath())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }
        try {
            this.updateSelectiveById(menu);
        } catch (Exception e) {
            throw new MenuException(ReturnCode.UPDATE_FAILED.getMsg(), ReturnCode.UPDATE_FAILED.getCode());
        }

        return ObjectRestResponse.success();
    }

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    public ObjectRestResponse deleteMenu(Integer id) {

        if (null == id) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }
        try {
            // 先删除本id对应的数据 ,执行逻辑删除
            mapper.deleteByPrimaryKey(id);
            // 然后删除该id下的所有节点 这个删除可以根据path来操作
            Example example = new Example(Menu.class);
            Example.Criteria criteria = example.createCriteria();
            Menu menu = mapper.selectByPrimaryKey(id);
            String parentId = "," + menu.getParentId();
            criteria.andLike("path", parentId);
            mapper.deleteByExample(example);
        } catch (Exception e) {
            throw new MenuException(ReturnCode.DELETE_FAILED.getMsg(), ReturnCode.DELETE_FAILED.getCode());
        }
        return ObjectRestResponse.success();
    }

    /**
     * 查询
     *
     * @return
     */
    public ObjectRestResponse selectMenu() {

        // 原始数据
        List<Menu> menus = this.selectListAll();
        // 转换数据
        List<MenuVO> menuVos = new ArrayList<>();
        // 返回数据
        List<MenuVO> returnMenuVos = new ArrayList<>();

        if (menus.size() > 0) {

            for (Menu menu : menus) {

                MenuVO menuVo = new MenuVO();
                menuVo.setId(menu.getId());
                menuVo.setParentId(menu.getParentId());
                menuVo.setPath(menu.getPath());
                menuVo.setMenuName(menu.getTitle());
                menuVo.setAddress(menu.getAddress());
                menuVo.setName(menu.getName());
                menuVo.setLabel(String.valueOf(menu.getTitle()));
                menuVo.setValue(String.valueOf(menu.getParentId()));
                menuVo.setGmtCreate(menu.getGmtCreate());
                menuVo.setGmtModfied(menu.getGmtModfied());
                menuVo.setIsDelete(menu.getIsDelete());
                menuVo.setIsEnable(menu.getIsEnable());
                menuVo.setIoc(menu.getIoc());
                menuVos.add(menuVo);
            }
            try {
                if (menuVos.size() > 0) {
                    returnMenuVos = TreeUtil.buildByRecursive(menuVos, 0);
                }
            } catch (Exception e) {
                throw new MenuException(ReturnCode.CREATE_TREE_FAIL.getMsg(), ReturnCode.CREATE_TREE_FAIL.getCode());
            }

        }
        return ObjectRestResponse.success(returnMenuVos);
    }

}
