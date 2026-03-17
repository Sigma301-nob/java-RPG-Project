package GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class KeyInputHandler extends KeyAdapter{

    private static boolean[] currentKeys = new boolean[256];
    private static boolean[] previousKeys = new boolean[256];

    public void update(){
        System.arraycopy(currentKeys, 0, previousKeys, 0, currentKeys.length);
    }

    public boolean isKeyPressed(int keyCode){   
        if(keyCode >= 0 && keyCode < 256){
            return currentKeys[keyCode];
        }
        return false;
    }

    public boolean isKeyDown(int keyCode){
        if(!previousKeys[keyCode] && currentKeys[keyCode]){
            return true;
        }
        return false;
    }



    public  void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();
        if(keycode >= 0 && keycode < 256){
            currentKeys[keycode] = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode >= 0 && keycode < 256){
            currentKeys[keycode] = false;
        }
    }
    
}