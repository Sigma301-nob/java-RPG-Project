import java.awt.Graphics;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class MapScene extends Scene{
    
   private int x = 100,y = 100;

    public void update(){
 	    KeyInputHandler.update();
        // Inputクラス経由で入力をチェック
        if (KeyInputHandler.isKeyPressed(KeyEvent.VK_W))    y -= 5;
        if (KeyInputHandler.isKeyPressed(KeyEvent.VK_S))  y += 5;
        if (KeyInputHandler.isKeyPressed(KeyEvent.VK_A))  x -= 5;
        if (KeyInputHandler.isKeyPressed(KeyEvent.VK_D)) x += 5;
    }

    public void draw(Graphics g){
        super.paintComponent(g);

         g.setColor(Color.BLACK);
        g.fillRect(x, y, 50, 50);

    }
}