import java.net.StandardSocketOptions;

/**
 * @file QuadraticFormular
 * @author 12humphreyd
 * to caculate an equation using the quaratic formular
 */
import java.util.*;
public class QuadraticFormular {
	
	public static int calcDiscriminate (int a, int b, int c)
	{
		int iResult;
		iResult = (b*b) - (4 * a * c);
		return iResult;
	}
	public static void main (String[] args) 
	{
		int a = 0;
		int b = 0;
		int c = 0;
		float fPos;
		float fNeg;
		int iDisc = 0 ;
		
		Scanner iInput = new Scanner (System.in);
		
		System.out.println("please enter your value for A");
		a = iInput.nextInt();
		System.out.println("please enter your value for B");
		b = iInput.nextInt();
		System.out.println("please enter your value for C");
		c = iInput.nextInt();
		
		iDisc = calcDiscriminate(a,b,c);
			
		if (iDisc >= 0)
		{
			fPos = ((-1 * b) + (float) Math.sqrt(iDisc))/(2*a);
			fNeg = ((-1 * b) - (float) Math.sqrt(iDisc))/(2*a);
			System.out.println("x = " + fPos);
			System.out.println("x = " + fNeg);
		}
		else 
		{
			System.out.println("error, your discriminant is a negative");
		}
		
		
	}	
	
}
