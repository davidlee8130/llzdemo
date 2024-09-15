package com.llz.controller;

import com.alibaba.fastjson.JSON;
import com.llz.controller.vo.ResultVO;
import com.llz.controller.vo.ValiTestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 测试控制类
 */
@RestController
@Slf4j
@RequestMapping("/api/llz")
public class BookController {
    /**
     * 测试接口
     * @return
     */
    @PostMapping("/test01")
    public ResultVO<Object> test01(@Valid @RequestBody ValiTestVO vo){
      log.info("接口请求:{}", JSON.toJSONString(vo));
      return ResultVO.success("请求成功");
    }

    @GetMapping("/ping")
    public String ping() {
        log.info("请求进来");
        return "pong";
    }


}
