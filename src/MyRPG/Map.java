package MyRPG;

/**
 * Created by Maniak on 21.08.2017.
 */
class Map {
    int[][] map = new int[4][4];
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
            for(int j = 0;j<map.length;j++) {
                if (i == x && j == y)
                    System.out.print("* ");
                else
                    System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }

    void randomize(){
        for(int i = 0;i<map.length;i++){
            for(int j = 0;j<map.length;j++)
                map[i][j] = (int) (Math.random()*2);
        }
        setData((int)(Math.random()*map.length),(int)(Math.random()*map.length), 3);
    }

    void setData(int x, int y,int data) {
        map[x][y] = data;
    }

    public int getData(int x, int y) {
        return map[x][y];
    }

    public int[][] getMap() {
        return map;
    }
}
