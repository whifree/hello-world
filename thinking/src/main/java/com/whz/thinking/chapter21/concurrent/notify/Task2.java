/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月30日 下午4:50:56 
 * @version V1.0 
 * @Title: Task2.java  
 */
package com.whz.thinking.chapter21.concurrent.notify;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月30日 下午4:50:56
 * @ClassName: Task2
 * 
 */
public class Task2 implements Runnable
{
    static Blocker blocker = new Blocker();

    @Override
    public void run()
    {
        blocker.waitingCall();
    }
}
