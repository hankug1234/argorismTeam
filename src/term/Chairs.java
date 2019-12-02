package term;
import java.awt.*;
import javax.swing.*;

public class Chairs extends JLabel{
	ImageIcon img;
	boolean state = false;
	
	public Chairs(ImageIcon img)
	{
		super();
		this.img = img;
	}
	
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);
    	g.drawImage(this.img.getImage(),0,0,this);
    }

	public void use()
	{
		state = true;
		this.setVisible(true);
		this.repaint();
	}
	
	public void unUse()
	{
		state = false;
		this.setVisible(false);
		this.repaint();
	}
}
