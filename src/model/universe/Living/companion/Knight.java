package model.universe.Living.companion;

import model.universe.Enum.DamageType;
import model.universe.Interface.Berserker;
import model.universe.Living.Living;
import views.Media.BookContent;
import views.Animations.ImageAnimated;

import java.util.HashMap;
import java.util.Map;

public class Knight extends Living  implements Berserker {
    private boolean isBerserk;
    private static final int defaultHealth = 100;
    private static final int defaultStrength = 50;
    private static final int defaultDodgeChance = 10;
    private static final Map<DamageType, Integer> defaultDefenses = new HashMap<>();

    private int originalStrength;
    private Map<DamageType, Integer>  originalDefense;

    public Knight() {
        super(defaultHealth, defaultStrength, defaultDodgeChance, defaultDefenses);
        defaultDefenses.put(DamageType.PHYSICAL, 10);
        defaultDefenses.put(DamageType.MAGIC, 5);
        defaultDefenses.put(DamageType.TRUE_DAMAGE, 5);
        originalDefense = defaultDefenses;
        originalStrength = defaultStrength;

        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Knight/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Knight/Attack", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Knight/Death", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Knight/TakeHit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Knight/Walk", 150, true, BookContent.getRatioD()));
    }

    public void enterBerserkMode() {
        isBerserk = true;
        increaseAttackPower();
        reduceDefense();
        System.out.println("Entrer en mode fou furieux !");
    }

    @Override
    public void exitBerserkMode() {
        isBerserk = false;
        normalizeAttackPower();
        normalizeDefense();
        System.out.println("Sortie du mode berserk.");
    }


    private void increaseAttackPower() {
        this.setStrength(this.getStrength() * 2);
    }

    private void reduceDefense() {

        Map<DamageType, Integer> currentDefenses = this.getDefense();


        currentDefenses.forEach((type, value) ->
                currentDefenses.put(type, value / 2)
        );


        System.out.println("Armure reduit " + this.getName());
    }

    private void normalizeAttackPower() {
        this.setStrength(this.originalStrength);
    }

    private void normalizeDefense() {
        this.setDefense(this.originalDefense);
    }






}
