package com.whz.thinking.chapter16.arrays;

import java.util.Arrays;

/**
 * 
 * @author Nestor Wang
 * @Date 2019年2月23日
 */
public class ArraysTest
{

	public static void main(String[] args)
	{
		int[] i = new int[7];
		int[] j = new int[10];
		
		Arrays.fill(i, 10);
		Arrays.fill(j, 99 );
		
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(j));
		
		System.arraycopy(i, 0, j, 0, i.length);
		
		System.out.println(Arrays.toString(j));
	}
}
