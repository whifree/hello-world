/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月9日 下午12:57:19 
 * @version V1.0 
 * @Title: ByteBufferTest.java  
 */
package com.whz.thinking.chapter18.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月9日 下午12:57:19
 * @ClassName: ByteBufferTest
 * 
 */
public class ByteBufferTest
{
    private static final int BSIZE = 1024;

    public static void main(String[] args)
    {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(new int[]{ 1, 2, 3, 4, 5 });
        ib.put(3, 9);
        
        ib.flip();
        //ib.rewind();
        
        while (ib.hasRemaining())
        {
            System.out.println(ib.get());
        }
    }
}
