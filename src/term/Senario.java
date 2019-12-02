package term;

import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Senario {
	static LinkedList<Data> generateClient(int k)
	{
		LinkedList<Data> list2 = new LinkedList<Data>();
		
		
		double input;
		for(int i=0;i<k*10;i++)
		{
		input = (double)(randomRange(1,4));	
		double num = (double)randomRange(1,30);

		list2.add(new Data(0.0,input,0.0));
		list2.get(i).calculateInitialValue(num, GUI.p_rice*input);
		}
		
		return list2;
	}
	
	static void selectClient(LimitBound run2, Schedule re2, ImageIcon r_cir, JTextArea result )
	{
		for(int i=0;i<re2.client.size();i++)
		{
			
			Data client = re2.client.get(i);
			if((int)client.weight == 1)
			{
				if(GUI.table_5.count<5)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				 
				}
				else if(GUI.table_6.count<5)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				  
				}
				else
				{
					client.removeState = false;
					
				}
			}
			else if((int)client.weight == 2)
			{
				if((5 - GUI.table_5.count)>=2)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				  
				}
				else if((5-GUI.table_6.count)>=2)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				 
				}
				else
				{
					for(int j=0;j<4;j++)
					{
					  int remain = 4 - GUI.tables[j].count;
					  if(remain>=(int)client.weight)
					  {
						  GUI.tables[j].add(r_cir,(int)client.weight);
						  client.seatNumber = j;
						  client.removeState = true;
						 
						  break;
					  }
					}
				}
			}
			else 
			{
				for(int j=0;j<4;j++)
				{
				  int remain = 4 - GUI.tables[j].count;
				  if(remain>=(int)client.weight)
				  {
					  GUI.tables[j].add(r_cir,(int)client.weight);
					  client.seatNumber = j;
					  client.removeState = true;
					 
					  break;
				  }
				  else
				  {
					  client.removeState = false;
				  }
				}
				if(client.removeState == false)
				{
					if((5 - GUI.table_5.count)>=4)
					{
					  GUI.table_5.add(r_cir,(int)client.weight);
					  client.seatNumber = 5;
					  client.removeState = true;
					 
					}
					else if((5-GUI.table_6.count)>=4)
					{
					  GUI.table_6.add(r_cir,(int)client.weight);
					  client.seatNumber = 6;
					  client.removeState = true;
					 
					}
				}
			}
			
			
		
		}
		
		LinkedList<Data> out = new LinkedList<Data>();
		LinkedList<Data> in = new LinkedList<Data>();
		
		result.append("\n accept client list\n");
		for(int i=0;i<re2.client.size();i++)
		{
			Data data = re2.client.get(i);
			result.append("size: "+data.weight+" price: "+data.price+" time: "+data.time+" seat: "+data.seatNumber+"\n");
			result.setCaretPosition(result.getDocument().getLength());
		}
		result.append("\ndown queue client list\n");
		for(int i=0;i<re2.client.size();i++)
		{
			Data data = re2.client.get(i);
			if(data.removeState == false)
			{
			out.addLast(data);
			result.append("size: "+data.weight+" price: "+data.price+" time: "+data.time+"\n");
			result.setCaretPosition(result.getDocument().getLength());
			}
			else
			{
				in.addLast(data);
			}
		}
		System.out.println("d:"+run2.list.size());
		
		for(int i=0;i<run2.list.size();i++)
		{
			
			Data client = run2.list.get(i);
			if((int)client.weight == 1)
			{
				if(GUI.table_5.count<5)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				 
				}
				else if(GUI.table_6.count<5)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				  
				}
				else
				{
					client.removeState = false;
				}
			}
			else if((int)client.weight == 2)
			{
				if((5 - GUI.table_5.count)>=2)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				
				}
				else if((5-GUI.table_6.count)>=2)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				 
				}
				else
				{
					
				}
			}
			else 
			{
					if((5 - GUI.table_5.count)>=4)
					{
					  GUI.table_5.add(r_cir,(int)client.weight);
					  client.seatNumber = 5;
					  client.removeState = true;
					  
					}
					else if((5-GUI.table_6.count)>=4)
					{
					  GUI.table_6.add(r_cir,(int)client.weight);
					  client.seatNumber = 6;
					  client.removeState = true;
					 
					}
			}
			
			
		}
		result.append("\n up form queue client list \n");
		
		System.out.println("c:"+run2.list.size());
		for(int i=0;i<run2.list.size();i++)
		{
			Data data = run2.list.get(i);
			if(data.removeState == false)
			{
			out.addLast(data);
			
			}
			else
			{
				in.addLast(data);
				result.append("size: "+data.weight+" price: "+data.price+" time: "+data.time+" seat:"+data.seatNumber+"\n");
				result.setCaretPosition(result.getDocument().getLength());
			}
		}
		
		re2.client = in;
		
		run2.list = out;
		
		run2.sort(run2.list);
		System.out.println("a:"+run2.list.size());
		
		LinkedList<Data> newlist = new LinkedList<Data>();
		
		for(int i=0;i<10;i++)
		{
			if(i<run2.list.size())
			{
			newlist.addLast(run2.list.get(i));
			GUI.chairs[i].use();
			}
			else
			{
				GUI.chairs[i].unUse();
			}
			
		}
		System.out.println("k:"+run2.list.size());
		
		run2.list = newlist;
		System.out.println("h:"+run2.list.size());
		result.append("\n queue client list\n");
		for(int i=0;i<run2.list.size();i++)
		{
			Data box = run2.list.get(i);
			result.append("size:"+box.weight+ "price:"+box.price+ "time:"+box.time+"\n");
		}
		
		for(int i=0;i<re2.client.size();i++)
        {
		int r = randomRange(1,5);
		re2.client.get(i).time += (double)((GUI.a_time*GUI.wstate)+r);
		re2.client.get(i).removeState = false;
        }
		result.append("\n ------------------------------------------ \n");
	}
	
	static void selectClient2(GrideAccept run2, Schedule re2, ImageIcon r_cir, JTextArea result )
	{
		for(int i=0;i<re2.client.size();i++)
		{
			
			Data client = re2.client.get(i);
			if((int)client.weight == 1)
			{
				if(GUI.table_5.count<5)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				 
				}
				else if(GUI.table_6.count<5)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				  
				}
				else
				{
					client.removeState = false;
					
				}
			}
			else if((int)client.weight == 2)
			{
				if((5 - GUI.table_5.count)>=2)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				  
				}
				else if((5-GUI.table_6.count)>=2)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				 
				}
				else
				{
					for(int j=0;j<4;j++)
					{
					  int remain = 4 - GUI.tables[j].count;
					  if(remain>=(int)client.weight)
					  {
						  GUI.tables[j].add(r_cir,(int)client.weight);
						  client.seatNumber = j;
						  client.removeState = true;
						 
						  break;
					  }
					}
				}
			}
			else 
			{
				for(int j=0;j<4;j++)
				{
				  int remain = 4 - GUI.tables[j].count;
				  if(remain>=(int)client.weight)
				  {
					  GUI.tables[j].add(r_cir,(int)client.weight);
					  client.seatNumber = j;
					  client.removeState = true;
					 
					  break;
				  }
				  else
				  {
					  client.removeState = false;
				  }
				}
				if(client.removeState == false)
				{
					if((5 - GUI.table_5.count)>=4)
					{
					  GUI.table_5.add(r_cir,(int)client.weight);
					  client.seatNumber = 5;
					  client.removeState = true;
					 
					}
					else if((5-GUI.table_6.count)>=4)
					{
					  GUI.table_6.add(r_cir,(int)client.weight);
					  client.seatNumber = 6;
					  client.removeState = true;
					 
					}
				}
			}
			
			
		
		}
		
		LinkedList<Data> out = new LinkedList<Data>();
		LinkedList<Data> in = new LinkedList<Data>();
		
		result.append("\n accept client list\n");
		for(int i=0;i<re2.client.size();i++)
		{
			Data data = re2.client.get(i);
			result.append("size: "+data.weight+" price: "+data.price+" time: "+data.time+" seat: "+data.seatNumber+"\n");
			result.setCaretPosition(result.getDocument().getLength());
		}
		result.append("\ndown queue client list\n");
		for(int i=0;i<re2.client.size();i++)
		{
			Data data = re2.client.get(i);
			if(data.removeState == false)
			{
			out.addLast(data);
			result.append("size: "+data.weight+" price: "+data.price+" time: "+data.time+"\n");
			result.setCaretPosition(result.getDocument().getLength());
			}
			else
			{
				in.addLast(data);
			}
		}
		System.out.println("d:"+run2.list.size());
		
		for(int i=0;i<run2.list.size();i++)
		{
			
			Data client = run2.list.get(i);
			if((int)client.weight == 1)
			{
				if(GUI.table_5.count<5)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				 
				}
				else if(GUI.table_6.count<5)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				  
				}
				else
				{
					client.removeState = false;
				}
			}
			else if((int)client.weight == 2)
			{
				if((5 - GUI.table_5.count)>=2)
				{
				  GUI.table_5.add(r_cir,(int)client.weight);
				  client.seatNumber = 5;
				  client.removeState = true;
				
				}
				else if((5-GUI.table_6.count)>=2)
				{
				  GUI.table_6.add(r_cir,(int)client.weight);
				  client.seatNumber = 6;
				  client.removeState = true;
				 
				}
				else
				{
					
				}
			}
			else 
			{
					if((5 - GUI.table_5.count)>=4)
					{
					  GUI.table_5.add(r_cir,(int)client.weight);
					  client.seatNumber = 5;
					  client.removeState = true;
					  
					}
					else if((5-GUI.table_6.count)>=4)
					{
					  GUI.table_6.add(r_cir,(int)client.weight);
					  client.seatNumber = 6;
					  client.removeState = true;
					 
					}
			}
			
			
		}
		result.append("\n up form queue client list \n");
		
		System.out.println("c:"+run2.list.size());
		for(int i=0;i<run2.list.size();i++)
		{
			Data data = run2.list.get(i);
			if(data.removeState == false)
			{
			out.addLast(data);
			
			}
			else
			{
				in.addLast(data);
				result.append("size: "+data.weight+" price: "+data.price+" time: "+data.time+" seat:"+data.seatNumber+"\n");
				result.setCaretPosition(result.getDocument().getLength());
			}
		}
		
		re2.client = in;
		
		run2.list = out;
		
		run2.sort(run2.list);
		System.out.println("a:"+run2.list.size());
		
		LinkedList<Data> newlist = new LinkedList<Data>();
		
		for(int i=0;i<10;i++)
		{
			if(i<run2.list.size())
			{
			newlist.addLast(run2.list.get(i));
			GUI.chairs[i].use();
			}
			else
			{
				GUI.chairs[i].unUse();
			}
			
		}
		System.out.println("k:"+run2.list.size());
		
		run2.list = newlist;
		System.out.println("h:"+run2.list.size());
		result.append("\n queue client list\n");
		for(int i=0;i<run2.list.size();i++)
		{
			Data box = run2.list.get(i);
			result.append("size:"+box.weight+ "price:"+box.price+ "time:"+box.time+"\n");
		}
		
		for(int i=0;i<re2.client.size();i++)
        {
		int r = randomRange(1,5);
		re2.client.get(i).time += (double)((GUI.a_time*GUI.wstate)+r);
		re2.client.get(i).removeState = false;
        }
		result.append("\n ------------------------------------------ \n");
	}
	
	public static int randomRange(int n1, int n2) {
	    return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	  }

}
