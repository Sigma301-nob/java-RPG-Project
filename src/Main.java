public class Main {
    
  public static void main(String[] args) {
    Game game = new Game("テストウィンドウ",400,300);
    game.add(new GamePanel(game));
    game.setVisible(true);
    game.startGameLoop();    
  }
}
