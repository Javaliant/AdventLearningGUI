/* Author: Luigi Vincent
Microwave Front-View  GUI
*/

import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFirstPanel extends JFrame {
	public MyFirstPanel(){ 

		// p1 Gridlayout Container for the buttons, panel for text field and p1
		JPanel p1 = new JPanel(), p2 = new JPanel(new BorderLayout());
		Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	String theTime = sdf.format(cal.getTime());
    	Font waveTimer = new Font("SansSerif", 1, 12);
		

		p1.setLayout(new GridLayout(4,3));

		// Buttons
		for (int i = 1; i < 10; i++){ p1.add(new JButton("" + i)); }

		p1.add(new JButton("" + 0));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		JTextField textField = new JTextField(theTime);
		p2.add(textField, BorderLayout.NORTH);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setFont(waveTimer);
		textField.setForeground(Color.GRAY);
		p2.add(p1, BorderLayout.CENTER);

		// Frame Content
		ImageIcon popcorn = new ImageIcon("C:/MyWork/Images/popcorn.jpeg");

		add(p2, BorderLayout.EAST);
		add(new JButton("Insert Here", popcorn), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		MyFirstPanel frame = new MyFirstPanel();
		frame.setTitle("Luigi's Microwave GUI");
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
