package com.us.example.controller;

import javax.persistence.EntityGraph;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.us.example.bean.User;
import com.us.example.serviceImpl.UserServiceImpl;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.us.example.util.CommonUtil;


@Controller
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    private static Log log = LogFactory.getLog(UserController.class);


    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String addUser(HttpServletRequest request) {
        Map<String, Object> map = CommonUtil.getParameterMap(request);
        User user = new User();
        user.setName("xxxx");
        user.setCreateTime(new Date());
        userService.saveUser(user);

        JSONObject jsonObject = JSONObject.fromObject(user);
        log.info(jsonObject.toString());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String listUser(HttpServletRequest request) {
        Map<String, Object> map = CommonUtil.getParameterMap(request);
        List<User> list = userService.getAllUser();


        JSONArray ja = JSONArray.fromObject(list);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",ja);
        log.info(jsonObject.toString());

        return jsonObject.toString();
    }





}