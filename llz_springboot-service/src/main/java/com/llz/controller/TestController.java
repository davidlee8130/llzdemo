package com.llz.controller;

import com.alibaba.fastjson.JSON;
import com.llz.common.async.AsyncService;
import com.llz.common.mq.SpringAmqpTestService;
import com.llz.controller.vo.ResultVO;
import com.llz.controller.vo.ValiTestVO;
import com.llz.dao.Test1Dao;
import com.llz.dao.po.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试控制类
 */
@RestController
@Slf4j
@RequestMapping("/api/llz")
public class TestController {

    @Autowired
    private Test1Dao test1Dao;
    @Autowired
    private SpringAmqpTestService springAmqpTestService;
    @Autowired
    private AsyncService asyncService;

    /**
     * 测试接口
     * @return
     */
    @PostMapping("/test01")
    public ResultVO<Object> test01(@Valid @RequestBody ValiTestVO vo){
        Student student = test1Dao.selectById("2");
        return ResultVO.success(student);
    }

    @GetMapping("/ping")
    public ResultVO<Object> ping() {
        springAmqpTestService.testSimpleQueue();
        return ResultVO.success("调用接口完毕");
    }

    @GetMapping("/ping1")
    public ResultVO<Object> ping1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add("2");
        }
        List<String> list1 = new ArrayList<>();
        long start = System.currentTimeMillis();
        Integer num = 0;
        CountDownLatch countDownLatch = new CountDownLatch(500);
        Lock lock = new ReentrantLock();
        for (String s : list) {
            asyncService.executeAsyncTask(s, list1,countDownLatch,lock);
            //            try {
//                num++;
//                log.info("执行第{}条",num);
//                Thread.sleep(100L);
//                list1.add(s);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        try {
            countDownLatch.await();
            log.info("所有线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("执行时间:{}ms",time);
        int size = list1.size();
        return ResultVO.success(size);
    }

    @GetMapping("/ping2")
    public ResultVO<Object> ping2() {
        Runnable runnable = () -> {
            log.info("异步线程启动!");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("异步线程执行完毕!");
        };
        new Thread(runnable).start();
        return ResultVO.success("调用接口完毕");
    }

}
