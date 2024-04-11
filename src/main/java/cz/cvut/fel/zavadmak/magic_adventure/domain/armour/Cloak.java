package cz.cvut.fel.zavadmak.magic_adventure.domain.armour;

public class Cloak extends Armour {

    public Cloak() {
        super(10);
    }

    public Cloak(int maximumUsage) {
        super(maximumUsage);
    }

    @Override
    public void use(int count) {
        this.usage -= count;
        if(this.usage < 0) {
            this.usage = 0;
        }
    }

    @Override
    public void repair(int count) {

    }
}
