package MyRPG;

/**
 * Created by Maniak on 21.08.2017.
 */
class Map {
    int[][] map = new int[5][5];
    int gg;
    int x;
    int y;

    public void setMap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void clearData(){
        //map[x][y] = 0;
    }

    void print(){
        for(int i = 0;i<map.length;i++){
            System.out.println();
            for(int j = 0;j<map.length;j++)
                System.out.print(map[i][j]+" ");
        }
        System.out.println();
    }

    void randomize(){
        for(int i = 0;i<map.length;i++){
            for(int j = 0;j<map.length;j++)
                map[i][j] = (int) (Math.random()*2);
        }
    }

    public int getData(int x, int y) {
        return map[x][y];
    }

    public int getGg() {
        return gg;
    }

    public int[][] getMap() {
        return map;
    }
}
