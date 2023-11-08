package model.universe.Living.Items.Companions;

import model.universe.Living.Enum.CompanionType;
import model.universe.Living.Enum.DamageType;
import model.universe.Living.Enum.TakingDamageStatus;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public abstract class Companion extends CompanionAttacks {

    protected String name;
    protected int health;
    protected int strength;

    protected boolean potionAttack;

    protected int bonusAttack;
    protected double dodgeChance;

    protected Map<DamageType, Integer> resistances;

    public Companion(String name, int health, int strength, double dodgeChance, Map<DamageType, Integer> attackValues, CompanionType companionType, DamageType dt) {

        super(attackValues,companionType, dt);

        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dodgeChance = dodgeChance;
        this.resistances = new HashMap<>();
        this.potionAttack = false;
        this.bonusAttack = 1;
    }
    public void attack(Companion target, DamageType damageType) {
        int bonus = 0;
        if(this.potionAttack){
            bonus += this.bonusAttack;
        }
        target.takeDamage(this.getAttackValues().get(damageType)+bonus,damageType);
    }

    public TakingDamageStatus takeDamage(int damage, DamageType damageType){
        Random rand = new Random();
        if(rand.nextDouble() < dodgeChance){
            return TakingDamageStatus.DODGED;
        }
        else{
            /*int defense = resistances.get(damageType);
            damage = Math.max(damage-defense, 0);*/
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

    public void addhealth(int n){
        this.health += n;
    }

    public void addDodgeChance(double d){
        this.dodgeChance += d;
    }

    public void addAttackDamage(int d){
        this.potionAttack = true;
        this.bonusAttack = d;
    }

    public int getHealth() {
        return health;
    }

    public boolean isdead(){
        return this.health == 0;
    }

    @Override
    public String toString() {
        return "Companion{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
