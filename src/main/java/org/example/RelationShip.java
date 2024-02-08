package org.example;

public class RelationShip {
    private NPC source;
    private NPC target;
    private int weight;


    public RelationShip(NPC source, NPC target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public NPC getSource() {
        return source;
    }

    public void setSource(NPC source) {
        this.source = source;
    }

    public NPC getTarget() {
        return target;
    }

    public void setTarget(NPC target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
