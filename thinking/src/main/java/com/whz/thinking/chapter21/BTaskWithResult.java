/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月13日 下午8:21:03 
 * @version V1.0 
 * @Title: BTaskWithResult.java  
 */
package com.whz.thinking.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月13日 下午8:21:03
 * @ClassName: BTaskWithResult
 * 
 */
public class BTaskWithResult implements Callable<String>
{
    private int id;

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public BTaskWithResult(int id)
    {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public String call()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(new Random(1000).nextLong());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        return "result of TaskWithResult " + id;
    }

    public static class CallableDemo
    {
        public static void main(String[] args)
        {
            ExecutorService exec = Executors.newCachedThreadPool();

            List<Future<String>> results = new ArrayList<>();

            for (int i = 0; i < 10; i++)
            {
                results.add(exec.submit(new BTaskWithResult(i)));
            }

            try
            {
                for (Future<String> future : results)
                {
                    System.out.println(future.get());
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
            finally
            {
                exec.shutdown();
            }
        }
    }
}
