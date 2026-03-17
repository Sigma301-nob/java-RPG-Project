package GameEngine;

import java.awt.Graphics;
import javax.swing.JPanel;

import Scene.Scene;

public class GamePanel extends JPanel{

    Game game;
    
    private Scene currentScene;

    public GamePanel(Game game){
        this.game = game;
    }

    public void paintComponent(Graphics g){
        currentScene = game.getCurrentScene();

        if(currentScene != null){
            currentScene.draw(g);
        }
    } 


}