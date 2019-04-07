/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 上午10:21:39 
 * @version V1.0 
 * @Title: Interrupting.java  
 */
package com.whz.thinking.chapter21.concurrent.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 中断处理
 * @author hongzhi wang
 * @date 2019年3月17日 上午10:21:39
 * @ClassName: Interrupting
 * 
 */
public class Interrupting
{
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void test(Runnable task) throws InterruptedException
    {
        Future<?> f = exec.submit(task);

        TimeUnit.MILLISECONDS.sleep(100);

        System.out.println("Interrupting " + task.getClass().getName());
        
        f.cancel(true);
        
        System.out.println("Interrupt send to " + task.getClass().getName());
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        
        TimeUnit.SECONDS.sleep(3);
        
        System.out.println("Aborting with System.exit(0)");
        
        System.exit(0);
    }
}
