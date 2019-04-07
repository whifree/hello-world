/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 下午1:48:49 
 * @version V1.0 
 * @Title: AtomicIntegerTest.java  
 */
package com.whz.thinking.chapter21.concurrent.atomic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 使用原子类代替synchronized
 * @author hongzhi wang
 * @date 2019年3月16日 下午1:48:49
 * @ClassName: AtomicIntegerTest
 * 
 */
public class AtomicIntegerTest implements Runnable
{
    private AtomicInteger ai = new AtomicInteger(0);

    public int getValue()
    {
        return ai.get();
    }

    public void evenIcrement()
    {
        ai.addAndGet(2);
    }

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
            evenIcrement();
        }
    }

    public static void main(String[] args)
    {
        new Timer().schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, 5000);

        ExecutorService exec = Executors.newCachedThreadPool();

        AtomicIntegerTest ait = new AtomicIntegerTest();

        exec.execute(ait);

        while (true)
        {
            int val = ait.getValue();

            if (val % 2 != 0)
            {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
