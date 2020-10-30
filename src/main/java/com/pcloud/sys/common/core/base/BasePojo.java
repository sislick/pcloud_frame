package com.pcloud.sys.common.core.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 基础实体类，包含共有字段及审计字段
 * @author huotengfei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePojo {

    /** 是否逻辑删除 */
    protected Integer isDeleted;

    /** 乐观锁 */
    protected Integer revision;

    /** 创建人id */
    protected String createdBy;

    /** 创建时间 */
    protected Date createdTime;

    /** 更新人id */
    protected String updatedBy;

    /** 更新时间 */
    protected Date updatedTime;
}
