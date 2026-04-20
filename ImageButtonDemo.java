package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ImageButtonDemo implements ActionListener {





    JFrame frame;
    JButton btnClock, btnHourGlass;
    JLabel label;

    public ImageButtonDemo() {

        // Create Frame
        frame = new JFrame("Image Button Demo");
        frame.setLayout(new FlowLayout());

        // Create Label
        label = new JLabel("Click an Image Button");
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        // Load Images (make sure images are in project folder)
        ImageIcon clockIcon = new ImageIcon("digital_clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hourglass.png");

        // Create Buttons with Images
        btnClock = new JButton(clockIcon);
        btnHourGlass = new JButton(hourGlassIcon);

        // Remove button borders (optional for clean UI)
        btnClock.setBorderPainted(false);
        btnHourGlass.setBorderPainted(false);

        // Add Action Listener
        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        // Add components to frame
        frame.add(btnClock);
        frame.add(btnHourGlass);
        frame.add(label);

        // Frame settings
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnClock) {
            label.setText("Digital Clock is pressed");
        } else if (e.getSource() == btnHourGlass) {
            label.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonDemo();
    }
}