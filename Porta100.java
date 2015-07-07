import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;


public class Porta100 implements ActionListener
{
	JFrame frame = new JFrame("Exercicio de JFrame");
	JButton button1 = new JButton("Topete");
	int counterTimes = 0;

	public static void main (String[] args)
	{
		Porta100 gui = new Porta100();
		gui.go();
	}
	
	public void go()
	{
	
		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.setSize(1920,1080);
		frame.setVisible(true);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.getContentPane().add(BorderLayout.WEST,button1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button1.addActionListener(this);
	}

	public 	void actionPerformed(ActionEvent e)
	{
		frame.repaint();


	}
	

	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{

			int x = 30;
			int y = 50;

			for (int i = 1; i < 101 ; i++) 
			{
				if(i == 20 || i == 40 || i == 60 || i == 80 || i == 100){
					g.fillRect(x, y, 40, 40);
					g.setColor(Color.BLACK);
					x = 30;
					y = y + 50;
				} 
				else 
				{
					g.fillRect(x, y, 40, 40);
					g.setColor(Color.BLACK);
					x = x + 41;		
				}
			}
		}
	}
}