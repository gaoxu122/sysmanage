package com.framework.security.integral.web.vo;

import lombok.Data;

import java.util.List;

/**
 * @author gaoxu
 */
@Data
public class PermissionVO {

    private String icon;
    private String index;
    private String title;
    private String label;
    private Integer id;
    private Integer parentId;
    private List<PermissionVO> children;
}
