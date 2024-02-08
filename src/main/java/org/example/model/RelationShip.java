package org.example.model;

import org.example.model.NPC;

import java.util.ArrayList;

public class RelationShip {
    private NPC source;
    private NPC target;
    private int weight;


    public RelationShip(NPC source, NPC target) {
        this.source = source;
        this.target = target;
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

    public void calculateCustomWeight() {
        this.weight = Math.abs( this.source.getLevel() - this.target.getLevel() );

        for ( Skill skill : this.source.getSkills() ){
            if( this.target.getSkills().contains(skill) && weight < 1 ){
                weight --;
            }
        }

        if ( this.source.getFaction() != this.target.getFaction() ){
            weight+=3;
        }
    }
}
