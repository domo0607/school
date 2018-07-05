import java.util.Random;
import java.util.Scanner;

public class LinearSearch 
{


	public static int list[] = new int[10];

	public static void populateList() 
	{
		int i;
		Random rnd = new Random();
		for (i = 0; i < list.length; i++) 
		{
			list[i] = rnd.nextInt(20);
		}
		return ;
	}



	public static void main (String[] args) 
	{

		Scanner kb = new Scanner (System.in);
		int iInput;
		int position[] = new int [10];
		int i;
		int n = 0;
		populateList();
		for (i = 0; i < position.length; i++) 
		{
			position[i] = -1;
		}
		System.out.println("LinearSearchReplace: PRE-search  list contains:");
		printList(list);
		iInput = kb.nextInt();
		search(iInput, position);
		System.out.println("LinearSearchReplace: Your target number [element: " + iInput +"] found locations are at:");
		printList(position);
		replace(position);
		System.out.println("LinearSearchReplace: finish. ==== ");
		System.out.println("LinearSearchReplace: POST-replacement  list contains:");
		printList(list);
		return ;
	}



	private static void printList(int[] array) 
	{
		for (int j = 0; j < array.length; j++) 
		{
			System.out.print(array[j] + "  ");
		}
		System.out.println();
	}


	/**
	 * 
	 * @param iInput - what the user wants to search 
	 * @param position - the array of the position of the input in list
	 */
	private static void search(int iInput, int[] position) 
	{
		boolean bFound;
		bFound = false;
		int n = 0 ;

		for (int i = 0; i < list.length; i++) 
		{
			if (list[i] == iInput)
			{
				bFound = true ;
				position[n] = i;
				n = n+1;
			}
		}
		
		if (bFound == false) 
		{
			System.out.println("number not found");
		}
	}
	private static void replace(int[] position)
	{
		for (int i = 0; i < position.length; i++) 
		{
			
			if(position[i] == -1)
			{
				
			}
			else 
			{
				list[position[i]] = 99 ;
			}
		}
	}

}
