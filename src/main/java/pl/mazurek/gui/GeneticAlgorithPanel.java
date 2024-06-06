package pl.mazurek.gui;

import pl.mazurek.application.GeneticAlgorithmApplication;

import javax.swing.*;
import java.awt.*;

public class GeneticAlgorithPanel extends JPanel {

    JTextField populationArea;
    JTextField generationArea;
    JTextField mutationArea;
    JTextArea logsArea;
    GeneticAlgorithmApplication geneticAlgorithmApplication;

    public GeneticAlgorithPanel() {
        geneticAlgorithmApplication = new GeneticAlgorithmApplication();

        setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("Genetic Algorithm", JLabel.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(headerLabel, BorderLayout.NORTH);

        JPanel algorithmSettingsPanel = new JPanel();
        algorithmSettingsPanel.setLayout(new GridLayout(3, 2, 10, 10));

        algorithmSettingsPanel.add(new JLabel("Population size:"));
        populationArea = new JTextField(String.valueOf(GeneticAlgorithmApplication.POPULATION));
        algorithmSettingsPanel.add(populationArea);

        algorithmSettingsPanel.add(new JLabel("Number of generations:"));
        generationArea = new JTextField(String.valueOf(GeneticAlgorithmApplication.GENERATION));
        algorithmSettingsPanel.add(generationArea);

        algorithmSettingsPanel.add(new JLabel("Mutation chance:"));
        mutationArea = new JTextField(String.valueOf(GeneticAlgorithmApplication.MUTATION_PROBABILITY));
        algorithmSettingsPanel.add(mutationArea);

        add(algorithmSettingsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveSettings());
        buttonPanel.add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> cancelSettings());
        buttonPanel.add(cancelButton);

        JButton startButton = new JButton("Start algorith");
        startButton.addActionListener(e -> startSimulation());
        buttonPanel.add(startButton);

        logsArea = new JTextArea(10,50);
        logsArea.setFont(new Font("Serif", Font.BOLD, 18));
        buttonPanel.add(logsArea);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void cancelSettings() {
    }

    private void saveSettings() {
    }

    private void startSimulation(){
        new Thread(() -> {
            geneticAlgorithmApplication.startAlgorithm(logsArea);
        }).start();
    }
}
