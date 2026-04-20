package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryListDemo extends JFrame implements ListSelectionListener {

    JList<String> countryList;

    public CountryListDemo() {

        // Frame settings
        setTitle("Country List Demo");
        setSize(300, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Country array
        String[] countries = {
                "USA", "India", "Vietnam", "Canada", "Denmark",
                "France", "Great Britain", "Japan", "Africa",
                "Greenland", "Singapore"
        };

        // Create JList
        countryList = new JList<>(countries);

        // Allow single selection
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add selection listener
        countryList.addListSelectionListener(this);

        // Add JList inside scroll pane
        add(new JScrollPane(countryList));

        setVisible(true);
    }

    // Event handling method
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) { // prevents duplicate events
            String selectedCountry = countryList.getSelectedValue();

            if (selectedCountry != null) {
                System.out.println("Selected Country: " + selectedCountry);
            }
        }
    }

    public static void main(String[] args) {
        new CountryListDemo();
    }
}