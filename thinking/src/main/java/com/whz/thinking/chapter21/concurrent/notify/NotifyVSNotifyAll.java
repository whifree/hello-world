/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月30日 下午4:55:23 
 * @version V1.0 
 * @Title: NotifyVSNotifyAll.java  
 */
package com.whz.thinking.chapter21.concurrent.notify;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author hongzhi wang
 * @date 2019年3月30日 下午4:55:23
 * @ClassName: NotifyVSNotifyAll
 * 
 */
public class NotifyVSNotifyAll
{
    public static void main(String[] args) throws InterruptedException
    {
        // 运行阻塞线程
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 5; i++)
        {
            exec.execute(new Task1());
        }
        
        exec.execute(new Task2());
        
        // 唤醒阻塞线程
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() 
        {
            boolean prod = true;
            
            @Override
            public void run()
            {
                if (prod)
                {
                    System.out.println("notify");
                    Task1.blocker.prod();
                    prod = false;
                }
                else
                {
                    System.out.println("notifyAll");
                    Task1.blocker.prodAll();
                    prod = true;
                }
            }
            
        }, 400, 400);
        
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nTimer Canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nshutting down");
        exec.shutdownNow();
    }
}
