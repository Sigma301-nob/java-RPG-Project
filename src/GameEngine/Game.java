package GameEngine;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;

import Map.*;
import Battle.*;
public class Game extends JFrame implements Runnable{

    private Thread th = null;

    Scene currentScene;
    JPanel gamePanel;
    KeyInputHandler keyInputHandler;
    MapModel mapModel;
    Hero hero;

    public Game(String title,int width,int height){
        super(title);
        currentScene = new StartScene(this);
        mapModel = new MapModel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        addKeyListener(new KeyInputHandler()); 
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
                Thread.sleep(16);
                repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(currentScene != null){
                currentScene.update();
        }

    }

    public Scene changeScene(Scene nextScene){
        this.currentScene = nextScene;
        return currentScene;
    }

    public Scene getCurrentScene(){
        return this.currentScene;
    }

    public MapModel getmapModel(){
        return this.mapModel;
    }

}
