package pl.mazurek.application;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneticAlgorithmApplication {

    private static final int LICZBA_POPULACJI = 6;
    private static final int LICZBA_ITERACJI = 10;
    private static final double PRAWDOPODOBIENSTWO_MUTACJI = 0.3;

    public void startAlgorithm() {
        System.out.println("Started algorithm");
        int[] wyniki = new int[LICZBA_POPULACJI];
        int[] timeSouthToNorthAndNorthToSouth = new int[LICZBA_POPULACJI];
        int[] timeWestToEastAndEastToWest = new int[LICZBA_POPULACJI];
        int[] timeSouthToWestAndNorthToEast = new int[LICZBA_POPULACJI];
        int[] timeWestToNorthAndEastToSouth = new int[LICZBA_POPULACJI];

        // creating population
        for (int i = 0; i < LICZBA_POPULACJI; i++) {
            timeSouthToNorthAndNorthToSouth[i] = losujCzas();
            timeWestToEastAndEastToWest[i] = losujCzas();
            timeSouthToWestAndNorthToEast[i] = losujCzas();
            timeWestToNorthAndEastToSouth[i] = losujCzas();
            System.out.println("wyniki");
            wyniki[i] = startSimulation(timeSouthToNorthAndNorthToSouth[i], timeWestToEastAndEastToWest[i], timeSouthToWestAndNorthToEast[i], timeWestToNorthAndEastToSouth[i]);
        }

        for (int i = 0; i < LICZBA_ITERACJI; i++) {
            int[] noweWyniki = new int[LICZBA_POPULACJI];
            int[] newTimeSouthToNorthAndNorthToSouth = new int[LICZBA_POPULACJI];
            int[] newTimeWestToEastAndEastToWest = new int[LICZBA_POPULACJI];
            int[] newTimeSouthToWestAndNorthToEast = new int[LICZBA_POPULACJI];
            int[] newTimeWestToNorthAndEastToSouth = new int[LICZBA_POPULACJI];

            for (int j = 0; j < LICZBA_POPULACJI; j += 2) {
                int parent1 = selectParent(wyniki);
                int parent2 = selectParent(wyniki);

                // crossing
                int crossPoint = 10;
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
                noweWyniki[j] = startSimulation(newTimeSouthToNorthAndNorthToSouth[j], newTimeWestToEastAndEastToWest[j], newTimeSouthToWestAndNorthToEast[j], newTimeWestToNorthAndEastToSouth[j]);
                noweWyniki[j + 1] = startSimulation(newTimeSouthToNorthAndNorthToSouth[j + 1], newTimeWestToEastAndEastToWest[j + 1], newTimeSouthToWestAndNorthToEast[j + 1], newTimeWestToNorthAndEastToSouth[j + 1]);
            }

            // old population replaced by new
            timeSouthToNorthAndNorthToSouth = newTimeSouthToNorthAndNorthToSouth;
            timeWestToEastAndEastToWest = newTimeWestToEastAndEastToWest;
            timeSouthToWestAndNorthToEast = newTimeSouthToWestAndNorthToEast;
            timeWestToNorthAndEastToSouth = newTimeWestToNorthAndEastToSouth;
            wyniki = noweWyniki;
        }

        int najlepszyIndex = findBestIndex(wyniki);
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
        int mutationAmount = new Random().nextInt(5500) - 2000;  // Smaller mutation range
        return time + mutationAmount;
    }


    private int selectParent(int[] wyniki) {
        int totalFitness = Arrays.stream(wyniki).sum();
        int randomPoint = new Random().nextInt(totalFitness);
        int runningSum = 0;

        for (int i = 0; i < wyniki.length; i++) {
            runningSum += wyniki[i];
            if (runningSum >= randomPoint) {
                return i;
            }
        }
        return wyniki.length - 1;
    }


    private int startSimulation(int southNorth, int westEast, int southWest, int westNorth) {
        // Initialize simulation application with given timings
        TrafficLightSimulationApplication simulationApplication = new TrafficLightSimulationApplication();
        simulationApplication.CZAS_DOL_GORA = southNorth;
        simulationApplication.CZAS_LEWO_PRAWO = westEast;
        simulationApplication.CZAS_DOL_LEWO = southWest;
        simulationApplication.CZAS_LEWO_GORA = westNorth;
        simulationApplication.isUsedByAlgorithm = true;

        // Run simulation and calculate fitness as the inverse of the total waiting time
        int totalWaitingTime = simulationApplication.simulation();
        return 1000000 / totalWaitingTime;  // Higher fitness for lower waiting times
    }


    private int crossParent(int rodzic1, int rodzic2) {
        return (rodzic1 + rodzic2) / 2;
    }

    private int losujCzas() {
        return new Random().nextInt(6000) + 1000;
    }
}
