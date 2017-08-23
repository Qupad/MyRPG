package MyRPG;

/**
 * Created by Maniak on 22.08.2017.
 */
class Ivent {
    Map map = new Map();

    void start(int ivent){
        if( ivent == 1){
            System.out.print("forest");
        } else if ( ivent == 0){
            System.out.print("mountain");
        }
    }
}
