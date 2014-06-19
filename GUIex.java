/* Author: Luigi Vincent
Simply testing GUI components
*/

import javax.swing.*;

public class GUIex {
	public static void main(String[] args) {
	
		JButton jbtOK = new JButton("OK"), jbtCancel = new JButton("Cancel");
	
		JLabel jlblName = new JLabel("Enter your name: ");
		
		JTextField jtfName = new JTextField("Type Name Here");

		JCheckBox jchkBold = new JCheckBox("Bold"), jchkItalic = new JCheckBox("Italic");

		JRadioButton jrbRed = new JRadioButton("Red"), jrbYellow = new JRadioButton("Yellow");

		JComboBox<String> jcboColor = new JComboBox<>(new String[]{"Freshman", "Sophomore", "Junior", "Senior"});

		JPanel panel = new JPanel();
		panel.add(jbtOK);
		panel.add(jbtCancel);
		panel.add(jlblName);
		panel.add(jtfName);
		panel.add(jchkBold);
		panel.add(jchkItalic);
		panel.add(jrbRed);
		panel.add(jrbYellow);
		panel.add(jcboColor);

		JFrame frame = new JFrame("GUI Components");
		frame.add(panel);
		frame.setSize(450, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
