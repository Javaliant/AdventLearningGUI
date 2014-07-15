/* Author: Luigi Vincent
Practicing Java Swing button and button events; Window that does simple calculation on two numbers
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class SimpleCalc extends JFrame {

    SimpleCalc (String name) {
        super(name);

        setLayout(new FlowLayout());

        // Fields for input and output
        JTextField result = new JTextField(10);
        JTextField num1 = new JTextField(5);
        JTextField num2 = new JTextField(5);
        result.setEditable(false);

        // Buttons for operations
        JButton add = new JButton("Add");
        JButton sub = new JButton("Subtract");
        JButton mul = new JButton("Multiply");
        JButton div = new JButton("Divide");

        // Listener to handle operations
        ActionListener calculator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Checks if fields are empty
                if (num1.getText().length() == 0 || num2.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Field missing", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // Checks if fields are numbers
                if (isNaN(num1.getText()) || isNaN(num2.getText())) {
                    JOptionPane.showMessageDialog(null, "Inputs must be numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                } 

                Double alpha = Double.parseDouble(num1.getText());
                Double beta = Double.parseDouble(num2.getText());
                Double omega = null;
                DecimalFormat f = new DecimalFormat("##.00");

                if (e.getSource() == add) {
                    omega = alpha + beta;
                }
                else if (e.getSource() == sub) {
                    omega = alpha - beta;
                }
                else if (e.getSource() == mul) {
                    omega = alpha * beta;
                }
                else if (e.getSource() == div) {
                    omega = alpha / beta;
                }
                result.setText(f.format(omega).toString());
            }
        };
       // Register buttons to event listener
        add.addActionListener(calculator);
        sub.addActionListener(calculator);
        mul.addActionListener(calculator);
        div.addActionListener(calculator);

       // Add everything to frame + labels    
        add(new JLabel("First Number"));
        add(num1);
        add(new JLabel("Second Number"));
        add(num2);
        add(new JLabel("Result"));
        add(result);
        add(add);
        add(sub);
        add(mul);
        add(div);
    }

    public static void main(String[] args) {
        SimpleCalc frame = new SimpleCalc("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method that checks whether or not input field is a number
    public static boolean isNaN(String str) {  
        try {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe) {
            return true;  
        }  
      return false;  
    }
}
