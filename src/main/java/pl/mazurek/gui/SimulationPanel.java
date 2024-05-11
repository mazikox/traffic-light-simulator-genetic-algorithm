package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    private JButton startButton;
    private JButton resetButton;
    private Timer timer;

    public SimulationPanel(TrafficLightSimulationApplication simulationApplication) {
        CarPanelService carPanel = new CarPanelService(simulationApplication);
        createTimerForCarAnimation(carPanel);
        createCars(carPanel);

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(carPanel);

        startButton.addActionListener(e -> startSimulation(simulationApplication));

        resetButton.addActionListener(e -> resetSimulation(simulationApplication, carPanel));
    }

    private void createTimerForCarAnimation(CarPanelService carPanel) {
        timer = new Timer(1, e -> {
            carPanel.moveCars();
        });
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
