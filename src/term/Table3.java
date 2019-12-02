package term;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Table3 extends JLabel{
	
	ImageIcon[] arr = new ImageIcon[5];
	ImageIcon rect_3;
    int count = 0;
    int size = 1;
	
	public Table3(ImageIcon img1,ImageIcon img2)
	{
		super();
		for(int i=0;i<5;i++)
		{
			arr[i] = img1;
		}
		rect_3 = img2;
		this.setBackground(new Color(0,0,0,0));
	}
	
	  public void paintComponent(Graphics g) {
		  super.paintComponent(g);
          g.drawImage(rect_3.getImage(), 30, 0, null);
           g.drawImage(arr[0].getImage(), 0, 15, null);
           g.drawImage(arr[1].getImage(), 0, 95, null);
           g.drawImage(arr[2].getImage(), 0, 175, null);
           g.drawImage(arr[3].getImage(), 0, 255, null);
           g.drawImage(arr[4].getImage(), 0, 335, null);
       }
	  
	  public void add(ImageIcon img,int n)
		 {
			 this.setBackground(new Color(0,0,0,0));
			 
			 int current = this.count;
			 for(int i=count;i<(n+current);i++)
			 {
				 arr[i] = img;
				 count +=1;
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
