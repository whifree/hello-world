/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 下午6:26:15 
 * @version V1.0 
 * @Title: Count.java  
 */
package com.whz.thinking.chapter21.concurrent.cancel;

import java.util.Random;

/**
 * @Description: 计数器
 * @author hongzhi wang
 * @date 2019年3月16日 下午6:26:15
 * @ClassName: Count
 * 
 */
public class Count
{
    private int count;
    private Random rand = new Random(47);

    public synchronized int increment()
    {
        int temp = count;

        if (rand.nextBoolean())
        {
            Thread.yield();
        }

        return count = ++temp;
    }

    public synchronized int value()
    {
        return count;
    }
}
