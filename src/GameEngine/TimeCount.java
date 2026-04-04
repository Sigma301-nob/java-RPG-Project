package GameEngine;

//タイマー。ゲームエンジンを作るときに何かと便利なので作った。実際使うかは知らん
public class TimeCount{

    private int timer;
    private int fpsCnt;

    public TimeCount(int timer){
        this.timer = timer;
        fpsCnt = 0;
    }

    public void update(){
        countDown();
    }

    public void countDown(){
        if(fpsCnt*16 >= 1000){
            if(timer > 0){
            timer--;
            }
            fpsCnt = 0;
        }else{
            fpsCnt++;
        }
    }

    public int getTimer(){
        return timer;
    }

    public boolean checkTimeup(){
        if(timer == 0){
            return true;
        }
        return false;
    }

    public void timerSet(int s){
        timer = s;
    }

}