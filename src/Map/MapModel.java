package Map;

import static java.lang.Math.abs;

import java.awt.event.KeyEvent;

import GameEngine.TimeCount;
import GameEngine.KeyInputHandler;


public class MapModel{
    //キーバインドの設定。プレイヤーからの変更も受け付けられるように変更できる形にしている
    private static int GO_TO_FORWARD = KeyEvent.VK_W;
    private static int GO_TO_BACK    = KeyEvent.VK_S;
    private static int GO_TO_RIGHT   = KeyEvent.VK_D;
    private static int GO_TO_LEFT    = KeyEvent.VK_A;
    


    private MapData currentMapData;
    private int mapId;
    private int playerX,playerY;
    private int stepsSinceLastBattle;

    private boolean interval;        //動いて一定時間はfalseになる
    private long currentTime,finalMoveTime;
    private long intervalTime = 200; //o.2秒に一回移動可能



    private boolean encount;


    public MapModel(MapData currentMapData,int mapId, int x,int y){
        this.currentMapData = currentMapData;
        this.mapId = mapId;
        playerX = x;
        playerY = y;
        interval = false; 

    }

    public MapModel(MapData currentMapData,int mapId){
        this.currentMapData = currentMapData;
        this.mapId = mapId;
        playerX = 1;
        playerY = 1;
        interval = false; 

    }

    public void update(KeyInputHandler key){
        playerMove(key);       
        checkEncounter(key);
        checkInterval();
        checkDepthShift();
    }

    //移動先がマップ外に出ないかと移動可能フラグがtureかを確認
    public void playerMove(KeyInputHandler key){
        if(!interval){
            if(playerY > 0 && currentMapData.isWalkable(playerX,(playerY - 1))){
                if (key.isKeyPressed(GO_TO_FORWARD))   playerY -= 1;
                intervalStart();
            }

            if((playerY + 1) < currentMapData.getMapHeight() && currentMapData.isWalkable(playerX,(playerY + 1))){
                if (key.isKeyPressed(GO_TO_BACK))   playerY += 1;
                intervalStart();
            }

            if(playerX > 0 && currentMapData.isWalkable((playerX - 1),playerY)){
                if (key.isKeyPressed(GO_TO_LEFT))   playerX -= 1;
                intervalStart();
            }

            if((playerX + 1) < currentMapData.getMapWidth()  && currentMapData.isWalkable((playerX + 1),playerY)){
                if (key.isKeyPressed(GO_TO_RIGHT))   playerX += 1;
                intervalStart();
            }
        }
    }

    public void checkDepthShift(){
        if(!interval){
            if(currentMapData.getTileAt(playerX, playerY) == 3){
                mapId += 1;
                playerY -= 1;    //無限に階段を行き来しないようにずらす
                mapShift(mapId);
            }else if(currentMapData.getTileAt(playerX, playerY) == 4){
                mapId -= 1;
                playerY -= 1;    //無限に階段を行き来しないようにずらす
                mapShift(mapId);
            }
        }
    }

    public void mapShift(int mapId){
        if(mapId == 0){
            currentMapData = new DungenFirstFloor();
        }else if(mapId == 1){
            currentMapData = new DungenSecondFloor();
        }else if(mapId == 2){
            currentMapData = new DungenThirdFloor();
        }
    }

    public void intervalStart(){
        interval = true;
        finalMoveTime = System.currentTimeMillis();
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

    public void checkInterval(){
        currentTime = System.currentTimeMillis();
        if(currentTime - finalMoveTime > intervalTime){
            interval = false;
        }
    }

    public MapData getCurrentMapData(){
        return currentMapData;
    }
    
}