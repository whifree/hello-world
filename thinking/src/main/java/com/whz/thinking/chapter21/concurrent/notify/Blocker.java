/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月30日 下午4:40:49 
 * @version V1.0 
 * @Title: Blocker.java  
 */
package com.whz.thinking.chapter21.concurrent.notify;

/**
 * @Description: 该对象将阻塞，可以使用notify和notifyAll唤醒
 * @author hongzhi wang
 * @date 2019年3月30日 下午4:40:49
 * @ClassName: Blocker
 * 
 */
public class Blocker
{

    /**
     * @Description: 使当前线程进入阻塞状态
     * @date 2019年3月30日 下午4:45:20
     * @version V1.0
     */
    public synchronized void waitingCall()
    {
        try
        {
            while (!Thread.interrupted())
            {
                wait();
                System.out.print(Thread.currentThread() + " ");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @Description: prod
     * @date 2019年3月30日 下午4:46:45
     * @version V1.0
     */
    public synchronized void prod()
    {
        notify();
    }

    public synchronized void prodAll()
    {
        notifyAll();
    }
}
