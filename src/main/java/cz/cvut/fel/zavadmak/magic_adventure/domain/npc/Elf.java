package cz.cvut.fel.zavadmak.magic_adventure.domain.npc;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.ArmourSet;
import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.Inventory;
import cz.cvut.fel.zavadmak.magic_adventure.domain.weapon.Weapon;

public class Elf extends GameObject {
    /**
     * The armour set
     */
    private ArmourSet armourSet;

    /**
     * The current weapon
     */
    private Weapon currentWeapon;

    /**
     * The inventory
     */
    private Inventory inventory;

    public Elf() {
        super("elf");
    }
}
