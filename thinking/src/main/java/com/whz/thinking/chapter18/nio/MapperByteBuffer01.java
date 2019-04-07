/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月9日 下午2:08:37 
 * @version V1.0 
 * @Title: MapperByteBuffer01.java  
 */
package com.whz.thinking.chapter18.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * @Description: buffer mapper
 * @author hongzhi wang
 * @date 2019年3月9日 下午2:08:37
 * @ClassName: MapperByteBuffer01
 * 
 */
public class MapperByteBuffer01
{
    private static final int LENGTH = 0x8FFFFFF;

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        MappedByteBuffer out = new RandomAccessFile("mapperbuffer.txt", "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++)
        {
            out.put((byte)'x');
        }
        
        System.out.println("Finished writing!");
        
        for (int i = LENGTH/2; i < LENGTH/2+6; i++)
        {
            System.out.println((char)out.get(i));
        }
    }
}
