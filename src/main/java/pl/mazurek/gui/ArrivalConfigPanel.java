package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArrivalConfigPanel extends JPanel implements ActionListener {

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

        setLayout(null);

        southToNorthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeSouthToNorth));
        southToWestTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeSouthToWest));
        westToEastTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeWestToEast));
        westToNorthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeWestToNorth));
        northToSouthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeNorthToSouth));
        northToEastTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeNorthToEast));
        eastToWestTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeEastToWest));
        eastToSouthTextField = new JTextField(String.valueOf(simulationApplication.carArrivalTimeEastToSouth));

        southToNorthTextField.setBounds(700,650, 100, 30);
        southToWestTextField.setBounds(550,650, 100, 30);
        westToEastTextField.setBounds(10,500, 100, 30);
        westToNorthTextField.setBounds(10,400, 100, 30);
        northToSouthTextField.setBounds(250,10, 100, 30);
        northToEastTextField.setBounds(400,10, 100, 30);
        eastToWestTextField.setBounds(890,150, 100, 30);
        eastToSouthTextField.setBounds(890,250, 100, 30);

        southToNorthTextField.addActionListener(this);
        southToWestTextField.addActionListener(this);
        westToEastTextField.addActionListener(this);
        westToNorthTextField.addActionListener(this);
        northToSouthTextField.addActionListener(this);
        northToEastTextField.addActionListener(this);
        eastToWestTextField.addActionListener(this);
        eastToSouthTextField.addActionListener(this);


        add(southToNorthTextField);
        add(southToWestTextField);
        add(westToEastTextField);
        add(westToNorthTextField);
        add(northToSouthTextField);
        add(northToEastTextField);
        add(eastToWestTextField);
        add(eastToSouthTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();
        String newText = source.getText();
        source.setText(newText);

        if (source == southToNorthTextField) {
            simulationApplication.carArrivalTimeSouthToNorth = Integer.parseInt(newText);
        } else if (source == southToWestTextField) {
            simulationApplication.carArrivalTimeSouthToWest = Integer.parseInt(newText);
        } else if (source == westToEastTextField) {
            simulationApplication.carArrivalTimeWestToEast = Integer.parseInt(newText);
        } else if (source == westToNorthTextField) {
            simulationApplication.carArrivalTimeWestToNorth = Integer.parseInt(newText);
        } else if (source == northToSouthTextField) {
            simulationApplication.carArrivalTimeNorthToSouth = Integer.parseInt(newText);
        } else if (source == northToEastTextField) {
            simulationApplication.carArrivalTimeNorthToEast = Integer.parseInt(newText);
        } else if (source == eastToWestTextField) {
            simulationApplication.carArrivalTimeEastToWest = Integer.parseInt(newText);
        } else if (source == eastToSouthTextField) {
            simulationApplication.carArrivalTimeEastToSouth = Integer.parseInt(newText);
        }
    }
}