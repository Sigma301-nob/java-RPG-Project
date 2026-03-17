package Map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;


public class MapView{

    private Image tileSet;


    public void draw(Graphics g,MapModel model){

        g.setColor(Color.BLACK);
        g.fillRect(model.getPlayerX(),model.getPlayerY(), 10, 10);

        g.drawString("" + model.getTime().getTimer(),280,20);
    }
}