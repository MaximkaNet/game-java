package cz.cvut.fel.zavadmak.magic_adventure.domain.armour;

public class Helmet extends Armour {

    public Helmet() {
        super(20);
    }

    public Helmet(int maximumUsage) {
        super(maximumUsage);
    }

    @Override
    public void use(int count) {

    }

    @Override
    public void repair(int count) {

    }
}
