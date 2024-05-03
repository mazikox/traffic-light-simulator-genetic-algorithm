package pl.mazurek.application;

import pl.mazurek.entity.Intersection;
import pl.mazurek.entity.Light;

public class IntersectionService {

    public Intersection intersection;
    private int kolejnoscSwiatel = 0;


    public void changeLight() {
        if (intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN && kolejnoscSwiatel == 0) {
            intersection.setLightSouthToNorthAndNorthToSouth(Light.RED);
            intersection.setLightSouthToWestAndNorthToEast(Light.GREEN);
            intersection.setLightWestToEastAndEastToWest(Light.RED);
            intersection.setLightWestToNorthAndEastToSouth(Light.RED);
            kolejnoscSwiatel = 1;
        } else if (intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN && kolejnoscSwiatel == 1) {
            intersection.setLightSouthToNorthAndNorthToSouth(Light.RED);
            intersection.setLightSouthToWestAndNorthToEast(Light.RED);
            intersection.setLightWestToEastAndEastToWest(Light.GREEN);
            intersection.setLightWestToNorthAndEastToSouth(Light.RED);
            kolejnoscSwiatel = 2;
            System.out.println();
            System.out.println("Swiatlo dol-gora: " + intersection.getLightSouthToNorthAndNorthToSouth());
            System.out.println("Swiatlo lewo-prawo: " + intersection.getLightWestToEastAndEastToWest());
        } else if (intersection.getLightWestToEastAndEastToWest() == Light.GREEN && kolejnoscSwiatel == 2) {
            intersection.setLightSouthToNorthAndNorthToSouth(Light.RED);
            intersection.setLightSouthToWestAndNorthToEast(Light.RED);
            intersection.setLightWestToEastAndEastToWest(Light.RED);
            intersection.setLightWestToNorthAndEastToSouth(Light.GREEN);
            kolejnoscSwiatel = 3;
        } else if (intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN && kolejnoscSwiatel == 3) {
            System.out.println("ZIELONE");
            intersection.setLightSouthToNorthAndNorthToSouth(Light.GREEN);
            intersection.setLightSouthToWestAndNorthToEast(Light.RED);
            intersection.setLightWestToEastAndEastToWest(Light.RED);
            intersection.setLightWestToNorthAndEastToSouth(Light.RED);
            kolejnoscSwiatel = 0;
            System.out.println();
            System.out.println("Swiatlo dol-gora: " + intersection.getLightSouthToNorthAndNorthToSouth());
            System.out.println("Swiatlo lewo-prawo: " + intersection.getLightWestToEastAndEastToWest());
        }

    }

    public void deleteCar() {
        if (intersection.getCarsSouth() != 0 && intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            intersection.setCarsSouth(intersection.getCarsSouth() - 1);
            intersection.setCarsPassedSouth(intersection.getCarsPassedSouth() + 1);
        }

        if (intersection.getCarsNorth() != 0 && intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            intersection.setCarsNorth(intersection.getCarsNorth() - 1);
            intersection.setCarsPassedNorth(intersection.getCarsPassedNorth() + 1);
        }

        if (intersection.getCarsWest() != 0 && intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            intersection.setCarsWest(intersection.getCarsWest() - 1);
            intersection.setCarsPassedWest(intersection.getCarsPassedWest() + 1);
        }

        if (intersection.getCarsEast() != 0 && intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            intersection.setCarsEast(intersection.getCarsEast() - 1);
            intersection.setCarsPassedEast(intersection.getCarsPassedEast() + 1);
        }

        if (intersection.getCarsSouthToWest() != 0 && intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            intersection.setCarsSouthToWest(intersection.getCarsSouthToWest() - 1);
            intersection.setCarsPassedSouthToWest(intersection.getCarsPassedSouthToWest() + 1);
        }

        if (intersection.getCarsNorthToEast() != 0 && intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            intersection.setCarsNorthToEast(intersection.getCarsNorthToEast() - 1);
            intersection.setCarsPassedNorthToEast(intersection.getCarsPassedNorthToEast() + 1);
        }

        if (intersection.getCarsWestToNorth() != 0 && intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            intersection.setCarsWestToNorth(intersection.getCarsWestToNorth() - 1);
            intersection.setCarsPassedWestToNorth(intersection.getCarsPassedWestToNorth() + 1);
        }

        if (intersection.getCarsEastToSouth() != 0 && intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            intersection.setCarsEastToSouth(intersection.getCarsEastToSouth() - 1);
            intersection.setCarsPassedEastToSouth(intersection.getCarsPassedEastToSouth() + 1);
        }
    }

    public void addCarNorth() {
        intersection.setCarsNorth(intersection.getCarsNorth() + 1);
    }

    public void addCarSouth() {
        intersection.setCarsSouth(intersection.getCarsSouth() + 1);
    }

    public void addCarEast() {
        intersection.setCarsEast(intersection.getCarsEast() + 1);
    }

    public void addCarWest() {
        intersection.setCarsWest(intersection.getCarsWest() + 1);
    }

    public void addCarSouthToWest() {
        intersection.setCarsSouthToWest(intersection.getCarsSouthToWest() + 1);
    }

    public void addCarNorthToEast() {
        intersection.setCarsNorthToEast(intersection.getCarsNorthToEast() + 1);
    }

    public void addCarWestToNorth() {
        intersection.setCarsWestToNorth(intersection.getCarsWestToNorth() + 1);
    }

    public void addCarEastToSouth() {
        intersection.setCarsEastToSouth(intersection.getCarsEastToSouth() + 1);
    }

    public void printNumbersOfCarsWaitingToPass() {
        System.out.println();
        System.out.println();
        System.out.println("Cars waiting from north: " + intersection.getCarsNorth());
        System.out.println("Cars waiting from south: " + intersection.getCarsSouth());
        System.out.println("Cars waiting from east: " + intersection.getCarsEast());
        System.out.println("Cars waiting from west: " + intersection.getCarsWest());
        System.out.println("Cars waiting from south to west: " + intersection.getCarsSouthToWest());
        System.out.println("Cars waiting from north to east: " + intersection.getCarsNorthToEast());
        System.out.println("Cars waiting from west to north: " + intersection.getCarsWestToNorth());
        System.out.println("Cars waiting from east to south: " + intersection.getCarsEastToSouth());
    }

    public void printNumbersOfCarsPassed() {
        System.out.println();
        System.out.println("Cars passed to north: " + intersection.getCarsPassedNorth());
        System.out.println("Cars passed to south: " + intersection.getCarsPassedSouth());
        System.out.println("Cars passed to east: " + intersection.getCarsPassedEast());
        System.out.println("Cars passed to west: " + intersection.getCarsPassedWest());
        System.out.println("Cars passed from south to west: " + intersection.getCarsPassedSouthToWest());
        System.out.println("Cars passed from north  to east: " + intersection.getCarsPassedNorthToEast());
        System.out.println("Cars passed from west to north: " + intersection.getCarsPassedWestToNorth());
        System.out.println("Cars passed from east to south: " + intersection.getCarsPassedEastToSouth());
    }

    public void reset(){
        intersection.reset();
        kolejnoscSwiatel = 0;
    }

    public IntersectionService() {
        intersection = new Intersection();
    }


    public Intersection getIntersection() {
        return intersection;
    }
}
