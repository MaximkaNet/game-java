package cz.cvut.fel.zavadmak.magic_adventure.views;

import cz.cvut.fel.zavadmak.magic_adventure.controllers.StartController;
import cz.cvut.fel.zavadmak.magic_adventure.controllers.WorldController;

public enum ViewList {
    /**
     * Start view
     */
    START(new StartView(new StartController())),

    /**
     * World view
     */
    WORLD(new WorldView(new WorldController()));

    private final View view;

    ViewList(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
