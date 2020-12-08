package com.ql.qlsql.controller;

import com.alibaba.fastjson.JSONObject;
import com.ql.qlsql.service.JpaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/12/4 15:51
 */
@Api(value = "Jpa连接示例的控制层")
@Controller
@RequestMapping("/jpa/admin")
public class JpaController {
    @Autowired
    private JpaService jpaService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody JSONObject params){
        JSONObject res = new JSONObject();
        res.put("data", jpaService.login(params));
        return res;
    }
}
