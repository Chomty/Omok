/**
 * 사이드바 관련 레이아웃만 작성함
 * 다른거 작성하면 죽음
 *
 * __________절 대 경 고 ____________
 *
 * 1. 동작 절 때 적지마라.
 * 2. 무조건 클래스 단위에서 쪼개라.
 * 3. 인스턴스 하지마라.
 *      이건 다른 파일에서 가져가서 실행하는거임.
 * 4. 못 지킬시 Smoking 압수형.
 *
 * __________절 대 엄 숙______________
 */

package Layout;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class GameLayout {
    /**
     * @param size : (int) 15로 할거임(렌주 룰)
     *
     * @return : (GridPane) 오목판
     *
     * 오목판을 만듦
     *
     * */
    public static GridPane GameBoard(int size){

        GridPane board = new GridPane();
        board.setHgap(5);
        board.setVgap(5);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button cell = new Button();
                cell.setPrefSize(38, 38);
                cell.getStyleClass().add("cell-button");
                board.add(cell, j, i); // (col, row)
            }
        }

        return board;
    }
    /**
     * @param x_value : (int) 너비
     * @param y_value : (int) 높이
     *
     * @return : (GridPane) 배경판
     *
     * GameBoard를 종속할 배경 레이아웃 역할을 함.
     * */
    public static GridPane outBoard(int x_value, int y_value){

        GridPane out = new GridPane(){{
            setPrefWidth(x_value);
            setPrefHeight(y_value);
            setStyle("-fx-background-color: #212121;");
        }};

        return out;
    }
}
