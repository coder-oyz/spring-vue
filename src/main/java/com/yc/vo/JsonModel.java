package com.yc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: JsonModel
 * @Author: coder-oyz
 * @Date: 2021/5/4 20:54
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class JsonModel implements Serializable {
    private Integer code;
    private String msg;
    private Object obj;
    private String url;




}

