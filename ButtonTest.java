/* Author: Luigi Vincent
Quick Button Test via Java 8
*/ 

import javax.swing.JFrame;
import javax.swing.JButton;

public class ButtonTest {
	public static void main(String[] args) {
		JButton btn = new JButton("Press Me");
		btn.addActionListener(e -> btn.setText("Pressed"));

		JFrame frame = new JFrame("Button test");
		frame.add(btn);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
