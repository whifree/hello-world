/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月13日 下午10:13:36 
 * @version V1.0 
 * @Title: EThreadFactory.java  
 */
package com.whz.thinking.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: 从工厂中生产守护线程
 * @author hongzhi wang
 * @date 2019年3月13日 下午10:13:36 
 * @ClassName: EThreadFactory
 *  
 */
public class EFactoryTestThread implements Runnable
{

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                TimeUnit.MILLISECONDS.sleep(100);
                
                System.out.println(Thread.currentThread() + " " + this);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private static class DeamonThreadFactory implements ThreadFactory
    {

        /* (non-Javadoc)
         * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
         */
        @Override
        public Thread newThread(Runnable r)
        {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService exec = Executors.newCachedThreadPool(new DeamonThreadFactory());
        
        for (int i = 0; i < 10; i++)
        {
            exec.execute(new EFactoryTestThread());
        }
        
        System.out.println("All Daemon started!");
        
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
