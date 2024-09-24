package com.llz.common.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class AsyncService {

    @Async("threadPoolTaskExecutor")
    public void executeAsyncTask(String msg , List<String> list, CountDownLatch countDownLatch, Lock lock) {
        //执行异步任务

        try {
            Thread.sleep(100L);
            lock.lock();
            list.add(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        countDownLatch.countDown();

    }
}
