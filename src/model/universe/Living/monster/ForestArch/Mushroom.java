package model.universe.Living.monster.ForestArch;

import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;
import model.universe.Living.Living;
import views.BookContent;
import views.ImageAnimated;

import java.util.HashMap;
import java.util.Map;

public class Mushroom extends Living {
    private static final int defaultHealth = 100;
    private static final int defaultStrength = 50;
    private static final int defaultDodgeChance = 10;
    private static final Map<DamageType, Integer> defaultDefenses = new HashMap<>();

    public Mushroom() {
        super(defaultHealth, defaultStrength, defaultDodgeChance, defaultDefenses);
        defaultDefenses.put(DamageType.PHYSICAL, 10);
        defaultDefenses.put(DamageType.MAGIC, 5);
        defaultDefenses.put(DamageType.TRUE_DAMAGE, 5);

        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Mushroom/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Mushroom/Attack", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Mushroom/Death", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Mushroom/TakeHit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Mushroom/Walk", 150, true, BookContent.getRatioD()));
    }


}
