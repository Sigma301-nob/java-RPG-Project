package Battle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

public class BattleView{

    private int playerMaxhp,playerhp;
    private int playerMaxmp,playermp;

    private int playeratk,playerdef;

    private int enemyMaxhp,enemyhp;
    private int enemyMaxmp,enemymp;

    private int selectAction;



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

        selectAction = model.getcommand();
        g.setColor(Color.BLACK);

        Font statusFont = new Font("SansSerif", Font.BOLD, 18);
        Font dialogFont = new Font("SansSerif", Font.PLAIN, 20);


        g.setFont(statusFont);
        //エネミーのステータス
        g.drawRect(50,50,280,60);
        g.drawString("HP:" + enemyhp + "/" + enemyMaxhp,70,70);
        g.drawString("MP:" + enemymp + "/" + enemyMaxmp,70,95);

        //HP・MPバーの塗りつぶしをここに挿入
        g.fillRect( 160, 55, (int)(160 *((double)enemyhp / enemyMaxhp)), 20);
        g.fillRect( 160, 80, (int)(160 *((double)enemymp / enemyMaxmp)), 20);

        g.setColor(Color.BLACK);
        g.drawRect(160,55,160,20);
        g.drawRect(160,80,160,20);


        //エネミー　イメージ
        g.drawOval(550,275,75,75);


        //プレイヤーのステータス
        g.drawRect(850,400,280,100);
        g.drawString("HP:" + playerhp + "/" + playerMaxhp,870,435);
        g.drawString("MP:" + playermp + "/" + playerMaxmp,870,460);

        //HP・MPバーの塗りつぶしをここに挿入
        g.fillRect( 960, 420, (int)(160 *((double)playerhp / playerMaxhp)), 20);
        g.fillRect( 960, 445, (int)(160 *((double)playermp / playerMaxmp)), 20);

        g.setColor(Color.BLACK);
        g.drawRect(960,420,160,20);
        g.drawRect(960,445,160,20);

        //本来は表示ない。デバッグ用にatk・defの値を表示
        g.drawString("atk:" + playeratk + "   ,def:" + playerdef,870,485);


        //アクションの選択肢

        g.setColor(Color.BLACK);
        g.drawRect(100,360,150,100);

        //敵のターン中は"select = -1"にすることで矢印を表示しなくする
        if(selectAction >= 0){
        g.drawString("➤", 120, 385 + (selectAction * 25));
        }

        g.drawString("こうげき" , 140, 385);
        g.drawString("まほう" , 140, 410);
        g.drawString("にげる"     , 140, 435);

        //ダイアログ(画面下部1/3)
        g.drawRect(50,530,1100,300);
        g.setFont(dialogFont);
    }
}
