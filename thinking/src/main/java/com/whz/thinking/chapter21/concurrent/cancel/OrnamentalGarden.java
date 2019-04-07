/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 下午7:07:27 
 * @version V1.0 
 * @Title: OrnamentalGarden.java  
 */
package com.whz.thinking.chapter21.concurrent.cancel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试终结任务
 * @author hongzhi wang
 * @date 2019年3月16日 下午7:07:27
 * @ClassName: OrnamentalGarden
 * 
 */
public class OrnamentalGarden
{
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        
        for (int i = 0; i < 5; i++)
        {
            exec.execute(new Entrance(i));
        }
        
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();    
        
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
        {
            System.out.println("Some task were not terminated!");
        }
        
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sunEntrances());
    }
}
