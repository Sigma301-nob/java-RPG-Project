import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements Runnable{

    private Thread th = null;

    Scene currentScene = new StartScene();//場面の初期設定
    JPanel gamePanel;
    KeyInputHandler keyInputHandler;
    Hero Hero;

    public Game(String title,int width,int height){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        addKeyListener(new KeyInputHandler()); 
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
                update();
                Thread.sleep(25);
                repaint();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){

        if(KeyInputHandler.isKeyPressed(KeyEvent.VK_SPACE)){
            currentScene = new MapScene();
        }

        if(currentScene != null){
                currentScene.update();
        }

    }

    public Scene changeScene(Scene nextScene){
        this.currentScene = nextScene;
        return currentScene;
    }

    public Scene getCurrentScene(){
        return this.currentScene;
    }

}
