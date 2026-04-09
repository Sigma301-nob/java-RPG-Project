package Scene;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.security.auth.kerberos.KerberosTicket;

import GameEngine.*;
import Map.*;
import MapStructure.*;

public class MapScene extends Scene{
     
    private MapView view;
    private MapModel model;

    //インスタンス化するときにLoaderの持つmodelのパスをもらう
   public MapScene(Game game){
        this.game = game;
        model = game.getMapLoader().getCurrentMapModel();
        view = new MapView(game.getWindowSizeWidth(),game.getWindowSizeHeight());

        model.setEncountToFalse();
    }
//modelの更新と場面転換の有無の判断
    public void update(){
        model.update(game.getKeyInputHandler());

        if(model.isEncountEnemy()){
            game.changeScene(new BattleScene(game));
        }else if(model.isEncountBoss()){
            game.changeScene(new BattleScene(game,0));
        }
    }


    public void draw(Graphics g){
        super.paintComponent(g);

        view.draw(g,model);
       
    }
}