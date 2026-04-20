package lab5;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class CountryCapitalList extends JFrame implements ListSelectionListener {

    JList<String> countryList;
    HashMap<String, String> capitalMap;

    public CountryCapitalList() {

        // Frame settings
        setTitle("Country Capital List");
        setSize(300, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Countries
        String[] countries = {
                "USA", "India", "Vietnam", "Canada", "Denmark",
                "France", "Great Britain", "Japan", "Africa",
                "Greenland", "Singapore"
        };

        // Create country-capital mapping
        capitalMap = new HashMap<>();
        capitalMap.put("USA", "Washington D.C");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "Nairobi"); // (generic handling)
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // Create JList
        countryList = new JList<>(countries);
        countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add listener
        countryList.addListSelectionListener(this);

        // Add scroll pane
        add(new JScrollPane(countryList));

        setVisible(true);
    }

    // Event handling
    public void valueChanged(ListSelectionEvent e) {

        if (!e.getValueIsAdjusting()) {
            String country = countryList.getSelectedValue();

            if (country != null) {
                String capital = capitalMap.get(country);
                System.out.println("Country: " + country + " | Capital: " + capital);
            }
        }
    }

    public static void main(String[] args) {
        new CountryCapitalList();
    }
}