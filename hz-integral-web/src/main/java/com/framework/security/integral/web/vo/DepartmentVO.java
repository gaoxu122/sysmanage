package com.framework.security.integral.web.vo;

import com.framework.security.integral.common.vo.TreeNode;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author gaoxu
 * @date 2019-10-09 17:10
 */

@Data
public class DepartmentVO extends TreeNode {

    /**
     * 级联选择的值
     */
    private String label;
    private String value;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 创建者ip
     */
    @Column(name = "creator_ip")
    private String creatorIp;


    /**
     * 深度
     */
    private String path;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 排序值
     */
    private Integer sort;


}
