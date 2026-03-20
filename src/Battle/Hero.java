package Battle;

public class Hero extends Character{

    private int level;
    private int exp;
    private final int nextLevelExp = 100;

    public Hero(){ 
    name  = "Hero";
    maxhp = 26;
    maxmp = 12;
    atk   =  8;
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


    public void normalAttack(int enemyNum){
    }

    public void maginalAttack(int enemyNum){
    }

    public void RunAway(){

    }

    public void action(Character target){
    }



    //以下、フィールド取得のためのgetメソッド
    public int getmaxhp(){
        return maxhp;
    }

    public int getmaxmp(){
        return maxmp;
    }

    public int gethp(){
        return hp;
    } 

    public int getmp(){
        return mp;
    }

    public int getatk(){
        return atk;
    }

    public int getdef(){
        return def;
    }


}