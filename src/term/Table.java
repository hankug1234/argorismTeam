package term;

import java.awt.*;

import javax.swing.*;

public class Table extends JLabel {
	ImageIcon[] arr = new ImageIcon[4];
	ImageIcon rect;
	int count = 0;
    int size = 4;
	
	public Table(ImageIcon img1,ImageIcon img2)
	{
		super();
		rect = img2;
		for(int i=0;i<4;i++)
		{
			arr[i] = img1;
		}
		
		this.setBackground(new Color(0,0,0,0));
	
	}
	
	 public void paint(Graphics g) {
		
		 super.paint(g);
         g.drawImage(arr[0].getImage(), 0, 20, this);
         g.drawImage(arr[2].getImage(), 0, 80, this);
         
         g.drawImage(rect.getImage(), 25, 25, this);
         
         g.drawImage(arr[1].getImage(), 100, 20, this);
         g.drawImage(arr[3].getImage(), 100, 80,this);
         
        
        
     }
	 
	 public void add(ImageIcon img,int n)
	 {
		 this.setBackground(new Color(0,0,0,0));
		
		 int current = this.count;
		 for(int i=this.count;i<(n+current);i++)
		 {
			arr[i] = img;
			this.count+=1;
		 }
		
		 this.validate();
		 this.repaint();
		 
	 }
	 
	 public void sub(ImageIcon img,int n)
	 {
		 this.setBackground(new Color(0,0,0,0));
		
		 for(int i=0;i<n;i++)
		 {
			arr[count-1] = img;
			count-=1;
		 }
		
		 this.validate();
		 this.repaint();
		 
	 }

}
