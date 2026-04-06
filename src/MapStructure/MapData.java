package MapStructure;

public abstract class MapData{

   // private final int[][] tileMap;
   // private final boolean[][] collisionMap;
   // private final int width,height;

    public abstract boolean isWalkable(int x,int y);

    public abstract int getTileAt(int x,int y);

    public abstract int getMapWidth();
    public abstract int getMapHeight();
    
}