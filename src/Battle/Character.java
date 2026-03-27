package Battle;

public abstract class Character{

    protected String name;
    protected int level;
    protected int hp;
    protected int maxhp;
    protected int mp;
    protected int maxmp;
    protected int atk;
    protected int def;


     //HP/MPの消費・回復用のメソッド
    public void costMp(int cost){
        mp = Math.max( (mp - cost), 0);
    }

    public void healMp(int heal){
        mp = Math.min( (mp + heal), maxmp);
    }

    public void takeDamage(int damage){
        hp = Math.max( (hp - damage), 0);
    }

    public void healHp(int heal){
        hp = Math.min( (hp + heal), maxhp);
    }

    public boolean isAlive(){
        if(hp > 0) return true;
        else return false;
    }

    //以下、フィールド取得のためのgetメソッド
    public String getName(){
        return name;
    }
    public int getMaxHp(){
        return maxhp;
    }

    public int getMaxMp(){
        return maxmp;
    }

    public int getHp(){
        return hp;
    } 

    public int getMp(){
        return mp;
    }

    public int getAtk(){
        return atk;
    }

    public int getDef(){
        return def;
    }

    public int getLevel(){
        return level;
    }

}