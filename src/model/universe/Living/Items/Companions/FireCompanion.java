package model.universe.Living.Items.Companions;

import model.universe.Living.Enum.CompanionType;
import model.universe.Living.Enum.DamageType;

import java.util.HashMap;
import java.util.Map;

public abstract class FireCompanion extends Companion{
    public FireCompanion(String name){
        super(name,100,100, 0,new HashMap<>(), CompanionType.Ice,DamageType.FIRE);
        Map<DamageType, Integer> attacks = new HashMap<DamageType, Integer>();
        attacks.put(DamageType.FIRE,20);
        attacks.put(DamageType.NORMAL,10);
        this.setAttackValues(attacks);
    }

}
