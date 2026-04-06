package Scene;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;

import GameEngine.*;
import Story.*;

public class StartScene extends Scene{

    private boolean      story;
    private StartModel   startModel;
    private Story01Model storyModel;
    private StartView    startView ;
    private Story01View  storyView ;


    public StartScene(Game game){
        this.game = game;
        startModel = new StartModel();
        storyModel = new Story01Model();
        startView  = new StartView();
        storyView  = new Story01View();
        story = false;
    }

    public void update(){
        if(!story){
            startModel.update(game.getKeyInputHandler());
            if(startModel.isStartNewGame()){
               story = true;
            }else if(startModel.isEndGame()){
                System.exit(0);
            }
        }else{
            storyModel.update(game.getKeyInputHandler());
            if(storyModel.isShiftToMap()){
                game.changeScene(new MapScene(game));
            }
        }
    }

    public void draw(Graphics g){
        super.paintComponent(g);
        if(!story){
            startView.draw(g,startModel);
        }else{
            storyView.draw(g,storyModel);
        }
    }
}