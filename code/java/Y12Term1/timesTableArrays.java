import java.io.IOException;
import java.util.*;

public class timesTableArrays {
	
	public static void main (String[] args) throws IOException {
	
		int x=0;
		int y=0;
		int[][] iNum;
		String sz = "";
		
		
		iNum = 	new int [12] [10];
		
		for (y=0; y < iNum[y].length ; y++ )
		{
			for (x=0; x < iNum.length ; x++ ) 
			{
				iNum[x][y] = (x+1) * (y+1);
			}
		}
		
		for (y=0; y < iNum[y].length ; y++ ) 
		{
			sz = (y+1) + "\t";
			for (x=0; x < iNum.length ; x++ ) 
			{
				sz = sz + "\t" + iNum[x][y];
			}
			System.out.println(sz);
		}
	}

}
