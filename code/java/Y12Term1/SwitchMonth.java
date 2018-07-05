/**
 * @File SwichMonth
 * @author 12humphreyd
 * Printing out the month number with the month and seson
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwitchMonth 
{
	public static void main ( String [] args ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			
		int iMonth;
		String szMonth;
		int iSeason = 0;
		String szSeason;
		
		System.out.println("Enter the number of the month between 1 and 12") ;
		
		iMonth  = Integer.parseInt(br.readLine());
		
		switch (iMonth)
		{
			case (1):
				szMonth = "January";
				iSeason = 1 ;
			break;
			
			case (2):
				szMonth = "Febuary";
				iSeason = 1 ;
			break;
			
			case (3):
				szMonth = "March";
				iSeason = 2 ;
			break;
			
			case (4):
				szMonth = "April";
				iSeason = 2 ;
			break;
			case (5):
				szMonth = "May";
				iSeason = 2 ;
			break;
			
			case (6):
				szMonth = "June";
				iSeason = 3 ;
			break;
			
			case (7):
				szMonth = "July";
				iSeason = 3 ;
			break;
			
			case (8):
				szMonth = "August";
				iSeason = 3 ;
			break;
			case (9):
				szMonth = "September";
				iSeason = 4 ;
			break;
			
			case (10):
				szMonth = "October";
				iSeason = 4 ;
			break;
			
			case (11):
				szMonth = "November";
				iSeason = 4 ;
			break;
			
			case (12):
				szMonth = "December";
				iSeason = 1 ;
			break;
			
			default :
				szMonth = "error";
				break;
			}
		
		System.out.println(szMonth);
		
		switch (iSeason)
		{
			case (1):
				szSeason = "Winter";
				break;
				
			case (2):
				szSeason = "Spring";
				break;
				
			case (3):
				szSeason = "Summer";
				break;
				
			case (4):
				szSeason = "Autumn";
				break;
				
			default:
				szSeason = "error";
				break;
		}
		System.out.println(szSeason);
		
			

		}

	}


		
	
	

