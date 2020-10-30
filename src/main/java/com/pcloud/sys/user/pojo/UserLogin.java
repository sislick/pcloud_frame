package com.pcloud.sys.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pcloud.sys.common.core.base.BasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录实体类
 * @author huotengfei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_login")
public class UserLogin extends BasePojo {
    /** 主键 */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /** 用户登录账号 */
    private String loginName;

    /** 手机号码 */
    private String phone;

    /** 用户姓名 */
    private String userName;

    /** 登录密码 */
    @TableField(select = false) // 设置不查询此字段
    private String password;

    /** 生成密码的盐值 */
    @TableField(select = false)
    private String salt;
}
