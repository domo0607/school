import java.io.*;

public class Arrays {
	
	public static void main (String[] args) throws IOException 
	{
		int iInput ;
		int [] iNum = new int [12];
		String sz;
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("What number do you want to have the times table for?");
		sz = br.readLine();
		iInput = Integer.parseInt(sz);
		
		for (int i = 0; i < iNum.length; i++) {
			iNum[i] = iInput * i;	
		}
		for(int i = 0; i< iNum.length; i++) {
			System.out.println(iNum[i]);
		}
	}
	
}
