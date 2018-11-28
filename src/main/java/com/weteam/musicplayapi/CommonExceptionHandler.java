package com.weteam.musicplayapi;

import com.weteam.musicplayapi.constant.Constants;
import com.weteam.musicplayapi.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {

    @ResponseBody
    @ExceptionHandler(CommonException.class)
    public Result commonExceptionHandler(CommonException ex) {

        Result result = new Result();
        result.setErrorCode(Constants.FAIL);
        result.setErrorMsg(ex.getMessage());
        return result;
    }
}
