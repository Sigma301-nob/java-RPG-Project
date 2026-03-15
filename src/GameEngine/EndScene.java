package GameEngine;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class EndScene extends Scene{
    
    int x = 0;

    public void update(){

    }

    public void draw(Graphics g){
        super.paintComponent(g);

         g.setColor(Color.BLACK);

        g.drawString("GameClear",x++,50);
    }
}