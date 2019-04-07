/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月13日 下午9:44:13 
 * @version V1.0 
 * @Title: DDaemon.java  
 */
package com.whz.thinking.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 守护线程
 * @author hongzhi wang
 * @date 2019年3月13日 下午9:44:13
 * @ClassName: DDaemon
 * 
 */
public class DDaemon implements Runnable
{

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        while (true)
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

    public static void main(String[] args) throws InterruptedException
    {
        Thread daemon = new Thread(new DDaemon());
        daemon.setDaemon(true);
        daemon.start();

        System.out.println("All daemons started!");

        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
