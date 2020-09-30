package com.framework.security.integral.web.controller.reptile;

import com.framework.security.integral.common.controller.BaseController;
import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.core.model.video.VideoType;
import com.framework.security.integral.web.biz.movie.VideoTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxu
 */
@RestController
@RequestMapping("/video")
public class VideoController extends BaseController<VideoTypeService, VideoType> {


    @PostMapping("/sync_video_type")
    public ObjectRestResponse syncVideoType() {

        return baseBiz.insertVideoTypes();
    }

    @GetMapping("/select_all_video_type")
    public ObjectRestResponse selectAllVideoType() {

        return baseBiz.selectVideoType();
    }

    @GetMapping("/select_all_video")
    public ObjectRestResponse selectAllVideos() {

        return baseBiz.selectAllVideos();
    }
}
