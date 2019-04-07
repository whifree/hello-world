/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 下午1:40:26 
 * @version V1.0 
 * @Title: WaxOff.java  
 */
package com.whz.thinking.chapter21.concurrent.wait;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 抛光
 * @author hongzhi wang
 * @date 2019年3月17日 下午1:40:26
 * @ClassName: WaxOff
 * 
 */
public class WaxOff implements Runnable
{
    private Car car;

    public WaxOff(Car car)
    {
        this.car = car;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        try
        {
            while (!Thread.interrupted())
            {
                System.out.println("Wax Off");
                car.waitForWaxing();
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Exiting Wax Off");
        }
        
        System.out.println("Ending Wax Off task");
    }
}
