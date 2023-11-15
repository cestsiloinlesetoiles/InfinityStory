package model.universe.Living;

import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;
import views.Animations.AnimationSet;

import java.util.Map;

public abstract class Living {

    protected AnimationSet livingAnimations;
    protected String Name;
    protected int currentHealth;
    protected int strength;
    //En pourcentages
    protected int dodgeChance;
    protected Map<DamageType, Integer> defense;

    private int maxHealth;


    public Living(int h, int s, int dd, Map<DamageType, Integer> d) {
        this.currentHealth = h;
        this.strength = s;
        this.dodgeChance = dd;
        this.defense = d;
        this.maxHealth = h;
    }

    public Map<DamageType, Integer> getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return Name;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAnim(AnimationSet a) {
        this.livingAnimations = a;
    }

    public void setCurrentHealth(int healAmount) {
        this.currentHealth = healAmount;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public TakingDamageStatus takeDamage(DamageType damageType, int damageAmount) {
        int finalDamage = damageAmount;
        if (Math.random() * 100 < dodgeChance) {
            System.out.println(Name + " a esquivé l'attaque !");
            return TakingDamageStatus.DODGED;
        }
        if (DamageType.TRUE_DAMAGE == damageType) {
            this.currentHealth -= finalDamage;

        } else {
            int resistance = defense.getOrDefault(damageType, 0);
            finalDamage = Math.max(damageAmount - resistance, 0);
            this.currentHealth -= finalDamage;
        }


        if (this.currentHealth <= 0) {
            System.out.println(Name + "a été vaincu");
            return TakingDamageStatus.DEFEATED;
        } else {
            System.out.println(Name + " a reçu " + finalDamage + " points de dégâts." + " Santé actuelle : " + currentHealth);
            return TakingDamageStatus.HIT;
        }
    }

    public TakingDamageStatus attack(Living target) {
        int damageDealt = this.getStrength();
        System.out.println(this.getName() + " attaque " + target.getName());
        return target.takeDamage(DamageType.PHYSICAL, damageDealt);
    }

    public void setStrength(int i) {
        this.strength = i;
    }

    public void setDefense(Map<DamageType, Integer> d){
        this.defense = d;
    }
}


