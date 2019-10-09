package com.framework.security.integral.web.controller.sys;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.sys.MenuMapper;
import com.framework.security.integral.core.model.sys.Menu;
import com.framework.security.integral.web.biz.sys.MenuBiz;
import org.springframework.web.bind.annotation.*;

/**
 * 对菜单进行控制
 *
 * @author gaoxu
 * @date 2019-07-11 15:51
 */

@RestController
@RequestMapping(value = "menu")
public class MenuController extends BaseController<MenuBiz, MenuMapper> {
    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    @PostMapping(value = "add_menu")
    public ObjectRestResponse insertMenu(Menu menu) {

        return baseBiz.insertMenu(menu);
    }

    @PutMapping(value = "update_menu")
    public ObjectRestResponse updateMenu(Menu menu) {

        return baseBiz.updateMenu(menu);
    }


    @DeleteMapping(value = "delete_menu")
    public ObjectRestResponse deleteMenu(Integer id) {

        return baseBiz.deleteMenu(id);
    }

    @GetMapping(value = "select_menu_tree")
    public ObjectRestResponse selectMenuTree() {

        return baseBiz.selectMenu();
    }


}
