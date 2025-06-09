package Logic;


public class GameController {
    // 진행 색
    private Stone currentStone = Stone.black;
    // 버튼이 눌림?
    private boolean actButton = false;
    // 다른 곳에서 참조 막기
    // 정상적인 경로에서의 변경만 허용함
    private static Stone[][] Table = new Stone[15][15];
    /**
     * 오목 테이블 초기화 로직
     * */
    public static void setOmokTable(){

            for(int i = 0; i < 15; i++){
                for(int j = 0; j < 15; j++){
                    Table[i][j] = Stone.empty;
                }
            }

    }
    // 돌 할당 판정
    public static void setStone(int x_value, int y_value, Stone stone){
        Table[x_value][y_value] = stone;
    }
    // 돌 위치 가져오기
    public static Stone getStone(int x, int y) {
        return Table[x][y];
    }

}
