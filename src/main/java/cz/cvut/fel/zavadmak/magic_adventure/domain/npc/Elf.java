package cz.cvut.fel.zavadmak.magic_adventure.domain.npc;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.ArmourSet;
import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.Inventory;
import cz.cvut.fel.zavadmak.magic_adventure.domain.weapon.Weapon;

public class Elf extends GameObject {
    private ArmourSet armourSet;
    private Weapon currentWeapon;
    private Inventory inventory;
}
