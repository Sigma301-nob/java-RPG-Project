package Battle;

public class BattleLoader{ 

    private Hero hero;
    private Enemy enemy;
    private BattleData battleData;
    private BattleModel battleModel;

    public void createBattle(Hero hero){

        this.hero = hero;
        enemy = new Enemy(3);

        battleData = new BattleData(hero,enemy);
        battleModel = new BattleModel(battleData);

    }

    public BattleData getBattleData(){
        return battleData;
    }

    public BattleModel getBattleModel(){
        return battleModel;
    }
}