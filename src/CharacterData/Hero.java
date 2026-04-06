package CharacterData;


import static java.lang.Math.random;

public class Hero extends Character{

    private int exp;
    private final int nextLevelExp = 100;                 


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
            level++;
            maxhp += 10;
            maxmp += 10;
            atk   +=  5;
            def   +=  5;

            hp = maxhp;
            mp = maxmp;
    }

    public void fullHealHpAndMP(){
        hp = maxhp;
        mp = maxmp;
    }

    public boolean isLevelup(int enemyLevel){
        exp += 60;

        if(exp >= nextLevelExp){
            levelup();
            exp = exp - nextLevelExp;
            return true;
        }

        return false;
    }


}