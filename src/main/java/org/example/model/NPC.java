package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class NPC {
    private String name;
    private int level;
    private Skill[] skills;

    private Faction faction;
    public NPC(){

    }

    public NPC(String name) {
        this.name = name;
    }

    public NPC(String name, int level, Skill[] skills, Faction faction) {
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

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
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
                ", skills=" + Arrays.toString(skills) +
                ", faction=" + faction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return level == npc.level && Objects.equals(name, npc.name) && Arrays.equals(skills, npc.skills) && faction == npc.faction;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, level, faction);
        result = 31 * result + Arrays.hashCode(skills);
        return result;
    }
}
