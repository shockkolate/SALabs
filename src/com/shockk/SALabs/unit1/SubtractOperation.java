package com.shockk.SALabs.unit1;

public class SubtractOperation implements IOperation
{
	@Override
	public Object operate()
	{
		Double value = null;
		
		try
		{
			value = Input.getDouble("first: ") - Input.getDouble("second: ");
		}
		catch(Exception e) {}
		
		return value;
	}
	
	@Override
	public String toString()
	{
		return "subtract";
	}
}