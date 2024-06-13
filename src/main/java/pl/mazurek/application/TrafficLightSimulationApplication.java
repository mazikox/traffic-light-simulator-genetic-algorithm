package pl.mazurek.application;

import pl.mazurek.entity.Light;

public class TrafficLightSimulationApplication {

    private IntersectionService intersectionService;

    public int speed = 10;

    public int southToNorthTimeLight = 3000;
    public int westToEastTimeLight = 1000;
    public int southToWestTimeLight = 1500;
    public int westToNorthTimeLight = 2500;
    public int carArrivalTimeNorthToSouth = 400;
    public int carArrivalTimeEastToWest = 550;
    public int carArrivalTimeSouthToNorth = 2000;
    public int carArrivalTimeWestToEast = 850;
    public int carArrivalTimeNorthToEast = 850;
    public int carArrivalTimeEastToSouth = 1850;
    public int carArrivalTimeSouthToWest = 1450;
    public int carArrivalTimeWestToNorth = 1450;
    public boolean isUsedByAlgorithm;
    private int lightTick;
    private boolean isActive = false;


    public void start() {
        if (!isActive) {
            simulation();
        }
    }

    public void stop() {
        if (isActive) {
            isActive = false;
            intersectionService.reset();
        }
    }

    public int simulation() {
        intersectionService = new IntersectionService();
        isActive = true;

        long lastTime = System.nanoTime();
        // 100 ticks per second
        double amountOfTicks = 100;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        int tick = 0;
        lightTick = 0;

        while (isActive) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                delta--;
                tick++;
                lightTick++;

                handleArrivalCarAtIntersection(tick);
                handleTrafficLightChange(intersectionService, southToNorthTimeLight, westToEastTimeLight, southToWestTimeLight, westToNorthTimeLight);
                if (isUsedByAlgorithm) {
                    if (tick > 200) {
                        wyswietlWartosciDoUsuniecia(tick);
                        return intersectionService.getValue();
                    }
                    deleteCarByAlgorith(tick);
                }
            }
        }
        return intersectionService.value;
    }

    private void deleteCarByAlgorith(int tick) {
        if (tick % countTimeWithSpeed(100) == 0) {
            intersectionService.deleteCarForAlgorithm(this);
        }
    }

    private void wyswietlWartosciDoUsuniecia(int tick) {
        System.out.println("Value: " + intersectionService.getValue());
        System.out.println(intersectionService.getIntersection());
        System.out.println("dol-gora: " + southToNorthTimeLight + " lewo-prawo: " + westToEastTimeLight + " dol-lewo: " + southToWestTimeLight + " lewo-gora: " + westToNorthTimeLight);
    }

    private void handleTrafficLightChange(IntersectionService intersectionService, int southToNorthTime, int westToEastTime, int southToWestTime, int westToNorthTime) {
        if (intersectionService.intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(southToNorthTime) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(westToEastTime) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(southToWestTime) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(westToNorthTime) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        }
    }


    private void handleArrivalCarAtIntersection(int tick) {
        if (tick % countTimeWithSpeed(carArrivalTimeSouthToNorth) == 0) {
            intersectionService.addCarSouth();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeNorthToSouth) == 0) {
            intersectionService.addCarNorth();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeEastToWest) == 0) {
            intersectionService.addCarEast();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeWestToEast) == 0) {
            intersectionService.addCarWest();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeNorthToEast) == 0) {
            intersectionService.addCarNorthToEast();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeSouthToWest) == 0) {
            intersectionService.addCarSouthToWest();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeWestToNorth) == 0) {
            intersectionService.addCarWestToNorth();
        }

        if (tick % countTimeWithSpeed(carArrivalTimeEastToSouth) == 0) {
            intersectionService.addCarEastToSouth();
        }
    }


    private int countTimeWithSpeed(int time) {
        if (speed < 1) {
            speed = 1;
        }
        return time / speed;
    }

    public TrafficLightSimulationApplication() {
    }

    public IntersectionService getIntersectionService() {
        return intersectionService;
    }

    public boolean isActive() {
        return isActive;
    }
}
