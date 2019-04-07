/**   
 * Copyright © 2019, whz. All Rights Reserved.
 * @author Nestor Wang   
 * @date 2019年3月2日 下午2:09:20 
 * @version V1.0 
 */
package com.whz.thinking.chapter18.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description:
 * @author Nestor Wang
 * @date 2019年3月2日 下午2:09:20
 * 
 */
public class FileInputStreamTest
{
    public static String read(String fileName)
    {
        StringBuilder sb = new StringBuilder();;
        BufferedReader bf = null;
        String s;
        
        try
        {
            bf = new BufferedReader(new FileReader(fileName));
            
            while ((s = bf.readLine()) != null)
            {
                sb.append(s).append("\n");
            }
            
            bf.close();
        } 
        catch (IOException e)
        {
            System.out.println("error!");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(read("pom.xml"));
    }
}
