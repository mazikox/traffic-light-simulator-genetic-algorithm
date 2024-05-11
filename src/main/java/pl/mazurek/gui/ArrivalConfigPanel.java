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

    public ArrivalConfigPanel() {
        setLayout(null);

        southToNorthTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeSouthToNorth));
        southToWestTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeSouthToWest));
        westToEastTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeWestToEast));
        westToNorthTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeWestToNorth));
        northToSouthTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeNorthToSouth));
        northToEastTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeNorthToEast));
        eastToWestTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeEastToWest));
        eastToSouthTextField = new JTextField(String.valueOf(TrafficLightSimulationApplication.carArrivalTimeEastToSouth));

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
            TrafficLightSimulationApplication.carArrivalTimeSouthToNorth = Integer.parseInt(newText);
        } else if (source == southToWestTextField) {
            TrafficLightSimulationApplication.carArrivalTimeSouthToWest = Integer.parseInt(newText);
        } else if (source == westToEastTextField) {
            TrafficLightSimulationApplication.carArrivalTimeWestToEast = Integer.parseInt(newText);
        } else if (source == westToNorthTextField) {
            TrafficLightSimulationApplication.carArrivalTimeWestToNorth = Integer.parseInt(newText);
        } else if (source == northToSouthTextField) {
            TrafficLightSimulationApplication.carArrivalTimeNorthToSouth = Integer.parseInt(newText);
        } else if (source == northToEastTextField) {
            TrafficLightSimulationApplication.carArrivalTimeNorthToEast = Integer.parseInt(newText);
        } else if (source == eastToWestTextField) {
            TrafficLightSimulationApplication.carArrivalTimeEastToWest = Integer.parseInt(newText);
        } else if (source == eastToSouthTextField) {
            TrafficLightSimulationApplication.carArrivalTimeEastToSouth = Integer.parseInt(newText);
        }
    }
}