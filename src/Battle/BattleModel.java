package Battle;

import java.awt.event.KeyEvent;

import GameEngine.KeyInputHandler;


public class BattleModel{

    private int turnNumber;
    private boolean isPlayerTurn;
    private BattleData battleData;

    private boolean playerWin;
    private boolean playerLose;
    private boolean runAway;
    private boolean bossDefeat;

    private boolean ableToPress;        //動いて一定時間はfalseになる
    private boolean wait;
    private long currentTime,finalPressedTime,endPlayerTurnTime;
    private long delaypressSpeed = 200; //o.2秒に一回移動可能
    private long waitEnemyTurn = 1000; //1秒エネミーのターンを待つ


    private int command;
    private int result;                 //現在選んでいる行動の選択肢


    public BattleModel(BattleData battleData){
        turnNumber = 0;
        isPlayerTurn =true;
        this.battleData = battleData;

        ableToPress = true;
        wait = false;
        command = 0;

        //場面転換の都合上追加したが、残すかは戦闘エンジンを作る人に任せる
        playerWin  = false;
        playerLose = false;
        runAway    = false;
        bossDefeat = false;
        

    }

    //ここが問題。myturnになってから1秒待機を入れているため、その間攻撃し放題！
    public void update(KeyInputHandler key){
        if(!wait){
            if(isPlayerTurn){           
                selectAction(key);
                checkAbleToPressed();
            }else{
                command = -1;
                processAction(battleData.getenemy(), battleData.gethero());
            }
        }
         checkStartPlayerTurn();
    }


    public void processAction(Character attacker,Character target){
        result = attacker.action(command, target);
        checkBattleEnd();   
    }

    public void checkBattleEnd(){
        if(result == 0){
             isPlayerTurn = !isPlayerTurn;
             endPlayerTurnTime = System.currentTimeMillis();
        }else if(isPlayerTurn && result == 1){
            playerWin  = true;
        }else if(!isPlayerTurn && result == 1){
            playerLose = true;
        }else if(result == 2){
            runAway = true;
        }
    }

    //本来は行動の選択をさせるメソッド。
    public void selectAction(KeyInputHandler key){
        if(!wait){
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
                else if(key.isKeyPressed(KeyEvent.VK_SPACE)){
                        battleData.gethero().fullHealHpAndMP();
                }
                if(key.isKeyPressed(KeyEvent.VK_E)){
                    processAction(battleData.gethero(),battleData.getenemy());
                    wait = true;
                    pressed();
                
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

    public void checkStartPlayerTurn(){
        if (!wait) return;

        currentTime = System.currentTimeMillis();
        if(currentTime - endPlayerTurnTime > waitEnemyTurn){
            wait = false;
            if(isPlayerTurn) command = 0;
        }
    }

    public int getcommand(){
        return command;
    }

    public  boolean isWin(){
        return playerWin;
    }

    public boolean isLose(){
        return playerLose;
    }

    public boolean isrun(){
        return runAway;
    }
    public boolean isbossDefeat(){
        return bossDefeat;
    }

    public BattleData getbattlebata(){
        return battleData;
    }

    public boolean getisplayerturn(){
        return wait;
    }
    
}
