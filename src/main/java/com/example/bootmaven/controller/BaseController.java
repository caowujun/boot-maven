package com.example.bootmaven.controller;

import com.example.bootmaven.tools.response.IErrorCode;
import com.example.bootmaven.tools.response.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author robin
 * @date 2022年06月21日 16:39
 */
public class BaseController {



    public BaseController() {
    }

    protected <T> R<T> success(T data) {
        return R.ok(data);
    }

    protected <T> R<T> failed(String msg) {
        return R.failed(msg);
    }

    protected <T> R<T> failed(IErrorCode errorCode) {
        return R.failed(errorCode);
    }


}