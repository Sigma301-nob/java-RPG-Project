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
    private boolean logStop;
    private int     sentence;
    private int     line;


    private boolean interval;
    private long currentTime,finalOutputLogTime;
    private long intervalTime = 1000;

    public Story01Model(){
        playerX  = 600;
        playerY  = 700;
        sentence = 0;
        line     = 0;

        shiftToMap = false;
        logStop    = false;
        interval   = false;
    }


    public void update(KeyInputHandler key){
         checkShiftoMap(key);
        if(playerY >= 450){
            move();
            if(playerY == 450){
                interval = true;
                finalOutputLogTime = System.currentTimeMillis();
            }
        }else{
            checkInterval();
        }
    }

    public void move(){
        playerY--;
    }
    public void checkShiftoMap(KeyInputHandler key){
        if(!interval){
            if(key.isKeyPressed(KeyEvent.VK_E) && sentence == kingDialog.length - 1){
                shiftToMap = true;
            }

            if(key.isKeyPressed(KeyEvent.VK_E) && logStop == true){
                logStop = false;
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
            if(line < kingDialog.length){
                if(!logStop){
                    if(sentence < kingDialog.length - 1){
                        sentence++;
                    }
                    line = sentence % 3;
                    finalOutputLogTime = System.currentTimeMillis();
                    interval = true;

                    if(line == 2 || sentence == kingDialog.length - 1){
                        logStop = true;
                    }
                }
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

    public int getsentence(){
        return sentence;
    }

    public boolean test(){
        return interval;
    }

    public int getPlayerX(){
        return playerX;
    }

    public int getPlayerY(){
        return playerY;
    }
}
