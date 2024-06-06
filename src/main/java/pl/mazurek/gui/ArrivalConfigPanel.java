package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.*;

public class ArrivalConfigPanel extends JPanel {

    private JTextField southToNorthTextField;
    private JTextField southToWestTextField;
    private JTextField westToEastTextField;
    private JTextField westToNorthTextField;
    private JTextField northToSouthTextField;
    private JTextField northToEastTextField;
    private JTextField eastToWestTextField;
    private JTextField eastToSouthTextField;

    TrafficLightSimulationApplication simulationApplication;

    public ArrivalConfigPanel(TrafficLightSimulationApplication simulationApplication) {
        this.simulationApplication = simulationApplication;

        setLayout(new BorderLayout());

        // Header
        JLabel headerLabel = new JLabel("Car Arrival Time Configuration", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(headerLabel, BorderLayout.NORTH);

        // Time settings panel
        JPanel timeSettingsPanel = new JPanel();
        timeSettingsPanel.setLayout(new GridLayout(8, 2, 10, 10));

        timeSettingsPanel.add(new JLabel("South to North:"));
        southToNorthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeSouthToNorth));
        timeSettingsPanel.add(southToNorthTextField);

        timeSettingsPanel.add(new JLabel("South to West:"));
        southToWestTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeSouthToWest));
        timeSettingsPanel.add(southToWestTextField);

        timeSettingsPanel.add(new JLabel("West to East:"));
        westToEastTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeWestToEast));
        timeSettingsPanel.add(westToEastTextField);

        timeSettingsPanel.add(new JLabel("West to North:"));
        westToNorthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeWestToNorth));
        timeSettingsPanel.add(westToNorthTextField);

        timeSettingsPanel.add(new JLabel("North to South:"));
        northToSouthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeNorthToSouth));
        timeSettingsPanel.add(northToSouthTextField);

        timeSettingsPanel.add(new JLabel("North to East:"));
        northToEastTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeNorthToEast));
        timeSettingsPanel.add(northToEastTextField);

        timeSettingsPanel.add(new JLabel("East to West:"));
        eastToWestTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeEastToWest));
        timeSettingsPanel.add(eastToWestTextField);

        timeSettingsPanel.add(new JLabel("East to South:"));
        eastToSouthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeEastToSouth));
        timeSettingsPanel.add(eastToSouthTextField);

        add(timeSettingsPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveSettings());
        buttonPanel.add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> cancelSettings());
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveSettings() {
        try {
            simulationApplication.carArrivalTimeSouthToNorth = Integer.parseInt(southToNorthTextField.getText());
            simulationApplication.carArrivalTimeSouthToWest = Integer.parseInt(southToWestTextField.getText());
            simulationApplication.carArrivalTimeWestToEast = Integer.parseInt(westToEastTextField.getText());
            simulationApplication.carArrivalTimeWestToNorth = Integer.parseInt(westToNorthTextField.getText());
            simulationApplication.carArrivalTimeNorthToSouth = Integer.parseInt(northToSouthTextField.getText());
            simulationApplication.carArrivalTimeNorthToEast = Integer.parseInt(northToEastTextField.getText());
            simulationApplication.carArrivalTimeEastToWest = Integer.parseInt(eastToWestTextField.getText());
            simulationApplication.carArrivalTimeEastToSouth = Integer.parseInt(eastToSouthTextField.getText());
            JOptionPane.showMessageDialog(this, "Settings saved successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Not a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelSettings() {
        southToNorthTextField.setText(String.valueOf(simulationApplication.carArrivalTimeSouthToNorth));
        southToWestTextField.setText(String.valueOf(simulationApplication.carArrivalTimeSouthToWest));
        westToEastTextField.setText(String.valueOf(simulationApplication.carArrivalTimeWestToEast));
        westToNorthTextField.setText(String.valueOf(simulationApplication.carArrivalTimeWestToNorth));
        northToSouthTextField.setText(String.valueOf(simulationApplication.carArrivalTimeNorthToSouth));
        northToEastTextField.setText(String.valueOf(simulationApplication.carArrivalTimeNorthToEast));
        eastToWestTextField.setText(String.valueOf(simulationApplication.carArrivalTimeEastToWest));
        eastToSouthTextField.setText(String.valueOf(simulationApplication.carArrivalTimeEastToSouth));
    }
}
