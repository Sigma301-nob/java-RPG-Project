package Story;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

public class Story01View {
    
    private String [] kingDialog;

    private int playerX;
    private int playerY;
    private int line;
    private int sentence;


    public void draw(Graphics g, Story01Model model){

        Font dialogFont = new Font("SansSerif", Font.PLAIN, 20);
         
        kingDialog = model.getKingDialog();
        playerX    = model.getPlayerX();  
        playerY    = model.getPlayerY();
        line       = model.getLine();
        sentence   = model.getsentence();
        g.setColor(Color.BLACK);
        g.fillRect(0,600,400,500);
        g.fillRect(800,600,400,500);
        g.fillRect(0,0,1200,50);

       
        g.setColor(Color.RED);
        g.fillOval(600,300,50,50);

        g.setColor(Color.BLUE);
        g.fillOval(playerX,playerY,30,30);

        g.setFont(dialogFont);

        g.drawString("sentence; " + sentence + model.test(),600,300);

        if(playerY < 450){
             g.setColor(Color.BLACK);
             g.fillRect(50,530,1100,300);
             g.setColor(Color.WHITE);
             g.drawRect(50,530,1100,300);

            
            for(int i = 0;i < line + 1; i++){
                g.drawString(kingDialog[(sentence - line) + i],100,600 + i*40);
            }
            

        }
    }
}