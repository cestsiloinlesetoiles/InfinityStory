package model.universe.Living.Items;



import model.universe.Living.Enum.DamageType;
import model.universe.Living.Enum.WeaponType;

import java.util.Map;
class Weapon extends Item {

    private Map<DamageType, Integer> attack;
    private WeaponType weaponType;

    public Weapon(String name, String description, Map<DamageType, Integer> attackValues, WeaponType weaponType) {
        super(name, description);
        this.attack= attackValues;
        this.weaponType = weaponType;
    }


    public int getAttackValue(DamageType type) {
        return attack.getOrDefault(type, 0);
    }


    public Map<DamageType, Integer> getAttackValues() {
        return attack;
    }

    public void setAttackValues(Map<DamageType, Integer> attackValues) {
        this.attack = attackValues;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

}