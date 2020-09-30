package com.framework.security.integral.web.vo;


import lombok.Data;

/**
 * @author gaoxu
 */

@Data
public class KeyValue {

    private String key;
    private String label;
    private Boolean disabled = true;


    public KeyValue(String key, String label, Boolean disabled) {

        this.key = key;
        this.label = label;
        this.disabled = disabled;
    }

    public KeyValue(String key, String label) {

        this.key = key;
        this.label = label;
    }
}
