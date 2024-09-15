package com.llz.controller;


import com.llz.common.enums.ResultCodeEnum;
import com.llz.controller.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制类
 */
@Controller
@Slf4j
@RequestMapping("/api/llz")
public class BookController {
    /**
     * 测试接口
     * @return
     */
    @GetMapping("/test01")
    public ResultVO<Object> test01(){
      log.info("接口请求:{}",1);
      return ResultVO.success("请求成功");
    }


}
