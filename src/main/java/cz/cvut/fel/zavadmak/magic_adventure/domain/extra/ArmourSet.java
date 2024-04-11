package cz.cvut.fel.zavadmak.magic_adventure.domain.extra;

import cz.cvut.fel.zavadmak.magic_adventure.domain.armour.Cloak;
import cz.cvut.fel.zavadmak.magic_adventure.domain.armour.Helmet;

public class ArmourSet {
    private Helmet helmet;
    private Cloak cloak;

    public ArmourSet(Helmet helmet, Cloak cloak) {
        this.helmet = helmet;
        this.cloak = cloak;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    public void setCloak(Cloak cloak) {
        this.cloak = cloak;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public Cloak getCloak() {
        return cloak;
    }
}
