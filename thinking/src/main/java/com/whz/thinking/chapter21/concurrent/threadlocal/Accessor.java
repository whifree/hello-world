/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 下午2:49:26 
 * @version V1.0 
 * @Title: Accessor.java  
 */
package com.whz.thinking.chapter21.concurrent.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author hongzhi wang
 * @date 2019年3月16日 下午2:49:26
 * @ClassName: Accessor
 * 
 */
public class Accessor implements Runnable
{
    private final int id;

    public Accessor(int id)
    {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
        {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    
    private static class ThreadLocalVariableHolder
    {
        private static ThreadLocal<Integer> value = new ThreadLocal<>() 
        {
            private Random rand = new Random(47);
            
            @Override
            protected synchronized Integer initialValue()
            {
                return rand.nextInt(10000);
            }
        };
        
        public static void increment()
        {
            value.set(value.get() + 1);
        }
        
        public static int get()
        {
            return value.get();
        }
    }
    
    @Override
    public String toString()
    {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
                
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 5; i++)
        {
            exec.execute(new Accessor(i));
        }
        
        TimeUnit.MILLISECONDS.sleep(3000);
        
        exec.shutdownNow();
    }
}
