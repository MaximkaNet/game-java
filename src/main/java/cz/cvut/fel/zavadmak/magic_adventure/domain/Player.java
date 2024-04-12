package cz.cvut.fel.zavadmak.magic_adventure.domain;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.engine.utils.Vector;
import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.ArmourSet;
import cz.cvut.fel.zavadmak.magic_adventure.domain.extra.Inventory;
import cz.cvut.fel.zavadmak.magic_adventure.domain.weapon.Weapon;

public class Player extends GameObject {

    /**
     * Player nickname
     */
    private String nickname;

    /**
     * The player inventory
     */
    private Inventory inventory;

    /**
     * The player armour
     */
    private ArmourSet armourSet;

    /**
     * The player weapon
     */
    private Weapon currentWeapon;

    /**
     * Player velocity
     */
    private final Vector velocity;

    public Player(String nickname) {
        this();
        this.nickname = nickname;
    }

    public Player() {
        super("player");
        this.velocity = new Vector(0, 0);
    }

    public Vector getVelocity() {
        return velocity;
    }

    public String getNickname() {
        return nickname;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArmourSet getArmourSet() {
        return armourSet;
    }

    public void changeWeapon(Weapon newWeapon) {
        this.currentWeapon = newWeapon;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setNickname(String nick) {
        this.nickname = nick;
    }

    /**
     * Move player using velocity
     */
    public void move() {
        this.getWorldPosition().add(this.velocity);
    }
}
