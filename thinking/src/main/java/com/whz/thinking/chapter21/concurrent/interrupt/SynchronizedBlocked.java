/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 上午10:15:42 
 * @version V1.0 
 * @Title: SynchronizedBlocked.java  
 */
package com.whz.thinking.chapter21.concurrent.interrupt;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月17日 上午10:15:42
 * @ClassName: SynchronizedBlocked
 * 
 */
public class SynchronizedBlocked implements Runnable
{
    public SynchronizedBlocked()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                f();
            }
        }.start();
    }

    public synchronized void f()
    {
        while (true)
        {
            Thread.yield();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        System.out.println("Try to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run");
    }

}
