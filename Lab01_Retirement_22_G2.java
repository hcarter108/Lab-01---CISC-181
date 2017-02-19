// 022-G2 - Hayden Carter, Taylor Bruno, Tianyi Cao
import java.util.Scanner;

public class Lab01_Retirement_22_G2 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// Instance of Scanner for inputs to our functions\
		// Kept input structure same as Assignment, all calculations done towards end
		// Throughout lab, initialize variables at -1 so as to use while statements to keep values positive, in case input is incorrect
		
		// Years expected to work
		double years2Work=-1;
		while(years2Work<0) {
			System.out.println("Enter years expected to continue working: ");
			years2Work=input.nextDouble();
			if(years2Work<0.00)
				System.out.println("Enter a positive number");
		}
		
		// Annual return rate while working
		double annualRet2=-1;
		while(annualRet2<0.00 || annualRet2>0.20)  {
			System.out.println("Enter an Annual Return Rate for while working in decimal form between 0.00 and 0.20: ");
			annualRet2=input.nextDouble();
			if(annualRet2<0.00 || annualRet2>0.20) 
				System.out.println("Enter a number in specified range");
		}
		
		// Years user expects to be retired
		double yearsRetired=-1;
		while(yearsRetired<0) {
			System.out.println("Enter years expected to be retired: ");
			yearsRetired=input.nextDouble();
			if(yearsRetired<0.00)
				System.out.println("Enter a positive number");
		}	
		
		// Annual return rate during retirement
		double annualRet1=-1;
		while(annualRet1<0.00 || annualRet1>0.03) {
			System.out.println("Enter an Annual Return Rate during retirement in decimal form between 0.00 and 0.03: ");
			annualRet1=input.nextDouble();
			if(annualRet1<0.00 || annualRet1>0.03)
				System.out.println("Enter a number within the specified range");
		}	
		
		// Required Income during retirement
		double reqIncome=-1;
		while(reqIncome<0.00) {
			System.out.println("Enter a required Monthly Income: ");
			reqIncome=input.nextDouble();
			if(reqIncome<0.00)
				System.out.println("Enter a positive number");
		}
		
		// Monthly SSI
		double MSSI=-1;
		while(MSSI<0.00 || MSSI>2642.00) {
			System.out.println("Enter a Monthly SSI bewtween $0.00 and $2642.00: ");
			MSSI=input.nextDouble();
			if(MSSI<0.00 || MSSI>2642.00)
				System.out.println("This value is not within the specified range");
		}
		
		// Assignments to simplify appearance of my overall calculation
		double incomeDifference = reqIncome - MSSI;
		double calcFactor1=(1+annualRet1/12);
		double calcFactor2=((1-(1/Math.pow(calcFactor1, yearsRetired*12))))/(annualRet1/12);
		
		// Amount needed to save, used later for savings per month
		double amount2Save = incomeDifference*calcFactor2;
		

		// Further assignments to simplify appearance of overall calculations
		double calcFactor3=(1+annualRet2/12);
		double calcFactor4=(Math.pow(calcFactor3,years2Work*12)-1)/(annualRet2/12);
		
		// Final calculation for the amount that needs to be saved per month
		double monthlySavings = amount2Save/calcFactor4;
		
		// Print amount to be saved, used the Math method to round to 2 decimal places
		System.out.println("The amount that needs to be saved per month is $" + Math.round(monthlySavings*100.0)/100.0);
		// Close input instance, Eclipse warned of "resource leak"
		input.close();
	}

}
