/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 上午10:07:33 
 * @version V1.0 
 * @Title: SleepBlocked.java  
 */
package com.whz.thinking.chapter21.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Description: sleep blocked
 * @author hongzhi wang
 * @date 2019年3月17日 上午10:07:33
 * @ClassName: SleepBlocked
 * 
 */
public class SleepBlocked implements Runnable
{

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
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("SleepBlocked interrupted");
        }
        
        System.out.println("Exiting SleepBlocked.run");
    }
}
