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

    private double speed = 5;

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

    public void setCurrentWeapon(Weapon newWeapon) {
        this.currentWeapon = newWeapon;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setNickname(String nick) {
        this.nickname = nick;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void addMovementX(int direction) {
        this.velocity.add(direction, 0);
    }

    public void addMovementY(int direction) {
        this.velocity.add(0, direction);
    }

    /**
     * Move player using velocity
     */
    public void move() {
        Vector normalizedVelocity = this.velocity.normalized();
        normalizedVelocity.multiply(this.speed);
        this.getWorldPosition().add(normalizedVelocity);
    }
}
