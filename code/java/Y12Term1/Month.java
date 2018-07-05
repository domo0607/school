/**
 * @File Month
 * @author 12humphreyd
 * Printing out the month number with the month 
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Month 
{
	public static void main ( String [] args ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in) ) ;
		int iNum;
		String szMonth;
		String szSelection ;
		int iMonth; 

		System.out.println("Select which one you want to do");
		System.out.println("A | Select the number of the month you want");
		System.out.println("B | Select the Name to convet to the number");
		szSelection = br.readLine().toLowerCase();
		{

			if (szSelection.equals("a")) ;
			{

				System.out.println("Enter the number of the month between 1 and 12") ;
				iNum  = Integer.parseInt(br.readLine()) ; 


				if (iNum == 1)	System.out.println("January");	
				if (iNum == 2)	System.out.println("February");
				if (iNum == 3) 	System.out.println("March");
				if (iNum == 4) 	System.out.println("April");
				if (iNum == 5) 	System.out.println("May");
				if (iNum == 6) 	System.out.println("June");
				if (iNum == 7) 	System.out.println("July");
				if (iNum == 8) 	System.out.println("August");
				if (iNum == 9) 	System.out.println("September");
				if (iNum == 10) System.out.println("October");
				if (iNum == 11) System.out.println("November");
				if (iNum == 12) System.out.println("December");
			}

			if (szSelection.equals("b")) ;
			{
				System.out.println("Enter a month") ;
				szMonth = br.readLine().toLowerCase();
				if (szMonth.startsWith("jan")) System.out.println("1");
				if (szMonth.startsWith("f")) System.out.println("2");
				if (szMonth.startsWith("mar")) System.out.println("3");
				if (szMonth.startsWith("apr")) System.out.println("4");
				if (szMonth.startsWith("may")) System.out.println("5");
				if (szMonth.startsWith("jun")) System.out.println("6");
				if (szMonth.startsWith("jul")) System.out.println("7");
				if (szMonth.startsWith("aug")) System.out.println("8");
				if (szMonth.startsWith("s")) System.out.println("9");
				if (szMonth.startsWith("o")) System.out.println("10");
				if (szMonth.startsWith("n")) System.out.println("11");
				if (szMonth.startsWith("d")) System.out.println("12");
			}
		}
		return ;
	}	
}
