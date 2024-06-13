package pl.mazurek.application;

import javax.swing.*;
import java.util.Random;

public class GeneticAlgorithmApplication {

    public static int POPULATION = 10;
    public static int GENERATION  = 5;
    public static double MUTATION_PROBABILITY = 0.1;

    public void startAlgorithm(JTextArea textArea) {
        textArea.append("Started algorithm\n");
        int[] results = new int[POPULATION];
        int[] timeSouthToNorthAndNorthToSouth = new int[POPULATION];
        int[] timeWestToEastAndEastToWest = new int[POPULATION];
        int[] timeSouthToWestAndNorthToEast = new int[POPULATION];
        int[] timeWestToNorthAndEastToSouth = new int[POPULATION];

        // creating population
        for (int i = 0; i < POPULATION; i++) {
            timeSouthToNorthAndNorthToSouth[i] = generateTime();
            timeWestToEastAndEastToWest[i] = generateTime();
            timeSouthToWestAndNorthToEast[i] = generateTime();
            timeWestToNorthAndEastToSouth[i] = generateTime();
            System.out.println("results");
            results[i] = startSimulation(timeSouthToNorthAndNorthToSouth[i],
                    timeWestToEastAndEastToWest[i],
                    timeSouthToWestAndNorthToEast[i],
                    timeWestToNorthAndEastToSouth[i]);
            textArea.append(".");
        }

        for (int i = 0; i < GENERATION; i++) {
            int[] newResults = new int[POPULATION];
            int[] newTimeSouthToNorthAndNorthToSouth = new int[POPULATION];
            int[] newTimeWestToEastAndEastToWest = new int[POPULATION];
            int[] newTimeSouthToWestAndNorthToEast = new int[POPULATION];
            int[] newTimeWestToNorthAndEastToSouth = new int[POPULATION];
            textArea.append("\n");

            for (int j = 0; j < POPULATION; j += 2) {
                int parent1 = selectParent(results);
                int parent2 = selectParent(results);

                newTimeSouthToNorthAndNorthToSouth[j] = crossParent(timeSouthToNorthAndNorthToSouth[parent1], timeSouthToNorthAndNorthToSouth[parent2]);
                newTimeWestToEastAndEastToWest[j] = crossParent(timeWestToEastAndEastToWest[parent1], timeWestToEastAndEastToWest[parent2]);
                newTimeSouthToWestAndNorthToEast[j] = crossParent(timeSouthToWestAndNorthToEast[parent1], timeSouthToWestAndNorthToEast[parent2]);
                newTimeWestToNorthAndEastToSouth[j] = crossParent(timeWestToNorthAndEastToSouth[parent1], timeWestToNorthAndEastToSouth[parent2]);

                newTimeSouthToNorthAndNorthToSouth[j + 1] = crossParent(timeSouthToNorthAndNorthToSouth[parent2], timeSouthToNorthAndNorthToSouth[parent1]);
                newTimeWestToEastAndEastToWest[j + 1] = crossParent(timeWestToEastAndEastToWest[parent2], timeWestToEastAndEastToWest[parent1]);
                newTimeSouthToWestAndNorthToEast[j + 1] = crossParent(timeSouthToWestAndNorthToEast[parent2], timeSouthToWestAndNorthToEast[parent1]);
                newTimeWestToNorthAndEastToSouth[j + 1] = crossParent(timeWestToNorthAndEastToSouth[parent2], timeWestToNorthAndEastToSouth[parent1]);

                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeSouthToNorthAndNorthToSouth[j] = mutate(newTimeSouthToNorthAndNorthToSouth[j]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeWestToEastAndEastToWest[j] = mutate(newTimeWestToEastAndEastToWest[j]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeSouthToWestAndNorthToEast[j] = mutate(newTimeSouthToWestAndNorthToEast[j]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeWestToNorthAndEastToSouth[j] = mutate(newTimeWestToNorthAndEastToSouth[j]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeSouthToNorthAndNorthToSouth[j + 1] = mutate(newTimeSouthToNorthAndNorthToSouth[j + 1]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeWestToEastAndEastToWest[j + 1] = mutate(newTimeWestToEastAndEastToWest[j + 1]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeSouthToWestAndNorthToEast[j + 1] = mutate(newTimeSouthToWestAndNorthToEast[j + 1]);
                }
                if (Math.random() < MUTATION_PROBABILITY) {
                    newTimeWestToNorthAndEastToSouth[j + 1] = mutate(newTimeWestToNorthAndEastToSouth[j + 1]);
                }

                // rating kids
                newResults[j] = startSimulation(newTimeSouthToNorthAndNorthToSouth[j],
                        newTimeWestToEastAndEastToWest[j],
                        newTimeSouthToWestAndNorthToEast[j],
                        newTimeWestToNorthAndEastToSouth[j]);
                textArea.append(".");
                newResults[j + 1] = startSimulation(newTimeSouthToNorthAndNorthToSouth[j + 1],
                        newTimeWestToEastAndEastToWest[j + 1],
                        newTimeSouthToWestAndNorthToEast[j + 1],
                        newTimeWestToNorthAndEastToSouth[j + 1]);
                textArea.append(".");
            }

            // old population replaced by new
            timeSouthToNorthAndNorthToSouth = newTimeSouthToNorthAndNorthToSouth;
            timeWestToEastAndEastToWest = newTimeWestToEastAndEastToWest;
            timeSouthToWestAndNorthToEast = newTimeSouthToWestAndNorthToEast;
            timeWestToNorthAndEastToSouth = newTimeWestToNorthAndEastToSouth;
            results = newResults;
        }

        int bestIndex = findBestIndex(results);
        textArea.setText("South to North: " + timeSouthToNorthAndNorthToSouth[bestIndex]);
        textArea.append("\nSouth to West: " + timeSouthToWestAndNorthToEast[bestIndex]);
        textArea.append("\nWest to East: " + timeWestToEastAndEastToWest[bestIndex]);
        textArea.append("\nWest To North: " + timeWestToNorthAndEastToSouth[bestIndex]);
    }

    private int findBestIndex(int[] results) {
        int bestIndex = 0;
        for (int i = 1; i < results.length; i++) {
            if (results[i] > results[bestIndex]) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    private int mutate(int time) {
        int mutationAmount = new Random().nextInt(3500) + 2000;
        return time + mutationAmount;
    }


    private int selectParent(int[] wyniki) {
        Random random = new Random();
        int tournamentSize = 3;
        int bestIndex = random.nextInt(wyniki.length);

        for (int i = 1; i < tournamentSize; i++) {
            int randomIndex = random.nextInt(wyniki.length);
            if (wyniki[randomIndex] > wyniki[bestIndex]) {
                bestIndex = randomIndex;
            }
        }

        return bestIndex;
    }


    private int startSimulation(int southNorth, int westEast, int southWest, int westNorth) {
        TrafficLightSimulationApplication simulationApplication = new TrafficLightSimulationApplication();
        simulationApplication.speed = 100;
        simulationApplication.southToNorthTimeLight = southNorth;
        simulationApplication.westToEastTimeLight = westEast;
        simulationApplication.southToWestTimeLight = southWest;
        simulationApplication.westToNorthTimeLight = westNorth;
        simulationApplication.isUsedByAlgorithm = true;

        return simulationApplication.simulation();
    }


    private int crossParent(int rodzic1, int rodzic2) {
        return (new Random().nextBoolean()) ? rodzic1 : rodzic2;
    }

    private int generateTime() {
        return new Random().nextInt(4000) + 2000;
    }
}
