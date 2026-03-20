package Battle;

import java.awt.event.KeyEvent;

import GameEngine.KeyInputHandler;


public class BattleModel{

    private int turnNumber;
    private boolean isPlayerTurn;
    private BattleData battleData;

    private boolean playerWin;
    private boolean playerLose;
    private boolean bossDefeat;

    public BattleModel(BattleData battleData){
        turnNumber = 0;
        isPlayerTurn =true;
        this.battleData = battleData;

        //場面転換の都合上追加したが、残すかは戦闘エンジンを作る人に任せる
        playerWin  = false;
        playerLose = false;
        bossDefeat = false;
        

    }

    public void update(KeyInputHandler key){
        selectAction(key);

    }

    public void calculateDamage(Character attacker,Character target){
    }

    public void processAttack(Character attacker,Character target){
    }

    //本来は行動の選択をさせるメソッド。
    //現在は、戦闘の結果を任意に選択できるようにしている。
    public void selectAction(KeyInputHandler key){
        if      (key.isKeyPressed(KeyEvent.VK_1)){
            playerWin  = true;
        }else if(key.isKeyPressed(KeyEvent.VK_2)){
            bossDefeat = true;
        }else if(key.isKeyPressed(KeyEvent.VK_3)){
            playerLose = true;
        }
    }

    public  boolean isWin(){
        return playerWin;
    }

    public boolean isLose(){
        return playerLose;
    }

    public boolean isbossDefeat(){
        return bossDefeat;
    }

    public BattleData getbattlebata(){
        return battleData;
    }
}
