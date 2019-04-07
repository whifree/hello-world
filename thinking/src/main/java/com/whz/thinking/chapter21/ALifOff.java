/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月13日 下午7:32:33 
 * @version V1.0 
 * @Title: ALifOff.java  
 */
package com.whz.thinking.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月13日 下午7:32:33
 * @ClassName: ALifOff
 * 
 */
public class ALifOff implements Runnable
{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public ALifOff()
    {

    }

    public ALifOff(int countDown)
    {
        this.countDown = countDown;
    }

    public String status()
    {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        while (countDown-- > 0)
        {
            System.out.print(status());

            Thread.yield();
        }
    }

    public static void main(String[] args)
    {
        /*
         * ALifOff lifOff = new ALifOff();
         * 
         * lifOff.run();
         */
        
        /*
         * Thread thread = new Thread(new ALifOff()); thread.start();
         * 
         * System.out.println("Waiting for LifOff!");
         */
        
        /*
         * for (int i = 0; i < 5; i++) { new Thread(new ALifOff()).start();; }
         * 
         * System.out.println("Waiting for LifOff!");
         */
        
        /*
         * ExecutorService exec = Executors.newCachedThreadPool();
         * 
         * for (int i = 0; i < 5; i++) { exec.execute(new ALifOff()); }
         * 
         * exec.shutdown();
         */
         
        /*
         * ExecutorService exec = Executors.newFixedThreadPool(5);
         * 
         * for (int i = 0; i < 5; i++) { exec.execute(new ALifOff()); }
         * 
         * exec.shutdown();
         */
        
        ExecutorService exec = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < 5; i++)
        {
            exec.execute(new ALifOff());
        }
        
        exec.shutdown();
    }
}
