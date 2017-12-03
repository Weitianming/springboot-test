package com.forezp.communicationMain.AsyncTask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Administrator on 2017/12/3/0003.
 */
@Service
public class AsyncTaskService {
    Random random = new Random(); // 默认构造方法

    @Async
    public void executeAsyncTask (Integer i) {
        System.out.println("测试异步" + i);
    }



}
