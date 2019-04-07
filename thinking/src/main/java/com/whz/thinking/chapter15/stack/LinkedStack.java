package com.whz.thinking.chapter15.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 **自定义堆栈链表
 * @author Nestor Wang
 * @Date 2019年2月20日
 */
public class LinkedStack<T>
{
    private static class Node<T>
    {
    	T item;
    	Node<T> next;
    	
        Node()
    	{
    		this.item = null;
    		this.next = null;
    	}
    	
        Node(T item, Node<T> next)
    	{
    		this.item = item;
    		this.next = next;
    	}
    	
    	boolean end()
    	{
    		return item == null && next == null; 
    	}
    }
    
    private Node<T> top = new Node<>();
    
    public void push(T item)
    {
    	top = new Node<T>(item, top);
    }
    
    public T pop()
    {
    	T result = top.item;
    	
    	if (!top.end())
		{
    		top = top.next;
		}
    	
    	return result;
    }
    
    public static void main(String[] args)
	{
		LinkedStack<String> linkedStack = new LinkedStack<>();
		
		for (String string : "I am whz".split( " " ))
		{
			linkedStack.push( string );
		}
		
		String s;
		while((s = linkedStack.pop()) != null)
		{
			System.out.println( s );
		}
		
		List<String> list = new ArrayList<>();
		
		list.add("aa");
		list.add("bb");
		
		System.out.println( list );
		
		Arrays.asList();
		
		new LinkedList<>();
		
		new HashMap<>();
	}
}
