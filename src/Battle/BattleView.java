package Battle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public class BattleView{

    private int playerMaxhp,playerhp;
    private int playerMaxmp,playermp;

    private int playeratk,playerdef;

    private int enemyMaxhp,enemyhp;
    private int enemyMaxmp,enemymp;


    public void draw(Graphics g,BattleModel model){
        //データの取得
        playerMaxhp = model.getbattlebata().gethero().getmaxhp();
        playerMaxmp = model.getbattlebata().gethero().getmaxmp();
        playerhp    = model.getbattlebata().gethero().gethp();
        playermp    = model.getbattlebata().gethero().getmp();
        playeratk   = model.getbattlebata().gethero().getatk();
        playerdef   = model.getbattlebata().gethero().getdef();

        enemyMaxhp  = model.getbattlebata().getenemy().getmaxhp();
        enemyMaxmp  = model.getbattlebata().getenemy().getmaxmp();
        enemyhp     = model.getbattlebata().getenemy().gethp();
        enemymp     = model.getbattlebata().getenemy().getmp();
        g.setColor(Color.BLACK);
       
        //エネミーのステータス
        g.drawRect(50,50,300,100);
        g.drawString("HP:" + enemyhp + "/" + enemyMaxhp,70,70);
        g.drawString("MP:" + enemymp + "/" + enemyMaxmp,70,110);

        //HP・MPバーの塗りつぶしをここに挿入


        g.setColor(Color.BLACK);
        g.drawRect(100,70,80,20);
        g.drawRect(100,70,80,20);

        //エネミー　イメージ
        g.drawOval(600,275,50,50);

        //プレイヤーのステータス
        g.drawRect(850,400,300,100);
        g.drawString("HP:" + playerhp + "/" + playerMaxhp,870,420);
        g.drawString("MP:" + playermp + "/" + playerMaxmp,870,460);

        //HP・MPバーの塗りつぶしをここに挿入


        g.setColor(Color.BLACK);
        g.drawRect(900,420,80,20);
        g.drawRect(900,460,80,20);

        //本来は表示ない。デバッグ用にatk・defの値を表示
        g.drawString("atk:" + playeratk + "   ,def:" + playerdef,870,485);

        //ダイアログ(画面下部1/3)
        g.drawRect(50,570,1100,300);
    }
}
