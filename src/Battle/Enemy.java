package Battle;

import static java.lang.Math.random;

public class Enemy extends Character{

    private int level;

    private double randomNum;

    public Enemy(int level){
        this.level = level;
        name  = "Testmob";
        maxhp = 10 * level;
        maxmp =  6 * level;
        atk   =  5 * level;
        def   =  2 * level;

        hp = maxhp;
        mp = maxmp;
    }

    public int normalAttack(){
        return atk;
    }

    public boolean RunAway(){
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

     public int calculateDamage(int attackerAtk,Character target){
        
        int targetDef   = target.getDef();

       return Math.max(attackerAtk - targetDef, 0);
    }

    
    //heroと同様。
    public int action(int command,Character target){
        int damage;

        damage = calculateDamage(normalAttack(),target);
        target.takeDamage(damage);

        if (target.isAlive()) return 1;
        else                  return 0;

    }


}