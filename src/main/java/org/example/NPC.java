package org.example;

import java.util.Arrays;
import java.util.Objects;

public class NPC {
    private String name;
    private int level;
    private String[] skills;

    public NPC(){

    }

    public NPC(String name, int level, String[] skills) {
        this.name = name;
        this.level = level;
        this.skills = skills;
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

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return level == npc.level && Objects.equals(name, npc.name) && Arrays.equals(skills, npc.skills);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, level);
        result = 31 * result + Arrays.hashCode(skills);
        return result;
    }
}
