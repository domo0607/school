import java.io.*;
import java.util.*;

public class SpeedEnforcement {         



	public static void main(String[] args) throws IOException 
	
	{
	
		String szReg[] = new String [4];
		int iSpeedlimit[] = new int [4];
		String szMotorway[] = new String [4];
		String szPrintMotorway;
		int iSpeed[] = new int [4];

		BufferedReader br = new BufferedReader ( new FileReader("speed.txt"));



		for (int i = 0; i < "speed.txt".length(); i++) 
		{
			szReg[i] = "speed.txt".substring(0,7);
			iSpeed[i] = Integer.parseInt("speed.txt".substring(16, 17));
			iSpeedlimit[i] = Integer.parseInt("speed.txt".substring(9, 10));
			szMotorway[i] = "speed.txt".substring(13,13);


			if (szMotorway[i].indexOf("M") == 0 ) 
			{
				szPrintMotorway = "motorway";
			}
			else 
			{
				szPrintMotorway = "NON-motorway";
			}
			System.out.println(szReg[i]);
		}

		

		
			System.out.println("report for vehical:       " + szReg);
			System.out.println("Speed limit:         70 on a motorway" );
			System.out.println("Recorded speed = " + iSpeed);
		}

	}





