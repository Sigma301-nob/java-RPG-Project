package Map;

import static java.lang.Math.abs;

import java.awt.event.KeyEvent;

import GameEngine.TimeCount;
import GameEngine.KeyInputHandler;


public class MapModel{

    private MapData currentMapData;
    private int playerX,playerY;
    private int stepsSinceLastBattle;

    private boolean ableToMove;        //動いて一定時間はfalseになる
    private long currentTime,finalMoveTime;
    private long delayMoveSpeed = 200; //o.2秒に一回移動可能



    private boolean encount;


    public MapModel(MapData currentMapData){
        this.currentMapData = currentMapData;
        playerX = 1;
        playerY = 1;
        ableToMove = true; 

    }
    public void update(KeyInputHandler key){
        playerMove(key);       
        checkEncounter(key);
        checkAbleToMove();
    }

    public void checkEncounter(KeyInputHandler key){
        if(key.isKeyPressed(KeyEvent.VK_SPACE)){
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


    //移動先がマップ外に出ないかと移動可能フラグがtureかを確認
    public void playerMove(KeyInputHandler key){
        if(ableToMove){
            if((playerY - 1) >= 0 && (playerY - 1) < currentMapData.getMapheight() && currentMapData.isWalkable(playerX,(playerY - 1))){
                if (key.isKeyPressed(KeyEvent.VK_W))   playerY -= 1;
                moved();
            }

            if((playerY + 1) >= 0 && (playerY + 1) < currentMapData.getMapheight() && currentMapData.isWalkable(playerX,(playerY + 1))){
                if (key.isKeyPressed(KeyEvent.VK_S))   playerY += 1;
                moved();
            }

            if((playerX - 1) >= 0 && (playerX - 1) < currentMapData.getMapwidth()  && currentMapData.isWalkable((playerX - 1),playerY)){
                if (key.isKeyPressed(KeyEvent.VK_A))   playerX -= 1;
                moved();
            }

            if((playerX + 1) >= 0 && (playerX + 1) < currentMapData.getMapwidth()  && currentMapData.isWalkable((playerX + 1),playerY)){
                if (key.isKeyPressed(KeyEvent.VK_D))   playerX += 1;
                moved();
            }
        }
    }

    public void moved(){
        ableToMove = false;
        finalMoveTime = System.currentTimeMillis();
    }

    public void checkAbleToMove(){
        currentTime = System.currentTimeMillis();
        if(currentTime - finalMoveTime > delayMoveSpeed){
            ableToMove = true;
        }
    }

    public MapData getcurrentMapData(){
        return currentMapData;
    }
    
}