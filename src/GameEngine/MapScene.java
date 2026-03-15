package GameEngine;

import java.awt.Graphics;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class MapScene extends Scene{
    
   private Game game; 


   public MapScene(Game game){
        this.game = game;
   }

    public void update(){
        game.getmapModel().update();
    }


    public void draw(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(game.getmapModel().getPlayerX(),game.getmapModel().getPlayerY(), 10, 10);

        g.drawString("" + timer.getTimer(),280,20);

    }
}