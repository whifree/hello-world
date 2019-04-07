/**   
 * Copyright © 2019, whz. All Rights Reserved.
 * @author Nestor Wang   
 * @date 2019年3月2日 下午12:42:28 
 * @version V1.0 
 */
package com.whz.thinking.chapter18.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description: 文件过滤器
 * @author Nestor Wang
 * @date 2019年3月2日 下午12:42:28
 * 
 */
public class DirFilterTest
{
    public static void main(final String[] args)
    {
        File path = new File(".");
        String[] files;
        
        if (args.length == 0)
        {
            files = path.list();
        } 
        else
        {
            files = path.list(new FilenameFilter()
            {
                private Pattern pattern = Pattern.compile(args[0]);
                
                @Override
                public boolean accept(File dir, String name)
                {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        
        System.out.println(Arrays.toString(files));
    }
}
