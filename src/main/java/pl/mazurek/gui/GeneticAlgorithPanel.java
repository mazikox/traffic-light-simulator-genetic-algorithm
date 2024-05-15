package pl.mazurek.gui;

import pl.mazurek.application.GeneticAlgorithmApplication;
import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;

public class GeneticAlgorithPanel extends JPanel {

    public GeneticAlgorithPanel() {
        JButton button = new JButton("Start algorith");
        button.addActionListener(e -> startSimulation());

        add(button);
    }

    private void startSimulation(){
        new Thread(() -> {
            GeneticAlgorithmApplication geneticAlgorithmApplication = new GeneticAlgorithmApplication();
            geneticAlgorithmApplication.startAlgorithm();
        }).start();
    }
}
