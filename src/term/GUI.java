package term;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import term.Schedule;
import term.Data;
import term.SeatCondition;



public class GUI extends JFrame {
	
    // ��� �ʵ忡 ImageIcon Ŭ���� ������   
    ImageIcon icon, chair, user, r_cir, b_cir, rect, rect_2, rect_3;
    static double p_rice = 0.0 ,a_time = 0.0;
    static Table3 table_6;
    static Table2 table_5;
    static Table[] tables= new Table[4]; 
    static Chairs[] chairs = new Chairs[10];
    static double wstate;
    
    public GUI(String title) {
    	super(title);
        this.setSize(1205,805);
	    JPanel frame = new JPanel();
	    
	    frame.setSize(1200,800);
	    frame.setLayout(null);
	    
	    
    	JTextField price = new JTextField(5);
    	//�޴� ������ ��� �Ǵ���
    	JTextField AET = new JTextField(5);
    	//Average Eating Time ��� �Ļ� �ð� �Է� field
    	
    	
    	JTextArea result = new JTextArea(7, 30);
    	JScrollPane scrollPane = new JScrollPane(result);
    	frame.add(scrollPane);
    	scrollPane.setBounds(730, 200, 300, 360);
    
    	
    	
    	ButtonGroup weather = new ButtonGroup();
    	JRadioButton sunny = new JRadioButton("Sunny");
    	JRadioButton rain = new JRadioButton("Rain");
    	weather.add(sunny);
    	weather.add(rain);
    	//������ư 2���� �׷쿡 �ֱ� (�׷� �����ȿ� ����/��)
    	
    	
    	JLabel m_price = new JLabel("Menu price : ");
    	frame.add(m_price);
    	m_price.setBounds(10, 30, 100, 70);
    	frame.add(price);
    	price.setBounds(90, 40, 80, 50);
    	//�޴� ����
    	
    	
    	JLabel aet = new JLabel("Average Eating Time : ");
    	frame.add(aet);
    	aet.setBounds(200, 30, 280, 70);
    	frame.add(AET);
    	AET.setBounds(330, 40, 80, 50);
    	//��� �Ļ� �ð�

    	
    	frame.add(sunny);
    	sunny.setBounds(430, 30, 60, 70);
    	frame.add(rain);
    	rain.setBounds(500, 40, 60, 50);
    	//���� �̺�Ʈ
    	
    	JButton commit = new JButton(new ImageIcon(new ImageIcon(
    			"C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\transmission.png")
    			.getImage().getScaledInstance(190, 60, Image.SCALE_DEFAULT)));
    	//���� ��ư �̹����� �����ϱ�
    	
    	commit.setBorderPainted(false);
    	commit.setContentAreaFilled(false);
    	commit.setFocusPainted(false);
    	frame.add(commit);
    	commit.setBounds(570, 35, 190, 60);
    	//����(Transmission) ��ư
    	
    	//Transmission ��ư�� ������ ���۵� �̺�Ʈ
    	ActionListener C_listener = new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if (sunny.isSelected()) {
    				result.append("Sunny Clicked!\n");
    				wstate = 1;
    			}//���� ��ư sunny �� ������ ��� �߻��ϴ� �̺�Ʈ
    			else if (rain.isSelected()) {
    				result.append("Rain Clicked!\n");
    				wstate = 2;
    			} //���� ��ư rainy�� ������ �� �߻��ϴ� �̺�Ʈ
    			else {
    				
    			}
    			GUI.p_rice = Double.parseDouble(price.getText());
    			GUI.a_time = Double.parseDouble(AET.getText());
    			result.append("price:" + p_rice + "\nTime : " + a_time+"\n");
    			

    		
    		}
    		
    	};
    	commit.addActionListener(C_listener);
    
    	
    	
    	
	    
	    icon = new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\floor.png");
	    r_cir = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\r_cir.png")
    			.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    	
    	b_cir = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\b_cir.png")
    			.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    	
    	rect = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\rect.png")
    			.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
    	
    	rect_2 = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\rect_2.png")
    			.getImage().getScaledInstance(380, 50, Image.SCALE_DEFAULT));
    	
    	rect_3 = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\rect_3.png")
    			.getImage().getScaledInstance(50, 380, Image.SCALE_DEFAULT));
    	
    	
	    // ��׶��� �̹��� ������ �޼ҵ忡 �̸����� Ŭ������ ����
	    JLabel imageLabel = new JLabel(icon);
		imageLabel.setBounds(0, 100, 700, 500);

		GUI.tables[0] = new Table(b_cir,rect);
	    tables[0].setBounds(50, 150, 150, 150);
	    
	    
	    GUI.tables[1] = new Table(b_cir,rect);
	    tables[1].setBounds(50, 300, 150, 150);
	    
	    
	    GUI.tables[2] = new Table(b_cir,rect);
	    tables[2].setBounds(350, 150, 150, 150);
	    
	    GUI.tables[3] = new Table(b_cir,rect);
	    tables[3].setBounds(350, 300, 150, 150);
	    

	    GUI.table_5 = new Table2(b_cir,rect_2);
	    table_5.setBounds(30, 500, 600, 700);
	    
	    GUI.table_6 = new Table3(b_cir,rect_3);
	    table_6.setBounds(620, 100, 700, 380);
	    
	    
	    for(int i=0;i<4;i++)
	    {
	    	frame.add(tables[i]);
	    }
	    
	    frame.add(table_5);
	    frame.add(table_6);
	    
	    
	    frame.add(imageLabel);

	    
    	JButton Start = new JButton(new ImageIcon(new ImageIcon(
    			"C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\start.png")
    			.getImage().getScaledInstance(140, 70, Image.SCALE_DEFAULT)));
    	//���� ��ư �̹����� �����ϱ�
	    
	    Start.setBorderPainted(false);
	    Start.setContentAreaFilled(false);
	    Start.setFocusPainted(false);
	    Start.setBounds(730, 100, 140, 70);
	    frame.add(Start);
	    
	    //Start ��ư�� ������ ���۵� �̺�Ʈ
    	ActionListener listener = new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			result.append("Clicked!\n");
    			Thread t = new Thread(new Animation(r_cir,b_cir,result));
    			t.start();
    			/*
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
    					}
    				}
    				
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
    					}
    				}
    				
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
    			*/
    		}
    		
    	};
    	Start.addActionListener(listener);
    	
    	
    	chair = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\chair.png")
    			.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
    	user = new ImageIcon(new ImageIcon("C:\\Users\\LG\\Desktop\\연구\\Algorithm_gui\\Algorithm_2\\src\\term\\user.png")
    			.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
    	
    	for(int i=0;i<10;i++)
    	{
    	chairs[i] = new Chairs(chair);
    	}
    	
    	//������ �ݴ�� �����Ͽ���(�������� 1�� ����)
    	for(int i=0;i<10;i++)
    	{
    		frame.add(chairs[i]);
        	chairs[i].setBounds(20+(80*i), 620, 70, 70);
        	chairs[i].unUse();
    	}
    	
    	
    	
	    this.add(frame);
	    this.setVisible(true);
	      

	}

	public static void main(String[] args) {
		new GUI("Algorithm");
	}
	
	 public static int randomRange(int n1, int n2) {
		    return (int) (Math.random() * (n2 - n1 + 1)) + n1;
		  }
}