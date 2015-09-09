package vm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Program {
	
	

	public static void saveTheInventory(VendingMachine[] machine)
	{
		String fileName = "out.bin";
		try 
		{
			FileOutputStream fileOs = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fileOs);
			
			for(int  i = 0 ; i < machine.length ; i++)
				os.writeObject(machine[i]);
			os.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static VendingMachine[] readTheInventroy(String fileName)
	{
		VendingMachine[] machine = null;
		VendingMachine element = null;
		
		try
		{
			FileInputStream fileIs = new FileInputStream(fileName);
			ObjectInputStream is = new ObjectInputStream(fileIs);
			
			element = (VendingMachine) is.readObject();
			machine  = new VendingMachine[2];
			machine[0] = element;
			element = (VendingMachine) is.readObject();
			machine[1] = element;
			is.close();
		}
		catch(Exception e){}
		
		return machine;
	}
	
	public static double[] runVendingMachine(VendingMachine []machine, int rm)
	{
		double [] result = new double[4];
		double balance = 0 ;
		double change = 0 ;
		double totalPurchase = 0;
		double totalAmountPaid = 0;
		double temp;
		int dispenser = 0;
		
		Random rand = new Random();
		int maxTime = rand.nextInt(40)+20;
		System.out.format("You have " + maxTime + " seconds to use the machine");
		Scanner in = new Scanner(System.in);
		long t= System.currentTimeMillis();
		long end = t + maxTime*1000;
		System.out.println(machine[rm]);
		while (System.currentTimeMillis() < end) 
		{
			try {
				
				System.out.print("Insert Money:");
				temp =  in.nextDouble();
				balance += temp;
				totalAmountPaid += temp;
				//error detecting
				while (balance < 0) {
					System.out.println("The Entered value is not valid");
					System.out.print("Insert Money:");
					temp =  in.nextDouble();
					balance += temp;
					totalAmountPaid += temp;
				}

				System.out.print("Choose the Dispenser:");
				dispenser = in.nextInt();
				while (dispenser >= 20 || dispenser < 0) {
					System.out.println("The selected dispenser is not valid");
					System.out.print("Choose the Dispenser:");
					dispenser = in.nextInt();
				}
				while (machine[rm].getDispenser()[dispenser].getNumber() == 0) {
					System.out.println("Your choice has been ran out");
					System.out.print("Choose the Dispenser:");
					dispenser = in.nextInt();
				}
				while (machine[rm].getDispenser()[dispenser].getPrice() > balance) {
					System.out.println("The entered money is not enough");
					System.out.print("Insert More Money:");
					temp =  in.nextDouble();
					balance += temp;
					totalAmountPaid += temp;
				}
				//end error detecting

				balance = balance
						- machine[rm].getDispenser()[dispenser].getPrice();
				totalPurchase += machine[rm].getDispenser()[dispenser].getPrice();
				//machine[rm].getDispenser()[dispenser].setNumber(machine[rm].getDispenser()[dispenser].getNumber() -1);
				machine[rm].vmcalc(dispenser);

			} catch (Exception e) {}
			
		}
		in.close();
		result[0] = dispenser;
		result[1] = balance;
		result[2] = totalAmountPaid;
		result[3] = totalPurchase;
		return result;
	}
	public static double[] runVendingMachine2(VendingMachine []machine,int rm)
	{
		double [] result = new double[2];
		double money = 0 ;
		double change = 0 ;
		int dispenser = 0;
		
		Random rand = new Random();
		int maxTime = rand.nextInt(4)+1;
		System.out.format("You have " + maxTime + " seconds to use the machine");
		Scanner in = new Scanner(System.in);
		long t= System.currentTimeMillis();
		long end = t + 10*1000;
		System.out.println(machine[rm]);
		while (System.currentTimeMillis() < end)
		{
			try 
			{
				System.out.print("Insert Money:");
				money += in.nextDouble();	
				System.out.print("Choose the Dispenser:");
				dispenser = in.nextInt();
				money = money - machine[rm].getDispenser()[dispenser].getPrice();
				machine[rm].vmcalc(dispenser);

			} catch (Exception e) {System.out.print("The Value is not correct.");}
			
			result[0] = money;
			result[1] = dispenser;
		}
		in.close();
		System.out.print("Time is up");
		return result;
	}
	public static Dispenser[] foodsAllocation1()
	{
		Food[] food = new Food[20];
		Dispenser [] d = new Dispenser[20];
		for(int i = 0; i < 20 ; i++)
		{
			food[i] = new Food("f" + new Integer(i).toString(),"k"+ new Integer(i).toString());
			d[i] = new Dispenser(20, i*2-i+1, food[i]);
		}
		return d;
	}
	public static Dispenser[] foodsAllocation2()
	{
		Food[] food = new Food[20];
		Dispenser [] d = new Dispenser[20];
		for(int i = 0; i < 20 ; i++)
		{
			food[i] = new Food("f" + new Integer(i).toString(),"k"+ new Integer(i).toString());
			d[i] = new Dispenser(20, i*2-i+1, food[i]);
		}
		return d;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//check for reading file
		VendingMachine []machine = null;
		machine= readTheInventroy("out.bin");
		if(machine == null)
		{
			machine = new VendingMachine[2];
			machine[0] = new VendingMachine(foodsAllocation1(),"vending Machine 1");
			machine[1] = new VendingMachine(foodsAllocation2(),"vending Machine 2");
		}
		
		Random rand = new Random();
		int rm = rand.nextInt(2);
		
		for(int i = 0 ; i < 20 ; i++)
		{
			System.out.println(machine[rm].getDispenser()[i]);
		}
		
		
		double [] res = null;
		
		/*int maxTime = rand.nextInt(300);
		Reminder r = new Reminder(maxTime);
	    System.out.format("Task scheduled.%n");
	    System.out.format("You have " + maxTime + " Seconds to use the machine");*/
	   

		res = runVendingMachine(machine, rm);
		
		machine[rm].printReceipt((int)res[0], res[1],res[2],res[3]);
		saveTheInventory(machine);
		
	}

}
