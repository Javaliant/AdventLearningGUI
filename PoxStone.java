/* Author: Luigi Vincent
Generates 4 cards with a highlight and random pressed icon. 
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PoxStone {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercise 12.1");
		frame.setSize(850, 325);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel();

		ImageIcon cardBack = new ImageIcon("C:/MyWork/Images/Default.png");
		ImageIcon cardLight = new ImageIcon("C:/MyWork/Images/Pandaria.png");

		JButton alpha = new JButton(cardBack);
		JButton beta = new JButton(cardBack);
		JButton gamma = new JButton(cardBack);
		JButton delta = new JButton(cardBack);

		alpha.setRolloverIcon(cardLight);
		beta.setRolloverIcon(cardLight);
		gamma.setRolloverIcon(cardLight);
		delta.setRolloverIcon(cardLight);

		ImageIcon[] cards = new ImageIcon[11];
		for (int i = 1; i < 12; i++){ cards[i - 1] = new ImageIcon("C:/MyWork/Images/PoxStone/" + i + ".jpg"); }

		Collections.shuffle(Arrays.asList(cards));

		alpha.setPressedIcon(cards[0]);
		beta.setPressedIcon(cards[1]);
		gamma.setPressedIcon(cards[2]);
		delta.setPressedIcon(cards[3]);

		p1.add(alpha);
		p1.add(beta);
		p1.add(gamma);
		p1.add(delta);

		frame.add(p1);
		frame.setVisible(true);
	}

	public static int getPick(){
		return (int)(Math.random() * 11);
	}
}
