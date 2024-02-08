package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class NPC {
    private String name;
    private int level;
    private ArrayList<Skill> skills;

    private Faction faction;
    public NPC(){

    }

    public NPC(String name) {
        this.name = name;
    }

    public NPC(String name, int level, ArrayList<Skill> skills, Faction faction) {
        this.name = name;
        this.level = level;
        this.skills = skills;
        this.faction = faction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return level == npc.level && Objects.equals(name, npc.name) && Objects.equals(skills, npc.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, skills);
    }
}
