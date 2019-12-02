package term;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Animation implements Runnable {
	ImageIcon r_cir,b_cir;
	JTextArea result;
	
	public Animation(ImageIcon r_cir,ImageIcon b_cir, JTextArea result)
	{
		this.r_cir = r_cir;
		this.b_cir = b_cir;
		this.result = result;
	}
	
	public void run()
	{
		double timeCount=0.0;
		double totalPrice = 0.0;
		int k = randomRange(1,4);
		
		
		LinkedList<Data> list2 = Senario.generateClient(k);
		
		LimitBound run2 = new LimitBound(list2,26);
		
		Schedule re2 = run2.run();
		
		Senario.selectClient(run2, re2, r_cir,result);
		
		System.out.println("");
		for(int i=0;i<re2.client.size();i++)
		{
			Data box = re2.client.get(i);
			System.out.println("size:"+box.weight+ "price:"+box.price+ "time:"+box.time+ "state:"+box.removeState);
		}
		
		System.out.println("");
		
		for(int i=0;i<run2.list.size();i++)
		{
			Data box = run2.list.get(i);
			System.out.println("size:"+box.weight+ "price:"+box.price+ "time:"+box.time+ "state:"+box.removeState);
		}
		
		while(run2.list.size()!=0)
		{
			LinkedList<Data> out = new LinkedList<Data>();
			LinkedList<Data> in = new LinkedList<Data>();
			int size = re2.client.size();
			for(int j=0;j<size;j++)
			{
				Data box = re2.client.get(j);
				box.time-=1.0;
				if(box.time<=0.0)
				{
					box.removeState = true;
					totalPrice+=box.price;
				}
			}
			timeCount+=1.0;
			for(int j=0;j<size;j++)
			{
				Data box = re2.client.get(j);
				if(box.removeState == true)
				{
					out.addLast(box);
				}
				else
				{
					in.addLast(box);
				}
			}
			
			for(int j=0;j<out.size();j++)
			{
				Data box = out.get(j);
				if(box.seatNumber == 5)
				{
					GUI.table_5.sub(b_cir, (int)box.weight);
					
				}
				else if(box.seatNumber == 6)
				{
					GUI.table_6.sub(b_cir, (int)box.weight);
				
				}
				else
				{
					GUI.tables[box.seatNumber].sub(b_cir, (int)box.weight);
					
				}
				
			}
			LinkedList<Data> re = in;
			double currentw = 0.0;
			
			for(int j=0;j<re.size();j++)
			{
				currentw+=re.get(j).weight;
			}
			run2.weight = 26.0 - currentw;
			System.out.println(run2.weight);
			
			re2 = run2.run();
			
			Senario.selectClient(run2, re2, r_cir,result);
			
			System.out.println("");
			for(int i=0;i<re2.client.size();i++)
			{
				Data box = re2.client.get(i);
				System.out.println("size:"+box.weight+ "price:"+box.price+ "time:"+box.time+ "state:"+box.removeState);
			}
			
			System.out.println("");
			
			for(int i=0;i<run2.list.size();i++)
			{
				Data box = run2.list.get(i);
				System.out.println("size:"+box.weight+ "price:"+box.price+ "time:"+box.time+ "state:"+box.removeState);
			}
			
			
			System.out.println(run2.list.size());
			
			for(int j=0;j<re.size();j++)
			{
				re2.client.addFirst(re.get(j));
			}
			
			try {

				Thread.sleep(500);

				} catch (InterruptedException m) {


				}

		}
		
		while(re2.client.size()!=0)
		{LinkedList<Data> out = new LinkedList<Data>();
		 LinkedList<Data> in = new LinkedList<Data>();
			int size = re2.client.size();
			for(int j=0;j<size;j++)
			{
				Data box = re2.client.get(j);
				box.time-=1.0;
				if(box.time<=0.0)
				{
					box.removeState = true;
					totalPrice+=box.price;
				}
			}
			timeCount+=1.0;
			for(int j=0;j<size;j++)
			{
				Data box = re2.client.get(j);
				if(box.removeState == true)
				{
					out.addLast(box);
				}
				else
				{
					in.addLast(box);
				}
			}
			
			for(int j=0;j<out.size();j++)
			{
				Data box = out.get(j);
				if(box.seatNumber == 5)
				{
					GUI.table_5.sub(b_cir, (int)box.weight);
					
				}
				else if(box.seatNumber == 6)
				{
					GUI.table_6.sub(b_cir, (int)box.weight);
				
				}
				else
				{
					GUI.tables[box.seatNumber].sub(b_cir, (int)box.weight);
					
				}
				
			}
			re2.client = in;
			try {

				Thread.sleep(500);

				} catch (InterruptedException m) {


				}
		}
		result.append("\n totalTime: "+timeCount+" totalPrice: "+totalPrice+"\n");
	}
	
	public static int randomRange(int n1, int n2) {
	    return (int) (Math.random() * (n2 - n1 + 1)) + n1;
	  }
		

}
