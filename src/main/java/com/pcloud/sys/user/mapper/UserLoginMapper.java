package com.pcloud.sys.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pcloud.sys.user.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户登录的mapper
 * @author huotengfei
 */
@Mapper
@Repository
public interface UserLoginMapper extends BaseMapper<UserLogin> {

}
