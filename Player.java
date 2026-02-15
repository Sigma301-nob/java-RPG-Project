public class Player {

    private String name;
    private int Lv;
    private int EXP;
    private int SP;
    private int MaxHP;
    private int HP;
    private int MaxMP;
    private int MP;
    private int ATK;
    private int DEF;

  public Player(String playername,int playerMaxHP,int playerMaxMP,int playerATK,int playerDEF){
    name  = playername;
    EXP   = 0;
    SP    = 0;
    MaxHP = playerMaxHP;
    HP    = MaxHP;
    MaxMP = playerMaxMP;
    MP    = MaxMP;
    ATK   = playerATK;
    DEF   = playerDEF;
  }
    
  public String getName(){
    return this.name;
  } 

  public int getHP(){
    return this.HP;
  }

  public int getMP(){
    return this.MP;
  }

  public int getATK(){
    return this.ATK;
  }

  public int getDEF(){
    return this.DEF;
  }
}
