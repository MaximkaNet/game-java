package cz.cvut.fel.zavadmak.magic_adventure.controllers;

import cz.cvut.fel.zavadmak.engine.ViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartController implements ViewController {

    public EventHandler<ActionEvent> getNewGameButtonActionHandler() {
        return (event) -> {
            System.out.println("Click");
        };
    }

    @Override
    public void startHandling() {
    }

    @Override
    public void shutdownController() {
    }
}
