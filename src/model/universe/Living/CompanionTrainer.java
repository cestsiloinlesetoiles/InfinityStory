package model.universe.Living;

import model.universe.Living.Items.Companions.Companion;

import java.util.ArrayList;

public class CompanionTrainer {
    private String name;
    private int level;
    private ArrayList<Companion> companionDex;

    public CompanionTrainer(String name){
        this.name = name;
        this.companionDex = new ArrayList<>();

    }
    public CompanionTrainer(String name, Companion c){
        this.name = name;
        this.companionDex = new ArrayList<>();
        this.companionDex.add(c);
    }

    public void addCompanionDex(Companion c){
        this.companionDex.add(c);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Companion> getCompanionDex() {
        return companionDex;
    }

    public String toStringDex(){
        String dex = "";
        for(Companion c : this.companionDex){
            dex += c.toString()+"\n";
        }
        return dex;
    }

    @Override
    public String toString() {
        return name+" level "+level+":\n"+
                "CompanionDex:"+toStringDex();

    }
}
