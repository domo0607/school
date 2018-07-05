import java.util.*;
import java.io.*;

/**
 * @file 
 * @author 12humphreyd
 * create a program where it will export the numbers 1-50 and for evry multiple of 3 say fizz and for every multiple of 5 say buzz
 */

public class FizzBuzz {

	/**
	 * function to see if the number is a multiple of 5, 
	 * this is done by seeing if there is a remainder as this can be found using 
	 * the % if there is no remainder then the number is a multiple of 5 and will output a true statement,
	 * if it has a remainder then it will output a false statement
	 * @param i
	 * @return
	 */
	public static boolean Buz (int i) //
	{

		if (i % 5 == 0)
		{
			return true ;
		}
		return false;
	}
	/**
	 * this function returns a true statement if the number contains the number 3
	 * it does this by changing the input of i into a string and then checking whether it is 
	 * contained using a if statement 
	 * @param i
	 * @return
	 */
	public static boolean Cont3 (int i)
	{
		String sz;
		
		sz = Integer.toString(i);
		if (sz.contains("3"))
		{
			return true;
		}
		return false;
	}
	public static boolean Cont5 (int i)
	{
		String sz;
		
		sz = Integer.toString(i);
		if (sz.contains("5"))
		{
			return true;
		}
		return false;
	}
	public static boolean Fizz (int i)
	{
		if (i % 3 == 0)
		{
			return true ;
		}
		return false;

	}

	public static void main (String[] args) 
	{
		int i = 1;

		// this allows us to set the number and the range and for it to count up one by one
		for ( i=1; i <= 30; i++)
		{
			// checks using the booleans that we made in the functions to see if it is true or false and then print it
			if (Fizz(i) && Buz(i) || Cont3(i) && Cont5(i))
			{
				System.out.println("fizzbuzz");
			}
			else if ( Fizz(i) || Cont3(i))
			{
				System.out.println("fizz");
			}
			else if ( Buz(i) || Cont5(i))
			{
				System.out.println("buzz");
			}
			else if (Cont3(i))
			{
				System.out.println("fizz");
			}
			
			// this prints if all the other statements are false, this is just printing the number so it only uses an else
			else
			{
				System.out.println(i);
			}
		}
	}

}