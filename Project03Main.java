import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.BorderLayout;
//import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project03Main extends JFrame implements ActionListener 
{
	private  JTextField textvelocity;
	private  JTextField textangle;
	private  JComboBox comboboxcolour;
	private  JButton buttonlaunch;
	private  JComboBox comboboxexplosion;
	private  JTextField texttime;
	
	public static  String colour;
	public static  String explosion;
	public static  int velocity;
	public static  int angle;
	public static  int time;
	public static  int launch;
	Canvas_1 canvas;

	
	
	public static String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

	public static String getExplosion() {
		return explosion;
	}
	public void setExplosion(String explosion) {
		this.explosion = explosion;
	}

	public static int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public static int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}

	public static int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public static int getLaunch() {
		return launch;
	}
	public static void setLaunch(int launch) {
		Project03Main.launch = launch;
	}

	public Project03Main() 
	{
		
		JPanel j = new JPanel();
		//setLayout(new FlowLayout());
		

		JLabel labelvelocity = new JLabel("Enter Velocity:");
		j.add(labelvelocity);
		textvelocity = new JTextField (4);
		j.add(textvelocity);
		textvelocity.addActionListener(this);
		
		JLabel labelangle = new JLabel ("Enter Angle:");
		j.add(labelangle);
		textangle = new JTextField (4);
		j.add(textangle);
		textangle.addActionListener(this);
		
		JLabel labeltime = new JLabel ("Enter Time:");
		j.add(labeltime);
		texttime = new JTextField (4);
		j.add(texttime);
		texttime.addActionListener(this);
		
		JLabel labelcolour = new JLabel ("Choose the firework colour:");
		j.add(labelcolour);
		String [] colourarray = { "Maroon", "Orange", "Yellow", "Purple", "Black"};
		comboboxcolour = new JComboBox (colourarray);
		j.add(comboboxcolour);
		comboboxcolour.addActionListener(this);
		
		
		JLabel labelexplosion = new JLabel ("Choose the explosion type:");
		j.add(labelexplosion);
		String [] explosionarray = { "A", "B", "C", "D", "E", "F", "G" };
		comboboxexplosion = new JComboBox (explosionarray);
		j.add(comboboxexplosion);
		comboboxexplosion.addActionListener(this);
		
		buttonlaunch = new JButton ("Launch");
		buttonlaunch.addActionListener(this);
		j.add(buttonlaunch);
		
		launch =0;
		
		j.setBackground(Color.GRAY);
		add(j, BorderLayout.NORTH);
		canvas = new Canvas_1();
		//canvas.setBackground(Color.PINK);
		add(canvas, BorderLayout.CENTER);
		
		JPanel emptyeast = new JPanel();
		emptyeast.setBackground(Color.GRAY);
		JPanel emptywest = new JPanel();
		emptywest.setBackground(Color.GRAY);
		JPanel emptysouth = new JPanel();
		emptysouth.setBackground(Color.GRAY);
		add(emptyeast, BorderLayout.EAST);
		add(emptywest, BorderLayout.WEST);
		add(emptysouth, BorderLayout.SOUTH);
		pack();
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) 
	{
		new Project03Main().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
//		if (e.getSource().equals(comboboxcolour)) 
//		{
//			colour = (String)comboboxcolour.getSelectedItem();
//		}
//
//		else if (e.getSource().equals(comboboxexplosion)) 
//		{
//			explosion = (String)comboboxexplosion.getSelectedItem();
//			
//			
//		}
//		
//		else if (e.getSource().equals(textvelocity)) 
//		{
//			velocity = Integer.parseInt(textvelocity.getText());
//			 
//		}
//		
//		else if (e.getSource().equals(textangle)) 
//		{
//			angle = Integer.parseInt(textangle.getText());
//			
//		}
//		
//		else if (e.getSource().equals(texttime)) 
//		{
//			time = Integer.parseInt(texttime.getText());
//			
//		}
		
		 if (e.getSource().equals(buttonlaunch)) 
		{
			launch++;
			
			canvas.setV(Integer.parseInt(textvelocity.getText()));
			canvas.setA(Math.toRadians((Integer.parseInt(textangle.getText()))));
			canvas.setT(Integer.parseInt(texttime.getText()));
			canvas.setExp((String)comboboxexplosion.getSelectedItem());
			canvas.setCol((String)comboboxcolour.getSelectedItem());
			
			
			
			System.out.println((String)comboboxexplosion.getSelectedItem());
			repaint();
		}
		
	}
	

}
