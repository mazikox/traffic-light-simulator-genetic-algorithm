package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.*;

public class StatsFrame extends JFrame {
    int carsWaitingNorthToSouth;
    int carsWaitingEastToWest;
    int carsWaitingSouthToNorth;
    int carsWaitingWestToEast;
    int carsWaitingNorthToEast;
    int carsWaitingEastToSouth;
    int carsWaitingSouthToWest;
    int carsWaitingWestToNorth;
    int carsPassedNorthToSouth;
    int carsPassedEastToWest;
    int carsPassedSouthToNorth;
    int carsPassedWestToEast;
    int carsPassedNorthToEast;
    int carsPassedEastToSouth;
    int carsPassedSouthToWest;
    int carsPassedWestToNorth;

    JLabel carsWaitingNorthToSouthLabel = new JLabel();
    JLabel carsWaitingEastToWestLabel = new JLabel();
    JLabel carsWaitingSouthToNorthLabel = new JLabel();
    JLabel carsWaitingWestToEastLabel = new JLabel();
    JLabel carsWaitingNorthToEastLabel = new JLabel();
    JLabel carsWaitingEastToSouthLabel = new JLabel();
    JLabel carsWaitingSouthToWestLabel = new JLabel();
    JLabel carsWaitingWestToNorthLabel = new JLabel();
    JLabel carsPassedNorthToSouthLabel = new JLabel();
    JLabel carsPassedEastToWestLabel = new JLabel();
    JLabel carsPassedSouthToNorthLabel = new JLabel();
    JLabel carsPassedWestToEastLabel = new JLabel();
    JLabel carsPassedNorthToEastLabel = new JLabel();
    JLabel carsPassedEastToSouthLabel = new JLabel();
    JLabel carsPassedSouthToWestLabel = new JLabel();
    JLabel carsPassedWestToNorthLabel = new JLabel();

    public StatsFrame(TrafficLightSimulationApplication simulationApplication) throws HeadlessException {

        setSize(600, 450);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        carsWaitingNorthToSouthLabel.setBounds(10, 10, 300, 25);
        carsWaitingEastToWestLabel.setBounds(10, 60, 300, 25);
        carsWaitingSouthToNorthLabel.setBounds(10, 110, 300, 25);
        carsWaitingWestToEastLabel.setBounds(10, 160, 300, 25);
        carsWaitingNorthToEastLabel.setBounds(10, 210, 300, 25);
        carsWaitingEastToSouthLabel.setBounds(10, 260, 300, 25);
        carsWaitingSouthToWestLabel.setBounds(10, 310, 300, 25);
        carsWaitingWestToNorthLabel.setBounds(10, 360, 300, 25);

        carsPassedNorthToSouthLabel.setBounds(300, 10, 300, 25);
        carsPassedEastToWestLabel.setBounds(300, 60, 300, 25);
        carsPassedSouthToNorthLabel.setBounds(300, 110, 300, 25);
        carsPassedWestToEastLabel.setBounds(300, 160, 300, 25);
        carsPassedNorthToEastLabel.setBounds(300, 210, 300, 25);
        carsPassedEastToSouthLabel.setBounds(300, 260, 300, 25);
        carsPassedSouthToWestLabel.setBounds(300, 310, 300, 25);
        carsPassedWestToNorthLabel.setBounds(300, 360, 300, 25);

        add(carsWaitingNorthToSouthLabel);
        add(carsWaitingEastToWestLabel);
        add(carsWaitingSouthToNorthLabel);
        add(carsWaitingWestToEastLabel);
        add(carsWaitingNorthToEastLabel);
        add(carsWaitingEastToSouthLabel);
        add(carsWaitingSouthToWestLabel);
        add(carsWaitingWestToNorthLabel);
        add(carsPassedNorthToSouthLabel);
        add(carsPassedEastToWestLabel);
        add(carsPassedSouthToNorthLabel);
        add(carsPassedWestToEastLabel);
        add(carsPassedNorthToEastLabel);
        add(carsPassedEastToSouthLabel);
        add(carsPassedSouthToWestLabel);
        add(carsPassedWestToNorthLabel);
        setTitle("Statistics");
        setLayout(null);
        setVisible(true);

        new Thread(() -> {
            while (true) {
                updateStats(simulationApplication);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void updateStats(TrafficLightSimulationApplication simulationApplication) {
        carsWaitingNorthToSouth = simulationApplication.getIntersectionService().getIntersection().getCarsNorthToSouthOnIntersection();
        carsWaitingEastToWest = simulationApplication.getIntersectionService().getIntersection().getCarsEastToWestOnIntersection();
        carsWaitingSouthToNorth = simulationApplication.getIntersectionService().getIntersection().getCarsSouthToNorthOnIntersection();
        carsWaitingWestToEast = simulationApplication.getIntersectionService().getIntersection().getCarsWestToEastOnIntersection();
        carsWaitingNorthToEast = simulationApplication.getIntersectionService().getIntersection().getCarsNorthToEastOnIntersection();
        carsWaitingEastToSouth = simulationApplication.getIntersectionService().getIntersection().getCarsEastToSouthOnIntersection();
        carsWaitingSouthToWest = simulationApplication.getIntersectionService().getIntersection().getCarsSouthToWestOnIntersection();
        carsWaitingWestToNorth = simulationApplication.getIntersectionService().getIntersection().getCarsWestToNorthOnIntersection();

        carsPassedNorthToSouth = simulationApplication.getIntersectionService().getIntersection().getCarsPassedNorthToSouth();
        carsPassedEastToWest = simulationApplication.getIntersectionService().getIntersection().getCarsPassedEastToWest();
        carsPassedSouthToNorth = simulationApplication.getIntersectionService().getIntersection().getCarsPassedSouthToNorth();
        carsPassedWestToEast = simulationApplication.getIntersectionService().getIntersection().getCarsPassedWestToEast();
        carsPassedNorthToEast = simulationApplication.getIntersectionService().getIntersection().getCarsPassedNorthToEast();
        carsPassedEastToSouth = simulationApplication.getIntersectionService().getIntersection().getCarsPassedEastToSouth();
        carsPassedSouthToWest = simulationApplication.getIntersectionService().getIntersection().getCarsPassedSouthToWest();
        carsPassedWestToNorth = simulationApplication.getIntersectionService().getIntersection().getCarsPassedWestToNorth();

        carsWaitingNorthToSouthLabel.setText("carsWaitingNorthToSouthLabel: " + carsWaitingNorthToSouth);
        carsWaitingEastToWestLabel.setText("carsWaitingEastToWestLabel: " + carsWaitingEastToWest);
        carsWaitingSouthToNorthLabel.setText("carsWaitingSouthToNorthLabel: " + carsWaitingSouthToNorth);
        carsWaitingWestToEastLabel.setText("carsWaitingWestToEastLabel: " + carsWaitingWestToEast);
        carsWaitingNorthToEastLabel.setText("carsWaitingNorthToEastLabel: " + carsWaitingNorthToEast);
        carsWaitingEastToSouthLabel.setText("carsWaitingEastToSouthLabel: " + carsWaitingEastToSouth);
        carsWaitingSouthToWestLabel.setText("carsWaitingSouthToWestLabel: " + carsWaitingSouthToWest);
        carsWaitingWestToNorthLabel.setText("carsWaitingWestToNorthLabel: " + carsWaitingWestToNorth);

        carsPassedNorthToSouthLabel.setText("carsPassedNorthToSouthLabel: " + carsPassedNorthToSouth);
        carsPassedEastToWestLabel.setText("carsPassedEastToWestLabel: " + carsPassedEastToWest);
        carsPassedSouthToNorthLabel.setText("carsPassedSouthToNorthLabel: " + carsPassedSouthToNorth);
        carsPassedWestToEastLabel.setText("carsPassedWestToEastLabel: " + carsPassedWestToEast);
        carsPassedNorthToEastLabel.setText("carsPassedNorthToEastLabel:" + carsPassedNorthToEast);
        carsPassedEastToSouthLabel.setText("carsPassedEastToSouthLabel: " + carsPassedEastToSouth);
        carsPassedSouthToWestLabel.setText("carsPassedSouthToWestLabel: " + carsPassedSouthToWest);
        carsPassedWestToNorthLabel.setText("carsPassedWestToNorthLabel: " + carsPassedWestToNorth);
    }
}
