import java.io.IOException;
import java.util.*;

public class randomNumFreq {
	
	public static void main (String[] args) throws IOException
	{
		int [] iRand;
		int [] iFreq;
		int iStart;
		int iEnd;
		int iAmount;

		Random rnd = new Random(); // Creating a random number generator
		Scanner kb = new Scanner(System.in);
		
		System.out.println("How many numbers do you want to generate?");
		iAmount = kb.nextInt(); // Take in the amount of values wanted to generate
		
		System.out.println("Start value?");
		iStart = kb.nextInt(); // Take in the start value
		
		System.out.println("End value?");
		iEnd = kb.nextInt(); // Take end value
		
		kb.close();
		
		iRand = new int [iAmount]; // Creating the array
		iFreq = new int [iEnd - iStart + 1];
		
		System.out.print("\n" + "Your values = ");
				
		for (int i = 0; i < iRand.length; i++) 
		{
			iRand[i] = rnd.nextInt((iEnd + 1) - iStart) + iStart;
			System.out.print(iRand[i] + " ");
			iFreq[iRand[i] - iStart] += 1 ;
		}
		
		System.out.println("\n") ;
		
		for (int i = 0; i < iFreq.length; i++) 
		{
			System.out.println( "i = "+(i+iStart) + " freq = " + iFreq[i]);
		}
	}
}
