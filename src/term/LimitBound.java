package term;
import java.util.*;

public class LimitBound {
	
	public LinkedList<Data> list;
	public Heap heapQueue = new Heap();
	public double weight;
	
	public LimitBound(LinkedList<Data> l,double weight)
	{
		list = l;
		this.weight = weight;
		sort(l);
		Data dd = start();
		System.out.println("index:"+dd.index+" weight:"+dd.weight+" value:"+dd.value);
	}
	
	public void sort(LinkedList<Data> l)
	{
		double weight, value, priority;
		LinkedList<Data> New = new LinkedList<Data>();
		int i;
		while(!list.isEmpty())
		{
			if(New.isEmpty())
			{
				New.addFirst(list.removeFirst());
			}
			else
			{
				priority = list.getFirst().value/list.getFirst().weight;
				for( i = 0;i<New.size();i++)
				{
					if(priority>(New.get(i).value/New.get(i).weight))
						{New.add(i,list.removeFirst());
						break;
						}
				}
				if(i == New.size())
					New.add(i,list.removeFirst());
					
			}	
		}
		list.clear();
		list = New;
		
	}
	
	public Schedule run()
	{
		Data d = start();
		Schedule re = new Schedule();
		re.client = this.find(d.index);

		return re;
	}
	
	private Data start()
	{Data dd,ll,rr,re;
	double weight,value,best,best2;
	dd = new Data(searchBound(1,0,0),0,0);
	dd.index = 1;
	best = dd.value;
	heapQueue.insert(dd);
	re = dd;
		while(!heapQueue.heap.isEmpty())
		{
			
			dd = heapQueue.delete();
				weight = list.get(height(dd.index)).weight;
				value = list.get(height(dd.index)).value;
				ll = new Data(searchBound(2*dd.index,dd.weight+weight,dd.value+value),dd.weight+weight,dd.value+value);
				rr = new Data(searchBound(2*dd.index+1,dd.weight,dd.value),dd.weight,dd.value);
				ll.index = 2*dd.index;
				rr.index = 2*dd.index+1;
			    if(ll.value>best)
			    {
			    	if(ll.weight<=this.weight)
			    	{
			    	best = ll.value;
			    	re = ll;
			    	}
			    }
			    if(rr.value>best)
			    {
			    	if(rr.weight<=this.weight)
			    	{
			    	best = rr.value;
			    	re = rr;
			    	}
			    }
			    if(ll.bound>best&&ll.weight<this.weight)
			    	heapQueue.insert(ll);
			    if(rr.bound>best&& rr.weight<this.weight)
			    	heapQueue.insert(rr);
			
		}
	 	return re;
	}
	
	private double searchBound(int index,double weight,double value)
	{
		int count = height(index);
		double w=weight,v=value;
		int num = index;
		if(weight>this.weight)
			return 0;
		
		while(height(2*index)<list.size() && w+list.get(count).weight<this.weight)
		{
			index = 2*index;v+=list.get(count).value; w+=list.get(count).weight; count = height(index);
		}
		if(height(2*index)>=list.size())
		{ 
			 if(height(2*num)>list.size())
				return v;
			  else
				v+=(this.weight-w)*(list.get(count).value/list.get(count).weight);
			
		}
		else
		{
			v+=(this.weight-w)*(list.get(count).value/list.get(count).weight);
		}
		return v;
	}
	
	private int height(int index)
	{
		return (int)(Math.log(index)/Math.log(2));
	}
	
	public LinkedList<Data> find(int index)
	{LinkedList<Data> client = new LinkedList<Data>();
		int h = 1;
	
		for(int i=0;i<this.list.size();i++)
 		{
 			this.list.get(i).removeState = false;
 		}
		
		while(h > 0)
		{
			h = (int)(this.height(index)-1);
			if(index%2 == 0)
			{  
				client.addFirst(this.list.get(h));
				this.list.get(h).removeState = true;
			}
			index = (int)(index/2);
		}
		
		LinkedList<Data> newone = new LinkedList<Data>();
		
 		for(int i=0;i<this.list.size();i++)
		{
			if(!this.list.get(i).removeState)
			{
				newone.addLast(this.list.get(i));
			}
			else
			{
				this.list.get(i).removeState = false;
			}
		}
 		
 		for(int i=0;i<client.size();i++)
 		{
 			client.get(i).removeState = false;
 		}
 		
 		this.list = newone;
 			
		return client;
	}

}
