package com.framework.security.integral.web.biz.movie.reptile;

import lombok.Data;

/**
 * @author gaoxu
 */
@Data
public class Movie {

    private String name;
    private Integer code;
    private String ImgUrl;
    private float score;
    private String director;
    private String actor;
    private String synopsis;
    private String movieUrl;
    private String date;
    private String downloadUrl;

}
