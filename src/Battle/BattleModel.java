package Battle;

import java.awt.event.KeyEvent;

import GameEngine.KeyInputHandler;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;


public class BattleModel{

    private int turnNumber;
    private boolean isPlayerTurn;
    private BattleData battleData;

    private boolean playerWin;
    private boolean playerLose;
    private boolean runAway;
    private boolean bossDefeat;

    private boolean ableToPress;        //動いて一定時間はfalseになる
    private boolean interval;           //ターン交代時の待機。
    private long currentTime,finalPressedTime,endTurnTime;
    private long delaypressSpeed = 200; //o.2秒に一回移動可能
    private long TurnInterval = 1000; //1秒エネミーのターンを待つ


    private int command;                 //現在選んでいる行動の選択肢
    private int result;                  //アクション後のバトル状況(0;続行　1;HP0による戦闘終了 2;逃亡成功)

    private String [] dialog;              //ダイアログの文章。そんなに多く表示しないので可変長リストにはしてないする。


    public BattleModel(BattleData battleData){
        turnNumber      = 0;
        isPlayerTurn    = true;
        this.battleData = battleData;
        this.dialog = new String[5];

        ableToPress     = true;
        interval        = false;
        command         = 0;

        //場面転換の都合上追加したが、残すかは戦闘エンジンを作る人に任せる
        playerWin       = false;
        playerLose      = false;
        runAway         = false;
        bossDefeat      = false;
    }

    public void update(KeyInputHandler key){
        if(!interval){
            if(isPlayerTurn){           
                selectAction(key);
                checkAbleToPressed();
            }else{
                command = -1;
                processAction(battleData.getEnemy(), battleData.getHero());
                turnNumber++;
            }
        }
        checkEndInterval();
    }


    public void processAction(Character attacker,Character target){
        result       = attacker.action(command, target);
        dialog[0] = (attacker.getName() + "は" + target.getName() + "に攻撃した");  
        interval     = true;     
        endTurnTime  = System.currentTimeMillis();

        checkBattleEnd();   
    }

    public void checkBattleEnd(){

        //戦闘続行
        if(result == 0){
             isPlayerTurn = !isPlayerTurn;


        //プレイヤーの勝利
        }else if(isPlayerTurn && result == 1){
            dialog[1] = battleData.getHero().getName() + "は魔物を倒した";
            playerWin  = true;


        //プレイヤーの敗北
        }else if(!isPlayerTurn && result == 1){
            dialog[1] = battleData.getHero().getName() +"は全滅した";
            playerLose = true;

        //逃げ出した
        }else if(result == 2){
            if(isPlayerTurn){
                dialog[1] = battleData.getHero().getName() +  "は逃げ出した";
            }else {
                dialog[1] = battleData.getEnemy().getName() + "は逃げ出した";
            }
            runAway = true;
        }
    }

    //本来は行動の選択をさせるメソッド。
    public void selectAction(KeyInputHandler key){
        if(!interval){
            if(ableToPress && isPlayerTurn){
                if     (key.isKeyPressed(KeyEvent.VK_S) && command < 2) {
                        command++;
                        pressed();
                }
                else if(key.isKeyPressed(KeyEvent.VK_W) && command > 0) {
                        command--;
                        pressed();
                }
                //動作確認用救済措置
                else if(key.isKeyPressed(KeyEvent.VK_H)){
                        battleData.getHero().fullHealHpAndMP();
                }
            
                if(key.isKeyPressed(KeyEvent.VK_E)){
                    processAction(battleData.getHero(),battleData.getEnemy());
                
                }
            }
        }
    }
        

     public void pressed(){
        ableToPress = false;
        finalPressedTime = System.currentTimeMillis();
    }

    public void checkAbleToPressed(){
        currentTime = System.currentTimeMillis();
        if(currentTime - finalPressedTime > delaypressSpeed){
            ableToPress = true;
        }
    }

    public void checkEndInterval(){
        if (!interval) return;

        currentTime = System.currentTimeMillis();
        if(currentTime - endTurnTime > TurnInterval){
            interval = false;
            for(int i = 0 ; i > 5; i++){
                dialog[i] = null;
            }
            if(isPlayerTurn) command = 0;
        }
    }

    public int getCommand(){
        return command;
    }

    public  boolean isWin(){
        if(!interval){
            return playerWin;
        }
        return false;
    }

    public boolean isLose(){
        if(!interval){
            return playerLose;
        }
        return false;
    }

    public boolean isrun(){
        if(!interval){
            return runAway;
        }
        return false;
    }
    public boolean isbossDefeat(){
        if(!interval){
            return bossDefeat;
        }
        return false;
    }

    public BattleData getBattlebata(){
        return battleData;
    }

    public int getTurnNumber(){
        return turnNumber;
    }

    public String [] getDialog(){
        return dialog;
    }
    
}
