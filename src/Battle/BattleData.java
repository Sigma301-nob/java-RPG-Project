package Battle;

import java.util.List;

public class BattleData{

    private Hero hero;
    private Enemy enemy;

    public BattleData(Hero hero,Enemy enemy){
        this.hero  = hero;
        this.enemy = enemy;
    }

    public Hero gethero(){
        return hero;
    }

    public Enemy getenemy(){
        return enemy;
    }
}