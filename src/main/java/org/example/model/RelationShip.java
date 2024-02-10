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

        if( this.weight <=4 ){
            this.weight++;
        }

        for (Skill skill : this.source.getSkills()) {
            if (this.target.getSkills().contains(skill)) {
                int sourceSkillLevel = skill.getLevel();
                int targetSkillLevel = this.target.getSkills().stream()
                        .filter(s -> s.getType().equals(skill.getType()))
                        .mapToInt(Skill::getLevel)
                        .findFirst()
                        .orElse(0);

                if (targetSkillLevel >= sourceSkillLevel) {
                    this.weight--;
                }
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


        this.weight = Math.abs(this.source.getLevel() - this.target.getLevel());

    }
}
