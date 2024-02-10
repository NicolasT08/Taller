package org.example.control;

import org.example.model.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import java.util.ArrayList;
import java.util.List;

public class RelationShipController {
    private Graph<NPC, DefaultWeightedEdge> graph;

    public RelationShipController(){
        this.graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
        addNpcs();
    }

    private void addNpcs(){
        ArrayList<Skill> npc1Skills = new ArrayList<>();
        npc1Skills.add(new Skill(Type.ENHANCED_DEFENSE, 13)); npc1Skills.add(new Skill(Type.PRECISION_SHOT, 24));
        NPC npc1 = new NPC("Amelia",28, npc1Skills, Faction.The_Dawn_Order);

        ArrayList<Skill> npc2Skills = new ArrayList<>();
        npc2Skills.add(new Skill(Type.SWIFT_STRIKE, 13)); npc2Skills.add(new Skill(Type.PRECISION_SHOT, 6));
        NPC npc2 = new NPC("Bob",14, npc2Skills, Faction.The_Children_of_the_Night);

        ArrayList<Skill> npc3Skills = new ArrayList<>();
        npc3Skills.add(new Skill(Type.ENHANCED_DEFENSE, 8)); npc3Skills.add(new Skill(Type.QUICK_REGENERATION, 31));
        NPC npc3 = new NPC("Charlie",37, npc3Skills, Faction.The_Twilight_Hunters);

        ArrayList<Skill> npc4Skills = new ArrayList<>();
        npc4Skills.add(new Skill(Type.SWIFT_STRIKE, 40)); npc4Skills.add(new Skill(Type.QUICK_REGENERATION, 24));
        NPC npc4 = new NPC("David",80, npc4Skills, Faction.The_Dawn_Order);

        ArrayList<Skill> npc5Skills = new ArrayList<>();
        npc5Skills.add(new Skill(Type.PRECISION_SHOT, 17)); npc5Skills.add(new Skill(Type.QUICK_REGENERATION, 41));
        NPC npc5 = new NPC("Eve",49, npc5Skills, Faction.The_Dawn_Order);

        ArrayList<Skill> npc6Skills = new ArrayList<>();
        npc6Skills.add(new Skill(Type.QUICK_REGENERATION, 19)); npc6Skills.add(new Skill(Type.SWIFT_STRIKE, 7));
        NPC npc6 = new NPC("Frank",22, npc6Skills, Faction.The_Children_of_the_Night);

        ArrayList<Skill> npc7Skills = new ArrayList<>();
        npc7Skills.add(new Skill(Type.PRECISION_SHOT, 3)); npc7Skills.add(new Skill(Type.ENHANCED_DEFENSE, 5));
        NPC npc7 = new NPC("George",8, npc7Skills, Faction.The_Twilight_Hunters);

        ArrayList<Skill> npc8Skills = new ArrayList<>();
        npc8Skills.add(new Skill(Type.PRECISION_SHOT, 34)); npc8Skills.add(new Skill(Type.SWIFT_STRIKE, 12));
        NPC npc8 = new NPC("Harold",41, npc8Skills, Faction.The_Twilight_Hunters);

        ArrayList<Skill> npc9Skills = new ArrayList<>();
        npc9Skills.add(new Skill(Type.ENHANCED_DEFENSE, 1)); npc9Skills.add(new Skill(Type.QUICK_REGENERATION, 2));
        NPC npc9 = new NPC("Ian",3, npc9Skills, Faction.The_Children_of_the_Night);

        ArrayList<Skill> npc10Skills = new ArrayList<>();
        npc10Skills.add(new Skill(Type.QUICK_REGENERATION, 10)); npc10Skills.add(new Skill(Type.SWIFT_STRIKE, 15));
        NPC npc10 = new NPC("Jack",17, npc10Skills, Faction.The_Twilight_Hunters);

        ArrayList<Skill> npc11Skills = new ArrayList<>();
        npc11Skills.add(new Skill(Type.ENHANCED_DEFENSE, 25)); npc11Skills.add(new Skill(Type.PRECISION_SHOT, 30));
        NPC npc11 = new NPC("Kyle",31, npc11Skills, Faction.The_Children_of_the_Night);

        ArrayList<Skill> npc12Skills = new ArrayList<>();
        npc12Skills.add(new Skill(Type.SWIFT_STRIKE, 39)); npc12Skills.add(new Skill(Type.PRECISION_SHOT, 23));
        NPC npc12 = new NPC("Luis",46, npc12Skills, Faction.The_Dawn_Order);

        ArrayList<Skill> npc13Skills = new ArrayList<>();
        npc13Skills.add(new Skill(Type.QUICK_REGENERATION, 6)); npc13Skills.add(new Skill(Type.ENHANCED_DEFENSE, 4));
        NPC npc13 = new NPC("Maria",9, npc13Skills, Faction.The_Twilight_Hunters);


        this.addNPC(npc1);
        this.addNPC(npc2);
        this.addNPC(npc3);
        this.addNPC(npc4);
        this.addNPC(npc5);
        this.addNPC(npc6);
        this.addNPC(npc7);
        this.addNPC(npc8);
        this.addNPC(npc9);
        this.addNPC(npc10);
        this.addNPC(npc11);
        this.addNPC(npc12);
        this.addNPC(npc13);


        RelationShip relationShip1 = new RelationShip(npc1,npc9);
        RelationShip relationShip2 = new RelationShip(npc1,npc2);
        RelationShip relationShip3 = new RelationShip(npc1,npc3);
        RelationShip relationShip4 = new RelationShip(npc1,npc8);
        RelationShip relationShip5 = new RelationShip(npc2,npc8);
        RelationShip relationShip6 = new RelationShip(npc2,npc7);
        RelationShip relationShip7 = new RelationShip(npc7,npc8);
        RelationShip relationShip8 = new RelationShip(npc7,npc5);
        RelationShip relationShip9 = new RelationShip(npc5,npc10);
        RelationShip relationShip10 = new RelationShip(npc5,npc13);
        RelationShip relationShip11 = new RelationShip(npc13,npc4);
        RelationShip relationShip12 = new RelationShip(npc13,npc12);
        RelationShip relationShip13 = new RelationShip(npc12,npc4);
        RelationShip relationShip14 = new RelationShip(npc12,npc6);
        RelationShip relationShip15 = new RelationShip(npc6,npc11);
        RelationShip relationShip16 = new RelationShip(npc11,npc9);
        RelationShip relationShip17 = new RelationShip(npc1,npc9);
        RelationShip relationShip18 = new RelationShip(npc9,npc3);
        RelationShip relationShip19 = new RelationShip(npc3,npc6);
        RelationShip relationShip20 = new RelationShip(npc8,npc10);
        RelationShip relationShip21 = new RelationShip(npc8,npc3);
        RelationShip relationShip22 = new RelationShip(npc3,npc4);
        RelationShip relationShip23 = new RelationShip(npc10,npc4);

        this.addRelationShip(relationShip1);
        this.addRelationShip(relationShip2);
        this.addRelationShip(relationShip3);
        this.addRelationShip(relationShip4);
        this.addRelationShip(relationShip5);
        this.addRelationShip(relationShip6);
        this.addRelationShip(relationShip7);
        this.addRelationShip(relationShip8);
        this.addRelationShip(relationShip9);
        this.addRelationShip(relationShip10);
        this.addRelationShip(relationShip11);
        this.addRelationShip(relationShip12);
        this.addRelationShip(relationShip13);
        this.addRelationShip(relationShip14);
        this.addRelationShip(relationShip15);
        this.addRelationShip(relationShip16);
        this.addRelationShip(relationShip17);
        this.addRelationShip(relationShip18);
        this.addRelationShip(relationShip19);
        this.addRelationShip(relationShip20);
        this.addRelationShip(relationShip21);
        this.addRelationShip(relationShip22);
        this.addRelationShip(relationShip23);


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

        if( this.graph.containsVertex(newNpc)) return false;

        this.graph.addVertex(newNpc);

        return true;

    }

    public boolean addRelationShip(RelationShip relation) {
        if (!this.graph.containsEdge(relation.getSource(), relation.getTarget())) {

            this.graph.addEdge(relation.getSource(), relation.getTarget());
            this.graph.setEdgeWeight(this.graph.getEdge(relation.getSource(), relation.getTarget()), relation.getWeight());

            this.graph.addEdge(relation.getTarget(), relation.getSource());
            this.graph.setEdgeWeight(this.graph.getEdge(relation.getTarget(), relation.getSource()), relation.getWeight());

            return true;
        }
        return false;
    }

    public List<NPC> calculateShortestPath(NPC sourceNPC, NPC targetNPC) {
        DijkstraShortestPath<NPC, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(this.graph);
        return dijkstra.getPath(sourceNPC, targetNPC).getVertexList();
    }

    public Graph<NPC, DefaultWeightedEdge> getGraph() {
        return this.graph;
    }
}
