import java.util.Scanner;

public class Main {
	int input;

	public Main() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		
		try{
			
	//		Scanner scanner = new Scanner(System.in);
			 
	//		System.out.print("Please enter the list of desired number"+"\n");
			
			PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(100);
			priorityQueue.Insert(4);
			priorityQueue.Insert(3);
			priorityQueue.Insert(10);
			priorityQueue.Insert(2);
		//	priorityQueue.BuildHeap();
			priorityQueue.printArray();
			
			System.out.print("min : "+ priorityQueue.ExtractMin()+"\n");
			priorityQueue.printArray();
			System.out.print("\n########"+"\n");
			priorityQueue.DeleteByValue(4);
			priorityQueue.printArray();
			System.out.print("\n******"+"\n");
			
			priorityQueue.ChangeKey(3, 15);
			priorityQueue.printArray();
			System.out.print("\n------"+"\n");
			priorityQueue.Insert(11);
			priorityQueue.printArray();
			priorityQueue.ChangeKey(11, 1);
			System.out.print("\n------"+"\n");
			priorityQueue.printArray();
		
			PriorityQueue<String> pq=new PriorityQueue<String>(100);
			pq.Insert("C");
			pq.Insert("B");
			pq.Insert("Ro");
			pq.Insert("Ele");
			pq.Insert("Bala");
			pq.printArray();
			pq.ChangeKey("Ro", "A");
			pq.printArray();
			pq.DeleteByValue("B");
			pq.printArray();

			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}

	}

}
