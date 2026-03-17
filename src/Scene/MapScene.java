package Scene;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.security.auth.kerberos.KerberosTicket;

import GameEngine.*;
import Map.*;

public class MapScene extends Scene{
     
    private MapView view;
    private MapModel model;

    //インスタンス化するときにLoaderの持つmodelのパスをもらう
   public MapScene(Game game){
        this.game = game;
        model = game.getMapLoader().getcurrentMapModel();
        view = new MapView();

        model.getTimer().timerSet(3);
        model.setEncountToFalse();
    }
//modelの更新と場面転換の有無の判断
    public void update(){
        model.update(game.getkeyInputHandler());

        if(model.isEncount()){

            game.changeScene(new BattleScene(game));
        }
    }


    public void draw(Graphics g){
        super.paintComponent(g);

        view.draw(g,model);
       
    }
}