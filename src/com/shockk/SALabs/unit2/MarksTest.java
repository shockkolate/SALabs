package com.shockk.SALabs.unit2;

public class MarksTest
{
	public static void main(String[] args)
	{
		while(true)
		{
			Marks marks = new Marks();
			marks.outputResults();

			String cont = Input.getString("Continue? (y/n): ");
			if(cont.equalsIgnoreCase("n")) break;
		}
	}
}