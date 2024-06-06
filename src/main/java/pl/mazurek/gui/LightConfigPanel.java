package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.*;

public class LightConfigPanel extends JPanel {

    private JTextField southToNorthTextField;
    private JTextField southToWestTextField;
    private JTextField westToEastTextField;
    private JTextField westToNorthTextField;

    TrafficLightSimulationApplication simulationApplication;

    public LightConfigPanel(TrafficLightSimulationApplication simulationApplication) {
        this.simulationApplication = simulationApplication;

        setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Traffic Light Configuration", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(headerLabel, BorderLayout.NORTH);

        JPanel timeSettingsPanel = new JPanel();
        timeSettingsPanel.setLayout(new GridLayout(4, 2, 10, 10));

        timeSettingsPanel.add(new JLabel("South to North:"));
        southToNorthTextField = new JTextField(String.valueOf(simulationApplication.southToNorthTimeLight));
        timeSettingsPanel.add(southToNorthTextField);

        timeSettingsPanel.add(new JLabel("South to West:"));
        southToWestTextField = new JTextField(String.valueOf(simulationApplication.southToWestTimeLight));
        timeSettingsPanel.add(southToWestTextField);

        timeSettingsPanel.add(new JLabel("West to East:"));
        westToEastTextField = new JTextField(String.valueOf(simulationApplication.westToEastTimeLight));
        timeSettingsPanel.add(westToEastTextField);

        timeSettingsPanel.add(new JLabel("West to North:"));
        westToNorthTextField = new JTextField(String.valueOf(simulationApplication.westToNorthTimeLight));
        timeSettingsPanel.add(westToNorthTextField);

        add(timeSettingsPanel, BorderLayout.CENTER);

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
            simulationApplication.southToNorthTimeLight = Integer.parseInt(southToNorthTextField.getText());
            simulationApplication.southToWestTimeLight = Integer.parseInt(southToWestTextField.getText());
            simulationApplication.westToEastTimeLight = Integer.parseInt(westToEastTextField.getText());
            simulationApplication.westToNorthTimeLight = Integer.parseInt(westToNorthTextField.getText());
            JOptionPane.showMessageDialog(this, "Settings saved successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Not a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelSettings() {
        southToNorthTextField.setText(String.valueOf(simulationApplication.southToNorthTimeLight));
        southToWestTextField.setText(String.valueOf(simulationApplication.southToWestTimeLight));
        westToEastTextField.setText(String.valueOf(simulationApplication.westToEastTimeLight));
        westToNorthTextField.setText(String.valueOf(simulationApplication.westToNorthTimeLight));
    }
}
