package com.whz.thinking.types;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Nestor Wang
 * @Date 2018年9月8日
 */
public class Person
{
	public Person(String name)
	{

	}

	public static void main(String[] args)
	{
		File file = new File(".");

		file.list(new FilenameFilter()
		{	
			public boolean accept(File dir, String name)
			{
				// TODO Auto-generated method stub
				return false;
			}
		});
	}
}
