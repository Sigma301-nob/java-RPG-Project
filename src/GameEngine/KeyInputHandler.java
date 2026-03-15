package GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class KeyInputHandler extends KeyAdapter{

    private static boolean[] currentKeys = new boolean[256];
    private static boolean[] previousKeys = new boolean[256];

    public static void update(){
        previousKeys = currentKeys.clone();
    }

    public static boolean isKeyPressed(int keyCode){
        if(keyCode >= 0 && keyCode < currentKeys.length){
            return currentKeys[keyCode];
        }
        return false;
    }

    public static boolean isKeyDown(int keyCode){
        if(!previousKeys[keyCode] && currentKeys[keyCode]){
            return true;
        }
        return false;
    }



    public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();
        if(keycode < currentKeys.length){
            currentKeys[keycode] = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode < currentKeys.length){
            currentKeys[keycode] = false;
        }
    }
    
}