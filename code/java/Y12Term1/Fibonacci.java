import java.io.IOException ;

public class Fibonacci {
	
	public static void main ( String args [] ) throws IOException
	{
		@SuppressWarnings("unused")
		int iNum, i, j , k, iTemp ;
		j=1;
		k=1;
		System.out.println("Position: 1. Value: " + j ) ;
		System.out.println("Position: 2. Value: " + k ) ;
		for ( i = 3 ; i<=10 ; i++ )
		{
			iNum = j + k ;
			System.out.println("Position: " + i + ". Value: " + iNum ) ;
			//will need to increase values of j & k
			// to set the next values. Requires a swap. Do a dry run.
			iTemp = j ;
			j = k ;
			k = iNum ;
		}
		return;
	}

}
