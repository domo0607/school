import java.util.Random;

public class InsertionSort {

	public static int list[] = new int[10];

	public static void populateList() {
		int i;
		Random rnd = new Random();
		for (i = 0; i < list.length; i++) {
			list[i] = rnd.nextInt(20);
		}
	}

	public static void printList() {
		populateList();
		for (int i = 0; i < list.length; i++) 
		{
			System.out.print(list[i] + " ");
		}
	}
	public static void main(String[] args) {
		int i =1;
		int j;
		
		while (i < list.length);
		j = i;
		while ((j > 0)&& list[j-1] > list[j]);
		
	
	

	}

}
