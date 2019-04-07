/**   
 * Copyright © 2019, whz. All Rights Reserved.
 * @author Nestor Wang   
 * @date 2019年3月2日 下午2:40:25 
 * @version V1.0 
 */
package com.whz.thinking.chapter18.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description:
 * @author Nestor Wang
 * @date 2019年3月2日 下午2:40:25
 * 
 */
public class RandomAccessFileTest
{
    /**
     * @Description: 输出文件细信息到控制台
     * @param fileName
     * @throws IOException
     * @author Nestor Wang
     * @date 2019年3月2日 下午2:57:34 
     * @version V1.0
     */
    public static void display(String fileName) throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        
        for (int i = 0; i < 7; i++)
        {
            System.out.println(raf.readDouble());
        }
        
        System.out.println(raf.readUTF());
        
        raf.close();
    }
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "aa.txt";
        
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        
        for (int i = 0; i < 7; i++)
        {
            raf.writeDouble(i * 1.23);
        }
        
        raf.writeUTF("我是whz");
        raf.close();
        display(fileName);
        
        raf = new RandomAccessFile(fileName, "rw");
        
        raf.seek(5 * 8);
        System.out.println(raf.readDouble());
        //raf.writeDouble(1.2356);
        raf.close();
        
        display(fileName);
    }
}
