package com.pcloud.sys.user.service;

import com.pcloud.sys.user.pojo.UserLogin;

/**
 * 用户登录功能的service
 * @author huotengfei
 */
public interface UserLoginService {
    /**
     * 用户登录
     * @param userLogin
     * @return
     */
    UserLogin handleLogin(UserLogin userLogin);
}
