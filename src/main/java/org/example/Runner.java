package org.example;

import org.example.control.RelationShipController;
import org.example.model.NPC;
import org.example.view.Window;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import javax.swing.*;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        // Creamos una instancia del controlador de relaciones
        RelationShipController controller = new RelationShipController();

        // Recuperamos el grafo
        Graph<NPC, DefaultWeightedEdge> graph = controller.getGraph();

        // Buscamos dos NPC específicos por sus nombres
        NPC sourceNPC = controller.findNPC("Amelia");
        NPC targetNPC = controller.findNPC("Eve");

        if (sourceNPC != null && targetNPC != null) {
            // Calculamos el camino más corto entre los dos NPC
            List<NPC> shortestPath = controller.calculateShortestPath(sourceNPC, targetNPC);

            if (shortestPath != null) {
                // Imprimimos el camino más corto
                System.out.println("Camino más corto entre " + sourceNPC.getName() + " y " + targetNPC.getName() + ":");
                for (NPC npc : shortestPath) {
                    System.out.println(npc.getName());
                }
            } else {
                System.out.println("No se encontró un camino entre los NPC.");
            }
        } else {
            System.out.println("No se encontraron NPC con los nombres especificados.");
        }
    }
}