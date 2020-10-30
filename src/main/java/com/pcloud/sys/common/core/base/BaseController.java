package com.pcloud.sys.common.core.base;

import com.pcloud.sys.common.core.exception.CommonException;
import com.pcloud.sys.common.util.Results;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础controller类，用于捕捉处理公共异常
 */
public abstract class BaseController {

    //处理异常的注解
    @ExceptionHandler(CommonException.class)
    //响应一个json对象
    @ResponseBody
    public ResponseEntity handleException(Exception e){
        return Results.error(e.getMessage());
    }
}
