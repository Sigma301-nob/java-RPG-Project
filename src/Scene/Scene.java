package Scene;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

import GameEngine.Game;

public abstract class Scene extends JPanel{

    protected Game game;

    public abstract void update();

    public abstract void draw(Graphics g);
} 