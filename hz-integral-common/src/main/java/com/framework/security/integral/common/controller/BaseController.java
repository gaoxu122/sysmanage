package com.framework.security.integral.common.controller;


import com.framework.security.integral.common.msg.ObjectRestResponse;
import com.framework.security.integral.common.biz.BaseBiz;
import com.framework.security.integral.common.util.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * BaseController
 *
 * 公共基础控制类
 *
 * @author jianghx
 * @create 2018/8/20 14:17
 **/
@Slf4j
public class BaseController<Biz extends BaseBiz, Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

    /**
     *保存
     *
     *@param
     *@return
     */
    //ToDo 外部调用该方法时候会报 Method Not Allowed
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity) throws UnsupportedEncodingException {
        baseBiz.insertSelective(entity);
        return ObjectRestResponse.genJsonResultByOk();
    }

     /**
      *查询对象
      *
      *@param
      *@return
      */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse <Entity> get(@PathVariable int id) {
        ObjectRestResponse <Entity> entityObjectRestResponse = new ObjectRestResponse <>();
        Object o = baseBiz.selectById(id);
        return ObjectRestResponse.genJsonResultByOk(o);
    }

    /**
     * 编辑方法
     * @param entity
     * @return
     * @throws UnsupportedEncodingException
     */
    //ToDo 外部调用该方法时候会报 Method Not Allowed
    @Deprecated
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse <Entity> update(@RequestBody Entity entity) throws UnsupportedEncodingException {
        baseBiz.updateSelectiveById(entity);
        return ObjectRestResponse.genJsonResultByOk();
    }

    /**
     *删除
     *
     *@param
     *@return
     */

    //Todo  此方法智能删除int类型数据，调用baseBiz.deleteById(id);删除数据时候，
    //Todo 主键是什么类型传入参数是什么类型，比如主键是long传入参数为long 不然要报类型转换异常
    @Deprecated
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse <Entity> delete(@PathVariable int id) {
        baseBiz.deleteById(id);

        return ObjectRestResponse.genJsonResultByOk();
    }

    /**
     *不分页
     *
     *@param
     *@return  entityObjectRestResponse
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse <List <Entity>> list() {
        ObjectRestResponse <List <Entity>> entityObjectRestResponse = new ObjectRestResponse <List <Entity>>();
        return ObjectRestResponse.genJsonResultByOk(baseBiz.selectListAll());
    }

    /**
     *分页查询
     *
     *@param  params
     *@return  TableResultResponse <Entity>
     */
    @RequestMapping(value = "/list_page", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse listPage(@RequestParam Map <String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        return baseBiz.selectByQuery(query);
    }

}
