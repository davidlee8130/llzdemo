package com.llz.controller.vo;


import com.llz.common.enums.ResultCodeEnum;
import lombok.Data;

/**
 * 返回VO
 */
@Data
public class ResultVO<T> {

    private String code;

    private String msg;

    private T data;

    public static <T>ResultVO<T> success(String msg){
        ResultVO<T> resultVO = new ResultVO<T>();
        resultVO.code = ResultCodeEnum.SUCCESS.getCode();
        resultVO.msg = msg;
        return resultVO;
    }

    public static <T>ResultVO<T> success(T data){
        ResultVO<T> resultVO = new ResultVO<T>();
        resultVO.code = ResultCodeEnum.SUCCESS.getCode();
        resultVO.msg = "成功";
        resultVO.data = data;
        return resultVO;
    }
}
