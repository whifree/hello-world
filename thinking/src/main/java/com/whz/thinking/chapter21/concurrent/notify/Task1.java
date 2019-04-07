/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月30日 下午4:47:45 
 * @version V1.0 
 * @Title: Task1.java  
 */
package com.whz.thinking.chapter21.concurrent.notify;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月30日 下午4:47:45
 * @ClassName: Task1
 * 
 */
public class Task1 implements Runnable
{
    static Blocker blocker = new Blocker();

    @Override
    public void run()
    {
        blocker.waitingCall();
    }
}
