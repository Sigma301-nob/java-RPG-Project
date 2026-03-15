import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class BattleScene extends Scene{
    
    private Game game;
    private TimeCount timer;
    int x = 0;

    public BattleScene(Game game){
        this.game = game;

        timer = new TimeCount(3); //3秒後場面転換
    }

    public void update(){
        timer.update();
    }

    public void draw(Graphics g){
        super.paintComponent(g);

         g.setColor(Color.BLACK);

        g.drawString("BattleScene",x++,50);
        g.drawString("" + timer.getTimer(),280,20);
    }
}