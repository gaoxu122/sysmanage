package com.framework.security.integral.web.util;


import org.springframework.beans.BeanUtils;


/**
 * DTO转换DO，DO转换DTO
 *
 * @author gaoxu
 */

public class MiteBeanUtils<DT, E> {

    /**
     * dot 转换为Do 工具类
     *
     * @param dtoEntity
     * @param doClass
     * @return
     */
    public static <E> E dtoToE(Object dtoEntity, Class<E> doClass) {
        // 判断dto是否为空!
        if (dtoEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (doClass == null) {
            return null;
        }
        try {
            E newInstance = doClass.newInstance();
            BeanUtils.copyProperties(dtoEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * do 转换为Dto 工具类
     *
     * @param doEntity
     * @param dtoClass
     * @return
     */
    public static <DT> DT doToDto(Object doEntity, Class<DT> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            DT newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }
    // 后面集合类型带封装
}
