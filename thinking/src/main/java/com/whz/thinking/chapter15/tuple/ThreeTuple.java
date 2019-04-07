package com.whz.thinking.chapter15.tuple;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B>
{
	public final C three;

	public ThreeTuple(A first, B second, C three)
	{
		super( first, second );
        this.three = three;		
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "ThreeTuple [three=" );
		builder.append( three );
		builder.append( ", first=" );
		builder.append( first );
		builder.append( ", second=" );
		builder.append( second );
		builder.append( "]" );
		return builder.toString();
	}
	
	public static void main(String[] args)
	{
		ThreeTuple<Integer, String, Double> threeTuple = new ThreeTuple<>(2, "eee", 2.21);
		
		System.out.println(threeTuple.toString());
	}
}
