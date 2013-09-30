package com.shockk.SALabs.unit1;

public class FarmerGame
{
	public enum Bank
	{
		Left,
		Right
	};
	
	public enum Entity
	{
		Fox,
		Chicken,
		Corn
	}
	
	private Bank farmer_bank = Bank.Left;
	private Bank[] entity_banks = new Bank[Entity.values().length];
	
	public FarmerGame()
	{
		for(int i=0; i<this.entity_banks.length; ++i)
		{
			this.entity_banks[i] = Bank.Left;
		}
	}
	
	public void print_state()
	{
		StringBuilder sb = new StringBuilder();
		this.get_entity_banks_sb(sb);
		
		if(sb.length() > 0) sb.insert(0, " with the ");
		
		System.out.println();
		System.out.println("You are at the edge of the " + this.farmer_bank.toString() + " river bank" + sb + ". What do you do?");
	}
	
	public void print_options()
	{
		System.out.println("1: Cross the river to the " + toggle_bank(this.farmer_bank) + " bank.");
		
		int n = 2;
		
		for(int i=0; i<this.entity_banks.length; ++i)
		{
			if(this.farmer_bank == this.entity_banks[i])
			{
				System.out.println(n++ + ": " + "Take the " + Entity.values()[i] + " across the river to the " + toggle_bank(this.farmer_bank) + " bank.");
			}
		}
	}
	
	public void process_input()
	{
		int input = 0;
		
		try
		{
			input = Input.get_int("> ");
		}
		catch(Exception e) {}
		
		
		if(input == 1)
		{
			this.farmer_bank = toggle_bank(this.farmer_bank);
			return;
		}
		
		int n = 2;
		
		for(int i=0; i<this.entity_banks.length; ++i)
		{
			if(this.farmer_bank == this.entity_banks[i])
			{
				if(n++ == input)
				{
					this.farmer_bank = toggle_bank(this.farmer_bank);
					this.entity_banks[i] = toggle_bank(this.entity_banks[i]);
					return;
				}
			}
		}

		System.out.println("Invalid option.");
	}
	
	public Bank toggle_bank(Bank bank)
	{
		return bank == Bank.Left ? Bank.Right : Bank.Left;
	}
	
	public void get_entity_banks_sb(StringBuilder sb)
	{
		int n = 0;
		
		for(int i=this.entity_banks.length-1; i>=0; --i)
		{
			if(this.farmer_bank == this.entity_banks[i])
			{
				switch(n++)
				{
				case 0:
					sb.insert(0, Entity.values()[i]);
					break;
				case 1:
					sb.insert(0, Entity.values()[i] + " and ");
					break;
				default:
					sb.insert(0, Entity.values()[i] + ", ");
					break;
				}
			}
		}
	}
}