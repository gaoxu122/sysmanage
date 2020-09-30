package com.framework.security.integral.core.model.video;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author gaoxu
 */
@Table(name = "video_type")
@Data
public class VideoType {
    @Id
    private Integer id;

    /**
     * 类型代码
     */
    private Integer code;

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
     * 类型名称
     */
    private String name;

    /**
     * 路径
     */
    private String url;

    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 上级id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 路径
     */
    private String path;


}