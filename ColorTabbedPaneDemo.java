package lab5;

import javax.swing.*;
import java.awt.*;

public class ColorTabbedPaneDemo extends JFrame {

    public ColorTabbedPaneDemo() {

        // Frame settings
        setTitle("Tabbed Pane Color Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // RED Panel
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        tabbedPane.addTab("RED", redPanel);

        // BLUE Panel
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        tabbedPane.addTab("BLUE", bluePanel);

        // GREEN Panel
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        tabbedPane.addTab("GREEN", greenPanel);

        // Add tabbed pane to frame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ColorTabbedPaneDemo();
    }
}