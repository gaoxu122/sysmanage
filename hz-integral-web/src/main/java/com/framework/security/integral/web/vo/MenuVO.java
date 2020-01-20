package com.framework.security.integral.web.vo;

import com.framework.security.integral.common.vo.TreeNode;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author gaoxu
 * @date 2019-07-11 16:32
 */
@Data
public class MenuVO extends TreeNode {

    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 深度
     */
    private String path;
    /**
     * 级联选择器的key
     */
    private String value;
    /**
     * 级联选择的值
     */
    private String label;

//    /**
//     * 菜单id
//     */
//    @Id
//    private Integer id;


//    /**
//     * 父id
//     */
//    @Column(name = "parent_id")
//    private Integer parentId;


    /**
     * 索引
     */
    private String name;

    /**
     * 图标
     */
    private String ioc;

    /**
     * 地址(vue地址)
     */
    private String address;

    /**
     * 是否删除（0：否 1：是）
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 是否启用 （0：否 1：是）
     */
    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modfied")
    private Date gmtModfied;
}
