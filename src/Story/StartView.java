package Story;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;


public class StartView{

    private int select;


    public void draw(Graphics g,StartModel model){
        Font title    = new Font("SansSerif", Font.PLAIN, 40);
        Font option   = new Font("SansSerif", Font.PLAIN, 20);

        select = model.getSelect();

        g.setFont(title);
        g.setColor(Color.BLACK);
        g.drawString("タイトル(未定)",450,300);

        g.setFont(option);
        g.setColor(Color.BLACK);
        g.drawString("New Game",530,450);
        g.drawString("Close the Window",530,475);

        g.drawString("➤",500, 450 + select*25);

      }
}