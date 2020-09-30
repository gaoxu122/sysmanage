package com.framework.security.integral.web.biz.movie;

import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.dao.video.VideoTypeMapper;
import com.framework.security.integral.core.model.video.VideoType;
import com.framework.security.integral.web.biz.movie.reptile.ReptileService;
import com.framework.security.integral.web.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xnio.IoUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 */
@Service
@Slf4j
public class VideoTypeService extends BaseBiz<VideoTypeMapper, VideoType> {

    @Autowired
    private VideoTypeMapper videoTypeMapper;

    @Autowired
    private ReptileService reptileService;

    /**
     * 批量插入视频类型
     *
     * @return
     */
    public ObjectRestResponse insertVideoTypes() {

        // 先爬取数据
        try {
            List<VideoType> videoTypes = reptileService.getTypeList();
            log.info(videoTypes.toString());
            videoTypeMapper.batchInsertVideoType(videoTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ObjectRestResponse.success();
    }

    /***
     *  查询清单
     * @return
     */
    public ObjectRestResponse selectVideoType() {

        List<VideoType> videoTypes = this.selectListAll();
        return ObjectRestResponse.success(videoTypes);
    }

    public ObjectRestResponse selectAllVideos() {

        String path = "D:\\video";
        List<Map<String, String>> maps = null;
        try {
            maps = IOUtils.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.success(maps);
    }


}
