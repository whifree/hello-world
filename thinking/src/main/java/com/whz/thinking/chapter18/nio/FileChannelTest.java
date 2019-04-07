/**   
 * Copyright © 2019, whz. All Rights Reserved.
 * @author Nestor Wang   
 * @date 2019年3月2日 下午5:34:38 
 * @version V1.0 
 */
package com.whz.thinking.chapter18.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: FileChannel测试
 * @author Nestor Wang
 * @date 2019年3月2日 下午5:34:38
 * 
 */
public class FileChannelTest
{
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException
    {
        String fileName = "data.txt";

        File file = new File(fileName);

        if (!file.exists())
        {
            file.createNewFile();
        }

        System.out.println(file.canWrite());

        // Write a file
        FileChannel fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("I am whz".getBytes()));
        fc.close();

        // Add to the end of file
        fc = new RandomAccessFile(fileName, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(", hello world!".getBytes()));
        fc.close();

        // Read the file
        fc = new FileInputStream(fileName).getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        fc.read(bf);
        bf.flip();

        while (bf.hasRemaining())
        {
            System.out.print((char) bf.get());
        }

        long fs = file.getFreeSpace();
        long ts = file.getTotalSpace();
        long us = file.getUsableSpace();

        String encoding = System.getProperty("file.encoding");

        System.out.println(" fs:" + fs + ", ts:" + ts + ", us:" + us);
        System.out.println("encoding：" + encoding);
    }
}
