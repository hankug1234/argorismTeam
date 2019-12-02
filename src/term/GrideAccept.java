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

	
	public GrideAccept(LinkedList<Data>l,double weight,LinkedList<SeatCondition> seatList,int limit)
	{
		this.weight = weight;
		this.absWeight = weight;
		this.limit = limit;
		this.seatList = seatList;
		this.list = l;
		
		this.sort(l);
		
	}
	
	public Schedule run()
	{
		Schedule re = new Schedule();
		re.client = new LinkedList<Data>();
		re.seatState = new LinkedList<SeatCondition>();
		
	
		for(int i=0;i<list.size();i++)
		{
			if(this.checkLimitCondition(list.get(i), this.limit, re)==true)
			{
				this.total+=list.get(i).value;
				re.client.addFirst(list.remove(i));
			}
		}
		
		System.out.println("subjectGrid:"+this.total);
		re.entire = this.seatList;
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
				priority = list.getFirst()
						.value/list.getFirst().weight;
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
	
	
	
	private boolean checkLimitCondition(Data d, int limit, Schedule re)
	{
		boolean result = false;
	    double num = d.weight;
	    double devide = 0.0;
	    
	    
	    for(int j=1;j<=limit;j++)
	    {
	    	devide = (double)j;
	    	num =Math.ceil(num/devide);
	    	if(num == 0.0)
	    		break;
	    	
	     
		for(int i=0;i<this.seatList.size();i++)
		{
			if(this.seatList.get(i).size >= num)
			{
				if(this.seatList.get(i).number>=devide)
				{
					this.seatList.get(i).number=this.seatList.get(i).number-devide;
					re.seatState.addFirst(new SeatCondition(this.seatList.get(i).size,devide,this.seatList.get(i).id));
					result = true;
					break;
				}
			}
			
		}
		if(result == true)
		{
			break;
		}
		
		
	    }
	    
	    return result;
				
	}
	
}
