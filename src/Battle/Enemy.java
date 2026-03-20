package Battle;

public class Enemy extends Character{

    private int level;

    public Enemy(int level){
        this.level = level;
        name  = "Testmob";
        maxhp = 10 * level;
        maxmp =  6 * level;
        atk   =  3 * level;
        def   =  5 * level;

        hp = maxhp;
        mp = maxmp;
    }

    public void normalAttack(int enemyNum){
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