/* Author: Luigi Vincent
Practicing Java Swing button and button events; Window that does simple calculation on two numbers
TO DO: Figure out why command prompt show so many messages when fields are empty & stop it
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
        JButton b_add = new JButton("Add");
        JButton b_sub = new JButton("Subtract");
        JButton b_mul = new JButton("Multiply");
        JButton b_div = new JButton("Divide");

        // Listener to handle operations
        ActionListener calculator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (num1.getText().length() == 0 || num2.getText().length() == 0) {
                        throw new Exception();
                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Field missing", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                Double alpha = Double.parseDouble(num1.getText());
                Double beta = Double.parseDouble(num2.getText());
                Double omega = null;
                DecimalFormat f = new DecimalFormat("##.00");

                if (e.getSource() == b_add) {
                    omega = alpha + beta;
                }
                else if (e.getSource() == b_sub) {
                    omega = alpha - beta;
                }
                else if (e.getSource() == b_mul) {
                    omega = alpha * beta;
                }
                else if (e.getSource() == b_div) {
                    omega = alpha / beta;
                }
                result.setText(f.format(omega).toString());
            }
        };
       // Register buttons to event listener
        b_add.addActionListener(calculator);
        b_sub.addActionListener(calculator);
        b_mul.addActionListener(calculator);
        b_div.addActionListener(calculator);

       // Add everything to frame + labels    
        add(new JLabel("First Number"));
        add(num1);
        add(new JLabel("Second Number"));
        add(num2);
        add(new JLabel("Result"));
        add(result);
        add(b_add);
        add(b_sub);
        add(b_mul);
        add(b_div);
    }
    public static void main(String[] args) {
        SimpleCalc frame = new SimpleCalc("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
