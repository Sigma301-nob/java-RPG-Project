package Scene;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.security.auth.kerberos.KerberosTicket;


import GameEngine.*;
import Battle.*;

public class BattleScene extends Scene{

    private BattleView  view;
    private BattleModel model;

    public BattleScene(Game game){
        this.game = game;
        game.getBattleLoader().createBattle(game.gethero()); 
        model = game.getBattleLoader().getbBattleModel();
        view  = new BattleView();
    }

    public void update(){
        model.update(game.getkeyInputHandler());

        if(model.isWin()){
            game.changeScene(new MapScene(game));
        }else if(model.isbossDefeat()){
            game.changeScene(new EndScene(game,0));
        }else if(model.isLose()){
            game.changeScene(new EndScene(game,1));
        }
    }


    public void draw(Graphics g){
        super.paintComponent(g);

        view.draw(g,model);
    }
}
