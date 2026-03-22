package Map;

public class MapLoader{
    private MapData currentMapData;
    private MapModel currentMapModel;

    //mapModelはここ以外ではインスタンス化させない
    public void loadMap(int mapId){
        if(mapId == 0){
            currentMapData = new TestMapData();
        }

        currentMapModel = new MapModel(currentMapData);
    }

    public MapModel getCurrentMapModel(){
        return currentMapModel;
    }

    public MapData getCurrentMapData(){
        return currentMapData;
    }
}