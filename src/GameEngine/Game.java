package GameEngine;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;

import Map.*;
import Battle.*;
import Scene.*;

public class Game extends JFrame implements Runnable{

    private Thread th = null;

    Scene currentScene;
    MapLoader mapLoader;
    JPanel gamePanel;
    KeyInputHandler keyInputHandler;
    Hero hero;

    public Game(String title,int width,int height){
        super(title);
        keyInputHandler = new KeyInputHandler();
        mapLoader = new MapLoader();
        mapLoader.loadMap();
        currentScene = new StartScene(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        addKeyListener(keyInputHandler); 
    }

    public synchronized void startGameLoop(){
        if(th == null){
            th = new Thread(this);
            th.start();
        }
    }

    public synchronized void stopGameLoop(){
        if(th != null){
            th = null;
        }
    }

    public void run(){
        while(th != null){
            try{
                update();
                Thread.sleep(16);  //60fps
                repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        keyInputHandler.update(); //ここ以外でkeyInputHandlerのアップデートはしない

        if(currentScene != null){
                currentScene.update();
        }

    }

    public Scene changeScene(Scene nextScene){
        this.currentScene = nextScene;
        return currentScene;
    }

    public KeyInputHandler getkeyInputHandler(){
        return keyInputHandler;
    }
    public Scene getCurrentScene(){
        return this.currentScene;
    }

    public MapLoader getMapLoader(){
        return mapLoader;
    }
}
