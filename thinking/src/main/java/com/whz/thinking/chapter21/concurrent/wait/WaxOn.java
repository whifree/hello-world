/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 下午1:36:19 
 * @version V1.0 
 * @Title: WaxOn.java  
 */
package com.whz.thinking.chapter21.concurrent.wait;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 涂蜡
 * @author hongzhi wang
 * @date 2019年3月17日 下午1:36:19
 * @ClassName: WaxOn
 * 
 */
public class WaxOn implements Runnable
{
    private Car car;

    public WaxOn(Car car)
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
                System.out.println("Wax On");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Exiting Wax Off");
        }
        
        System.out.println("Ending Wax On task");
    }
}
