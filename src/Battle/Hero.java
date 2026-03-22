package Battle;


import static java.lang.Math.random;

public class Hero extends Character{

    private int level;
    private int exp;
    private final int nextLevelExp = 100;                 

    private double randomNum;               //"逃げる"の成功を判断するときに利用

    public Hero(){ 
    name  = "Hero";
    maxhp = 26;
    maxmp = 12;
    atk   = 15;
    def   = 11;

    hp = maxhp;
    mp = maxmp;

    level = 1;
    exp = 0;
    }


    public void levelup(){
        if(exp == nextLevelExp){
            level++;
            maxhp += 10;
            maxhp += 10;
            atk   +=  5;
            def   +=  5;

            hp = maxhp;
            mp = maxmp;
        }
    }

    public void fullHealHpAndMP(){
        hp = maxhp;
        mp = maxmp;
    }


    //attackメソッドは与ダメージを返す
    public int normalAttack(){
        return atk;
    }

    public int maginalAttack(){
        mp = mp - 2;
        return atk + 2;
    }

    public boolean runAway(){
        randomNum = Math.random();
        if(randomNum > 0.33){
            return true;
        }
        return false;

    }

    public void takeDamage(int damage){
        hp = Math.max( (hp - damage), 0);
    }

    public boolean isAlive(){
        if(hp == 0) return true;
        else return false;
    }


    //ダメージ計算はアタッカーのクラスでやるほうがいいと思うので、移動した。
    //理由：攻撃の種類によって計算方法を変えるとなると、modelが大きくなりすぎたり、キャラによって持っている攻撃手段が違うから。

    //ただ、actionとは別でダイアログのためにmodelでもダメージ計算をしているのが気持ち悪い。
    //Heroのdamageのスコープをクラスに広げてgetDamageで渡すでもいいが、直前の攻撃時のダメージに次の攻撃ダメを上書きしていくという処理になる。
    //それはそれで、気持ち悪い。damageは各actionで完全に独立しているので、actionのたびに新たに定義するほうが自然。
    
    //いろいろ書いたが、とりあえず保留。
    public int calculateDamage(int attackerAtk,Character target){
        
        int targetDef = target.getDef();

       return Math.max(attackerAtk - targetDef, 0);
    }

    //処理結果を返す。0;戦闘続行 1;HP0による戦闘終了　2;逃走成功
    public int action (int command,Character target) {
        int damage;
        switch(command){
            case 0:
                damage = calculateDamage(normalAttack(),target);
                target.takeDamage(damage);
                if(target.isAlive()) return 1;
                else return 0;

            case 1:
                damage = calculateDamage(maginalAttack(),target);
                target.takeDamage(damage);
                if(target.isAlive()) return 1;
                else return 0;

            case 2:
                if(runAway()) return 2;
                else return 0;

            default:
                return 1;
        }
    }



}