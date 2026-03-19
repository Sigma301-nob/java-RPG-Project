package GameEngine;


public class Main {
    
  //新しいウィンドウの作成とゲームループの開始
  public static void main(String[] args) {
    Game game = new Game("テストウィンドウ",1200,900);
    game.add(new GamePanel(game));
    game.setVisible(true);
    game.startGameLoop();  
  }
}
