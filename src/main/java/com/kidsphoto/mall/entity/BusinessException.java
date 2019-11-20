package com.kidsphoto.mall.entity;

import com.kidsphoto.mall.util.ExceptionUtil;
import lombok.Data;

/**
 * Created by tracywindy on 2017-1-12.
 */
@Data
public class BusinessException  extends RuntimeException{
    private  int code = -1;
    public BusinessException(int code,String message){
        super(message);
        this.code = code;
    }
    public BusinessException(String message){
        this(-1,message);
    }
    public String toString(){
        return ExceptionUtil.getExceptionInfo(this);
    }
}
