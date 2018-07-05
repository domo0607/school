/**
 * @flile HelloWorld
 * @author 12humphreyd
 * Basic code example
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloWorld
{
	public static void main ( String [] args ) throws IOException
	{
		//declare variables and initialising a & b, but not c
		int a = 12 ;
		int b = 5 ;
		int c ;
		String szName ;
		int age ;
		c = a % b ;
		String szSurname;
		char FirstLetterName;
		String LowerSur ;
		int year ;
		String NL = System.getProperty("line.separator");
		String szThanks ;
		int i ;
		String Hello = "Where Did You Go?" ;
		String Hey;
		String Goodbye;	//declare a variable and instantiate its storage
		char cLetter = 'a' ;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println(NL) ;
		
		for (i=0; i<26; i++ )
		{
			System.out.println( (char) ( 'a' + i ) ) ;
		}
		System.out.println(NL) ;
		
		do
		{
			System.out.println(cLetter) ;
			cLetter =  (char) ( cLetter + 1 )  ;
		}while ( cLetter <= 'z' );
		
		System.out.println(NL) ;
		
		System.out.println( "Hello Little Big Planet" ) ;
		
		Hey = Hello.toLowerCase() ;
		
		System.out.println( Hey ) ;
		
		Hello = "What Happened To You?" ;
		
		Goodbye = Hello.toUpperCase() ;
		
		System.out.println( Goodbye ) ;
		
		System.out.println( a + " + " + b + " = " + ( a + b ) ) ; 
		
		System.out.println(NL) ;																//line spaceing
		
																								//Taking an input
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in) ) ;
		System.out.println( "What is your forename?" );
		szName = br.readLine() ;																// getting input of there forename
		System.out.println(NL) ;
		System.out.println( "What is your surname?");
		szSurname = br.readLine() ;																// getting input of there surname
		System.out.println(NL) ;
		System.out.println( "Hello " + szName + " " + szSurname);
		System.out.println(NL) ;
		System.out.println( "How old are you " + szName + "?") ;
		age = Integer.parseInt(br.readLine()) ; 												//getting input of how old they are
		System.out.println(NL) ;
		System.out.println( szName + ", You will be " + (age+5) + " in five years time.") ;		//calculating how old they would be in 5 years
		System.out.println(NL) ;
		System.out.println(szName + " what year are you in?") ;
		year = Integer.parseInt(br.readLine()) ; 												//getting the year that they are in
		System.out.println(NL) ;
		LowerSur = szSurname.toLowerCase() ;
		FirstLetterName = szName.toLowerCase().charAt(0) ;
		
		System.out.println("Your username is " + (-year+24) + LowerSur + FirstLetterName);		//Printing out there username 
		
		szThanks = br.readLine() ; 
			 
				if ( szThanks.contentEquals("thanks")) {
					System.out.println("That's okay") ;
				}
				if (szThanks.contentEquals("Thats wrong")) {
					System.out.println("Are you sure?");
				}
				
		
			
	return;
	}

			
}


