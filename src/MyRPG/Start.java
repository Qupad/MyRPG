package MyRPG;

import java.util.*;
/**
 * Created by Maniak on 21.08.2017.
 */
public class Start {
    public static void main(String[] args) {
        Map map = new Map();
        Ivent ivent = new Ivent();
        Scanner sc = new Scanner(System.in);
        map.setMap(0,0);
        map.randomize();
        while (true) {
            Boolean n = false ,w = false,e = false,s = false;
            map.print();
            System.out.print("You are in ");
            ivent.start(map.getData(map.x,map.y));
            System.out.println();
            System.out.println("U see: ");
            if (map.x - 1 >= 0) {
                ivent.start(map.getData(map.x - 1,map.y));
                n = true;
            } else System.out.print("giant black wall");
            System.out.println(" at North ");

            if (map.y - 1 >= 0) {
                ivent.start(map.getData(map.x,map.y-1));
                w = true;
            } else System.out.print("giant black wall");
            System.out.println(" at West ");

            if (map.x + 1 < map.map.length) {
                ivent.start(map.getData(map.x + 1,map.y));
                s = true;
            } else System.out.print("giant black wall");
            System.out.println(" at South ");

            if (map.y + 1 < map.map.length){
                ivent.start(map.getData(map.x,map.y+1));
                e = true;
            } else System.out.print("giant black wall");
            System.out.println(" at East ");

            String chose = sc.next();
            if (w && chose.equals("W")) {
                map.clearData();
                map.setMap(map.x, map.y-1);
            } else if (e && chose.equals("E")) {
                map.clearData();
                map.setMap(map.x, map.y+1);
            } else if (s && chose.equals("S")) {
                map.clearData();
                map.setMap(map.x+1, map.y);
            } else if (n && chose.equals("N")) {
                map.clearData();
                map.setMap(map.x-1, map.y);
            } else
                System.out.println("Wrong");
        }
    }
}
