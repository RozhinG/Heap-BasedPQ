import 	java.util.*;

public class PriorityQueue<T extends Comparable <T>> {
	
	public class HeapNode<T>{
		T Item;
		int priority;
		
		public HeapNode(T value,int pri) {
			this.Item=value;
			this.priority=pri;
		}
		
		public T getItem() {
			return Item;
		}
		public void setItem(T item) {
			Item = item;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		
	}
	
	 int current_size;
     int Max_capacity;
	 ArrayList<HeapNode<T>> arrlist ; 
	 HashMap< T, Integer> LookUp; ///maping value to index
     public ArrayList<HeapNode<T>> getArrlist() {
		return arrlist;
	}

	public void setArrlist(ArrayList<HeapNode<T>> arrlist) {
		this.arrlist = arrlist;
	}

	public HashMap<T, Integer> getLookUp() {
		return LookUp;
	}

	public void setLookUp(HashMap<T, Integer> lookUp) {
		LookUp = lookUp;
	}

	
	
	


	public PriorityQueue(int cap) {
		// TODO Auto-generated constructor stub
		this.current_size=0;
	    this.arrlist=new ArrayList<HeapNode<T>>();
		this.Max_capacity=cap;
		this.LookUp=new HashMap<T,Integer>();
	
				
	}
	
	  public void swap(int index1,int index2)
	   {
		   HeapNode<T> node1=this.arrlist.get(index1);
		   HeapNode<T> node2=this.arrlist.get(index2);
		  this.arrlist.set(index1, node2);
		  node2.setPriority(index1);
		  this.arrlist.set(index2, node1);   
		  node1.setPriority(index2);
		  //update the priority of a node
		  this.LookUp.put(node1.getItem(),index2);
		  this.LookUp.put(node2.getItem(),index1);
	   }
	

	public void printArray() {
		
	//	int occupied=(this.Max_capacity-this.current_size)+1;

		for(int i=0;i<this.current_size;i++)
		 System.out.print(this.arrlist.get(i).getItem()+"\n");
		System.out.print("---------\n");
		
	}
	
	public void populateLookupTable()
	{
		for(HeapNode<T> i:this.arrlist)
		{
			this.LookUp.put(i.getItem(),i.getPriority());
			System.out.print("\n");
			System.out.print( i.getItem()+"\t"+this.LookUp.get(i.getItem())+"\n");
		}
		
		
			
	}
	
	
    public int parent(int index)
    {
    	int i=(int) Math.floor((index-1)/2);
        return i;
    	
    }
    
    public int leftChild(int i)
    {
    	return 2*i+1;
    }
   public int rightChild(int i)
   {
	   return 2*i+2;
   }
 

   void Heapify_down(int index)
   {
	   int smallest_index;
	    int left;
	    int right;

	        smallest_index=index;
	        left=leftChild(index);
	        right=rightChild(index);
	        ///determining the smallest element
	        if(left<this.current_size && this.arrlist.get(left).getItem().compareTo(this.arrlist.get(smallest_index).getItem())<0)
	            smallest_index=left; ///left child index
	        if(right<current_size && this.arrlist.get(right).getItem().compareTo(this.arrlist.get(smallest_index).getItem())<0)
	            smallest_index=right;

	        ///once we decided now swap the values
	        if(smallest_index !=index)
	        {
	         this.swap(index,smallest_index);
	         this.Heapify_down(smallest_index);
	        }


   }
   public void BuildHeap()
   {
	   int LastParent=this.current_size/2-1;

	     for(int i=LastParent;i>=0;i--)
	        this.Heapify_down(i);
   }
     
  
   public void Heapify_up(int index)
    {
	   int prnt=this.parent(index);
	     if(this.arrlist.get(prnt).getItem().compareTo(this.arrlist.get(index).getItem())>0&& index!=0)
	    {
	        this.swap(prnt,index);
	        this.Heapify_up(prnt);
	    }
	    else
	        return;
    }
   
   public void Insert(T value)
   {
	   if(this.current_size==this.Max_capacity)
	    {
	        System.out.print("there is no extra spaces. program will terminate.");
	        return;
	    }
	    else{
	    	HeapNode<T> node= new HeapNode(value,this.current_size);
	    	this.LookUp.put(value, this.current_size);
	    	this.arrlist.add(node);
	        this.current_size++;
	        int index=this.arrlist.indexOf(node);
	        int prnt=this.parent(index);

	   	    if(this.arrlist.get(prnt).getItem().compareTo(this.arrlist.get(index).getItem())>0)
	   	        this.Heapify_up(index);
	   	    else
	   	        this.Heapify_down(index);
	    }
   }
   

   public void Insert(HeapNode<T> node)
   {
	   if(this.current_size==this.Max_capacity)
	    {
	        System.out.print("there is no extra spaces. program will terminate.");
	        return;
	    }
	    else{
	    //	HeapNode<T> node= new HeapNode(value,this.current_size);
	    	this.LookUp.put(node.getItem(), node.getPriority());
	    	this.arrlist.add(node);
	        this.current_size++;
	        int index=this.arrlist.indexOf(node);
	        int prnt=this.parent(index);

	   	    if(this.arrlist.get(prnt).getItem().compareTo(this.arrlist.get(index).getItem())>0)
	   	        this.Heapify_up(index);
	   	    else
	   	        this.Heapify_down(index);
	    }
   }
   

public T FindMin()throws NullPointerException
   {
	   if(this.current_size==0)
	    {
	     //  throw ("no element left. program will terminate."+"\n");
		   return null; 
	    }
	   if(this.current_size>1)
	    {
	    	return this.arrlist.get(0).getItem();
	    }
	return null;

	
   }

public HeapNode<T> FindMinByNode()throws NullPointerException
{
	   if(this.current_size==0)
	    {
	     //  throw ("no element left. program will terminate."+"\n");
		   return null; 
	    }
	   if(this.current_size>1)
	    {
	    	return this.arrlist.get(0);
	    }
	return null;

	
}
   
   public T ExtractMin()throws NullPointerException
   {
	   HeapNode<T> minimum;

	   if(this.current_size==0)
	    {
	        System.out.print("no element left. program will terminate."+"\n");
	        return null ;
	    }
	    else if(this.current_size==1)
	    {
	    	  minimum=this.arrlist.get(0);
	        this.current_size--;
	        return minimum.getItem();
	    }

	    minimum=this.arrlist.get(0);
	    this.swap(0,this.current_size-1);
	    this.arrlist.remove(this.current_size-1);
	    this.current_size--;
	    this.LookUp.remove(minimum.getItem());
	    this.Heapify_down(0);
	    return minimum.getItem();
	   
   }
   public HeapNode<T> ExtractMinByNode()throws NullPointerException
   {
	   HeapNode<T> minimum;

	   if(this.current_size==0)
	    {
	        System.out.print("no element left. program will terminate."+"\n");
	        return null ;
	    }
	    else if(this.current_size==1)
	    {
	    	  minimum=this.arrlist.get(0);
	        this.current_size--;
	        return minimum;
	    }

	    minimum=this.arrlist.get(0);
	    this.swap(0,this.current_size-1);
	    this.arrlist.remove(this.current_size-1);
	    this.current_size--;
	    this.LookUp.remove(minimum.getItem());
	    this.Heapify_down(0);
	    return minimum;
	   
   }
   
   public void Delete(int index)
   {
	 ///we need to swap the values at index and the last item in the array
	    ///then if current value is less than the parent heapify up otherwise heapify down.
	   if(this.current_size==0)
	    {
	        System.out.print("no element left. program will terminate."+"\n");
	        return ;
	    }
	   
	    this.swap(index,this.current_size-1);
	    this.LookUp.remove(this.arrlist.get(this.current_size-1).getItem());
	    this.arrlist.remove(this.current_size-1);
	    this.current_size--;
	    
	    int prnt=this.parent(index);

	    if(this.arrlist.get(prnt).getItem().compareTo(this.arrlist.get(index).getItem())>0 )
	        this.Heapify_up(index);
	    else
	        this.Heapify_down(index);

	   
   }
   
   public void DeleteByValue(T value)
   {
	   if(!this.LookUp.containsKey(value))
	   {
		   System.out.print("no element left. program will terminate."+"\n");
		   return;
	   }
	   int pri=this.LookUp.get(value);

	   this.Delete(pri);
   }
 
   public void DeleteByNode(HeapNode<T> node)
   {
	   if(!this.LookUp.containsKey(node.getItem()))
	   {
		   System.out.print("no element left. program will terminate."+"\n");
		   return;
	   }
	   int pri=this.LookUp.get(node.getItem());

	   this.Delete(pri);
   }
   public void ChangeKey(T value,T newValue)
    {
	   if(!this.LookUp.containsKey(value))
	   {
		   System.out.print("no element left. program will terminate."+"\n");
		   return;
	   }
    	 int priority=this.LookUp.get(value);///=position[value];
    	 
    	 this.LookUp.remove(value);
    	 this.arrlist.get(priority).setItem(newValue);
    	 this.arrlist.set(priority, this.arrlist.get(priority));

    	 
    	   

    	   int prnt=this.parent(priority);

   	    if(this.arrlist.get(prnt).getItem().compareTo(this.arrlist.get(priority).getItem())>0)
   	        this.Heapify_up(priority);
   	    else
   	        this.Heapify_down(priority);


    }
   
   public void ChangeKeyByNode(HeapNode<T> node1,HeapNode<T> node2)
   {
	   if(!this.LookUp.containsKey(node1.getItem()))
	   {
		   System.out.print("no element left. program will terminate."+"\n");
		   return;
	   }
   	 int priority=this.LookUp.get(node1.getItem());///=position[value];
   	 
   	 this.LookUp.remove(node1.getItem());
   	 this.arrlist.get(priority).setItem(node2.getItem());
   	 this.arrlist.set(priority, this.arrlist.get(priority));

   	 
   	   

   	   int prnt=this.parent(priority);

  	    if(this.arrlist.get(prnt).getItem().compareTo(this.arrlist.get(priority).getItem())>0)
  	        this.Heapify_up(priority);
  	    else
  	        this.Heapify_down(priority);


   }
  


}

