package Map;

public class MapLoader{
    private MapData currentMapData;
    private MapModel currentMapModel;

    //mapModelはここ以外ではインスタンス化させない
    public void loadMap(int mapId){
        //マップIDの使い道未定。ゲーム開始後、最初のマップは毎回同じなのでは？
        //loadmap使い方次第だか、現在最初の1回しか呼び出さない
        if(mapId == 0){
            currentMapData = new DungenFirstFloor();
        }

        currentMapModel = new MapModel(currentMapData,mapId);
    }

    public MapModel getCurrentMapModel(){
        return currentMapModel;
    }

    public MapData getCurrentMapData(){
        return currentMapData;
    }
}