package model.universe.Living.Items;

import model.universe.Living.Items.Companions.Companion;

public interface PotionHealth {
    String description = "Cette potion vous permettra d'augmentez la vie de votre companion";
    int HealthBonus = 20;

    void UsePotionHealth(Companion companion);
}
