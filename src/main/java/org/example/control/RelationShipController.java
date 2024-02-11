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
    private static final int direct = 0;
    private static final int inDirect = 1;

    public RelationShipController(){
        this.graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
        addNpcs();
    }

    private void addNpcs(){

        this.addNPC("Amelia",28, new Skill[]{new Skill(Type.ENHANCED_DEFENSE,13),new Skill(Type.PRECISION_SHOT,24)}, Faction.The_Dawn_Order);
        this.addNPC("Baelz",51, new Skill[]{new Skill(Type.SWIFT_STRIKE, 37),new Skill(Type.QUICK_REGENERATION, 40)}, Faction.The_Children_of_the_Night);
        this.addNPC("Calliope",37, new Skill[]{new Skill(Type.ENHANCED_DEFENSE,8), new Skill(Type.MAGIC_AFFINITY,31)}, Faction.The_Twilight_Hunters);
        this.addNPC("David",45, new Skill[]{new Skill(Type.SWIFT_STRIKE,37), new Skill(Type.QUICK_REGENERATION,40)}, Faction.The_Dawn_Order);
        this.addNPC("Eve",67, new Skill[]{new Skill(Type.PRECISION_SHOT,57), new Skill(Type.QUICK_REGENERATION, 61)}, Faction.The_Dawn_Order);
        this.addNPC("Frank",22, new Skill[]{new Skill(Type.DARK_AURA, 19), new Skill(Type.SWIFT_STRIKE, 7)}, Faction.The_Children_of_the_Night);
        this.addNPC("Gura",8, new Skill[]{new Skill(Type.PRECISION_SHOT, 3), new Skill(Type.ENHANCED_DEFENSE, 5)}, Faction.The_Twilight_Hunters);
        this.addNPC("Hana",41, new Skill[]{new Skill(Type.MAGIC_AFFINITY, 34), new Skill(Type.SWIFT_STRIKE, 12)}, Faction.The_Twilight_Hunters);
        this.addNPC("Ina",3, new Skill[]{new Skill(Type.ENHANCED_DEFENSE, 1), new Skill(Type.DARK_AURA, 2)}, Faction.The_Children_of_the_Night);
        this.addNPC("Jack",17, new Skill[]{new Skill(Type.QUICK_REGENERATION, 10), new Skill(Type.SWIFT_STRIKE, 15)}, Faction.The_Twilight_Hunters);
        this.addNPC("Kiara",31, new Skill[]{new Skill(Type.ENHANCED_DEFENSE, 25), new Skill(Type.PRECISION_SHOT, 30)}, Faction.The_Children_of_the_Night);
        this.addNPC("Lui",46, new Skill[]{new Skill(Type.SWIFT_STRIKE, 39), new Skill(Type.MAGIC_AFFINITY, 23)}, Faction.The_Dawn_Order);
        this.addNPC("Moona",9, new Skill[]{new Skill(Type.SWIFT_STRIKE, 6), new Skill(Type.ENHANCED_DEFENSE, 4)}, Faction.The_Twilight_Hunters);
        this.addNPC("Nick", 60,new Skill[]{new Skill(Type.PRECISION_SHOT,65),new Skill(Type.QUICK_REGENERATION,57)},Faction.The_Dawn_Order);
        this.addNPC("Pekora", 53,new Skill[]{new Skill(Type.DARK_AURA,43),new Skill(Type.ENHANCED_DEFENSE,37)},Faction.The_Children_of_the_Night);

        addRelationShip("Amelia","Baelz",RelationShipController.inDirect);
        addRelationShip("Amelia","Eve",RelationShipController.inDirect);
        addRelationShip("Amelia","David",RelationShipController.inDirect);
        addRelationShip("David","Hana",RelationShipController.inDirect);
        addRelationShip("Hana","Ina",RelationShipController.inDirect);
        addRelationShip("Hana","Moona",RelationShipController.inDirect);
        addRelationShip("Moona","Nick",RelationShipController.inDirect);
        addRelationShip("Nick","Jack",RelationShipController.direct);
        addRelationShip("Nick","Pekora",RelationShipController.inDirect);
        addRelationShip("Pekora","Kiara",RelationShipController.inDirect);
        addRelationShip("Pekora","Lui",RelationShipController.inDirect);
        addRelationShip("Lui","Gura",RelationShipController.inDirect);
        addRelationShip("Lui","Kiara",RelationShipController.direct);
        addRelationShip("Gura","Kiara",RelationShipController.inDirect);
        addRelationShip("Gura","Frank",RelationShipController.inDirect);
        addRelationShip("Gura","Calliope",RelationShipController.inDirect);
        addRelationShip("Calliope","Frank",RelationShipController.inDirect);
        addRelationShip("Calliope","Baelz",RelationShipController.direct);
        addRelationShip("Eve","Baelz",RelationShipController.inDirect);
        addRelationShip("Eve","Frank",RelationShipController.inDirect);
        addRelationShip("Eve","Jack",RelationShipController.direct);
        addRelationShip("Eve","David",RelationShipController.direct);
        addRelationShip("Frank","Baelz",RelationShipController.inDirect);
        addRelationShip("Jack","Kiara",RelationShipController.inDirect);
        addRelationShip("Jack","Ina",RelationShipController.inDirect);
        addRelationShip("Kiara","Frank",RelationShipController.direct);
        addRelationShip("Ina","Eve",RelationShipController.direct);
        addRelationShip("Ina","Moona",RelationShipController.direct);


    }

    public NPC findNPC(String name){

        for ( NPC npc : this.graph.vertexSet() ){
            if ( npc.getName().equals(name) ){
                return npc;
            }
        }

        return null;
    }

    public boolean addNPC(String name, int level, Skill[] skills, Faction faction ){

        NPC newNpc = new NPC(name, level, skills, faction);

        if( this.graph.containsVertex(newNpc)) return false;

        this.graph.addVertex(newNpc);

        return true;

    }

    public boolean addRelationShip(String source, String target, int direct) {

        RelationShip relation = new RelationShip(this.findNPC(source), this.findNPC(target));

        if (!this.graph.containsEdge(relation.getSource(), relation.getTarget())) {

            this.graph.addEdge(relation.getSource(), relation.getTarget());
            this.graph.setEdgeWeight(this.graph.getEdge(relation.getSource(), relation.getTarget()), relation.getWeight());

            if( direct == 1){
                this.graph.addEdge(relation.getTarget(), relation.getSource());
                this.graph.setEdgeWeight(this.graph.getEdge(relation.getTarget(), relation.getSource()), relation.getWeight());
            }

            return true;
        }
        return false;
    }

    public List<NPC> calculateShortestPath(String source, String target) {

        NPC sourceNPC = this.findNPC(source);
        NPC targetNPC = this.findNPC(target);

        DijkstraShortestPath<NPC, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(this.graph);

        if( dijkstra.getPath(sourceNPC, targetNPC).getVertexList() == null ) return null;
        return dijkstra.getPath(sourceNPC, targetNPC).getVertexList();
    }

    public Graph<NPC, DefaultWeightedEdge> getGraph() {
        return this.graph;
    }

    public NPC[] getNpc(){
        return this.graph.vertexSet().toArray(new NPC[0]);
    }
}
