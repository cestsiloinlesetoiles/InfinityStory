package model.universe.Living.Items;

import model.universe.Living.Items.Companions.Companion;

public interface PotionAttack {

    String description = "Cette potion vous permettra de boostez les attaques de votre companion";
    int boost = 10;

    void UsePotionAttack(Companion companion);


}
