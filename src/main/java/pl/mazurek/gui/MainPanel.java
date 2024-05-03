package pl.mazurek.gui;

import pl.mazurek.application.TrafficLightSimulationApplication;
import pl.mazurek.entity.Car;
import pl.mazurek.entity.Direction;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {
    private TrafficLightSimulationApplication simulationApplication;


    private JButton startButton;
    private JButton resetButton;
    private CarPanelService carPanel;

    private Timer timer;

    public MainPanel(TrafficLightSimulationApplication simulationApplication) {
        this.simulationApplication = simulationApplication;

        setTitle("Simulation");
        setSize(1024, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        createTimerForCarAnimation();
        carPanel = new CarPanelService(simulationApplication);
        createCars(carPanel);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel simulationPanel = new JPanel();
        simulationPanel.setLayout(new BorderLayout());


        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        simulationPanel.add(buttonPanel, BorderLayout.SOUTH);
        simulationPanel.add(carPanel);

        tabbedPane.addTab("Simulation", simulationPanel);

        JPanel geneticAlgorithmPanel = new JPanel();
        tabbedPane.addTab("Genetic Algorithm", geneticAlgorithmPanel);

        add(tabbedPane);

        startButton.addActionListener(e -> startSimulation());

        resetButton.addActionListener(e -> resetSimulation());
    }

    private void createTimerForCarAnimation() {
        timer = new Timer(1, e -> {
            carPanel.moveCars();
        });
    }

    private void startSimulation() {
        new Thread(
                simulationApplication::start
        ).start();

        timer.start();
    }

    private void resetSimulation() {
        simulationApplication.stop();
        carPanel.resetCars();
        timer.stop();
    }

    private void createCars(CarPanelService carPanel) {
//        carPanel.addCar(780, 600, Direction.SOUTH, Direction.NORTH);
//        carPanel.addCar(200, -200, Direction.NORTH, Direction.SOUTH);
//        carPanel.addCar(920, 170, Direction.WEST, Direction.EAST);
//        carPanel.addCar(30, 520, Direction.EAST, Direction.WEST);

        new Thread(
                () -> {
                    while (true) {
                        if (simulationApplication.isActive()) {
                            synchronized (carPanel.getCars()) {
                                if (simulationApplication.getIntersectionService().getIntersection().getCarsSouth() > 0) {
                                    int numberOfCarsWaiting = carPanel.howManyCarsAreWaitingFromDirection(Direction.SOUTH);
                                    carPanel.addCar(780, 500 + numberOfCarsWaiting * 50, Direction.SOUTH, Direction.NORTH);
                                    simulationApplication.getIntersectionService().getIntersection().setCarsSouth(simulationApplication.getIntersectionService().getIntersection().getCarsSouth() - 1);

                                }
                                if (simulationApplication.getIntersectionService().getIntersection().getCarsNorth() > 0) {
                                    Car previousCar = getLastCarFromDirection(carPanel, Direction.SOUTH);
                                    int y = -50;
                                    if (previousCar != null && previousCar.y < 0) {
                                        y = previousCar.y - 50;
                                    }
                                    carPanel.addCar(200, y, Direction.NORTH, Direction.SOUTH);
                                    simulationApplication.getIntersectionService().getIntersection().setCarsNorth(simulationApplication.getIntersectionService().getIntersection().getCarsNorth() - 1);
                                }
                                if (simulationApplication.getIntersectionService().getIntersection().getCarsWest() > 0) {
                                    int numberOfCarsWaiting = carPanel.howManyCarsAreWaitingFromDirection(Direction.WEST);
                                    carPanel.addCar(50 - numberOfCarsWaiting * 50, 520, Direction.WEST, Direction.EAST);
                                    simulationApplication.getIntersectionService().getIntersection().setCarsWest(simulationApplication.getIntersectionService().getIntersection().getCarsWest() - 1);
                                }
                                if (simulationApplication.getIntersectionService().getIntersection().getCarsEast() > 0) {
                                    int numberOfCarsWaiting = carPanel.howManyCarsAreWaitingFromDirection(Direction.EAST);
                                    carPanel.addCar(920 + numberOfCarsWaiting * 50, 170, Direction.EAST, Direction.WEST);
                                    simulationApplication.getIntersectionService().getIntersection().setCarsEast(simulationApplication.getIntersectionService().getIntersection().getCarsEast() - 1);
                                }
                            }
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        ).start();
    }

    private Car getLastCarFromDirection(CarPanelService carPanel, Direction direction) {
        synchronized (carPanel.getCars()) {
            for (int i = carPanel.getCars().size() - 1; i >= 0; i--) {
                if (carPanel.getCars().get(i).getDirection().equals(direction)) {
                    return carPanel.getCars().get(i);
                }
            }
        }
        return null;
    }
}
