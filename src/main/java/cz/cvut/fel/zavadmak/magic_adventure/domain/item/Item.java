package cz.cvut.fel.zavadmak.magic_adventure.domain.item;

import cz.cvut.fel.zavadmak.engine.material.Material;

import java.util.Objects;

public class Item {
    /**
     * The item name
     */
    private String name;

    /**
     * Count items
     */
    private int count;

    /**
     * The item image
     */
    private Material material;

    /**
     * Able to stack
     */
    private boolean stackable = true;

    public Item() {
        this.count = 1;
    }

    public Item(String name) {
        this();
        this.name = name;
    }

    /**
     * Set image using file path
     *
     * @param filePath path to image
     */
    public void setMaterial(String filePath) {
        try {
            this.material = new Material(filePath);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            // Set default image
//            this.image = new Image();
        }
    }

    /**
     * Get item image
     *
     * @return Image if is set, null otherwise
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Set the item name
     *
     * @param name item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get item name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add one item
     */
    public void addOne() {
        count++;
    }

    /**
     * Remove one item
     */
    public void removeOne() {
        count--;
    }

    /**
     * Get count items
     */
    public int getCount() {
        return this.count;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public boolean isStackable() {
        return stackable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
