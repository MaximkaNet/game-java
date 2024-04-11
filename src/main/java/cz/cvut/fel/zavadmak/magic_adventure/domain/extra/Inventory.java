package cz.cvut.fel.zavadmak.magic_adventure.domain.extra;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.magic_adventure.domain.item.Item;

import java.util.ArrayList;

public class Inventory {

    /**
     * Inventory name
     */
    private String name;

    /**
     * Inventory contents
     */
    private ArrayList<Item> items;

    /**
     * Inventory owner
     */
    private GameObject owner;

    public Inventory(GameObject applicant) {
        this.owner = applicant;
    }

    /**
     * Get inventory items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Get inventory owner
     */
    public GameObject getOwner() {
        return owner;
    }

    /**
     * Check item if exists in inventory items using equals method
     * @param item Item to check
     * @return TRUE if contains in inventory items, FALSE otherwise
     */
    public boolean contains(Item item) {
        for (Item i: items) {
            if(i.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
