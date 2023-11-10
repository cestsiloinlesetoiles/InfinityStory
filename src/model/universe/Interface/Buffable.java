package model.universe.Interface;

import model.universe.Living.Living;

public interface Buffable {
    void heal(Living target);
    void reduceArmor(Living target);
}
