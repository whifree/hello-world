/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 下午1:16:14 
 * @version V1.0 
 * @Title: Car.java  
 */
package com.whz.thinking.chapter21.concurrent.wait;

/**
 * @Description: car
 * @author hongzhi wang
 * @date 2019年3月17日 下午1:16:14
 * @ClassName: Car
 * 
 */
public class Car
{
    private boolean waxOn = false;

    public synchronized void waxed()
    {
        waxOn = true;
        notifyAll();
    }
    
    public synchronized void buffed()
    {
        waxOn = false;
        notifyAll();
    }
    
    public synchronized void waitForWaxing() throws InterruptedException
    {
        if (waxOn == false)
        {
            wait();
        }
    }
    
    public synchronized void waitForBuffing() throws InterruptedException
    {
        if (waxOn == true)
        {
            wait();
        }
    }
}
