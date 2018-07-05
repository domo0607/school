/**
 * @file BirthdayDate
 * @author 12humphreyd
 * working out the age according to month
 */
import java.util.*;
import java.util.Calendar;

public class BirthdayDate {

	public static void main(String[] args) 
	{
		
		int dob;
		int currentYear;
		int ageNow;
		int ageLast;
		int ageNext;
		int currentMonth;
		int currentDate;
		int yearBorn;
		int monthBorn;
		int dayBorn;
		
		
		Scanner kb = new Scanner (System.in);
		Calendar cal = Calendar.getInstance();
		currentYear = cal.get(Calendar.YEAR);
		currentMonth = cal.get(Calendar.MONTH);
		currentDate = cal.get(Calendar.DATE);
		
		System.out.println("Greetings Stranger");
		
		System.out.println("What year were you born in?");
		yearBorn = kb.nextInt();
		System.out.println("What month were you born in? (as a number)");
		monthBorn = kb.nextInt();
		System.out.println("What day were you born?");
		dayBorn = kb.nextInt();
		
		if (monthBorn < currentMonth)
		{
			yearBorn = yearBorn;
		}
			
		else if (monthBorn > currentMonth)
		{
			yearBorn = yearBorn - 1;
		}
		
		else if (monthBorn == currentMonth)
		{
			if (dayBorn <= currentDate)
			{
				yearBorn = yearBorn ;
			}
			else if (dayBorn > currentDate)
			{
				yearBorn = yearBorn + 1;  
			}
		}
		
		
		ageNow = currentYear - yearBorn;
		System.out.println("You are currently " + ageNow + " years old." );
		ageLast = currentYear - yearBorn -1;
		System.out.println("You were " + ageLast + " years old last year.");
		ageNext = currentYear - yearBorn +1;
		System.out.println("You will be " + ageNext + " years old next year.");
		
		
		
	}

}
