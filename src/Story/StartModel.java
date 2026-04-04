package Story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;

import GameEngine.KeyInputHandler;

//スタートメニューのモデルとビューをまとめたもの。クラス設計上、分離させたほうが良いならば分離させる。
//まとめてしまったのでこのまま置いとく
public class StartModel{

    private boolean newGame;
    private boolean gameEnd;

    private int     select;
    
    private boolean interval;        //動いて一定時間はfalseになる
    private long currentTime,finalPressedTime;
    private long intervalTime = 200; //o.2秒に一回移動可能


    public StartModel(){
        newGame  = false;
        gameEnd  = false;

        select   = 0;
        interval = false;
    }

    public void update(KeyInputHandler key){
        if(!interval){
            selectMenu(key);
        }
        checkEndInterval();
    }

    public void selectMenu(KeyInputHandler key){
        if(!interval){
            if(key.isKeyPressed(KeyEvent.VK_S) && select < 1) {
                select++;
                pressed();
            }
            else if(key.isKeyPressed(KeyEvent.VK_W) && select > 0) {
                    select--;
                    pressed();
            }

            if(key.isKeyPressed(KeyEvent.VK_E)){
                if(select == 0){
                    newGame = true;
                }else if(select == 1){
                    gameEnd = true;
                }
            }
        }
    }

     public void pressed(){
        interval = true;
        finalPressedTime = System.currentTimeMillis();
    }

    public void checkEndInterval(){
        currentTime = System.currentTimeMillis();
        if(currentTime - finalPressedTime > intervalTime){
            interval = false;
        }
    }

    public boolean isStartNewGame(){
        return newGame;
    }

    public boolean isEndGame(){
        return gameEnd;
    }

    public int getSelect(){
        return select;
    }

}