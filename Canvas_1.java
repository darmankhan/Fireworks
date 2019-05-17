import java.awt.Color;
import java.util.Random;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Canvas_1 extends JComponent {

	public static double v;
	public static double a;
	public static int t;
	public static String exp = "";
	public static String col = "";
	int[] colorarray = new int[] { 10, 40, 70, 100, 130, 160, 200, 250 };

	public void paintComponent(Graphics g) {

		setBackground(Color.PINK);
		// int ax = 1;

		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		int y1 = getHeight();
		Random ran = new Random();
		double xstart = 0;
		double ystart = getHeight();
		double xendx = v * Math.cos(a) * t;
		double yendy = (y1 - (v * Math.sin(a) * t - 0.5 * 9.81 * t * t));

//		//colours
//		if (col.equals("Maroon")) 
//		{
//			Color D = new Color(26, 35, 126);
//			g.setColor(D);
//		}
//		
//		else if (col.equals("Orange")) 
//		{
//			Color E = new Color(0, 96, 100);
//			g.setColor(E);
//		}
//		
//		else if (col.equals("Yellow")) 
//		{
//			Color F = new Color(27, 94, 32);
//			g.setColor(F);
//			
//		}
//		
//		else if (col.equals("Purple")) 
//		{
//			Color G = new Color(1, 255, 1);
//			g.setColor(G);
//			
//		}
//		
//		else if (col.equals("Black")) 
//		{
//			Color H = new Color(1, 1, 1);
//			g.setColor(H);
//			
//		}
//		

		// DRAWS LINE
		for (double dis = 0; dis < t; dis = dis + 0.01) {

			if (col.equals("Maroon")) {
				Color D = new Color(128, 0, 0);
				g.setColor(D);
			}

			else if (col.equals("Orange")) {
				Color E = new Color(255, 140, 0);
				g.setColor(E);
			}

			else if (col.equals("Yellow")) {
				Color F = new Color(255, 255, 0);
				g.setColor(F);

			}

			else if (col.equals("Purple")) {
				Color G = new Color(128, 0, 128);
				g.setColor(G);

			}

			else if (col.equals("Black")) {
				Color H = new Color(1, 1, 1);
				g.setColor(H);

			}

			double xend = v * Math.cos(a) * dis;
			double yend = (y1 - (v * Math.sin(a) * dis - 0.5 * 9.81 * dis * dis));
			g.drawLine((int) xstart, (int) ystart, (int) xend, (int) yend);
			xstart = xend;
			ystart = yend;
		}

		// EXPLOSIONS

		// String BOOM
		if (exp.equals("A")) {
			g.setColor(new Color(colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)]));
			g.setFont(new Font("Helvetica", Font.BOLD, 40));
			String string = "\"BOOM!\"";
			g.drawString(string, (int) (xendx - 70), (int) (yendy + 15));
		}

		// Spider web
		else if (exp.equals("B")) {
			g.setColor(new Color(colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)]));
			g.drawLine((int) xendx - 70, (int) yendy - 70, (int) xendx + 70, (int) yendy + 70);
			g.drawLine((int) xendx - 70, (int) yendy + 70, (int) xendx + 70, (int) yendy - 70);
			g.drawLine((int) xendx - 100, (int) yendy, (int) xendx + 100, (int) yendy);
			g.drawLine((int) xendx, (int) yendy - 100, (int) xendx, (int) yendy + 100);
			g.setColor(new Color(colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)]));
			g.drawLine((int) xendx - 50, (int) yendy - 50, (int) xendx - 50, (int) yendy);
			g.drawLine((int) xendx - 50, (int) yendy - 50, (int) xendx, (int) yendy - 50);
			g.drawLine((int) xendx + 50, (int) yendy - 50, (int) xendx, (int) yendy - 50);
			g.drawLine((int) xendx + 50, (int) yendy - 50, (int) xendx + 50, (int) yendy);
			g.drawLine((int) xendx + 50, (int) yendy, (int) xendx + 50, (int) yendy + 50);
			g.drawLine((int) xendx + 50, (int) yendy + 50, (int) xendx, (int) yendy + 50);
			g.drawLine((int) xendx, (int) yendy + 50, (int) xendx - 50, (int) yendy + 50);
			g.drawLine((int) xendx - 50, (int) yendy + 50, (int) xendx - 50, (int) yendy);

			for (int inc = 10; inc <= 100; inc = inc + 10) {
				g.setColor(
						new Color(colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)]));
				int startx = (int) xendx + inc;
				int starty = (int) yendy;
				for (int theta = 0; theta <= 360; theta = theta + 45) {
					int x = (int) (inc * Math.cos(theta * Math.PI / 180) + xendx);
					int y = (int) (inc * Math.sin(theta * Math.PI / 180) + yendy);
					g.drawLine(startx, starty, x, y);
					startx = x;
					starty = y;
				}

			}
		}

		// Pattern of concentric circles
		else if (exp.equals("C")) {
			Color C = new Color(49, 27, 146);
			g.setColor(C);

			for (int displace = 5; displace < ran.nextInt(1000); displace = displace + 5) {
				Color XXX = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
				g.setColor(XXX);
				g.drawOval((int) xendx - (displace / 2), (int) yendy - (displace / 2), (int) displace, (int) displace);
			}
		}

		// explosion
		else if (exp.equals("D")) {

			for (int i = 0; i <= 360; i = i + 4) {

				int ran1 = colorarray[ran.nextInt(8)];
				int ran2 = colorarray[ran.nextInt(8)];
				int ran3 = colorarray[ran.nextInt(8)];
				Color D = new Color(ran1, ran2, ran3);
				g.setColor(D);
				double hor = xendx - 100 * Math.cos(i * (Math.PI) / 180);
				double ver = yendy - 100 * Math.sin(i * (Math.PI) / 180);
				g.drawLine((int) xendx, (int) yendy, (int) hor, (int) ver);
			}
		}

		// flower petals
		else if (exp.equals("E")) {
			g.setColor(new Color(colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)]));
			g.fillOval((int) xendx - 20, (int) yendy - 66, 45, 45);
			g.fillOval((int) xendx + 23, (int) yendy - 20, 45, 45);
			g.fillOval((int) xendx + 10, (int) yendy + 27, 45, 45);
			g.fillOval((int) xendx - 42, (int) yendy + 27, 45, 45);
			g.fillOval((int) xendx - 68, (int) yendy - 20, 45, 45);
			g.setColor(Color.YELLOW);
			g.fillOval((int) xendx - 18, (int) yendy - 18, 36, 36);

		}

		// spiral ring
		else if (exp.equals("F")) {
			g.setColor(new Color(colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)], colorarray[ran.nextInt(8)]));
			int hor = (int) xendx;
			int ver = (int) yendy;
			for (double i = 0; i <= 6.28; i = i + 0.07) {
				hor = (int) (xendx + 100 * Math.cos(i));
				ver = (int) (yendy - 100 * Math.sin(i));
				g.drawArc((int) hor, (int) ver, 50, 70, 0, 330);
				g.drawLine((int) xendx, (int) yendy, hor + 12, ver + 12);

			}
		}

		// Extra Credit
		else if (exp.equals("G")) {
			for (int k = 0; k <= 8; k++) {
				int startx = (int) xendx;
				int starty = (int) yendy;
				int ran3 = colorarray[ran.nextInt(8)];
				int ran4 = colorarray[ran.nextInt(8)];
				int ran5 = colorarray[ran.nextInt(8)];
				if (k == 0) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 6; dis = dis + 0.1) {
						double ec1x = xendx + 20 * Math.cos(45 * (Math.PI / 180)) * dis;
						double ec1y = yendy - (20 * Math.sin(45 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine(startx, starty, (int) ec1x, (int) ec1y);
						startx = (int) ec1x;
						starty = (int) ec1y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				} else if (k == 1) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 6; dis = dis + 0.1) {
						double ec2x = xendx - 20 * Math.cos(45 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (20 * Math.sin(45 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				} else if (k == 2) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 6; dis = dis + 0.1) {
						double ec2x = xendx + 25 * Math.cos(65 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (30 * Math.sin(65 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				}

				else if (k == 3) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 6; dis = dis + 0.1) {
						double ec2x = xendx - 15 * Math.cos(70 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (15 * Math.sin(70 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				} else if (k == 4) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 5; dis = dis + 0.1) {
						double ec2x = xendx - 40 * Math.cos(75 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (40 * Math.sin(75 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				} else if (k == 5) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 5; dis = dis + 0.1) {
						double ec2x = xendx + 40 * Math.cos(80 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (45 * Math.sin(80 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				} else if (k == 6) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 6; dis = dis + 0.1) {
						double ec2x = xendx + 12 * Math.cos(40 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (12 * Math.sin(40 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				} else if (k == 7) {
					g.setColor(new Color(ran3, ran4, ran5));
					for (double dis = 0; dis < 6; dis = dis + 0.1) {
						double ec2x = xendx - 30 * Math.cos(55 * (Math.PI / 180)) * dis;
						double ec2y = yendy - (30 * Math.sin(55 * (Math.PI / 180)) * dis - 0.5 * 9.81 * dis * dis);
						g.drawLine((int) startx, (int) starty, (int) ec2x, (int) ec2y);
						startx = (int) ec2x;
						starty = (int) ec2y;
					}
					for (int i = 0; i <= 360; i = i + 10) {
						double hor = startx - 15 * Math.cos(i * (Math.PI) / 180);
						double ver = starty - 15 * Math.sin(i * (Math.PI) / 180);
						g.drawLine((int) startx, (int) starty, (int) hor, (int) ver);
					}
				}

			}
		}

	}

	public static String getExp() {
		return exp;
	}

	public static void setExp(String exp) {
		Canvas_1.exp = exp;
	}

	public static double getV() {
		return v;
	}

	public void setV(double v1) {
		this.v = v1;
	}

	public static double getA() {
		return a;
	}

	public void setA(double a1) {
		this.a = a1;
	}

	public static int getT() {
		return t;
	}

	public void setT(int t1) {
		this.t = t1;
	}

	public static String getCol() {
		return col;
	}

	public static void setCol(String col) {
		Canvas_1.col = col;
	}

}
