/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月14日 上午7:43:47 
 * @version V1.0 
 * @Title: GJion.java  
 */
package com.whz.thinking.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月14日 上午7:43:47
 * @ClassName: GJion
 * 
 */
public class GJoin
{
    private static class Sleeper extends Thread
    {
        int duration;

        Sleeper(String name, int sleepTime)
        {
            super(name);
            this.duration = sleepTime;

            start();
        }

        @Override
        public void run()
        {
            try
            {
                TimeUnit.MILLISECONDS.sleep(duration);
            }
            catch (InterruptedException e)
            {
                System.out.println(getName() + " was interrupt. " + "isInterrupted() is: " + isInterrupted());

                return;
            }

            System.out.println(getName() + " has awakened");
        }
    }
    
    private static class Joiner extends Thread
    {
        Sleeper sleeper;
        
        Joiner(String name, Sleeper sleeper)
        {
            super(name);
            this.sleeper = sleeper;
            
            start();
        }
        
        @Override
        public void run()
        {
            try
            {
                sleeper.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            System.out.println(getName() + " join completed");
        }
    }
    
    public static void main(String[] args)
    {
        Sleeper 
            sleepy = new Sleeper("Sleeper", 2500),
            grumpy = new Sleeper("Grumpy", 1500);
        
        Joiner 
            dopey = new Joiner("Dopey", sleepy),
            doc = new Joiner("Doc", grumpy);
        
        grumpy.interrupt();
    }
}
