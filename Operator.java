import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Operator extends JFrame {
	
	public static void main(String[] args) 
	{
		
		JFrame jframe = new JFrame("Operator");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Container container = jframe.getContentPane();
		
		Canvas_1 canvas = new Canvas_1();
		jframe.add(canvas, BorderLayout.CENTER);
		Project03Main xx = new Project03Main();
		
		jframe.add(xx, BorderLayout.NORTH);
		
		JPanel emptyeast = new JPanel();
		emptyeast.setBackground(Color.red);
		JPanel emptywest = new JPanel();
		emptywest.setBackground(Color.black);
		JPanel emptysouth = new JPanel();
		emptysouth.setBackground(Color.blue);
		jframe.add(emptyeast, BorderLayout.EAST);
		jframe.add(emptywest, BorderLayout.WEST);
		jframe.add(emptysouth, BorderLayout.SOUTH);
		
		//container.setLayout(new GridLayout(4,4));
		jframe.pack();
		jframe.setSize(1000,1000);
		jframe.setVisible(true);
		
		
	}

}
