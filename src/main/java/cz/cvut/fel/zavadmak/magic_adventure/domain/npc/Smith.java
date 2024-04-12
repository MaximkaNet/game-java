package cz.cvut.fel.zavadmak.magic_adventure.domain.npc;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.magic_adventure.domain.item.Key;

import java.util.HashMap;
import java.util.Map;

public class Smith extends GameObject {

    /**
     * The key fragments
     */
    private final Map<Key.Fragment, Key> fragments = new HashMap<>();

    /**
     * The nickname
     */
    private final String nickname;

    public Smith(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Apply key fragment. If key fragment already exists,
     * it will be rewritten by new fragment
     *
     * @param fragment Fragment to apply
     */
    public void applyKeyFragment(Key fragment) {
        fragments.put(fragment.getKeyFragment(), fragment);
    }

    /**
     * Make a key
     *
     * @return Key with fragment statement Key.Fragment.FULL
     */
    public Key make() {
        if (hasEnoughFragments()) {
            fragments.clear();
            return new Key(Key.Fragment.FULL);
        }
        // Throws not enough exception ...
        return null;
    }

    /**
     * Checks fragments using containsKey function
     *
     * @return TRUE if fragments enough, FALSE otherwise
     */
    public boolean hasEnoughFragments() {
        return fragments.containsKey(Key.Fragment.FIRST) &&
                fragments.containsKey(Key.Fragment.SECOND);
    }
}
