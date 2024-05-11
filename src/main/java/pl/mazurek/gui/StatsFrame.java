package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.*;

public class StatsFrame extends JFrame {
    int carsWaitingNorthToSouth;
    int carsWaitingEastToWest;
    int carsWaitingSouthToNorth;
    int carsWaitingWestToEast;
    int carsPassedNorthToSouth;
    int carsPassedEastToWest;
    int carsPassedSouthToNorth;
    int carsPassedWestToEast;

    JLabel carsWaitingNorthToSouthLabel;
    JLabel carsWaitingEastToWestLabel;
    JLabel carsWaitingSouthToNorthLabel;
    JLabel carsWaitingWestToEastLabel;
    JLabel carsPassedNorthToSouthLabel;
    JLabel carsPassedEastToWestLabel;
    JLabel carsPassedSouthToNorthLabel;
    JLabel carsPassedWestToEastLabel;

    public StatsFrame(TrafficLightSimulationApplication simulationApplication) throws HeadlessException {

        setSize(600, 450);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        carsWaitingNorthToSouthLabel = new JLabel("carsWaitingNorthToSouthLabel: " + carsWaitingNorthToSouth);
        carsWaitingNorthToSouthLabel.setBounds(10, 10, 300, 25);

        carsWaitingEastToWestLabel = new JLabel("carsWaitingEastToWestLabel: " + carsWaitingEastToWest);
        carsWaitingEastToWestLabel.setBounds(10, 60, 300, 25);

        carsWaitingSouthToNorthLabel = new JLabel("carsWaitingSouthToNorthLabel: " + carsWaitingSouthToNorth);
        carsWaitingSouthToNorthLabel.setBounds(10, 110, 300, 25);

        carsWaitingWestToEastLabel = new JLabel("carsWaitingWestToEastLabel: " + carsWaitingWestToEast);
        carsWaitingWestToEastLabel.setBounds(10, 160, 300, 25);

        carsPassedNorthToSouthLabel = new JLabel("carsPassedNorthToSouthLabel: " + carsPassedNorthToSouth);
        carsPassedNorthToSouthLabel.setBounds(300, 10, 300, 25);

        carsPassedEastToWestLabel = new JLabel("carsPassedEastToWestLabel: " + carsPassedEastToWest);
        carsPassedEastToWestLabel.setBounds(300, 60, 300, 25);

        carsPassedSouthToNorthLabel = new JLabel("carsPassedSouthToNorthLabel: " + carsPassedSouthToNorth);
        carsPassedSouthToNorthLabel.setBounds(300, 110, 300, 25);

        carsPassedWestToEastLabel = new JLabel("carsPassedWestToEastLabel: " + carsPassedWestToEast);
        carsPassedWestToEastLabel.setBounds(300, 160, 300, 25);

        add(carsWaitingNorthToSouthLabel);
        add(carsWaitingEastToWestLabel);
        add(carsWaitingSouthToNorthLabel);
        add(carsWaitingWestToEastLabel);
        add(carsPassedNorthToSouthLabel);
        add(carsPassedEastToWestLabel);
        add(carsPassedSouthToNorthLabel);
        add(carsPassedWestToEastLabel);
        setTitle("Statistics");
        setLayout(null);
        setVisible(true);

        new Thread(() -> {
            while (true){
                updateStats(simulationApplication);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void updateStats(TrafficLightSimulationApplication simulationApplication){
        carsWaitingNorthToSouth = simulationApplication.getIntersectionService().getIntersection().getCarsNorthToSouthOnIntersection();
        carsWaitingEastToWest = simulationApplication.getIntersectionService().getIntersection().getCarsEastToWestOnIntersection();
        carsWaitingSouthToNorth = simulationApplication.getIntersectionService().getIntersection().getCarsSouthToNorthOnIntersection();
        carsWaitingWestToEast = simulationApplication.getIntersectionService().getIntersection().getCarsWestToEastOnIntersection();
        carsPassedNorthToSouth = simulationApplication.getIntersectionService().getIntersection().getCarsPassedNorthToSouth();
        carsPassedEastToWest = simulationApplication.getIntersectionService().getIntersection().getCarsPassedEastToWest();
        carsPassedSouthToNorth = simulationApplication.getIntersectionService().getIntersection().getCarsPassedSouthToNorth();
        carsPassedWestToEast = simulationApplication.getIntersectionService().getIntersection().getCarsPassedWestToEast();

        carsWaitingNorthToSouthLabel.setText("carsWaitingNorthToSouthLabel: " + carsWaitingNorthToSouth);
        carsWaitingEastToWestLabel.setText("carsWaitingEastToWestLabel: " + carsWaitingEastToWest);
        carsWaitingSouthToNorthLabel.setText("carsWaitingSouthToNorthLabel: " + carsWaitingSouthToNorth);
        carsWaitingWestToEastLabel.setText("carsWaitingWestToEastLabel: " + carsWaitingWestToEast);
        carsPassedNorthToSouthLabel.setText("carsPassedNorthToSouthLabel: " + carsPassedNorthToSouth);
        carsPassedEastToWestLabel.setText("carsPassedEastToWestLabel: " + carsPassedEastToWest);
        carsPassedSouthToNorthLabel.setText("carsPassedSouthToNorthLabel: " + carsPassedSouthToNorth);
        carsPassedWestToEastLabel.setText("carsPassedWestToEastLabel: " + carsPassedWestToEast);
    }
}
