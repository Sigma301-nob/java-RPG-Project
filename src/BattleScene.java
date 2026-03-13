import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class BattleScene extends Scene{
    
    int x = 0;

    public void update(){

    }

    public void draw(Graphics g){
        super.paintComponent(g);

         g.setColor(Color.BLACK);

        g.drawString("BattleScene",x++,50);
    }
}