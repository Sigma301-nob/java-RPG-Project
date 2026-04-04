package Scene;

import java.awt.event.KeyEvent;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

import GameEngine.*;

public class EndScene extends Scene{

    String ending;

    TimeCount timer;
    
    public EndScene(Game game,int result){
        this.game = game;

        timer = new TimeCount(3);
        timer.timerSet(3);


        if(result == 0){
            ending = "GameClear";
        }else{
            ending = "GameOver";
        }
    }

    public void update(){
        timer.update();

        if(timer.checkTimeup()){
            game.changeScene(new StartScene(game));
        }


    }

    public void draw(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString(ending,600,450);

        //動作確認の都合上、ループ構造を作りたかったので追加した
        g.drawString(timer.getTimer() +"秒後にスタート画面に戻る(初期化はされていない)",510,850);
           
    }
}