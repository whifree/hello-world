/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午6:57:54 
 * @version V1.0 
 * @Title: InnerThread2.java  
 */
package com.whz.thinking.chapter21.innerthreads;

import java.util.concurrent.TimeUnit;

/**
 * @Description: inner thread 2
 * @author hongzhi wang
 * @date 2019年3月15日 下午6:57:54
 * @ClassName: InnerThread2
 * 
 */
public class InnerThread2
{
    private int countDown = 5;

    private Thread thread;

    public InnerThread2(String name)
    {
        this.thread = new Thread(name)
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
                return getName() + ": " + countDown;
            }
        };

        thread.start();
    }
}
