package Battle;

public abstract class Character{

    protected String name;
    protected int hp;
    protected int maxhp;
    protected int mp;
    protected int maxmp;
    protected int atk;
    protected int def;


    public abstract void takeDamage(int damage);

    public abstract boolean isAlive();

    public abstract int calculateDamage(int attackeratk,Character target);
    
    public abstract int action(int command, Character target);

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

}