package model.universe.Living;

import model.universe.Living.Enum.DamageType;
import model.universe.Living.Enum.TakingDamageStatus;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public abstract class Living {

    protected String name;
    protected int health;
    protected int strength;

    protected double criticalAttackChance;

    protected double dodgeChance;

    protected Map<DamageType, Integer> resistances;

    public Living(String name, int health, int strength, int defense, double criticalAttackChance, double dodgeChance) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.criticalAttackChance = criticalAttackChance;
        this.dodgeChance = dodgeChance;
        this.resistances = new HashMap<>();
    }
    public abstract void attack(Living target,DamageType damageType);

    public TakingDamageStatus takeDamage(int damage, DamageType damageType){
        Random rand = new Random();
        if(rand.nextDouble() < dodgeChance){
            return TakingDamageStatus.DODGED;
        }
        else{
            int defense = resistances.get(damageType);
            damage = Math.max(damage-defense, 0);
            health -= damage;
            health = Math.max(health, 0);
            if(health>0){
               return TakingDamageStatus.HIT;
            }
            else {
               return TakingDamageStatus.DEFEATED;
            }


        }
    }
}
