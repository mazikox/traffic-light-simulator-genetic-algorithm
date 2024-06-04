package pl.mazurek.application;

import pl.mazurek.entity.Light;

public class TrafficLightSimulationApplication {

    private IntersectionService intersectionService;

    public int speed = 10;

    public int CZAS_DOL_GORA = 3000;
    public int CZAS_LEWO_PRAWO = 1000;
    public int CZAS_DOL_LEWO = 1500;
    public int CZAS_LEWO_GORA = 2500;
    public int carArrivalTimeNorthToSouth = 200;
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
        // 1000 ticks per second
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
                handleTrafficLightChange(intersectionService, CZAS_DOL_GORA, CZAS_LEWO_PRAWO, CZAS_DOL_LEWO, CZAS_LEWO_GORA);
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
        System.out.println("dol-gora: " + CZAS_DOL_GORA + " lewo-prawo: " + CZAS_LEWO_PRAWO + " dol-lewo: " + CZAS_DOL_LEWO + " lewo-gora: " + CZAS_LEWO_GORA);
    }

    private void handleTrafficLightChange(IntersectionService intersectionService, int czasDolGora, int czasLewoPrawo, int czasDolLewo, int czasLewoGora) {
        if (intersectionService.intersection.getLightSouthToNorthAndNorthToSouth() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasDolGora) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightWestToEastAndEastToWest() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasLewoPrawo) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightSouthToWestAndNorthToEast() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasDolLewo) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        } else if (intersectionService.intersection.getLightWestToNorthAndEastToSouth() == Light.GREEN) {
            if (lightTick % countTimeWithSpeed(czasLewoGora) == 0) {
                intersectionService.changeLight();
                lightTick = 0;
            }
        }
    }


    private void handleArrivalCarAtIntersection(int tick) {
        // every 2 second
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
