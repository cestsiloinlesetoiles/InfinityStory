package model.universe.Living.companion;

import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;
import model.universe.Interface.AreaEffectAttack;
import model.universe.Interface.Buffable;
import model.universe.Living.Living;
import views.Media.BookContent;
import views.Animations.ImageAnimated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wizzard extends Living implements Buffable, AreaEffectAttack {

    private static final int defaultHealth = 100;
    private static final int defaultStrength = 50;
    private static final int defaultDodgeChance = 10;
    private static final Map<DamageType, Integer> defaultDefenses = new HashMap<>();

    public Wizzard() {
        super(defaultHealth, defaultStrength, defaultDodgeChance, defaultDefenses);
        defaultDefenses.put(DamageType.PHYSICAL, 10);
        defaultDefenses.put(DamageType.MAGIC, 5);
        defaultDefenses.put(DamageType.TRUE_DAMAGE, 5);

        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Wizzard/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Wizzard/Attack_1", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 2",new ImageAnimated("src/res/living/Wizzard/Attack_2", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Wizzard/Death", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Wizzard/TakeHit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Wizzard/Walk", 150, true, BookContent.getRatioD()));
    }





    public void heal(Living target) {
        int healAmount = 20;
        target.setCurrentHealth(Math.min(target.getCurrentHealth() + healAmount, target.getMaxHealth()));
        System.out.println("Soigne " + target.getName());
    }


    public void reduceArmor(Living target) {
        int armorReduction = 5;
        Map<DamageType, Integer> targetDefenses = target.getDefense();
        targetDefenses.forEach((type, value) -> targetDefenses.put(type, Math.max(value - armorReduction, 0)));
        System.out.println("Réduit l'armure de " + target.getName() + " de " + armorReduction);
    }

    @Override
    public TakingDamageStatus[] AttackArea(List<Living> targets) {
        int areaDamage = 10;
        int size = 3;
        TakingDamageStatus[] attackResults = new TakingDamageStatus[size];
        int count = 0;
        for (Living target : targets) {
            if(count >= size) break;
            System.out.println(this.getName() + "effectue une attaque AoE sur " + target.getName());
            attackResults[count] = target.takeDamage(DamageType.PHYSICAL, areaDamage);
            count++;
        }
        return attackResults;
    }
}
