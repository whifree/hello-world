/**   
 * @Description: TODO
 * @author hongzhi wang   
 * @date 2019年4月4日 下午10:36:46 
 * @version V1.0 
 * @Title: LambdaTest.java  
 */
package com.whz.thinking.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @Description: lambda表达式，有参数的表达式
 * @author hongzhi wang
 * @date 2019年4月4日 下午10:36:46
 * @ClassName: LambdaTest
 * 
 */
public class LambdaTest
{
    /**
     * innerClass
     * 
     * @Description: innerClass
     * @date 2019年4月4日 下午10:39:28
     * @version V1.0
     *//*
        * @Test public void innerClass() { // 1.排序 List<Student> students = new ArrayList<>(); students.add(new
        * Student("a", 0.9)); students.add(new Student("b", 0.8)); Collections.addAll(students, new Student("c", 0.7),
        * new Student("d", 0.6), new Student("e", 0.5), new Student("e", 0.7));
        * 
        * // 原来使用匿名内类进行排序方式 Collections.sort(students, new Comparator<Student>() {
        * 
        * @Override public int compare(Student o1, Student o2) { return o1.getScore().compareTo(o2.getScore()); } });
        * 
        * System.out.println(students);
        * 
        * // lambda表达式的方式排序 Collections.sort(students, (s1, s2) -> Double.compare(s2.getScore(), s1.getScore()));
        * 
        * System.out.println(students);
        * 
        * // 2.新建线程 new Thread(new Runnable() {
        * 
        * @Override public void run() { System.out.println("传统方法新建线程"); }
        * 
        * }).start();
        * 
        * new Thread(() -> System.out.println("lambda方式新建线程")).start();
        * 
        * // 3.list转换成map Map<String, Double> map1 = students.stream() .collect(Collectors.toMap(Student::getName,
        * Student::getScore, (k1, k2) -> k1));
        * 
        * System.out.println(map1.toString());
        * 
        * Map<String, Student> map2 = students.stream() .collect(Collectors.toMap(Student::getName, s -> s, (k1, k2) ->
        * k1));
        * 
        * System.out.println(map2.toString()); }
        */

    @Test
    public void list()
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < 100000; i++)
        {
            list1.add(String.valueOf(i));
            list2.add(String.valueOf(i + 1));
        }
        
        long start = System.currentTimeMillis();

        Runtime run = Runtime.getRuntime();

        long startFree = run.totalMemory() - run.freeMemory();

        for (String str1 : list1)
        {
            for (String str2 : list2)
            {

            }
        }

        System.out.println("list cost time = " + (System.currentTimeMillis() - start) + "ms");

        long endFree = run.totalMemory() - run.freeMemory();

        System.out.println("list cost memory = " + (endFree - startFree));

        /*
         * long start2 = System.currentTimeMillis();
         * 
         * Map<String, String> map = list2.stream().collect(Collectors.toMap(String::new, String::new, (k1, k2) -> k1));
         * 
         * for (String str3 : list1) { map.get(str3); }
         * 
         * System.out.println("map cost = " + (System.currentTimeMillis() - start2) + "ms");
         */

    }

    @Test
    public void map()
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < 100000; i++)
        {
            list1.add(String.valueOf(i));
            list2.add(String.valueOf(i + 1));
        }

        long start2 = System.currentTimeMillis();

        Runtime run = Runtime.getRuntime();
        long startFree = run.totalMemory() - run.freeMemory();

        Map<String, String> map = list2.stream().collect(Collectors.toMap(String::new, String::new, (k1, k2) -> k1));

        for (String str3 : list1)
        {
            map.get(str3);
        }

        System.out.println("map cost time = " + (System.currentTimeMillis() - start2) + "ms");

        long endFree = run.totalMemory() - run.freeMemory();

        System.out.println("map cost memory = " + (endFree - startFree));
    }
    
    @Test
    public void strToArray1()
    {
        String str = "abcdefghijk";
        
        char[] chars = str.toCharArray();
        
        char[] reverseChar = new char[chars.length];
        
        for (int i = 0; i < chars.length; i++)
        {
            reverseChar[i] = chars[chars.length-1-i];
        }
        
        System.out.println(Arrays.toString(reverseChar));
    }
    
    @Test
    public void strToArray2()
    {
        String str = "abcdefghijk";
    }
}
