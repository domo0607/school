/**
 * @flile TimesTable
 * @author 12humphreyd
 * Basic code example
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TimesTables
{
	public static void main ( String [] args ) throws IOException
	{
		//declare variables and initialising a & b, but not c
		String NL = System.getProperty("line.separator");
		int q ;
		char cLetter = 'a' ;
		Scanner input = new Scanner(System.in);


		System.out.println(NL) ;
		
		for (q=0; q<26; q++ )
		{
			System.out.println( (char) ( 'a' + q ) ) ;
		}
		System.out.println(NL) ;
		
		do
		{
			System.out.println(cLetter) ;
			cLetter =  (char) ( cLetter + 1 )  ;
		}while ( cLetter <= 'z' );
		
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in) ) ;
		
		
		
				
        System.out.println("Which times table do you need to learn?");//taking the input
        int number;
        number = input.nextInt();
        System.out.println("Here is the table.");
        if(number<0)
        {
            number = (-1)*number; //making the number positive
        }
        if(number>=2&&number<=12)
        {
            for(int i=1;i<=12;i++)//adding the numbers a specific amount of times
            {
                System.out.println(number + " " + "x " + i + " =" + ( number * i ));
            }
        }
        else
        {
            System.out.println("Enter numbers from 2 to 12 only");//creating a 
            System.exit(number);
        }
        
   	return;
	}
}
