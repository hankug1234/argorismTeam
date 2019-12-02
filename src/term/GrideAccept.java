package term;

import java.util.LinkedList;

public class GrideAccept {
	public LinkedList<Data> list;
	public double weight;
	public double absWeight;
	public LinkedList<SeatCondition> seatList;
	public int limit;
	public double sum = 0.0;
	double total = 0.0;

	
	public GrideAccept(LinkedList<Data>l,int limit)
	{
		this.absWeight = weight;
		this.limit = limit;
		this.list = l;
		
		this.sort(l);
		
	}
	
	public Schedule run()
	{
		Schedule re = new Schedule();
		re.client = new LinkedList<Data>();
		double cWeight = 0.0;
	
		for(int i=0;i<list.size();i++)
		{
			if(cWeight< (double)limit)
			{
				this.total+=list.get(i).value;
				re.client.addFirst(list.remove(i));
			}
		}
		
	
		return re;
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
				priority = list.getFirst().time;
				for( i = 0;i<New.size();i++)
				{
					if(priority>(New.get(i).time))
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
	
	
	
}
