package com.ql.qlsql.controller;

import com.alibaba.fastjson.JSONObject;
import com.ql.qlsql.service.MybatisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:  mybatis测试
 */
@Controller
@RequestMapping("/mybatis/user")
@Api(value = "Mybatis连接示例的控制层")
public class MybatisController {
    @Autowired
    private MybatisService mybatisService;

    @ApiOperation(value = "实现用户登录")
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody JSONObject params){
        JSONObject res = new JSONObject();
        res.put("data", mybatisService.login(params));
        return res;
    }
}
