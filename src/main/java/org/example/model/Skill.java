package org.example.model;

public class Skill {

    private Type type;
    private int level;

    public Skill(){

    }

    public Skill(Type type, int level) {
        this.type = type;
        this.level = level;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Skill(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "type=" + type +
                ", level=" + level +
                '}';
    }
}
