/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午6:44:22 
 * @version V1.0 
 * @Title: InnerThread1.java  
 */
package com.whz.thinking.chapter21.innerthreads;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 使用内部thread
 * @author hongzhi wang
 * @date 2019年3月15日 下午6:44:22
 * @ClassName: InnerThread1
 * 
 */
public class InnerThread1
{
    private int countDown = 5;
    private Inner inner;
    
    public InnerThread1(String name)
    {
        this.inner = new Inner(name);
    }
    
    private class Inner extends Thread
    {
        Inner(String name)
        {
            super(name);

            start();
        }

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

        public String toString()
        {
            return getName() + ": " + countDown + "\n";
        }
    }
}
