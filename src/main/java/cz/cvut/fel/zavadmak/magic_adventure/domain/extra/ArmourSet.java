package cz.cvut.fel.zavadmak.magic_adventure.domain.extra;

import cz.cvut.fel.zavadmak.magic_adventure.domain.armour.Cloak;
import cz.cvut.fel.zavadmak.magic_adventure.domain.armour.Helmet;

public class ArmourSet {
    /**
     * The helmet
     */
    private Helmet helmet;

    /**
     * The cloak
     */
    private Cloak cloak;

    public ArmourSet(Helmet helmet, Cloak cloak) {
        this.helmet = helmet;
        this.cloak = cloak;
    }

    /**
     * Set helmet
     *
     * @param helmet
     */
    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }

    /**
     * Set cloak
     *
     * @param cloak
     */
    public void setCloak(Cloak cloak) {
        this.cloak = cloak;
    }

    /**
     * Get helmet instance
     *
     * @return Helmet
     */
    public Helmet getHelmet() {
        return helmet;
    }

    /**
     * Get cloak
     *
     * @return Cloak
     */
    public Cloak getCloak() {
        return cloak;
    }
}
