package cz.cvut.fel.zavadmak.magic_adventure.domain.block;

public class Grass extends Block {

    public Grass() {
        super();

    }
    public Grass(double x, double y) {
        this();
        setWorldPosition(x, y);
    }
}
