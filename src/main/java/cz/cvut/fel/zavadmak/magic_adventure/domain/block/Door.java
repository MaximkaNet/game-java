package cz.cvut.fel.zavadmak.magic_adventure.domain.block;

public class Door extends Block {
    /**
     * Door statements
     */
    public enum DoorState {
        CLOSE,
        OPEN_FRONT,
        OPEN_BACK
    }

    /**
     * Door statement
     */
    private DoorState state = DoorState.CLOSE;

    public Door() {
        super();
    }

    public boolean isOpen() {
        return state != DoorState.CLOSE;
    }

    public void setClose() {
        state = DoorState.CLOSE;
    }

    public void setOpenFront() {
        state = DoorState.OPEN_FRONT;
    }

    public void setOpenBack() {
        state = DoorState.OPEN_BACK;
    }

    /**
     * Set door statement
     * @param state The door statement
     */
    public void setState(DoorState state) {
        this.state = state;
    }
}
