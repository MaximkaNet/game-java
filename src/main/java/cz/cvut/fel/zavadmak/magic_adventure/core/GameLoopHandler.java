package cz.cvut.fel.zavadmak.core;

import cz.cvut.fel.zavadmak.World;
import javafx.animation.AnimationTimer;

public class GameLoopHandler extends AnimationTimer {
    private World world;
    private RenderProvider renderProvider;

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public RenderProvider getRenderProvider() {
        return renderProvider;
    }

    public void setRenderProvider(RenderProvider renderProvider) {
        this.renderProvider = renderProvider;
    }

    @Override
    public void start() {
        if (renderProvider == null) {
            System.err.println("Render provider is not defined");
            return;
        }
        super.start();
    }

//    private long lastTime = 0;
//    int fps = 60;
//    double frameInterval = 1000 / fps;
//    double frameCounter = 0;
//    double frameTimer = 0;
    
    @Override
    public void handle(long l) {
//        double deltaTime = l - lastTime;
//        lastTime = l;
//        if(frameTimer > frameInterval) {
//            System.out.println(frameCounter);
//            frameTimer = 0;
//            frameCounter = 0;
//        } else {
//            frameTimer += deltaTime;
//            frameCounter++;
//        }

        // Update world
//        world.update();
        // Draw game world
//        world.draw(renderProvider.getGraphicsContext2D());
    }
}
