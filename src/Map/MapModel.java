package Map;

import java.awt.event.KeyEvent;

import GameEngine.TimeCount;
import GameEngine.KeyInputHandler;


public class MapModel{

    //private MapData currentMapData;
    private int playerX,playerY;
    private int stepsSinceLastBattle;



    private boolean encount;

    private TimeCount timer;


    public MapModel(){
        playerX = 10;
        playerY = 10;
        

        timer = new TimeCount(); 

    }
    public void update(KeyInputHandler key){
        timer.update();
        playerMove(key);       
        checkEncounter();
    }

    public void checkEncounter(){
        if(timer.checkTimeup()){
            encount = true;
        }  
    }

    public void setEncountToFalse(){
        encount = false;
    }

    public boolean isEncount(){
        return encount;
    }

    public int getPlayerX(){
        return playerX;
    }

    public int getPlayerY(){
        return playerY;
    }

    public void playerMove(KeyInputHandler key){
        if (key.isKeyPressed(KeyEvent.VK_W))    playerY -= 5;
        if (key.isKeyPressed(KeyEvent.VK_S))  playerY += 5;
        if (key.isKeyPressed(KeyEvent.VK_A))   playerX -= 5;
        if (key.isKeyPressed(KeyEvent.VK_D)) playerX += 5;

    }

    public TimeCount getTime(){
        return timer;
    }

    public TimeCount getTimer(){
        return timer;
    }

    
}