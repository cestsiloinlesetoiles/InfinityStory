package model.universe.Living.Items;

import model.universe.Living.Items.Companions.Companion;

public class NormalHealthPotion extends Item implements PotionHealth{


    public NormalHealthPotion() {
        super("Potion PV normale", description);
    }

    public void UsePotionHealth(Companion companion) {
        companion.addhealth(HealthBonus);
    }
}
