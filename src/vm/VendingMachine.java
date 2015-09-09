package vm;

import java.io.Serializable;

public class VendingMachine implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dispenser [] dispenser;
	private String name;
	private double saleTotal;
	public VendingMachine(Dispenser [] d,String name)
	{
		dispenser = d;
		this.name = name;
		saleTotal = 0 ;
	}
	
	public void totalSubtotalReceipt()
	{
		System.out.println("Sale Total: " + saleTotal);
		for(int i = 0 ; i < dispenser.length ; i++)
		{
			if(dispenser[i].getNumber() < dispenser[i].getMax())
			{
				int temp = dispenser[i].getMax() - dispenser[i].getNumber(); 
				System.out.println("Sale Subtotal of dispenser : " + i + "is " + temp * dispenser[i].getPrice());
			}
		}
	}
	public void printReceipt(int dispenserIndex,double balance,double totalMoney,double totalPurchase)
	{
		try {
			System.out.println("Reciept: " );
			System.out.println("Total amount paid: " +  totalMoney);
			double change =  balance ;
			System.out.println("total Purchase: " + totalPurchase);
			System.out.println("Change: " +  change);
			System.out.println("You have purchased at vending machine"
			+ this.name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	public void vmcalc(int dispenserNumber)
	{
		saleTotal += this.getDispenser()[dispenserNumber].getPrice();
		this.getDispenser()[dispenserNumber].setNumber(this.getDispenser()[dispenserNumber].getNumber() - 1) ;
	}
	
	
	//getter and setter 
	public Dispenser[] getDispenser() {
		return dispenser;
	}
	public void setDispenser(Dispenser[] dispenser) {
		this.dispenser = dispenser;
		}
	public String getName() {
		return name;		}
	public void setName(String name) {	
		this.name = name;
		}
		@Override
	public String toString() {
		return "VendingMachine [name=" + name + "]";
	}
		
	
		
}
