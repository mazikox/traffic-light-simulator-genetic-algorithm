package pl.mazurek;

import pl.mazurek.application.IntersectionService;
import pl.mazurek.application.TrafficLightSimulationApplication;
import pl.mazurek.entity.Intersection;
import pl.mazurek.gui.MainPanel;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        IntersectionService intersectionService = new IntersectionService();

        TrafficLightSimulationApplication simulationApplication = new TrafficLightSimulationApplication(intersectionService);
        MainPanel mainPanel = new MainPanel(simulationApplication);
    }
}