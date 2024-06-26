package cz.cvut.fel.zavadmak.magic_adventure.domain.armour;

import cz.cvut.fel.zavadmak.engine.material.Material;

public abstract class Armour {

    public Armour(int usage) {
        this.usage = usage;
    }

    /**
     * UI item icon
     */
    protected Material itemIcon;

    /**
     * Sprite material
     */
    protected Material material;

    /**
     * Current usage number of armour
     */
    protected int usage;

    /**
     * Get usage number
     *
     * @return usage
     */
    public int getUsage() {
        return usage;
    }

    /**
     * Get sprite material
     *
     * @return Material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Get ui item icon
     *
     * @return Material
     */
    public Material getItemIcon() {
        return itemIcon;
    }

    /**
     * Use armour
     */
    abstract public void use(int count);

    /**
     * Repair armour
     *
     * @param count Number of armour units repaired
     */
    abstract public void repair(int count);
}
