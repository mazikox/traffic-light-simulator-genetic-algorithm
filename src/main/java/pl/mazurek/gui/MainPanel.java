package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;

import javax.swing.*;

public class MainPanel extends JFrame {


    public MainPanel() {

        setTitle("Simulation");
        setSize(1024, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


        JTabbedPane tabbedPaneMain = new JTabbedPane();
        JTabbedPane tabbedPaneSimulation = new JTabbedPane();

        TrafficLightSimulationApplication simulationApplication = new TrafficLightSimulationApplication();
        JPanel simulationPanel = new HomeSimulationPanel(simulationApplication);
        JPanel arrivalConfigPanel = new ArrivalConfigPanel(simulationApplication);
        JPanel lightConfigPanel = new LightConfigPanel(simulationApplication);

        tabbedPaneSimulation.add("Home", simulationPanel);
        tabbedPaneSimulation.add("Arrival Config", arrivalConfigPanel);
        tabbedPaneSimulation.add("Light Config", lightConfigPanel);
        tabbedPaneMain.addTab("Simulation", tabbedPaneSimulation);

        JPanel geneticAlgorithmPanel = new GeneticAlgorithPanel();
        tabbedPaneMain.addTab("Genetic Algorithm", geneticAlgorithmPanel);

        add(tabbedPaneMain);
        setVisible(true);
    }
}
