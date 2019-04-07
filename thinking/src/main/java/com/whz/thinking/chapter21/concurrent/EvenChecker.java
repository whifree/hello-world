/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 上午10:30:53 
 * @version V1.0 
 * @Title: EvenChecker.java  
 */
package com.whz.thinking.chapter21.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: 检查是否是偶数的线程
 * @author hongzhi wang
 * @date 2019年3月16日 上午10:30:53 
 * @ClassName: EvenChecker
 *  
 */
public class EvenChecker implements Runnable
{
    private IntGenerator intGenerator;
    private final int id;
    
    public EvenChecker(IntGenerator intGenerator, int id)
    {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        while (!intGenerator.isCancel())
        {
            int val = intGenerator.next();
            
            if (val%2 != 0)
            {
                System.out.println(val + " not even！");
                intGenerator.cancel();                
            }
        }
    }
    
    /**
     * @Description: 创建指定数量偶数检查线程
     * @param intGenerator
     * @param count
     * @date 2019年3月16日 上午10:43:38 
     * @version V1.0
     */
    public static void test(IntGenerator intGenerator, int count)
    {
        System.out.println("Press Control-C to exit");
        
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < count; i++)
        {
            exec.execute(new EvenChecker(intGenerator, i));
        }
        
        exec.shutdown();
    }

    /**
     * @Description: 创建默认数量偶数检查线程，默认10
     * @param intGenerator
     * @date 2019年3月16日 上午10:45:30 
     * @version V1.0
     */
    public static void test(IntGenerator intGenerator)
    {
        test(intGenerator, 10);
    }
}
