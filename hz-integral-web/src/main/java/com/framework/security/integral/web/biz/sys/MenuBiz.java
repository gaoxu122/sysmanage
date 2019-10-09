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
        if (StringUtils.isBlank(menu.getName()) || StringUtils.isBlank(menu.getPath())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }

        try {
            // 插入数据
            this.insert(menu);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MenuException(ReturnCode.INSERT_FAILED.getMsg(), ReturnCode.INSERT_FAILED.getCode());
        }
        return ObjectRestResponse.success();
    }

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    public ObjectRestResponse updateMenu(Menu menu) {

        if (StringUtils.isBlank(menu.getName()) || StringUtils.isBlank(menu.getPath())) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }
        try {
            this.insertSelective(menu);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MenuException(ReturnCode.UPDATE_FAILED.getMsg(), ReturnCode.UPDATE_FAILED.getCode());
        }

        return ObjectRestResponse.success();
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    public ObjectRestResponse deleteMenu(Integer id) {

        if (null == id) {
            return ObjectRestResponse.failure(ReturnCode.PARAMETER_INCOMING_ERROR.getCode(), ReturnCode.PARAMETER_INCOMING_ERROR.getMsg());
        }

        try {
            // 先删除本id对应的数据
            this.mapper.deleteByPrimaryKey(id);
            // 然后删除该id下的所有节点 这个删除可以根据path来操作


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 查询
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
                menuVo.setMenuName(menu.getName());
                menuVo.setAddress(menu.getAddress());
                menuVo.setLabel(String.valueOf(menu.getName()));
                menuVo.setValue(String.valueOf(menu.getParentId()));
                menuVo.setGmtCreate(menu.getGmtCreate());
                menuVo.setGmtModfied(menu.getGmtModfied());
                menuVo.setDelect(menu.getIsDelete());
                menuVo.setEnable(menu.getIsEnable());
                menuVo.setIoc(menu.getIoc());
                menuVos.add(menuVo);
            }

            if (menuVos.size() > 0) {
                returnMenuVos = TreeUtil.buildByRecursive(menuVos, 0);
            }

        }


        return ObjectRestResponse.success(returnMenuVos);
    }

}
