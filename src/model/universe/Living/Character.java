package model.universe.Living;

import model.universe.Item;
import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;

import java.util.ArrayList;
import java.util.Map;

public class Character extends Living  {

    protected ArrayList<Living> companion;
    protected ArrayList<Item> inventory;
    public Character(int health, int strength, int dodgeChance , Map<DamageType, Integer> defense){
        super(health, strength, dodgeChance, defense);
        this.companion = new ArrayList<>();
    }

    public void addSummoned(Living entity){
        this.companion.add(entity);
    }

    public void removeSummoned(Living entity){
        this.removeSummoned(entity);
    }

    public ArrayList<Living> getSummonedList() {
        return companion;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    @Override
    public TakingDamageStatus attack(Living living) {
        return TakingDamageStatus.TEST;
    }


}
