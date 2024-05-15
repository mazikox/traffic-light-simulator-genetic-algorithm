package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightConfigPanel extends JPanel implements ActionListener {

    private JTextField southToNorthTextField;
    private JTextField southToWestTextField;
    private JTextField westToEastTextField;
    private JTextField westToNorthTextField;

    TrafficLightSimulationApplication simulationApplication;

    public LightConfigPanel(TrafficLightSimulationApplication simulationApplication) {
        this.simulationApplication = simulationApplication;

        setLayout(null);

        southToNorthTextField = new JTextField(String.valueOf(simulationApplication.CZAS_DOL_GORA));
        southToWestTextField = new JTextField(String.valueOf(simulationApplication.CZAS_DOL_LEWO));
        westToEastTextField = new JTextField(String.valueOf(simulationApplication.CZAS_LEWO_PRAWO));
        westToNorthTextField = new JTextField(String.valueOf(simulationApplication.CZAS_LEWO_GORA));

        southToNorthTextField.setBounds(700,650, 100, 30);
        southToWestTextField.setBounds(550,650, 100, 30);
        westToEastTextField.setBounds(10,500, 100, 30);
        westToNorthTextField.setBounds(10,400, 100, 30);

        southToNorthTextField.addActionListener(this);
        southToWestTextField.addActionListener(this);
        westToEastTextField.addActionListener(this);
        westToNorthTextField.addActionListener(this);


        add(southToNorthTextField);
        add(southToWestTextField);
        add(westToEastTextField);
        add(westToNorthTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();
        String newText = source.getText();
        source.setText(newText);

        if (source == southToNorthTextField) {
            simulationApplication.CZAS_DOL_GORA = Integer.parseInt(newText);
        } else if (source == southToWestTextField) {
            simulationApplication.CZAS_DOL_LEWO = Integer.parseInt(newText);
        } else if (source == westToEastTextField) {
            simulationApplication.CZAS_LEWO_PRAWO = Integer.parseInt(newText);
        } else if (source == westToNorthTextField) {
            simulationApplication.CZAS_LEWO_GORA = Integer.parseInt(newText);
        }
    }
}