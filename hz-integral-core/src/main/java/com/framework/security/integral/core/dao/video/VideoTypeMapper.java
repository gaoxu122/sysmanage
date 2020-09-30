package com.framework.security.integral.core.dao.video;

import com.framework.security.integral.core.model.video.VideoType;
import lombok.Value;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VideoTypeMapper extends Mapper<VideoType> {


    /**
     * 批量插入视频类型
     *
     * @param videoTypes
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    Integer batchInsertVideoType(@Param("videoTypes") List<VideoType> videoTypes);
}