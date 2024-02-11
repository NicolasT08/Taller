package org.example.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelationShip {
    private NPC source;
    private NPC target;
    private int weight;


    public RelationShip(NPC source, NPC target) {
        this.source = source;
        this.target = target;
        calculateCustomWeight();
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
        this.weight = Math.abs(this.source.getLevel() - this.target.getLevel());


        List<Skill> sourceSkills = Arrays.asList(this.source.getSkills());
        List<Skill> targetSkills = Arrays.asList(this.source.getSkills());

        for ( int i = 0; i < sourceSkills.size(); i++ ){
            if( sourceSkills.get(i) == targetSkills.get(i) ){
               weight--;
            }

            if( sourceSkills.get(i).getType() == Type.ENHANCED_DEFENSE && targetSkills.get(i).getType() == Type.QUICK_REGENERATION ||
                    targetSkills.get(i).getType() == Type.ENHANCED_DEFENSE && sourceSkills.get(i).getType() == Type.QUICK_REGENERATION ){
                weight+=2;
            }
            if( sourceSkills.get(i).getType() == Type.SWIFT_STRIKE && targetSkills.get(i).getType() == Type.PRECISION_SHOT ||
                    targetSkills.get(i).getType() == Type.SWIFT_STRIKE && sourceSkills.get(i).getType() == Type.PRECISION_SHOT){
                weight+=2;
            }


        }


        if (this.source.getFaction() != this.target.getFaction()) {
            this.weight += 1;
        }

        if(this.source.getFaction().equals(Faction.The_Twilight_Hunters) && this.target.getFaction().equals(Faction.The_Children_of_the_Night)){
            this.weight +=2;
        }
        if(this.source.getFaction().equals(Faction.The_Dawn_Order) && this.target.getFaction().equals(Faction.The_Children_of_the_Night)){
            this.weight +=3;
        }
        if(this.source.getFaction().equals(Faction.The_Children_of_the_Night) && this.target.getFaction().equals(Faction.The_Twilight_Hunters)){
            this.weight +=4;
        }
        if(this.source.getFaction().equals(Faction.The_Dawn_Order) && this.target.getFaction().equals(Faction.The_Twilight_Hunters)){
            this.weight +=2;
        }

    }
}
