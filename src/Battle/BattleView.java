package Battle;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

public class BattleView{

    

    private String playerName;
    private int playerLevel;
    private int playerMaxhp,playerhp;
    private int playerMaxmp,playermp;

    private int playerAtk,playerDef;

    private int playerPreMaxhp,playerPreMaxmp;
    private int playerPreAtk,playerPreDef;

    private int enemyMaxhp,enemyhp;
    private int enemyMaxmp,enemymp;

    private int turnNumber;

    private int selectAction;

    private boolean statusUpdate;

    private String [] dialog;



    public void draw(Graphics g,BattleModel model){
        //データの取得
        playerName   = model.getBattlebata().getHero().getName();
        playerLevel  = model.getBattlebata().getHero().getLevel();
        playerMaxhp  = model.getBattlebata().getHero().getMaxHp();
        playerMaxmp  = model.getBattlebata().getHero().getMaxMp();
        playerhp     = model.getBattlebata().getHero().getHp();
        playermp     = model.getBattlebata().getHero().getMp();
        playerAtk    = model.getBattlebata().getHero().getAtk();
        playerDef    = model.getBattlebata().getHero().getDef();

        enemyMaxhp   = model.getBattlebata().getEnemy().getMaxHp();
        enemyMaxmp   = model.getBattlebata().getEnemy().getMaxMp();
        enemyhp      = model.getBattlebata().getEnemy().getHp();
        enemymp      = model.getBattlebata().getEnemy().getMp();

        turnNumber   = model.getTurnNumber();

        selectAction = model.getCommand();
        statusUpdate = model.isLevelup();
        dialog       = model.getDialog();

        int dialogLine = 0;
        g.setColor(Color.BLACK);

        Font statusFont = new Font("SansSerif", Font.BOLD, 18);
        Font dialogFont = new Font("SansSerif", Font.PLAIN, 20);
        Font levelup    = new Font("SansSerif", Font.PLAIN, 32);

        if(!statusUpdate){
            playerPreMaxhp = playerMaxhp;
            playerPreMaxmp = playerMaxmp;
            playerPreAtk   = playerAtk;
            playerPreDef   = playerDef;


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
            g.drawRect(850,380,280,120);
            g.drawString( "Lv" + playerLevel + "  " + playerName,870, 410);
            g.drawString("HP:" + playerhp + "/" + playerMaxhp,870,435);
            g.drawString("MP:" + playermp + "/" + playerMaxmp,870,460);

            //HP・MPバーの塗りつぶしをここに挿入
            g.fillRect( 960, 420, (int)(160 *((double)playerhp / playerMaxhp)), 20);
            g.fillRect( 960, 445, (int)(160 *((double)playermp / playerMaxmp)), 20);

            g.setColor(Color.BLACK);
            g.drawRect(960,420,160,20);
            g.drawRect(960,445,160,20);

            //本来は表示ない。デバッグ用にatk・defの値を表示
            g.drawString("atk:" + playerAtk + "   ,def:" + playerDef,870,485);


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

            //ターン数の表示
            g.drawString(turnNumber + "ターン目", 1000,70);

            //ダイアログ(画面下部1/3)
            g.drawRect(50,530,1100,300);
            g.setFont(dialogFont);

            while(dialog[dialogLine] != null){
                g.drawString(dialog[dialogLine], 100,600 + dialogLine * 40);
                dialogLine++;
            }
        }

        //レベルアップ時のステータス表示
        if(statusUpdate){
            g.setFont(levelup);
            g.drawRect(400,150,280,350);
            g.drawString("LEVEL UP!",450,200);
            g.drawString(playerName,500, 260);
            g.drawString("Lv    "  + (playerLevel - 1)   + "    →    " + playerLevel   , 430, 320);

            g.setFont(dialogFont);
            g.drawString("HP     "  + playerPreMaxhp      + "    →    " + playerMaxhp   , 450, 370);
            g.drawString("MP    "  + playerPreMaxmp      + "    →    " + playerMaxmp   , 450, 405);
            g.drawString("ATK   "  + playerPreAtk        + "    →    " + playerAtk     , 450, 440);
            g.drawString("DEF   "  + playerPreDef        + "    →    " + playerDef     , 450, 475);

        }
    }
}
