package Scene;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;

import GameEngine.*;
import Story.*;

public class StartScene extends Scene{

    private Story01    story;
    private StartModel model;
    private StartView  view ;


    private boolean    storytell;


    public StartScene(Game game){
        this.game = game;
        story = new Story01();
        model = new StartModel();
        view  = new StartView();

        storytell = false;
    }

    public void update(){
        model.update(game.getKeyInputHandler());
        if(story.isShiftToMap()){
            game.changeScene(new MapScene(game));
        }else if(model.isStartNewGame()){
           storytell = true;
        }else if(model.isEndGame()){
            System.exit(0);
        }
    }

    public void draw(Graphics g){
        super.paintComponent(g);

        if(!storytell){
            view.draw(g,model);
        }else{
            story.draw(g,game.getKeyInputHandler());
        }
    }
}