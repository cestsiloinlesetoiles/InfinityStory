package model.universe.Living.monster.ForestArch;

import model.universe.Enum.DamageType;
import model.universe.Interface.HoldShield;
import model.universe.Living.Living;
import views.BookContent;
import views.ImageAnimated;

import java.util.HashMap;
import java.util.Map;

public class Skeleton extends Living implements HoldShield {
    private boolean isShieldActive;
    private Map<DamageType, Integer>  originalDefense;
    private static final int defaultHealth = 100;
    private static final int defaultStrength = 50;
    private static final int defaultDodgeChance = 10;
    private static final Map<DamageType, Integer> defaultDefenses = new HashMap<>();

    public Skeleton() {
        super(defaultHealth, defaultStrength, defaultDodgeChance, defaultDefenses);
        defaultDefenses.put(DamageType.PHYSICAL, 10);
        defaultDefenses.put(DamageType.MAGIC, 5);
        defaultDefenses.put(DamageType.TRUE_DAMAGE, 5);
        originalDefense = defaultDefenses;


        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Skeleton/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Skeleton/Attack", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Shield",new ImageAnimated("src/res/living/Skeleton/Shield", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Skeleton/Dead", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Skeleton/Takehit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Skeleton/Walk", 150, true, BookContent.getRatioD()));
    }

    public void activateShield() {
        isShieldActive = true;
        getDefense().forEach((type, value) -> getDefense().put(type, value+10));
        System.out.println("Bouclier activé. Défense augmentée.");
    }
    public  void deactivateShield(){
        isShieldActive = false;
        this.setDefense(this.originalDefense);
        System.out.println("Bouclier desactiver.");
    };

}
