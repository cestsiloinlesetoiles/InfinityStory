package model.universe.Living.Items;


import model.universe.Living.Enum.ArmorType;
import model.universe.Living.Enum.DamageType;

import java.util.Map;

class Armor extends Item {

    private Map<DamageType, Integer> defense;
    private ArmorType armorType;

    public Armor(String name, String description, Map<DamageType, Integer> defense, ArmorType armorType) {
        super(name, description);
        this.defense = defense;
        this.armorType = armorType;
    }


    public Map<DamageType, Integer> getDefense() {
        return defense;
    }

    public void setDefense(Map<DamageType, Integer> defense) {
        this.defense = defense;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
