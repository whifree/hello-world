/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月16日 下午2:24:07 
 * @version V1.0 
 * @Title: Pair.java  
 */
package com.whz.thinking.chapter21.concurrent.atomic.syncblock;

/**
 * @Description: pair
 * @author hongzhi wang
 * @date 2019年3月16日 下午2:24:07
 * @ClassName: Pair
 * 
 */
public class Pair
{
    private int x;
    private int y;

    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
    
    public void incrementX()
    {
        x++;
    }
    
    public void incrementY()
    {
        y++;
    }
    
    public void checkState()
    {
        if (x != y)
        {
            new PairValuesNotEqualException();
        }
    }
    
    private class PairValuesNotEqualException extends RuntimeException
    {
        /** 
         * @Fields serialVersionUID : 
         * @data 2019年3月16日 下午2:31:06 
         */ 
        private static final long serialVersionUID = 1678479194686986955L;

        public PairValuesNotEqualException()
        {
            super("Pair values not equal: " + Pair.this);
        }
    }
}
