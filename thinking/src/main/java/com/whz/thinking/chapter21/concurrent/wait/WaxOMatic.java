/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月17日 下午1:45:34 
 * @version V1.0 
 * @Title: WaxOMatic.java  
 */
package com.whz.thinking.chapter21.concurrent.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试
 * @author hongzhi wang
 * @date 2019年3月17日 下午1:45:34
 * @ClassName: WaxOMatic
 * 
 */
public class WaxOMatic
{
    public static void main(String[] args) throws InterruptedException
    {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        
        exec.shutdownNow();
    }
}
