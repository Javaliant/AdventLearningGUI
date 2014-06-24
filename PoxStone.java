/* Author: Luigi Vincent
Generates 8 cards with a highlight, and pressed icon, revealing a random and distinct card on click
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ex_11 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("PoxStone");
		frame.setSize(850, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon cardBack = new ImageIcon("C:/MyWork/Images/Default.png");
		ImageIcon cardLight = new ImageIcon("C:/MyWork/Images/Pandaria.png");
		ImageIcon cardClick = new ImageIcon("C:/MyWork/Images/Black Temple.png");

		ImageIcon nora = new ImageIcon("C:/MyWork/Images/Nora.png");
		frame.setIconImage(nora.getImage());

		ImageIcon[] cards = new ImageIcon[11];
		for (int i = 1; i < 12; i++){ cards[i - 1] = new ImageIcon("C:/MyWork/Images/PoxStone/" + i + ".jpg"); }

		Collections.shuffle(Arrays.asList(cards));

		JButton[] card_select = new JButton[8]; // button array
		// Populate with buttons
		for (int i = 0; i < 8; i++) {
			card_select[i] = new JButton(cardBack); // default
			card_select[i].setRolloverIcon(cardLight); // on hover
			card_select[i].setPressedIcon(cardClick); // on press icon
		}
		// Action Listener for buttons
		ActionListener cardListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 8; i++) {
					if (e.getSource() == card_select[i]) {
						card_select[i].setIcon(cards[i]);
						card_select[i].setRolloverIcon(null);
						card_select[i].setPressedIcon(null);
					}
				}
			}
		};
		// Register Action Listener
		for (int i = 0; i < 8; i++) { card_select[i].addActionListener(cardListener); } 

		// Panels to house buttons
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		// Add buttons to panels
		for (int i = 0; i < 8; i++) { if (i < 4) p1.add(card_select[i]); else p2.add(card_select[i]); }
		// Add panels to frame
		frame.add(p1, BorderLayout.CENTER);
		frame.add(p2, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
