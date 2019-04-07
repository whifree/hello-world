/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年4月2日 下午11:53:47 
 * @version V1.0 
 * @Title: MainTest.java  
 */
package com.whz.thinking.types;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @author hongzhi wang
 * @date 2019年4月2日 下午11:53:47
 * @ClassName: MainTest
 * 
 */
public class MainTest
{
    public static void main(String[] args)
    {
        String[] a = { "8", "3", "5", "7" };
        
        List<String> list = Arrays.asList(a);
        
        for (String str : list)
        {
            System.out.print(str);
        }
        
        System.out.println("\n----------------------");
        //list.stream().sorted((o1, o2) -> o1.compareTo(o2)).forEach(System.out::print);
        
        list.stream().sorted(new ComparatorChild()).forEach(System.out::print);
    }
    
    private static class ComparatorChild implements Comparator<String>
    {
        /* 
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(String o1, String o2)
        {
            return 0;
        }
    }
}
