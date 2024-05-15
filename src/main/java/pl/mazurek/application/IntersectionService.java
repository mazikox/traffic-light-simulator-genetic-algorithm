package pl.mazurek.application;

import pl.mazurek.entity.Car;
import pl.mazurek.entity.Direction;
import pl.mazurek.entity.Intersection;
import pl.mazurek.entity.Light;

public class IntersectionService {

    public Intersection intersection;
    private int kolejnoscSwiatel = 0;
    int value = 0;


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
        } else if (intersection.getLightWestToEastAndEastToWest() == Light.GREEN && kolejnoscSwiatel == 2) {
            intersection.setLightSouthToNorthAndNorthToSouth(Light.RED);
            intersection.setLightSouthToWestAndNorthToEast(Light.RED);
            intersection.setLightWestToEastAndEastToWest(Light.RED);
            intersection.setLightWestToNorthAndEastToSouth(Light.GREEN);
            kolejnoscSwiatel = 3;
        } else if (intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN && kolejnoscSwiatel == 3) {
            intersection.setLightSouthToNorthAndNorthToSouth(Light.GREEN);
            intersection.setLightSouthToWestAndNorthToEast(Light.RED);
            intersection.setLightWestToEastAndEastToWest(Light.RED);
            intersection.setLightWestToNorthAndEastToSouth(Light.RED);
            kolejnoscSwiatel = 0;
        }

    }

    public void deleteCar(Car car) {

        if (car.getStartPosition() == Direction.SOUTH && car.getDirection() == Direction.NORTH) {
            intersection.setCarsSouthToNorthOnIntersection(intersection.getCarsSouthToNorthOnIntersection() - 1);
            intersection.setCarsPassedSouthToNorth(intersection.getCarsPassedSouthToNorth() + 1);
        } else if (car.getStartPosition() == Direction.NORTH && car.getDirection() == Direction.SOUTH) {
            intersection.setCarsNorthToSouthOnIntersection(intersection.getCarsNorthToSouthOnIntersection() - 1);
            intersection.setCarsPassedNorthToSouth(intersection.getCarsPassedNorthToSouth() + 1);
        } else if (car.getStartPosition() == Direction.WEST && car.getDirection() == Direction.EAST) {
            intersection.setCarsWestToEastOnIntersection(intersection.getCarsWestToEastOnIntersection() - 1);
            intersection.setCarsPassedWestToEast(intersection.getCarsPassedWestToEast() + 1);
        } else if (car.getStartPosition() == Direction.EAST && car.getDirection() == Direction.WEST) {
            intersection.setCarsEastToWestOnIntersection(intersection.getCarsEastToWestOnIntersection() - 1);
            intersection.setCarsPassedEastToWest(intersection.getCarsPassedEastToWest() + 1);
        } else if (car.getStartPosition() == Direction.SOUTH && car.getDirection() == Direction.WEST) {
            intersection.setCarsSouthToWestOnIntersection(intersection.getCarsSouthToWestOnIntersection() - 1);
            intersection.setCarsPassedSouthToWest(intersection.getCarsPassedSouthToWest() + 1);
        } else if (car.getStartPosition() == Direction.NORTH && car.getDirection() == Direction.EAST) {
            intersection.setCarsNorthToEastOnIntersection(intersection.getCarsNorthToEastOnIntersection() - 1);
            intersection.setCarsPassedNorthToEast(intersection.getCarsPassedNorthToEast() + 1);
        } else if (car.getStartPosition() == Direction.WEST && car.getDirection() == Direction.NORTH) {
            intersection.setCarsWestToNorthOnIntersection(intersection.getCarsWestToNorthOnIntersection() - 1);
            intersection.setCarsPassedWestToNorth(intersection.getCarsPassedWestToNorth() + 1);
        } else if (car.getStartPosition() == Direction.EAST && car.getDirection() == Direction.SOUTH) {
            intersection.setCarsEastToSouthOnIntersection(intersection.getCarsEastToSouthOnIntersection() - 1);
            intersection.setCarsPassedEastToSouth(intersection.getCarsPassedEastToSouth() + 1);
        }
    }

    public void deleteCarForAlgorithm(TrafficLightSimulationApplication simulationApplication) {
        if (intersection.getCarsSouthToNorthOnIntersection() != 0 && intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            intersection.setCarsSouthToNorthOnIntersection(intersection.getCarsSouthToNorthOnIntersection() - 1);
            intersection.setCarsPassedSouthToNorth(intersection.getCarsPassedSouthToNorth() + 1);
            value += simulationApplication.carArrivalTimeSouthToNorth;
        }

        if (intersection.getCarsNorthToSouthOnIntersection() != 0 && intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            intersection.setCarsNorthToSouthOnIntersection(intersection.getCarsNorthToSouthOnIntersection() - 1);
            intersection.setCarsPassedNorthToSouth(intersection.getCarsPassedNorthToSouth() + 1);
            value += simulationApplication.carArrivalTimeNorthToSouth;
        }

        if (intersection.getCarsWestToEastOnIntersection() != 0 && intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            intersection.setCarsWestToEastOnIntersection(intersection.getCarsWestToEastOnIntersection() - 1);
            intersection.setCarsPassedWestToEast(intersection.getCarsPassedWestToEast() + 1);
            value += simulationApplication.carArrivalTimeSouthToNorth;
        }

        if (intersection.getCarsEastToWestOnIntersection() != 0 && intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            intersection.setCarsEastToWestOnIntersection(intersection.getCarsEastToWestOnIntersection() - 1);
            intersection.setCarsPassedEastToWest(intersection.getCarsPassedEastToWest() + 1);
            value += simulationApplication.carArrivalTimeEastToWest;
        }

        if (intersection.getCarsSouthToWestOnIntersection() != 0 && intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            intersection.setCarsSouthToWestOnIntersection(intersection.getCarsSouthToWestOnIntersection() - 1);
            intersection.setCarsPassedSouthToWest(intersection.getCarsPassedSouthToWest() + 1);
            value += simulationApplication.carArrivalTimeSouthToWest;
        }

        if (intersection.getCarsNorthToEastOnIntersection() != 0 && intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            intersection.setCarsNorthToEastOnIntersection(intersection.getCarsNorthToEastOnIntersection() - 1);
            intersection.setCarsPassedNorthToEast(intersection.getCarsPassedNorthToEast() + 1);
            value += simulationApplication.carArrivalTimeNorthToEast;
        }

        if (intersection.getCarsWestToNorthOnIntersection() != 0 && intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            intersection.setCarsWestToNorthOnIntersection(intersection.getCarsWestToNorthOnIntersection() - 1);
            intersection.setCarsPassedWestToNorth(intersection.getCarsPassedWestToNorth() + 1);
            value += simulationApplication.carArrivalTimeWestToNorth;
        }

        if (intersection.getCarsEastToSouthOnIntersection() != 0 && intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            intersection.setCarsEastToSouthOnIntersection(intersection.getCarsEastToSouthOnIntersection() - 1);
            intersection.setCarsPassedEastToSouth(intersection.getCarsPassedEastToSouth() + 1);
            value += simulationApplication.carArrivalTimeEastToSouth;
        }
    }

    public void addCarNorth() {
        intersection.setCarsNorthToSouthForRender(intersection.getCarsNorthToSouthForRender() + 1);
        intersection.setCarsNorthToSouthOnIntersection(intersection.getCarsNorthToSouthOnIntersection() + 1);
    }

    public void addCarSouth() {
        intersection.setCarsSouthToNorthForRender(intersection.getCarsSouthToNorthForRender() + 1);
        intersection.setCarsSouthToNorthOnIntersection(intersection.getCarsSouthToNorthOnIntersection() + 1);
    }

    public void addCarEast() {
        intersection.setCarsEastToWestForRender(intersection.getCarsEastToWestForRender() + 1);
        intersection.setCarsEastToWestOnIntersection(intersection.getCarsEastToWestOnIntersection() + 1);
    }

    public void addCarWest() {
        intersection.setCarsWestToEastForRender(intersection.getCarsWestToEastForRender() + 1);
        intersection.setCarsWestToEastOnIntersection(intersection.getCarsWestToEastOnIntersection() + 1);
    }

    public void addCarSouthToWest() {
        intersection.setCarsSouthToWestForRender(intersection.getCarsSouthToWestForRender() + 1);
        intersection.setCarsSouthToWestOnIntersection(intersection.getCarsSouthToWestOnIntersection() + 1);
    }

    public void addCarNorthToEast() {
        intersection.setCarsNorthToEastForRender(intersection.getCarsNorthToEastForRender() + 1);
        intersection.setCarsNorthToEastOnIntersection(intersection.getCarsNorthToEastOnIntersection() + 1);
    }

    public void addCarWestToNorth() {
        intersection.setCarsWestToNorthForRender(intersection.getCarsWestToNorthForRender() + 1);
        intersection.setCarsWestToNorthOnIntersection(intersection.getCarsWestToNorthOnIntersection() + 1);
    }

    public void addCarEastToSouth() {
        intersection.setCarsEastToSouthForRender(intersection.getCarsEastToSouthForRender() + 1);
        intersection.setCarsEastToSouthOnIntersection(intersection.getCarsEastToSouthOnIntersection() + 1);
    }


    public void reset() {
        intersection.reset();
        kolejnoscSwiatel = 0;
    }

    public IntersectionService() {
        intersection = new Intersection();
    }

    public int getValue() {
        return value;
    }

    public Intersection getIntersection() {
        return intersection;
    }
}
