import java.util.Random;

public class BubbleSort {
	public static int list[] = new int[10];

	public static void populateList() {
		int i;
		Random rnd = new Random();
		for (i = 0; i < list.length; i++) {
			list[i] = rnd.nextInt(20);
			
		}
	
	}

	
	
	public static void swap(int j,int i) {
		
		int k = list[j];
		list[i] = list[j + 1];
		list[j] = list[i];
		list[i] = k;
		
	}
		
	public static void sorting(){
		int i;
		int j;
		//*boolean bStop;
		for (i = 0; i < ( list.length - 1 ); i++) 
		{
			//*bStop = true ;
			System.out.println(list);
			for (j = 0; j <( list.length - i); j++) 
			{System.out.println(list);
				if (list[j] > list [j+1] ) 
				{
					swap(list[j], list[i]);
					
					//*bStop = false ; 
					System.out.println(list);
				}
				//*if (bStop == true) {
				//*break;
			}
			}
				
			
		}

	//*}
	
public static void printList() {
		populateList();
		for (int i = 0; i < list.length; i++) 
		{
			System.out.print(list[i] + " ");
		}
	}
	
		
	

	public static void main (String [] args)
	{
		populateList();
		printList();


	}

}

