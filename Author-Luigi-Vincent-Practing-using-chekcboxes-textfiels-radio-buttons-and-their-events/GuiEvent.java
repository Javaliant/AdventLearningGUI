/* Author: Luigi Vincent 
Practing using chekcboxes, textfiels, radio buttons and their events
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class GuiEvent extends JFrame {
	private JLabel msg = new JLabel("I love Java", JLabel.CENTER);

	private JCheckBox bold = new JCheckBox("Bold");
	private JCheckBox italic = new JCheckBox("Italic");

	private JRadioButton c_red= new JRadioButton("Red");
	private JRadioButton c_green = new JRadioButton("Green");
	private JRadioButton c_blue = new JRadioButton("Blue");

	private JTextField txt = new JTextField(10);

	public static void main(String[] args) {
		GuiEvent frame = new GuiEvent();
		frame.pack();
		frame.setTitle("Gui Events At Work");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public GuiEvent() {
		msg.setBorder(new LineBorder(Color.BLACK, 2));
		add(msg, BorderLayout.CENTER);

		JPanel cPanel = new JPanel();
		cPanel.setLayout(new GridLayout(2, 1));
		cPanel.add(bold);
		cPanel.add(italic);
		add(cPanel, BorderLayout.EAST);

		JPanel rPanel = new JPanel();
		rPanel.setLayout(new GridLayout(3, 1));
		rPanel.add(c_red);
		rPanel.add(c_green);
		rPanel.add(c_blue);
		add(rPanel, BorderLayout.WEST);

		ButtonGroup group = new ButtonGroup();
		group.add(c_red);
		group.add(c_green);
		group.add(c_blue);

		c_blue.setSelected(true);
		msg.setForeground(Color.BLUE);

		JPanel tPanel = new JPanel();
		tPanel.setLayout(new BorderLayout(5, 0));
		tPanel.add(new JLabel("Enter a new message"), BorderLayout.WEST);
		tPanel.add(txt, BorderLayout.CENTER);
		txt.setHorizontalAlignment(JTextField.RIGHT);
		add(tPanel, BorderLayout.NORTH);

		bold.setMnemonic('B');
		italic.setMnemonic('I');
		c_red.setMnemonic('E');
		c_green.setMnemonic('G');
		c_blue.setMnemonic('U');

		bold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewFont();
			}
		});
		italic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewFont();
			}
		});

		c_red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setForeground(Color.RED);
			}
		});

		c_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setForeground(Color.BLUE);
			}
		});

		c_green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setForeground(Color.GREEN);
			}
		});

		txt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setText(txt.getText());
				txt.requestFocusInWindow();
			}
		});
	}

	private void setNewFont() {
		int fontStyle = Font.PLAIN;
		fontStyle += (bold.isSelected() ? Font.BOLD : Font.PLAIN);
		fontStyle += (italic.isSelected() ? Font.ITALIC : Font.PLAIN);

		Font font = msg.getFont();
		msg.setFont( new Font(font.getName(), fontStyle, font.getSize()));
	}
}
