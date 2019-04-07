/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月14日 上午7:15:34 
 * @version V1.0 
 * @Title: FThread.java  
 */
package com.whz.thinking.chapter21;

/**
 * @Description: 继承Thread来创建线程
 * @author hongzhi wang
 * @date 2019年3月14日 上午7:15:34
 * @ClassName: FThread
 * 
 */
public class FThread extends Thread
{
    private int countDown = 5;
    private static int threadCount = 0;

    public FThread()
    {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString()
    {
        return "#" + getName() + "(" + countDown + "), ";
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            System.out.print(this);
            
            if (--countDown == 0)
            {
                return;
            }
        }
    }
    
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            new FThread();
        }
    }
}
