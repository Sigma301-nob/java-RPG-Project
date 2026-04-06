package Story;

import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;

import GameEngine.KeyInputHandler;

public class Story01Model{

     private String [] kingDialog = {"勇者よ！",
                                   "ダンジョン最奥に住まう魔王を討伐してきてくれ",
                                   "ダンジョンは3階構造になっており、上に上がるに連れて魔物は強くなっていくので気を付けるのだぞ",
                                   "誠に残念なことに、勇者とともに魔王を戦おうという勇敢な者は我が領地には存在しなかったが",
                                   "そう心配するものでないぞ",
                                   "魔王の住むダンジョンの魔物は群れることはせぬと聞く",
                                   "さあ、勇者よ！ 旅立つのじゃ!"};

    private int playerX,playerY;
    
    private boolean shiftToMap;
    private int     line;


    private boolean interval;
    private long currentTime,finalOutputLogTime;
    private long intervalTime = 1000;

    public Story01Model(){
        playerX = 600;
        playerY = 700;
        line    = 0;

        shiftToMap = false;
        interval   = false;
    }


    public void update(KeyInputHandler key){
        checkShiftoMap(key);
        if(playerY >= 450){
            move();
        }else{
            checkInterval();
        }
    }

    public void move(){
        playerY--;
    }
    public void checkShiftoMap(KeyInputHandler key){
        if(!interval){
            if(key.isKeyPressed(KeyEvent.VK_SPACE)){
                shiftToMap = true;
            }
        }
    
    }

    public void checkInterval(){
        if(interval){
            currentTime = System.currentTimeMillis();
            if(currentTime - finalOutputLogTime > intervalTime){
                interval = false;
            }
        }else{
            if(line < kingDialog.length - 1){
                line++;
                finalOutputLogTime = System.currentTimeMillis();
                interval = true;
            }
        }
    }
    public String [] getKingDialog(){
        return kingDialog;
    }

    public boolean isShiftToMap(){
        return shiftToMap;
    }

    public int getLine(){
        return line;
    }

    public int getPlayerX(){
        return playerX;
    }

    public int getPlayerY(){
        return playerY;
    }
}
