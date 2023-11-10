package model.universe.Living.companion;

import model.universe.Enum.DamageType;
import model.universe.Living.Living;
import views.BookContent;
import views.ImageAnimated;

import java.util.HashMap;
import java.util.Map;

public class Hero extends Living  {
    private static final int defaultHealth = 100;
    private static final int defaultStrength = 50;
    private static final int defaultDodgeChance = 10;
    private static final Map<DamageType, Integer> defaultDefenses = new HashMap<>();


    public Hero() {
        super(defaultHealth, defaultStrength, defaultDodgeChance, defaultDefenses);
        defaultDefenses.put(DamageType.PHYSICAL, 10);
        defaultDefenses.put(DamageType.MAGIC, 5);
        defaultDefenses.put(DamageType.TRUE_DAMAGE, 5);

        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Hero/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Hero/Attack_1", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 2",new ImageAnimated("src/res/living/Hero/Attack_2", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Hero/Death", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Hero/Takehit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Hero/Walk", 150, true, BookContent.getRatioD()));
    }





}
