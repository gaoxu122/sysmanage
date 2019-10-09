/*
package com.huizhiframework.security.integral.common.util;

import com.huizhiframework.security.integral.common.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;


*/
/**
*EntityUtils
 *
*实体类相关工具类
 *解决问题： 1、快速对实体的常驻字段，如：crtUser、crtHost、updUser等值快速注入
 *
*@author jianghx
*@create 2018/8/22 9:56
**//*

@Slf4j
public class EntityUtils {

	*/
/**
	 *快速将bean的crtUser、crtHost、crtTime、updUser、updHost、updTime附上相关值
	 *
	 *@param
	 *@return
	 *//*

	public static <T> void setCreatAndUpdatInfo(T entity) {
		setCreateInfo(entity);
		setUpdatedInfo(entity);
	}

	*/
/**
	 *快速将bean的crtUser、crtHost、crtTime附上相关值
	 *
	 *@param
	 *@return
	 *//*

	public static <T> void setCreateInfo(T entity){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		if(request!=null) {
			hostIp = StringUtils.defaultIfBlank(request.getHeader("userHost"), ClientUtil.getClientIp(request));
			name = StringUtils.trimToEmpty(request.getHeader("userName"));
			id = StringUtils.trimToEmpty(request.getHeader("userId"));
			try {
				name = URLDecoder.decode(name,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.info("解码错误");
				e.printStackTrace();
			}

		}

		if (StringUtils.isBlank(name)) {
			name = BaseContextHandler.getUserName();
		}
		if (StringUtils.isBlank(id)) {
			id = BaseContextHandler.getUserID();
		}

		// 默认属性
		String[] fields = {"crtName","crtUser","crtHost","crtTime"};
		Field field = ReflectionUtils.getAccessibleField(entity, "crtTime");
		// 默认值
		Object [] value = null;
		if(field!=null&&field.getType().equals(Date.class)){
			value = new Object []{name,id,hostIp,new Date()};
		}
		// 填充默认属性值
		setDefaultValues(entity, fields, value);
	}

	*/
/**
	 *快速将bean的updUser、updHost、updTime附上相关值
	 *
	 *@param
	 *@return
	 *//*

	public static <T> void setUpdatedInfo(T entity) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		if(request!=null) {
			hostIp = StringUtils.defaultIfBlank(request.getHeader("userHost"), ClientUtil.getClientIp(request));
			name = StringUtils.trimToEmpty(request.getHeader("userName"));
			try {
				name = URLDecoder.decode(name,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.info("解码错误");
				e.printStackTrace();
			}
			id = StringUtils.trimToEmpty(request.getHeader("userId"));
		}

		if (StringUtils.isBlank(name)) {
			name = BaseContextHandler.getUserName();
		}
		if (StringUtils.isBlank(id)) {
			id = BaseContextHandler.getUserID();
		}

		// 默认属性
		String[] fields = {"updName","updUser","updHost","updTime"};
		Field field = ReflectionUtils.getAccessibleField(entity, "updTime");
		Object [] value = null;
		if(field!=null&&field.getType().equals(Date.class)){
			value = new Object []{name,id,hostIp,new Date()};
		}
		// 填充默认属性值
		setDefaultValues(entity, fields, value);
	}
	*/
/**
	*EntityUtils
	 *
	*依据对象的属性数组和值数组对对象的属性进行赋值
	 *
	*@author jianghx
	*@create 2018/8/22 9:57
	**//*

	private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
		for(int i=0;i<fields.length;i++){
			String field = fields[i];
			if(ReflectionUtils.hasField(entity, field)){
				ReflectionUtils.invokeSetter(entity, field, value[i]);
			}
		}
	}
	*/
/**
	*EntityUtils
	 *
	*根据主键属性，判断主键是否值为空
	 *
	*@author jianghx
	*@create 2018/8/22 9:56
	**//*

	public static <T> boolean isPKNotNull(T entity,String field){
		if(!ReflectionUtils.hasField(entity, field)) {
			return false;
		}
		Object value = ReflectionUtils.getFieldValue(entity, field);
		return value!=null&&!"".equals(value);
	}
}
*/
