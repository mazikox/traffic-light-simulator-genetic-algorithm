package pl.mazurek.gui;

import pl.mazurek.application.GeneticAlgorithmApplication;

import javax.swing.*;
import java.awt.*;

public class GeneticAlgorithPanel extends JPanel {

    JTextField populationTextField;
    JTextField generationTextField;
    JTextField mutationTextField;
    JTextArea logsTextArea;
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
        populationTextField = new JTextField(String.valueOf(GeneticAlgorithmApplication.POPULATION));
        algorithmSettingsPanel.add(populationTextField);

        algorithmSettingsPanel.add(new JLabel("Number of generations:"));
        generationTextField = new JTextField(String.valueOf(GeneticAlgorithmApplication.GENERATION));
        algorithmSettingsPanel.add(generationTextField);

        algorithmSettingsPanel.add(new JLabel("Mutation chance:"));
        mutationTextField = new JTextField(String.valueOf(GeneticAlgorithmApplication.MUTATION_PROBABILITY));
        algorithmSettingsPanel.add(mutationTextField);

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

        logsTextArea = new JTextArea(10, 50);
        logsTextArea.setFont(new Font("Serif", Font.BOLD, 18));
        logsTextArea.setEditable(false);
        buttonPanel.add(logsTextArea);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveSettings() {
        try {
            GeneticAlgorithmApplication.POPULATION = Integer.parseInt(populationTextField.getText());
            GeneticAlgorithmApplication.GENERATION = Integer.parseInt(generationTextField.getText());
            GeneticAlgorithmApplication.MUTATION_PROBABILITY = Double.parseDouble(mutationTextField.getText());
            JOptionPane.showMessageDialog(this, "Settings saved successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Not a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelSettings() {
        populationTextField.setText(String.valueOf(GeneticAlgorithmApplication.POPULATION));
        generationTextField.setText(String.valueOf(GeneticAlgorithmApplication.GENERATION));
        mutationTextField.setText(String.valueOf(GeneticAlgorithmApplication.MUTATION_PROBABILITY));
    }

    private void startSimulation() {
        new Thread(() -> {
            geneticAlgorithmApplication.startAlgorithm(logsTextArea);
        }).start();
    }
}
