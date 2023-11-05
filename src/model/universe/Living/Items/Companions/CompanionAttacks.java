package model.universe.Living.Items.Companions;



import model.universe.Living.Enum.DamageType;
import model.universe.Living.Enum.CompanionType;

import java.util.Map;
public abstract class CompanionAttacks  {

    private Map<DamageType, Integer> attack;
    private CompanionType companionType;

    public CompanionAttacks( Map<DamageType, Integer> attackValues, CompanionType companionType) {

        this.attack= attackValues;
        this.companionType = companionType;
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

    public CompanionType getcompanionType() {
        return companionType;
    }

    public void setCompanionTypeType( CompanionType companionType) {
        this.companionType = companionType;
    }

}