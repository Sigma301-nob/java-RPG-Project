package Map;

public class MapLoader{
    private MapData currentMapData;
    private MapModel currentMapModel;

    //mapModelはここ以外ではインスタンス化させない
    public void loadMap(){
        currentMapModel = new MapModel();
    }

    public MapModel getcurrentMapModel(){
        return currentMapModel;
    }
}