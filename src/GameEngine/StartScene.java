package GameEngine;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class StartScene extends Scene{

    private Game game;
    int y = 0;

    public StartScene(Game game){
        this.game = game;
    }

    public void update(){
        if(y == 100){
            game.changeScene(new MapScene(game));
        }
    }

    public void draw(Graphics g){
        super.paintComponent(g);

         g.setColor(Color.BLACK);

        g.drawString("GameStart",150,y++);
    }
}