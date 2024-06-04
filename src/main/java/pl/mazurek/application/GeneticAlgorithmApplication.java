package pl.mazurek.application;

import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithmApplication {

    private static final int POPULATION = 6;
    private static final int GENERATION = 10;
    private static final double PRAWDOPODOBIENSTWO_MUTACJI = 0.1;

    public void startAlgorithm() {
        System.out.println("Started algorithm");
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
            results[i] = startSimulation(timeSouthToNorthAndNorthToSouth[i], timeWestToEastAndEastToWest[i], timeSouthToWestAndNorthToEast[i], timeWestToNorthAndEastToSouth[i]);
        }

        for (int i = 0; i < GENERATION; i++) {
            int[] newResults = new int[POPULATION];
            int[] newTimeSouthToNorthAndNorthToSouth = new int[POPULATION];
            int[] newTimeWestToEastAndEastToWest = new int[POPULATION];
            int[] newTimeSouthToWestAndNorthToEast = new int[POPULATION];
            int[] newTimeWestToNorthAndEastToSouth = new int[POPULATION];

            for (int j = 0; j < POPULATION; j += 2) {
                int parent1 = selectParent(results);
                int parent2 = selectParent(results);

                // crossing
                newTimeSouthToNorthAndNorthToSouth[j] = crossParent(timeSouthToNorthAndNorthToSouth[parent1], timeSouthToNorthAndNorthToSouth[parent2]);
                newTimeWestToEastAndEastToWest[j] = crossParent(timeWestToEastAndEastToWest[parent1], timeWestToEastAndEastToWest[parent2]);
                newTimeSouthToWestAndNorthToEast[j] = crossParent(timeSouthToWestAndNorthToEast[parent1], timeSouthToWestAndNorthToEast[parent2]);
                newTimeWestToNorthAndEastToSouth[j] = crossParent(timeWestToNorthAndEastToSouth[parent1], timeWestToNorthAndEastToSouth[parent2]);

                newTimeSouthToNorthAndNorthToSouth[j + 1] = crossParent(timeSouthToNorthAndNorthToSouth[parent2], timeSouthToNorthAndNorthToSouth[parent1]);
                newTimeWestToEastAndEastToWest[j + 1] = crossParent(timeWestToEastAndEastToWest[parent2], timeWestToEastAndEastToWest[parent1]);
                newTimeSouthToWestAndNorthToEast[j + 1] = crossParent(timeSouthToWestAndNorthToEast[parent2], timeSouthToWestAndNorthToEast[parent1]);
                newTimeWestToNorthAndEastToSouth[j + 1] = crossParent(timeWestToNorthAndEastToSouth[parent2], timeWestToNorthAndEastToSouth[parent1]);

                // mutation changing random 1 kid
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeSouthToNorthAndNorthToSouth[j] = mutate(newTimeSouthToNorthAndNorthToSouth[j]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeWestToEastAndEastToWest[j] = mutate(newTimeWestToEastAndEastToWest[j]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeSouthToWestAndNorthToEast[j] = mutate(newTimeSouthToWestAndNorthToEast[j]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeWestToNorthAndEastToSouth[j] = mutate(newTimeWestToNorthAndEastToSouth[j]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeSouthToNorthAndNorthToSouth[j + 1] = mutate(newTimeSouthToNorthAndNorthToSouth[j + 1]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeWestToEastAndEastToWest[j + 1] = mutate(newTimeWestToEastAndEastToWest[j + 1]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeSouthToWestAndNorthToEast[j + 1] = mutate(newTimeSouthToWestAndNorthToEast[j + 1]);
                }
                if (Math.random() < PRAWDOPODOBIENSTWO_MUTACJI) {
                    newTimeWestToNorthAndEastToSouth[j + 1] = mutate(newTimeWestToNorthAndEastToSouth[j + 1]);
                }

                // rating kids
                newResults[j] = startSimulation(newTimeSouthToNorthAndNorthToSouth[j], newTimeWestToEastAndEastToWest[j], newTimeSouthToWestAndNorthToEast[j], newTimeWestToNorthAndEastToSouth[j]);
                newResults[j + 1] = startSimulation(newTimeSouthToNorthAndNorthToSouth[j + 1], newTimeWestToEastAndEastToWest[j + 1], newTimeSouthToWestAndNorthToEast[j + 1], newTimeWestToNorthAndEastToSouth[j + 1]);
            }

            // old population replaced by new
            timeSouthToNorthAndNorthToSouth = newTimeSouthToNorthAndNorthToSouth;
            timeWestToEastAndEastToWest = newTimeWestToEastAndEastToWest;
            timeSouthToWestAndNorthToEast = newTimeSouthToWestAndNorthToEast;
            timeWestToNorthAndEastToSouth = newTimeWestToNorthAndEastToSouth;
            results = newResults;
        }

        int najlepszyIndex = findBestIndex(results);
        System.out.println("timeSouthToNorthAndNorthToSouth: " + timeSouthToNorthAndNorthToSouth[najlepszyIndex]);
        System.out.println("timeWestToEastAndEastToWest: " + timeWestToEastAndEastToWest[najlepszyIndex]);
        System.out.println("timeSouthToWestAndNorthToEast: " + timeSouthToWestAndNorthToEast[najlepszyIndex]);
        System.out.println("timeWestToNorthAndEastToSouth: " + timeWestToNorthAndEastToSouth[najlepszyIndex]);

    }

    private int findBestIndex(int[] wyniki) {
        int bestIndex = 0;
        for (int i = 1; i < wyniki.length; i++) {
            if (wyniki[i] > wyniki[bestIndex]) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    private int mutate(int time) {
        int mutationAmount = new Random().nextInt(5500) + 1000;
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
        // Initialize simulation application with given timings
        TrafficLightSimulationApplication simulationApplication = new TrafficLightSimulationApplication();
        simulationApplication.speed = 100;
        simulationApplication.CZAS_DOL_GORA = southNorth;
        simulationApplication.CZAS_LEWO_PRAWO = westEast;
        simulationApplication.CZAS_DOL_LEWO = southWest;
        simulationApplication.CZAS_LEWO_GORA = westNorth;
        simulationApplication.isUsedByAlgorithm = true;

        // Run simulation and calculate fitness as the inverse of the total waiting time
        int value = simulationApplication.simulation();
        return value;  // Higher fitness for lower waiting times
    }


    private int crossParent(int rodzic1, int rodzic2) {
        return (new Random().nextBoolean()) ? rodzic1 : rodzic2;
    }

    private int generateTime() {
        return new Random().nextInt(6000) + 1000;
    }
}
