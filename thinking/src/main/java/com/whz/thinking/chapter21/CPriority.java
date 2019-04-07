/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月13日 下午8:49:21 
 * @version V1.0 
 * @Title: CPriority.java  
 */
package com.whz.thinking.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 线程优先级
 * @author hongzhi wang
 * @date 2019年3月13日 下午8:49:21
 * @ClassName: CPriority
 * 
 */
public class CPriority implements Runnable
{
    private int countDown = 5;
    private volatile double d;
    private int prority;

    public CPriority(int prority)
    {
        this.prority = prority;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        Thread.currentThread().setPriority(prority);

        while (true)
        {
            for (int i = 0; i < 100000; i++)
            {
                d += (Math.PI * Math.PI + Math.E) / (double) i;

                if (i % 1000 == 0)
                {
                    Thread.yield();
                }
            }

            System.out.println(this);

            if (--countDown == 0)
            {
                return;
            }
        }
    }

    @Override
    public String toString()
    {
        return Thread.currentThread() + ": " + countDown;
    }

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new CPriority(Thread.MIN_PRIORITY));
        exec.execute(new CPriority(Thread.NORM_PRIORITY));
        exec.execute(new CPriority(Thread.MAX_PRIORITY));

        exec.shutdown();
    }
}
