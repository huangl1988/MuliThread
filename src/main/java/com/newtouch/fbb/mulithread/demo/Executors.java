package com.newtouch.fbb.mulithread.demo;

import java.util.concurrent.*;

/**
 * Created by steven on 2018/1/5.
 */
public class Executors {

    private  static int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    public static ExecutorService getExecutor(){
        return  new ThreadPoolExecutor(CORE_SIZE*4,CORE_SIZE*20,1l,TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(100),r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
    }






}
