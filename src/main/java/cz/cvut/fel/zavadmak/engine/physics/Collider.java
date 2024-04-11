package cz.cvut.fel.zavadmak.engine.physics;

import cz.cvut.fel.zavadmak.engine.utils.Vector;

public interface Collider {
    boolean overlaps(Collider collider);
    Vector getPosition();
}
