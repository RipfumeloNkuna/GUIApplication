import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUIApplication {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(7, 2));

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel surnameLabel = new JLabel("Surname:");
        JTextField surnameField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);

        JLabel countryLabel = new JLabel("Country:");
        String[] countries = {"USA", "Canada", "UK", "India", "Australia","south africa"};
        JComboBox<String> countryBox = new JComboBox<>(countries);

        JCheckBox termsCheckBox = new JCheckBox("Agree to terms");

        JButton displayButton = new JButton("Display");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        // Add components to frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(surnameLabel);
        frame.add(surnameField);
        frame.add(genderLabel);
        frame.add(genderPanel);
        frame.add(countryLabel);
        frame.add(countryBox);
        frame.add(termsCheckBox);
        frame.add(new JLabel());
        frame.add(displayButton);
        frame.add(saveButton);
        frame.add(exitButton);

        // Button actions
        displayButton.addActionListener(e -> {
            if (!termsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(frame, "You must agree to the terms.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String name = nameField.getText();
            String surname = surnameField.getText();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Other";
            String country = (String) countryBox.getSelectedItem();

            JOptionPane.showMessageDialog(frame, "Name: " + name + "\nSurname: " + surname + "\nGender: " + gender + "\nCountry: " + country);
        });

        saveButton.addActionListener(e -> {
            if (!termsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(frame, "You must agree to the terms.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String name = nameField.getText();
            String surname = surnameField.getText();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Other";
            String country = (String) countryBox.getSelectedItem();

            try (FileWriter writer = new FileWriter("output.txt")) {
                writer.write("Name: " + name + "\n");
                writer.write("Surname: " + surname + "\n");
                writer.write("Gender: " + gender + "\n");
                writer.write("Country: " + country + "\n");
                JOptionPane.showMessageDialog(frame, "Data saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        // Make frame visible
        frame.setVisible(true);
    }
}

