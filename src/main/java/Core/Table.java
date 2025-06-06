package Core;


enum Stone {
    BLACK,
    WHITE,
    EMPTY
}

class Omok_Table{
    int[][] Omok_Vecter = new int[15][15];

}

class Act{
    /**
     * @param MyStone : Stone(enum)
     * 주어진 돌을 반전해서 반환함.
     * @return 반대색의 돌 (BLACK, WHITE)
     * */
    public Stone Invert_Stone(Stone MyStone){
        if(MyStone == Stone.BLACK){
            return Stone.WHITE;
        } else if (MyStone == Stone.WHITE) {
            return Stone.BLACK;
        }
        return Stone.EMPTY; // 변환 못하면 빈 값 출력
    }



}

public class Table {
    Stone MyStone = Stone.EMPTY;


}
