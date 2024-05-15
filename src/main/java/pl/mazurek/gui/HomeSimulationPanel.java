package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.*;

public class HomeSimulationPanel extends JPanel {
    private Timer timer;
    TrafficLightSimulationApplication simulationApplication;

    public HomeSimulationPanel(TrafficLightSimulationApplication simulationApplication) {
        this.simulationApplication = simulationApplication;
        CarPanelService carPanel = new CarPanelService(simulationApplication);
        createTimerForCarAnimation(carPanel);
        createCars(carPanel);

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(carPanel);

        startButton.addActionListener(e -> {
            simulationApplication.isUsedByAlgorithm = false;
            startSimulation(simulationApplication);
        });

        resetButton.addActionListener(e -> resetSimulation(simulationApplication, carPanel));
    }

    private void createTimerForCarAnimation(CarPanelService carPanel) {
        timer = new Timer(1, e -> carPanel.moveCars());
    }

    private void startSimulation(TrafficLightSimulationApplication simulationApplication) {
        new Thread(
                simulationApplication::start
        ).start();

        timer.start();
    }

    private void resetSimulation(TrafficLightSimulationApplication simulationApplication, CarPanelService carPanel) {
        simulationApplication.stop();
        carPanel.resetCars();
        timer.stop();
    }

    private void createCars(CarPanelService carPanel) {
        new Thread(
                carPanel::createCars
        ).start();
    }
}
