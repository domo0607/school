import java.io.IOException;

public class TwoDArrays {
	public static void main (String[] args) throws IOException {
		
		int j;
		int i;
		String [][] szArray = new String [3][2];
		szArray[0][0]="jksrpua1";
		szArray[0][1]="jksrpua1A";
		szArray[1][0]="jksrpua2";
		
		
		
		for (j = 0; j < 3 ; j++ ) {
			
			for(i = 0 ; i < 2 ; i++) {
				System.out.println(szArray[j][i]);
			}
		}
	}


}
