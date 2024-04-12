package cz.cvut.fel.zavadmak.magic_adventure.domain.item;

public class Key extends Item {
    /**
     * The key fragments
     */
    public enum Fragment {
        FULL,
        EMPTY,
        FIRST,
        SECOND
    }

    /**
     * Key fragment
     */
    private final Fragment keyFragment;

    public Key(Fragment fragment) {
        keyFragment = fragment;
    }

    public Fragment getKeyFragment() {
        return keyFragment;
    }

    /**
     * Check kind of key
     *
     * @return TRUE if keyFragment is FIRST or SECOND, FALSE otherwise
     */
    public boolean isFragment() {
        return (keyFragment == Fragment.FIRST ||
                keyFragment == Fragment.SECOND);
    }

    public boolean isEmpty() {
        return keyFragment == Fragment.EMPTY;
    }

    public boolean isFull() {
        return keyFragment == Fragment.FULL;
    }
}
