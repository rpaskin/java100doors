import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;


public class Porta100 implements ActionListener
{
	JFrame frame = new JFrame("Exercicio de JFrame");
	JButton button1 = new JButton("Topete");
	int counterTimes = 0;
	boolean door;

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
		if(e.getSource()==button1){
			counterTimes++;
			frame.repaint();
		}
	}	

	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			int x = 30;
			int y = 0;

			for (int i = 1; i < 101 ; i++) 
			{
				boolean aberta = false;

				if(counterTimes == 1){
					aberta = true;
				}
				else if(counterTimes == 2){
					if(i % 2 != 0){
						aberta = true;
					}
				}
				else if(counterTimes == 3){
					if(i % 2 != 0){
						aberta = true;
					}
					if(i % 3 == 0){
						aberta = !aberta;
					}
				}

				if (aberta){
					g.setColor(Color.RED);						
				}
				else {
					g.setColor(Color.BLACK);					
				}

				g.fillRect(x, y, 40, 40);

				if(i == 20 || i == 40 || i == 60 || i == 80 || i == 100){
					x = 30;
					y = y + 50;
				} 
				else 
				{
					x = x + 41;
				}
			}
			}
	}
}