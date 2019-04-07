/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月15日 下午10:33:41 
 * @version V1.0 
 * @Title: IntGenerator.java  
 */
package com.whz.thinking.chapter21.concurrent;

/**
 * @Description: 获取int抽象类
 * @author hongzhi wang
 * @date 2019年3月15日 下午10:33:41
 * @ClassName: IntGenerator
 * 
 */
public abstract class IntGenerator
{
    /**
     * volatile保证可见性
     */
    private volatile boolean canceled = false;
    
    public void cancel()
    {
        this.canceled = true;
    }
    
    public boolean isCancel()
    {
        return this.canceled;
    }
    
    public abstract int next();
}
