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