import java.util.Scanner ;

public class CaesarEncryption 
{

	public static char [] splitString (char [] cMessageSplit, String szMessage)
	{
		for( int i = 0 ; i < cMessageSplit.length; i++)
		{
			cMessageSplit[i] = szMessage.charAt(i) ;
		}


		return cMessageSplit  ;
	}

	//encrypts message and converts back into string
	public static String encryptString (char [] cMessageSplit, int iShift, String szEncrypted) 
	{
		for (int i = 0 ; i < cMessageSplit.length ; i++)
		{
			//shift the char by iShift
			cMessageSplit [i] += iShift ;
			if (cMessageSplit[i] > 'z')
			{
				cMessageSplit[i] = (char) (cMessageSplit[i] - 26) ;
			}
		}

		//turns cMessageSplit back into String
		szEncrypted = new String (cMessageSplit) ;

		return szEncrypted ;
	}

	//decrypts message and converts back into string
	public static String decryptString (char [] cMessageSplit, int iShift, String szDecrypted) 
	{
		for (int i = 0 ; i < cMessageSplit.length ; i++)
		{
			//shift the char by iShift
			cMessageSplit [i] -= iShift ;
			if (cMessageSplit[i] < 'a')
			{
				cMessageSplit[i] = (char) (cMessageSplit[i] + 26) ;
			}
		}

		//turns cMessageSplit back into String
		szDecrypted = new String (cMessageSplit) ;

		return szDecrypted ;
	} 

	//breaks code
	public static String decodeString (char [] cMessageSplit, String szDecoded)
	{
		for (int x = 0 ; x < 26 ; x++)
		{
			for (int i = 0 ; i < cMessageSplit.length ; i++)
			{
				//shift the char by iShift
				cMessageSplit [i] += x ;



			}
		}
		return szDecoded ;
	}

	public static void main(String[] args)
	{
		// variables
		Scanner sc ;

		//shift variables
		String szChoice ;
		int iShift ; 

		//Strings
		String szMessage ;
		String szEncrypted = null ;
		String szDecrypted = null ; 
		String szDecoded = null ;
		char [] cMessageSplit ;

		sc = new Scanner(System.in) ;
		System.out.println("Welcome") ;
		System.out.println("Would you like to encrypt or decrypt? (e/d)") ;
		szChoice = sc.nextLine() ;

		//if statement, encrypt or decrypt
		if (szChoice.substring(0, 1).toLowerCase().compareTo("e") == 0 )
		{
			//taking in what the user wants the shift to be and message to encrypt
			System.out.println("What is the message you would like to encrypt?") ;
			szMessage = sc.nextLine() ;
			System.out.println("What would you like the shift to be?") ;
			iShift = sc.nextInt() % 26 ;
			cMessageSplit  = new char [szMessage.length()] ;
			splitString(cMessageSplit, szMessage) ;//function to split string into char array
			szEncrypted = encryptString(cMessageSplit, iShift, szEncrypted) ;//function that carries out the shift 

			//print out the new encrypted message

			System.out.println("Your new encrypted message is: ") ;
			System.out.println(szEncrypted) ;


		}else if (szChoice.substring(0, 1).toLowerCase().compareTo("d") == 0 )

		{
			System.out.println("What is the code you would like to decrypt?") ;
			szMessage = sc.nextLine() ;
			System.out.println("What is the shift?") ;
			iShift = sc.nextInt() % 26 ;
			cMessageSplit  = new char [szMessage.length()] ;
			splitString(cMessageSplit, szMessage) ;//function to split string into char array
			szDecrypted = decryptString(cMessageSplit, iShift, szEncrypted) ;//function that carries out the shift 

			//print out the message
			System.out.println( "This is your message: " + szDecrypted) ;

		}
		else if (szChoice.substring(0, 1).toLowerCase().compareTo("b") == 0 )

		{
			System.out.println("What is the code you would like to breal?") ;
			szMessage = sc.nextLine() ;
			cMessageSplit  = new char [szMessage.length()] ;
			splitString(cMessageSplit, szMessage) ;//function to split string into char array
			szDecoded = decodeString(cMessageSplit, szDecoded) ;




		}
		else
		{
			System.out.println("You did not enter 'encrypt' or 'decrypt'") ;
		}

		sc.close() ;
	}

}
