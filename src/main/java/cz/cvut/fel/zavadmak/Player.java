package cz.cvut.fel.zavadmak;

import cz.cvut.fel.zavadmak.core.GameObject;
import cz.cvut.fel.zavadmak.core.factory.IInteract;
import cz.cvut.fel.zavadmak.core.factory.IMovable;
import cz.cvut.fel.zavadmak.core.utils.Vector;

public final class Player extends GameObject implements IMovable, IInteract {

    private Vector velocity;

    public Player() {
        velocity = new Vector(0, 0);
    }

    public Vector getVelocity() {
        return velocity;
    }
}
