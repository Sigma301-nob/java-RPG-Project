package Story;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;

import GameEngine.KeyInputHandler;

public class Story01{
    private String [] kingDialog = {"勇者よ！",
                                   "ダンジョン最奥に住まう魔王を討伐してきてくれ",
                                   "ダンジョンは3階構造になっており、上に上がるに連れて魔物は強くなっていくので気を付けるのだぞ",
                                   "誠に残念なことに、勇者とともに魔王を戦おうという勇敢な者は我が領地には存在しなかったが",
                                   "そう心配するものでないぞ",
                                   "魔王の住むダンジョンの魔物は群れることはせぬと聞く",
                                   "さあ、勇者よ！ 旅立つのじゃ!"};
    

    private int playerX;
    private int playerY;
    private int line;

    private boolean endDialog;
    private boolean interval;
    private boolean shiftToMap;
    private long currentTime,finalOutputLogTime;
    private long intervalTime = 1000;


    public void draw(Graphics g, KeyInputHandler key){
        Font dialogFont = new Font("SansSerif", Font.PLAIN, 20);

        int line = 0;

        endDialog = false;
        interval  = false;
        shiftToMap = false;

        playerX = 600;
        playerY = 700;
        
        g.setColor(Color.BLACK);
        g.fillRect(0,600,400,500);
        g.fillRect(800,600,400,500);
        g.fillRect(0,0,1200,50);

       
        g.setColor(Color.RED);
        g.fillOval(600,300,50,50);

        g.setColor(Color.BLUE);
        g.fillOval(playerX,playerY,30,30);

        g.setFont(dialogFont);
        if(playerY > 450){
            playerY--;
        }else{
             g.setColor(Color.BLACK);
             g.fillRect(50,530,1100,300);
             g.setColor(Color.WHITE);
             g.drawRect(50,530,1100,300);

             checkIntervalAndEndLog();

             if(line < 3){
                for(int i = 0;i < line; i++){
                    g.drawString(kingDialog[line],100,600 + i*40);
                }
             }else{
                for(int i = 0;i < 3; i++){
                    g.drawString(kingDialog[line],100,600 + i*40);
                }
             }
            if(!endDialog){
                if(!interval){
                    line++;
                    newLogOutput();
                }
            }else{
                if(key.isKeyPressed(KeyEvent.VK_SPACE)){
                    shiftToMap = true;
                }
            }

        }
    }

    public void newLogOutput(){
        finalOutputLogTime = System.currentTimeMillis();
        interval = true;
    }

    public void checkIntervalAndEndLog(){
        currentTime = System.currentTimeMillis();
         if(currentTime - finalOutputLogTime > intervalTime){
            interval = false;
        }
        if(line == kingDialog.length){
            endDialog = true;
        }
    }

    public boolean isShiftToMap(){
        return shiftToMap;
    }
}