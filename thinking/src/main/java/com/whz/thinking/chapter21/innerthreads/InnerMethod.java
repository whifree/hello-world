/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午7:29:42 
 * @version V1.0 
 * @Title: InnerMethod.java  
 */
package com.whz.thinking.chapter21.innerthreads;

import java.util.concurrent.TimeUnit;

/**
 * @Description: inner thread method
 * @author hongzhi wang
 * @date 2019年3月15日 下午7:29:42
 * @ClassName: InnerMethod
 * 
 */
public class InnerMethod
{
    private int countDown = 5;
    private String name;
    private Thread thread;

    public InnerMethod(String name)
    {
        this.name = name;
    }

    /**
     * @Description: 运行线程
     * @date 2019年3月15日 下午7:35:31
     * @version V1.0
     */
    public void runTask()
    {
        this.thread = new Thread(name)
        {
            @Override
            public void run()
            {
                try
                {
                    while (true)
                    {
                        System.out.print(this);

                        if (--countDown < 0)
                        {
                            return;
                        }

                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public String toString()
            {
                return getName() + ": " + countDown;
            }
        };

        this.thread.start();
    }
}
