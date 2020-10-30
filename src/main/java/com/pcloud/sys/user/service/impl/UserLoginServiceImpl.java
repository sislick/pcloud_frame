package com.pcloud.sys.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pcloud.sys.common.core.exception.CommonException;
import com.pcloud.sys.user.mapper.UserLoginMapper;
import com.pcloud.sys.user.pojo.UserLogin;
import com.pcloud.sys.user.service.UserLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用户登录service
 * @author huotengfei
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    /**
     * 用户登录功能（用户名和密码登录）
     * @param userLogin
     * @return
     */
    @Override
    public UserLogin handleLogin(UserLogin userLogin) {
        QueryWrapper<UserLogin> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name", userLogin.getLoginName());
        UserLogin result = userLoginMapper.selectOne(wrapper);
        if(result == null){
            throw new CommonException("该用户名未注册，请核实后登录");
        }

        String password = userLogin.getPassword();// 明文密码
        String slat = result.getSalt();
        String mD5Password = mD5Password(password, slat);
        wrapper.eq("password", mD5Password);
        result = userLoginMapper.selectOne(wrapper);
        if(result == null){
            throw new CommonException("密码错误，请核实后登录");
        }

        return result;
    }

    /**
     * 自定义md5加密算法
     * @param password 用户输入的明文密码
     * @param salt 盐值
     * @return md5加密后的密文密码
     */
    private String mD5Password(String password, String salt){
        String str = password.concat(salt);
        String md5Password = DigestUtils.md5DigestAsHex(str.getBytes());
        str = md5Password.concat(salt);
        md5Password = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5Password;
    }
}
