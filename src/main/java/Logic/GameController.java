package Logic;


public class GameController {
    // 진행 색
    private static Stone currentStone = Stone.black;
    // 버튼이 눌림?
    public static boolean actButton = false;
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
    // 돌 할당 판정 (pressTable을 받을 함수)
    public static void setStone(int x_value, int y_value){
        if (actButton){
            Table[x_value][y_value] = currentStone;
            OmokDrawer.drawStone(x_value, y_value, currentStone);
            switch (currentStone) {
                case black:
                    currentStone = Stone.white;
                    break;
                case white:
                    currentStone = Stone.black;
                    break;
                case empty:
                    break; // 혹은 throw 예외
            }

            actButton = false;
        }
    }
    // 돌 위치 가져오기
    public static Stone getStone(int x, int y) {
        return Table[x][y];
    }

}
