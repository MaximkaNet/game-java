package cz.cvut.fel.zavadmak.magic_adventure.domain.block;

import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.Inventory;

public class Chest extends Block {
    private String title;
    private Inventory inventory;
    public Chest() {
        super();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getTitle() {
        return title;
    }
}
