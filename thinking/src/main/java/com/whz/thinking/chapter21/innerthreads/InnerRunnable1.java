/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午7:05:29 
 * @version V1.0 
 * @Title: InnerRunnable1.java  
 */
package com.whz.thinking.chapter21.innerthreads;

import java.util.concurrent.TimeUnit;

/**
 * @Description: inner runnable
 * @author hongzhi wang
 * @date 2019年3月15日 下午7:05:29
 * @ClassName: InnerRunnable1
 * 
 */
public class InnerRunnable1
{
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable
    {
        Thread thread;

        Inner(String name)
        {
            this.thread = new Thread(this, name);

            this.thread.start();
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Runnable#run()
         */
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
            return thread.getName() + ": " + countDown;
        }
    }

    public InnerRunnable1(String name)
    {
        this.inner = new Inner(name);
    }
}
