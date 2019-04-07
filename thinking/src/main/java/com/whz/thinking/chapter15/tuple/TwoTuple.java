package com.whz.thinking.chapter15.tuple;

public class TwoTuple<A, B>
{
    public final A first;
    public final B second;
    
    public TwoTuple(A first, B second)
    {
    	this.first = first;
    	this.second = second;
    }

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "TwoTuple [first=" );
		builder.append( first );
		builder.append( ", second=" );
		builder.append( second );
		builder.append( "]" );
		return builder.toString();
	}
}
