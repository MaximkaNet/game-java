package cz.cvut.fel.zavadmak.magic_adventure.domain.weapon;

import cz.cvut.fel.zavadmak.engine.utils.Direction;
import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.magic_adventure.domain.item.Item;

public abstract class Weapon extends GameObject {

    /**
     * The weapon face direction
     */
    protected Direction direction;

    /**
     * The weapon cool down
     */
    protected double coolDown;

    /**
     * The weapon reference to item
     */
    protected Item referenceItem;

    public Weapon(String name, double coolDown) {
        super(name);
        this.coolDown = coolDown;
    }

    public Weapon(String name, double coolDown, Direction direction, Item referenceItem) {
        super(name);
        this.coolDown = coolDown;
        this.direction = direction;
        this.referenceItem = referenceItem;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setReferenceItem(Item referenceItem) {
        this.referenceItem = referenceItem;
    }

    public Direction getDirection() {
        return direction;
    }

    public double getCoolDown() {
        return coolDown;
    }

    public abstract void use();
}
