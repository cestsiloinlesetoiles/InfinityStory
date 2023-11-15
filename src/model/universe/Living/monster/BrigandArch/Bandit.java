package model.universe.Living.monster.BrigandArch;

import model.universe.Enum.DamageType;
import model.universe.Enum.TakingDamageStatus;
import model.universe.Interface.AreaEffectAttack;
import model.universe.Living.Living;
import views.Media.BookContent;
import views.Animations.ImageAnimated;

import java.util.List;

public class Bandit extends Brigand  implements AreaEffectAttack {
    // Rajouter ligne AnimSet
    public Bandit() {
        livingAnimations.addAnimation("Idle",new ImageAnimated("src/res/living/Brigand/Idle", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 1",new ImageAnimated("src/res/living/Brigand/Attack_1", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 2",new ImageAnimated("src/res/living/Brigand/Attack_2", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 3",new ImageAnimated("src/res/living/Brigand/Attack_3", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Attack 4",new ImageAnimated("src/res/living/Brigand/Attack_4", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Death",new ImageAnimated("src/res/living/Brigand/Death", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("TakeHit",new ImageAnimated("src/res/living/Brigand/Takehit", 150, true, BookContent.getRatioD()));
        livingAnimations.addAnimation("Walk", new ImageAnimated("src/res/living/Brigand/Walk", 150, true, BookContent.getRatioD()));
    }


    @Override
    public TakingDamageStatus[] AttackArea(List<Living> targets) {
        int areaDamage = 10;
        int size = 2;
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
