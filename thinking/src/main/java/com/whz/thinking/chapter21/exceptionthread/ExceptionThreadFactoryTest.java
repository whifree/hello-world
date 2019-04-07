/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午9:47:36 
 * @version V1.0 
 * @Title: ExceptionThreadFactoryTest.java  
 */
package com.whz.thinking.chapter21.exceptionthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Description: 捕获线程中的异常
 * @author hongzhi wang
 * @date 2019年3月15日 下午9:47:36
 * @ClassName: ExceptionThreadFactoryTest
 * 
 */
public class ExceptionThreadFactoryTest
{
    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory()
        {
            @Override
            public Thread newThread(Runnable r)
            {
                System.out.println(this + " creating new Thread");

                Thread thread = new Thread(r);
                System.out.println("create " + thread);

                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
                {
                    @Override
                    public void uncaughtException(Thread t, Throwable e)
                    {
                        System.out.println("catch " + e);
                    }
                });

                return thread;
            }
        });

        exec.execute(new Thread()
        {
            @Override
            public void run()
            {
                Thread thread = Thread.currentThread();

                System.out.println("run by " + thread);
                System.out.println("eh = " + thread.getUncaughtExceptionHandler());

                throw new RuntimeException();
            }
        });
    }
}
