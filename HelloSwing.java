package lab4;
import javax.swing.*;
import java.awt.*;

public class HelloSwing {





    public static void main(String[] args) {

        // Create JFrame
        JFrame frame = new JFrame("Hello Swing");

        // Create JLabel
        JLabel label = new JLabel("Hello! VI C, Welcome to Swing Programming");

        // Set font (Plain, size 32)
        label.setFont(new Font("Arial", Font.PLAIN, 32));

        // Set text color to Blue
        label.setForeground(Color.BLUE);

        // Center the text
        label.setHorizontalAlignment(JLabel.CENTER);

        // Add label to frame
        frame.add(label);

        // Set frame size
        frame.setSize(700, 200);

        // Close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make frame visible
        frame.setVisible(true);
    }
}