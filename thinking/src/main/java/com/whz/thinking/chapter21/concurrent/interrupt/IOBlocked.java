/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 上午10:10:49 
 * @version V1.0 
 * @Title: IOBlocked.java  
 */
package com.whz.thinking.chapter21.concurrent.interrupt;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: IO blocked
 * @author hongzhi wang
 * @date 2019年3月17日 上午10:10:49
 * @ClassName: IOBlocked
 * 
 */
public class IOBlocked implements Runnable
{
    private InputStream in;

    public IOBlocked(InputStream in)
    {
        this.in = in;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        System.out.println("Waiting for read");

        try
        {
            in.read();
        }
        catch (IOException e)
        {
            if (Thread.currentThread().isInterrupted())
            {
                System.out.println("IOBlocked interrupted");
            }
        }

        System.out.println("Exiting IOBlocked");
    }
}
