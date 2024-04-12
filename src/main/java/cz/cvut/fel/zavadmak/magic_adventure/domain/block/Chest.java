package cz.cvut.fel.zavadmak.magic_adventure.domain.block;

import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.Inventory;

public class Chest extends Block {
    /**
     * The chest title
     */
    private String title;

    /**
     * The inventory
     */
    private Inventory inventory;

    public Chest() {
        super();
    }

    /**
     * Get inventory instance
     *
     * @return Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Get title
     *
     * @return String
     */
    public String getTitle() {
        return title;
    }
}
