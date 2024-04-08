package cz.cvut.fel.zavadmak.magic_adventure.core.factory;

import cz.cvut.fel.zavadmak.magic_adventure.core.utils.Vector;

public interface Movable {

    /**
     * The movable object velocity
     * @return Velocity vector
     */
    Vector getVelocity();

    /**
     * Set new object position using velocity
     */
    void move();
}
