import java.io.*;
import java.io.IOException;
public class fileHandling {


	public static void main(String[] args) throws IOException
	{

		String szFileName = "output.txt";
		int i = 0 ;
		String [] szOutput = {"a","b","c"};
		int [] iOutput = {1 , 3 , 7 , 11 };
		BufferedWriter bw = new BufferedWriter (new FileWriter(szFileName));

		for (i = 0; i < iOutput.length; i++) 
		{
			bw.write(iOutput[i]);

			bw.write("\n");

			System.out.println("Written" + i + "" );	

		}
		bw.close();	

	}

}
