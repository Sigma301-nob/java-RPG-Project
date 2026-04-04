package Battle;

import java.awt.event.KeyEvent;

import GameEngine.KeyInputHandler;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;


public class BattleModel{

    private BattleOperation operation;

    private int turnNumber;
    private boolean isPlayerTurn;
    private BattleData battleData;

    private boolean playerWin;
    private boolean playerLose;
    private boolean escapeSuccessful;
    private boolean bossDefeat;
    private boolean changeToMap;

    private boolean ableToPress;        //動いて一定時間はfalseになる
    private boolean interval;           //ターン交代時の待機
    private boolean levelup;            //レベルアップしたかどうか示す
    private long currentTime,finalPressedTime,endTurnTime;
    private long delaypressSpeed = 200; //o.2秒に一回移動可能
    private long TurnInterval = 1000; //1秒エネミーのターンを待つ


    private int command;                 //現在選んでいる行動の選択肢
    private String [] dialog;

    public BattleModel(BattleData battleData){
        operation = new BattleOperation();

        turnNumber       = 0;
        isPlayerTurn     = true;
        this.battleData  = battleData;

        ableToPress      = true;
        interval         = false;
        levelup          = false;
        command          = 0;
        dialog           = new String[5];

        //場面転換の都合上追加したが、残すかは戦闘エンジンを作る人に任せる
        playerWin        = false;
        playerLose       = false;
        escapeSuccessful = false;
        bossDefeat       = false;
        changeToMap      = false;
    }

    public void update(KeyInputHandler key){
        if(!interval){
            if(!playerWin){
                if(isPlayerTurn){           
                    selectAction(key);
                    checkAbleToPressed();
                }else{
                    command = -1;
                    processAction(0,battleData.getEnemy(), battleData.getHero());
                    turnNumber++;
                }
            }else{
                if(!levelup){
                    levelup = battleData.getHero().isLevelup(battleData.getEnemy().getLevel());
                }
                viewStatus(key);
            }
        }
        checkEndInterval();
    }

//逃げるの表示場所は固定。commandは描画の時に使う数字であり、攻撃の種類を識別するcommandNumとは異なる。
//現在は、攻撃種類が増えたときどのように表示するか決めていないので疑似的にcommand = commandNumとしている
    public void processAction(int commandNum, Character attacker,Character target){
        if(commandNum == -1){
            escapeSuccessful = operation.runAway(attacker);
        }else{
            dialog[0] = operation.damageOperation(commandNum, attacker, target);
        }
        checkBattleEnd(commandNum,attacker,target);
        interval     = true;     
        endTurnTime  = System.currentTimeMillis();   
    }

    public void checkBattleEnd(int commandNum, Character attacker, Character target){

        if(!escapeSuccessful){
            //戦闘続行
            if(target.isAlive()){
                if(commandNum == -1){
                    dialog[0] = attacker.getName() +"は逃げようとしたが回り込まれた";
                }

                isPlayerTurn = !isPlayerTurn;

            //プレイヤーの勝利
            }else if(isPlayerTurn){
                dialog[1] = battleData.getHero().getName() + "は魔物を倒した";
                playerWin  = true;

            //プレイヤーの敗北
            }else if(!isPlayerTurn){
                dialog[1] = battleData.getHero().getName() +"は全滅した";
                playerLose = true;
            }

        }else{
                dialog[0] = attacker.getName() + "逃げ出した";
        }

    }

    

    //本来は行動の選択をさせるメソッド。
    public void selectAction(KeyInputHandler key){
        int commandNum;
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
                //動作確認用回復措置
                else if(key.isKeyPressed(KeyEvent.VK_H)){
                        battleData.getHero().fullHealHpAndMP();
                }
            
                if(key.isKeyPressed(KeyEvent.VK_E)){
                    if(command == 2){
                        commandNum = -1;
                    }else{
                        commandNum = command;
                    }
                    processAction(commandNum,battleData.getHero(),battleData.getEnemy());
                
                }
            }
        }
    }

    public void viewStatus(KeyInputHandler key){

        if(levelup){
            if(key.isKeyPressed(KeyEvent.VK_R)){
                    changeToMap = true;
            }
        }else{
                    changeToMap = true;
        }
    }

        
//キーを押した瞬間の時間を記録
     public void pressed(){
        ableToPress = false;
        finalPressedTime = System.currentTimeMillis();
    }

//ある時点から十分に時間が経過したか確かめる
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


//以下、is○○やget○○のメソッドのみ記述
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

    public boolean isLevelup(){
        if(!interval){
            return levelup;
        }
        return false;
    }

    public boolean isRun(){
        if(!interval){
            return escapeSuccessful;
        }
        return false;
    }

    public boolean isChangeToMap(){
        if(!interval){
            return changeToMap;
        }
        return false;
    }

    public boolean isBossDefeat(){
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
