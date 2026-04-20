package lab5;

import javax.swing.*;
import java.awt.*;

public class CYMTabbedPaneDemo extends JFrame {

    public CYMTabbedPaneDemo() {

        // Frame settings
        setTitle("CYM Tabbed Pane Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // CYAN Panel
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);
        tabbedPane.addTab("CYAN", cyanPanel);

        // MAGENTA Panel
        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);
        tabbedPane.addTab("MAGENTA", magentaPanel);

        // YELLOW Panel
        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        tabbedPane.addTab("YELLOW", yellowPanel);

        // Add tabbed pane to frame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CYMTabbedPaneDemo();
    }
}