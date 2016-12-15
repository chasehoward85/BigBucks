import java.io.*;
import java.util.*;
import java.text.*;

public class Tester {

	public static void main(String[] args) {

		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
		String name;
		List<BankAccount>aryLst = new ArrayList<BankAccount>();
		
		do{
			Scanner kbReader = new Scanner(System.in);
			System.out.println("Please enter the name to whom the account belongs. (\"Exit\" to abort)");
			name = kbReader.nextLine();
	
			if(!name.equalsIgnoreCase("EXIT")){
				System.out.println("Please enter the amount of the deposit.");
				Double amount = kbReader.nextDouble();
				System.out.println(" ");
				aryLst.add(new BankAccount(name, amount));
			}
		}while(!name.equalsIgnoreCase("EXIT"));

		BankAccount ba = aryLst.get(0);
		double maxBalance = ba.balance;
		String maxName = ba.name;
		
		for(int j = 1; j < aryLst.size(); j++){
			
			BankAccount ab = aryLst.get(j);
			if(ab.balance > maxBalance){
				maxBalance = ab.balance;
				maxName = ab.name;
			}
		}
		System.out.println("The account with the largest balance belongs to " + maxName);
		System.out.println("The amount is $" + maxBalance);
	}
}