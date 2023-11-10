package model.universe.Living.monster.BrigandArch;

import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;
import model.universe.Living.Living;

import java.util.HashMap;
import java.util.Map;

public abstract class Brigand extends Living {
    // Rajouter ligne AnimSet
    private boolean isInStealth;
    private static final int defaultHealth = 100;
    private static final int defaultStrength = 50;
    private static final int defaultDodgeChance = 10;
    private static final Map<DamageType, Integer> defaultDefenses = new HashMap<>();


    public Brigand() {
        super(defaultHealth, defaultStrength, defaultDodgeChance, defaultDefenses);
        defaultDefenses.put(DamageType.PHYSICAL, 10);
        defaultDefenses.put(DamageType.MAGIC, 5);
        defaultDefenses.put(DamageType.TRUE_DAMAGE, 5);
    }
    @Override
    public TakingDamageStatus takeDamage(DamageType damageType, int damageAmount) {
        if(isInStealth){
            System.out.println("Furtivité activée");
            return TakingDamageStatus.DODGED;
        }
        return super.takeDamage(damageType,damageAmount);
    }

    public void setInStealth(boolean inStealth) {
        isInStealth = inStealth;
    }

    public boolean getInStealth(){
        return  isInStealth;
    }

    public TakingDamageStatus attack(Living target) {
        int damageDealt = this.getStrength();
        System.out.println(this.getName() + " attaque " + target.getName());
        return target.takeDamage(DamageType.TRUE_DAMAGE, damageDealt);
    }

}
