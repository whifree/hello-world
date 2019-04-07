/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 上午10:48:42 
 * @version V1.0 
 * @Title: EvenGenerator.java  
 */
package com.whz.thinking.chapter21.concurrent;

/** 
 * @Description: 偶数生成器
 * @author hongzhi wang
 * @date 2019年3月16日 上午10:48:42 
 * @ClassName: EvenGenerator
 *  
 */
public class EvenGenerator extends IntGenerator
{
    private int currentEvenValue = 0;

    /* (non-Javadoc)
     * @see com.whz.thinking.chapter21.concurrent.IntGenerator#next()
     */
    @Override
    public int next()
    {
        ++currentEvenValue;
        //Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    
    public static void main(String[] args)
    {
        EvenChecker.test(new EvenGenerator());
    }
}
