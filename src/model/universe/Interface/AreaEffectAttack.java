package model.universe.Interface;
import model.universe.Enum.TakingDamageStatus;
import model.universe.Living.Living;

import java.util.List;

public interface AreaEffectAttack {
    TakingDamageStatus[] AttackArea(List<Living> targets);
}
