package Battle;

import static java.lang.Math.random;

//  コマンド、アタッカー、ターゲットを受け取って、ダメージ計算を行って反映、さらにダイアログを作成して返す。
//  コマンドの選択肢を番号で管理して、受け取ったコマンド(int型)応じてダメージ計算方法や効果を選択する

//  とりあえず、　0;こうげき　1;まほう　-1;逃げる
//※逃げるだけ特殊コマンドなのでマイナスの値で扱っている。
public class BattleOperation{



    public String damageOperation(int commandNum,Character attacker,Character target){
        int       damage;
        String    dialog;

        switch (commandNum){
            case 0:
                damage = normalAttack(attacker,target);
                dialog= attacker.getName() + "は" + target.getName() + "に" + damage + "ダメージを与えた";

            return dialog;

            case 1:
                damage = maginalAttack(attacker,target);
                dialog = attacker.getName() + "は" + target.getName() + "に" + damage + "ダメージを与えた";

            return dialog;

            default:
            return null;
        }

    }

    public boolean runAway(Character it){
        double  randomNum = Math.random();

        if(randomNum > 1){
            return true;
        }else{
            return false;
        }

    }





    //以下、各攻撃手段に応じた処理内容を記述したメソッドを書く

    //通常攻撃
    public int normalAttack(Character attacker, Character target){
        int damage;

        damage = Math.max( attacker.getAtk() - target.getDef(), 0);
        target.takeDamage(damage);
        
        return damage;
    }
    

    //魔法攻撃
    public int maginalAttack(Character attacker, Character target){
        int damage;
        int cost;

        cost = 2;
        damage = Math.max( (attacker.getAtk() + cost*2) - target.getDef(), 0);

        attacker.costMp(cost);
        target.takeDamage(damage);

        return damage;

    }



}