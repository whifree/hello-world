/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午8:34:36 
 * @version V1.0 
 * @Title: ResponsiveUI.java  
 */
package com.whz.thinking.chapter21.responsiveui;

import java.io.IOException;

/** 
 * @Description: 响应式的用户界面
 * @author hongzhi wang
 * @date 2019年3月15日 下午8:34:36 
 * @ClassName: ResponsiveUI
 *  
 */
public class ResponsiveUI extends Thread
{
    private static volatile double d = 1;
    
    public ResponsiveUI()
    {
        setDaemon(true);
        start();
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            d += (Math.PI + Math.E)/d;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
