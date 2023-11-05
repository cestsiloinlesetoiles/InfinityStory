package model.universe.Living.Items;

import model.universe.Living.Items.Companions.Companion;

public interface PotionDodge {
    String description = "Cette potion vous permettra d'augmentez les capacités d'esquives de votre companion";
    double dodgepercentage = 0.2;

    void UsePotionDodge(Companion companion);
}
