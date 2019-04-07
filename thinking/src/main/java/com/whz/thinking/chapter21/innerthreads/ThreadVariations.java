/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午7:38:16 
 * @version V1.0 
 * @Title: ThreadVariations.java  
 */
package com.whz.thinking.chapter21.innerthreads;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月15日 下午7:38:16
 * @ClassName: ThreadVariations
 * 
 */
public class ThreadVariations
{
    public static void main(String[] args)
    {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new InnerMethod("InnerMethod").runTask();
    }
}
