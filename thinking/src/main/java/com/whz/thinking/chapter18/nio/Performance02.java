/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年3月9日 下午2:29:08 
 * @version V1.0 
 * @Title: Performance02.java  
 */
package com.whz.thinking.chapter18.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年3月9日 下午2:29:08
 * @ClassName: Performance02
 * 
 */
public class Performance02
{
    private static final int NUMBER_OF_INTS = 4000000;

    private static final int NUMBER_OF_BUFFER_INTS = 200000;

    private static final String FILENAME = "temp.tmp";

    private static final String READ_WRITE = "rw";

    private abstract static class Tester
    {
        private String name;

        public Tester(String name)
        {
            this.name = name;
        }

        public void runTest() throws IOException
        {
            System.out.print(name + " ");

            long start = System.nanoTime();
            test();
            double duration = System.nanoTime() - start;

            System.out.format("%.2f\n", duration / 10000);
        }

        public abstract void test() throws FileNotFoundException, IOException;
    }

    private static Tester[] testers = { new Tester("Steam Writer")
    {
        @Override
        public void test() throws IOException
        {
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(new File(FILENAME))));

            for (int i = 0; i < NUMBER_OF_INTS; i++)
            {
                dos.write(i);
            }

            dos.close();
        }
    },

            new Tester("Mapper write")
            {
                @Override
                public void test() throws FileNotFoundException, IOException
                {
                    FileChannel fc = new RandomAccessFile(FILENAME, READ_WRITE).getChannel();

                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();

                    for (int i = 0; i < NUMBER_OF_INTS; i++)
                    {
                        ib.clear();

                        ib.put(i);
                    }

                    fc.close();
                }
            },

            new Tester("Stream read")
            {

                @Override
                public void test() throws FileNotFoundException, IOException
                {
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILENAME)));

                    for (int i = 0; i < NUMBER_OF_INTS; i++)
                    {
                        dis.read();
                    }
                    
                    dis.close();
                }
            },

            new Tester("Mapper read")
            {
                @Override
                public void test() throws FileNotFoundException, IOException
                {
                    FileChannel fc = new RandomAccessFile(FILENAME, READ_WRITE).getChannel();

                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();

                    while (ib.hasRemaining())
                    {
                        ib.get();
                    }

                    fc.close();
                }
            },

            new Tester("Stream read/write")
            {
                @Override
                public void test() throws FileNotFoundException, IOException
                {
                    RandomAccessFile raf = new RandomAccessFile(new File(FILENAME), READ_WRITE);

                    raf.write(1);

                    for (int i = 0; i < NUMBER_OF_BUFFER_INTS; i++)
                    {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }

                    raf.close();
                }
            },

            new Tester("Mapper read/write")
            {
                @Override
                public void test() throws FileNotFoundException, IOException
                {
                    FileChannel fc = new RandomAccessFile(FILENAME, READ_WRITE).getChannel();

                    IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();

                    ib.put(0);

                    for (int i = 1; i < NUMBER_OF_BUFFER_INTS; i++)
                    {
                        ib.put(ib.get(i - 1));
                    }

                    fc.close();
                }
            } };

    public static void main(String[] args) throws IOException
    {
        for (Tester tester : testers)
        {
            tester.runTest();
        }
    }
}
