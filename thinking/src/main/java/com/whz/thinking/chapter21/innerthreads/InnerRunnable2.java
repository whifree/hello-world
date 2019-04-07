/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午7:18:26 
 * @version V1.0 
 * @Title: InnerRunnable2.java  
 */
package com.whz.thinking.chapter21.innerthreads;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月15日 下午7:18:26
 * @ClassName: InnerRunnable2
 * 
 */
public class InnerRunnable2
{
    private int countDown = 5;
    private Thread thread;

    public InnerRunnable2(String name)
    {
        this.thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    while (true)
                    {
                        System.out.print(this);

                        if (--countDown == 0)
                        {
                            return;
                        }

                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public String toString()
            {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);
        
        thread.start();
    }
}
