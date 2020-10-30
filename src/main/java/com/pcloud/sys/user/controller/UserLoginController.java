package com.pcloud.sys.user.controller;

import com.pcloud.sys.common.core.base.BaseController;
import com.pcloud.sys.common.util.Results;
import com.pcloud.sys.user.pojo.UserLogin;
import com.pcloud.sys.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户登录相关 API
 * @author huotengfei
 */
@RestController
public class UserLoginController extends BaseController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/login")
    public ResponseEntity handleLogin(@RequestBody UserLogin userLogin, HttpSession session){
        UserLogin result = userLoginService.handleLogin(userLogin);

        session.setAttribute("login", result);
        // 设置session失效时间为30分钟
        session.setMaxInactiveInterval(60*30);
        return Results.success(result);
    }
}
