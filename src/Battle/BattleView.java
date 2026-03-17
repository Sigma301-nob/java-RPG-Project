package Battle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public class BattleView{

    public void draw(Graphics g,BattleModel model){
        g.setColor(Color.BLACK);
        g.drawString("プレイヤーの勝利⇒マップ: 1",80,80);
        g.drawString("ボスの攻略⇒ゲームクリア: 2",80,105);
        g.drawString("プレイヤーの敗北⇒ゲームオーバー : 3\n",80,130);
    }
}
