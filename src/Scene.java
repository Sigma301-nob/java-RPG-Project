import java.awt.Graphics;

public abstract class Scene{

    protected Game game;

    public abstract void update();

    public abstract void draw(Graphics g);
} 