public abstract class Character{

    protected String name;
    protected int hp;
    protected int maxhp;
    protected int mp;
    protected int maxmp;
    protected int atk;
    protected int def;


    public void takeDamage(int damage){
    }

    public void isAlive(){
    }

    public abstract void action(Character target);

}