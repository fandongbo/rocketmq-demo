package com.example.demo;

import java.io.Serializable;

/**
 * Created By fandongbo on 2019-12-24
 */
public interface ErrorCode extends Serializable {

    /**
     * 错误码
     *
     * @return
     */
    String getCode();

    /**
     * 错误信息
     *
     * @return
     */
    String getMsg();
}
