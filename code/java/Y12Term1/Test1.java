/**
 * @author Joe Bloggs
 * @file  Term 1 Test 2017-10-04
 * Question 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) throws IOException  
	{

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		int iNum =0 ;
		int i;
		int iAmount;
		String szAmount;
		int iResult;
		int iRemainder;

		System.out.println("Greatings user. This programme will find the arithmetic mean");
		System.out.println("Please type in the number of elements you will submit");
		szAmount = br.readLine(); 

		//taking the amount of integers they want
		iAmount = Integer.valueOf(szAmount).intValue();

		for ( i = 0; i < iAmount; i++ )
		{
			System.out.println("please enter your value:");
			iNum = iNum + Integer.parseInt(br.readLine()) ; 
			

		}
		
		iResult = iNum/iAmount;
		
		iRemainder = iNum % iAmount;
			
		System.out.println("Your mean is: " + iResult + " and " + iRemainder + "/" + iAmount);


	}

}


