package com.pcloud;

import com.pcloud.sys.user.mapper.UserLoginMapper;
import com.pcloud.sys.user.pojo.UserLogin;
import com.pcloud.sys.user.service.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * springboot测试类
 * @author huotengfei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PCloudFrameRunTest {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private UserLoginService userLoginService;

    /**
     * 测试登录service
     */
    @Test
    public void testLogin(){
        UserLogin userLogin = this.userLoginService.handleLogin(new UserLogin() {{
            setUserName("1");
            setPassword("123");
        }});
    }

    /**
     * 测试新增数据到sys_login表中
     */
    @Test
    public void testInsertUserLogin(){
        UserLogin userLogin = new UserLogin(){{
            setLoginName("a");
            setPassword("123456");
            setPhone("13630238697");
            setSalt("123");
            setUserName("a");
        }};
        this.userLoginMapper.insert(userLogin);

        System.out.println("userLogin==>" + userLogin);
    }

    /**
     * 测试查询sys_login表中的所有数据
     */
    @Test
    public void testGetAll() {
        List<UserLogin> list = this.userLoginMapper.selectList(null);
        for (UserLogin obj : list) {
            System.out.println("obj==>" + obj);
        }
    }
}
