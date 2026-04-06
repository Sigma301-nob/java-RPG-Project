package CharacterData;


public class Enemy extends Character{



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

   

}