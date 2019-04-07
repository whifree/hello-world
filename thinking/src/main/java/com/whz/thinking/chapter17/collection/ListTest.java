/**
 * 
 */
package com.whz.thinking.chapter17.collection;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nestor Wang
 * @Date 2019年2月23日
 */
public class ListTest
{

    public static void main(String[] args)
    {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("3");
        list2.add("4");
        list2.add("2");
        
        List<String> list3 = new ArrayList<>();
        list3.add("3");
        list3.add("4");
        
        System.out.println(list2.containsAll(list1));
        
        System.out.println(Collections.frequency(list2, "2"));
        
        System.out.println(Collections.max(list2));
        
        Collections.reverse(list2);
        System.out.println(list2.toString());
        
        
        Collections.shuffle(list2, new SecureRandom());
        Collections.shuffle(list2);
        
        System.out.println(list2.toString());
        
        final List<String> l = list1;
        int i = 0;
        int j = 1;
        
        String a = l.set(j, l.get(i));
        String b = l.set(i, a);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(l.toString());
        System.out.println(list1.toString());
        
        Collections.swap(list1, i, j);
        System.out.println(list1.toString());
        
        System.out.println(Collections.disjoint(list1, list3));
        
    }
}
