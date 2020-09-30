package com.framework.security.integral.web.vo;


import lombok.Data;

import java.util.List;

@Data
public class AuthVO {

    private List<KeyValue> keyValueList;
    private List<String> keys;
}
