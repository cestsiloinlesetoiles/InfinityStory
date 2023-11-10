package model.universe.Living.monster.BrigandArch;

import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;
import model.universe.Interface.Stealth;
import model.universe.Living.Living;
import views.BookContent;
import views.ImageAnimated;

import java.util.HashMap;
import java.util.Map;

public class Bandit_2 extends Brigand implements Stealth {
    // Rajouter ligne AnimSet
    public Bandit_2() {
        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Brigand_2/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Brigand_2/Attack_1", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 2",new ImageAnimated("src/res/living/Brigand_2/Attack_2", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 3",new ImageAnimated("src/res/living/Brigand_2/Attack_1", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Brigand_2/Death", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Brigand_2/Takehit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Brigand_2/Walk", 150, true, BookContent.getRatioD()));
    }

    public void activeStealth(){
        this.setInStealth(true);
    };
    public void disableStealth(){
        this.setInStealth(false);
    };


}
