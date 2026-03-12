import javax.swing.JPanel;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{

    private Thread th = null;

    Scene currentScene = new StartScene();
    JPanel gamePanel;
    KeyInputHandler keyInputHandler;
    Hero Hero;

    public Game(String title,int width,int height){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public synchronized void startGameLoop(){
        if(th == null){
            th = new Thread(this);
            th.start();
        }
    }

    public synchronized void stopGameLoop(){
        if(th != null){
            th = null;
        }
    }

    public void run(){
        while(th != null){
            try{
                Thread.sleep(25);
                repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
          if(currentScene != null){
                currentScene.update();
        }

    }

    public void changeScene(Scene nextScene){
    }

    public Scene getCurrentScene(){
        return currentScene;
    }

}
