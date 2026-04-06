package Map;

import java.awt.Graphics;
import java.awt.Image;
import static java.lang.Math.min;

import GameEngine.Game;
import MapStructure.*;

import java.awt.Color;


public class MapView{

    private Image tileSet;
    private int tileSize;
    private int startW,startH;
    private int windowSizeWidth,windowSizeHeight;
    private int mapTileWidth,mapTileHeight;

    private int drawW,drawH;

    public MapView(int width,int height){
        windowSizeWidth  = width - 100;
        windowSizeHeight = height - 100;


    }

    public void draw(Graphics g,MapModel model){

        //マップサイズを求める
        mapTileWidth  = model.getCurrentMapData().getMapWidth();
        mapTileHeight = model.getCurrentMapData().getMapHeight();

        tileSize = Math.min( (windowSizeWidth/mapTileWidth) , (windowSizeHeight/mapTileHeight) );
        startW =((windowSizeWidth  - (mapTileWidth  * tileSize)) / 2);
        startH =((windowSizeHeight - (mapTileHeight * tileSize)) / 2) + 25;

        //マップを描画
        for (int h = 0; h < mapTileHeight; h++){
            for (int w = 0; w < mapTileWidth; w++){
                drawW = startW + (w * tileSize);
                drawH = startH + (h * tileSize);

                //タイルの種類は番号で管理。番号に応じてタイルの色を変える
                //0;空白。プレイヤーが通過可能の領域
                if(model.getCurrentMapData().getTileAt(w,h) == 0){
                    g.setColor(Color.DARK_GRAY);

                //1;壁　プレイヤーが通過不可能な領域
                }else if(model.getCurrentMapData().getTileAt(w, h) == 1){
                    g.setColor(Color.BLACK);

                //2;ボス。　プレイヤーと座標が被ると戦闘開始(仮)
                }else if(model.getCurrentMapData().getTileAt(w, h) == 2){
                    g.setColor(Color.RED);

                //上り階段。    
                }else if(model.getCurrentMapData().getTileAt(w, h) == 3){
                    g.setColor(Color.LIGHT_GRAY);

                //下り階段    
                }else if(model.getCurrentMapData().getTileAt(w, h) == 4){
                    g.setColor(Color.WHITE);
                }
                //タイルの中を塗りつぶし
                g.fillRect(drawW, drawH, tileSize, tileSize);

                //タイルの枠を描画
                g.setColor(Color.BLACK);
                g.drawRect(drawW, drawH, tileSize, tileSize);

            }
        }

        //プレイヤーの描画
        g.setColor(Color.BLUE);
        g.fillRect(startW + (model.getPlayerX() * tileSize),startH + (model.getPlayerY() * tileSize), tileSize, tileSize);


        g.setColor(Color.BLACK);
        g.drawString("Spaceキーでエンカウント",500,850);
        
    }
}