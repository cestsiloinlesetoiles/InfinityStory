package model.universe.Living.Items.Companions;

import model.universe.Living.Enum.CompanionType;
import model.universe.Living.Enum.DamageType;

import java.util.HashMap;
import java.util.Map;

public abstract class IceCompanion extends Companion {
    public IceCompanion(String name){
        super(name,100,100, 0,new HashMap<>(), CompanionType.Electric);
        Map<DamageType, Integer> attacks = new HashMap<DamageType, Integer>();
        attacks.put(DamageType.ICE,10);
        attacks.put(DamageType.NORMAL,5);
        this.setAttackValues(attacks);
    }
}
