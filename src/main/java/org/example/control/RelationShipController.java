package org.example.control;

import org.example.model.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import java.util.ArrayList;
import java.util.List;

public class RelationShipController {
    private Graph<NPC, DefaultWeightedEdge> graph;

    public RelationShipController(){
        this.graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
    }

    private void addNpcs(){
        ArrayList<Skill> npc1Skills = new ArrayList<>();
        npc1Skills.add(new Skill(Type.PRECISION_SHOT, 1)); npc1Skills.add(new Skill(Type.ENHANCED_DEFENSE, 2));
        NPC npc1 = new NPC("Alice",5, npc1Skills, Faction.The_Twilight_Hunters);

        ArrayList<Skill> npc2Skills = new ArrayList<>();
        npc2Skills.add(new Skill(Type.PRECISION_SHOT, 3)); npc2Skills.add(new Skill(Type.SWIFT_STRIKE, 7));
        NPC npc2 = new NPC("Bob",7, npc2Skills, Faction.The_Dawn_Order);

        ArrayList<Skill> npc3Skills = new ArrayList<>();
        npc3Skills.add(new Skill(Type.QUICK_REGENERATION, 8)); npc3Skills.add(new Skill(Type.ENHANCED_DEFENSE, 4));
        NPC npc3 = new NPC("Charlie",10, npc3Skills, Faction.The_Children_of_the_Night);

        ArrayList<Skill> npc4Skills = new ArrayList<>();
        npc4Skills.add(new Skill(Type.SWIFT_STRIKE, 1)); npc4Skills.add(new Skill(Type.QUICK_REGENERATION, 2));
        NPC npc4 = new NPC("David",2, npc4Skills, Faction.The_Twilight_Hunters);

        ArrayList<Skill> npc5Skills = new ArrayList<>();
        npc5Skills.add(new Skill(Type.QUICK_REGENERATION, 7)); npc5Skills.add(new Skill(Type.PRECISION_SHOT, 5));
        NPC npc5 = new NPC("Eve",8, npc5Skills, Faction.The_Dawn_Order);

        ArrayList<Skill> npc6Skills = new ArrayList<>();
        npc6Skills.add(new Skill(Type.SWIFT_STRIKE, 4)); npc6Skills.add(new Skill(Type.QUICK_REGENERATION, 5));
        NPC npc6 = new NPC("Frank",5, npc6Skills, Faction.The_Children_of_the_Night);

        this.addNPC(npc1);
        this.addNPC(npc2);
        this.addNPC(npc3);
        this.addNPC(npc4);
        this.addNPC(npc5);
        this.addNPC(npc6);

        List<NPC> npcList = new ArrayList<>(graph.vertexSet());
        for (int i = 0; i < npcList.size(); i++) {
            for (int j = i + 1; j < npcList.size(); j++) {
                NPC sourceNPC = npcList.get(i);
                NPC targetNPC = npcList.get(j);
                RelationShip newRelation = new RelationShip(sourceNPC, targetNPC);
                addRelationShip(newRelation);
            }
        }

    }

    public NPC findNPC(String name){

        for ( NPC npc : this.graph.vertexSet() ){
            if ( npc.getName().equals(name) ){
                return npc;
            }
        }

        return null;
    }

    public boolean addNPC(NPC newNpc ){

        if ( this.findNPC(newNpc.getName()) != null ) return false;

        this.graph.addVertex(newNpc);

        return true;

    }

    public boolean addRelationShip(RelationShip relation){

        if ( !this.graph.containsEdge(relation.getSource(), relation.getTarget()) ){
            this.graph.addEdge(relation.getSource(), relation.getTarget());
            this.graph.setEdgeWeight(this.graph.getEdge(relation.getSource(), relation.getTarget()), relation.getWeight());
            return true;
        }

        return false;

    }

    public List<DefaultWeightedEdge> calculateShortestPath(NPC sourceNPC, NPC targetNPC) {
        DijkstraShortestPath<NPC, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(this.graph);
        return dijkstra.getPath(sourceNPC, targetNPC).getEdgeList();
    }
}
