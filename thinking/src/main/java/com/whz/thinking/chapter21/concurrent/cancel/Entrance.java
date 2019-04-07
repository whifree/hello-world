/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 下午6:42:59 
 * @version V1.0 
 * @Title: Entrance.java  
 */
package com.whz.thinking.chapter21.concurrent.cancel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: 入口
 * @author hongzhi wang
 * @date 2019年3月16日 下午6:42:59 
 * @ClassName: Entrance
 *  
 */
public class Entrance implements Runnable
{
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number;
    private final int id;
    private static volatile boolean canceled = false;
    
    public static void cancel()
    {
        canceled = true;
    }
    
    public Entrance(int id)
    {
        this.id = id;
        
        entrances.add(this);
    }
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        while(!canceled)
        {
            synchronized(this)
            {
                ++number;
            }
            
            System.out.println(this + " Total: " + count.increment());
            
            try
            {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("Stopping " + this);
    }
    
    public synchronized int getValue()
    {
        return number;
    }
    
    public static int getTotalCount()
    {
        return count.value();
    }
    
    public static int sunEntrances()
    {
        int sum = 0;
        
        for (Entrance entrance : entrances)
        {
            sum += entrance.getValue();
        }
        
        return sum;
    }
    
    @Override
    public String toString()
    {
        return "Entrance" + id + ": " + getValue();
    }
}
