package Layout;

import Logic.OmokDrawer;
import Logic.ButtonAction;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;


public class RootLayout {

    public static HBox createRoot(int x, int y){
        // 열기
        Button MenuOpen = SideBarLayout
                .createButton(
                        "MenuButton",
                        24,
                        "null",
                        ButtonAction::MenuAction  //뭔가 신기한 기능
                );
        // 닫기
        Button MenuOff = SideBarLayout
                .createButton(
                        "MenuOffButton",
                        24,
                        "null",
                        ButtonAction::MenuOffAction
                );
        // 게임 아웃보드
        // 오목판 그리기
        Canvas boardCanvas = OmokCanvas.createBoard(15, 43);
        Canvas stoneCanvas = new Canvas(boardCanvas.getWidth(), boardCanvas.getHeight());
        OmokDrawer.setGraphicsContext(stoneCanvas.getGraphicsContext2D());
        StackPane boardLayer = new StackPane();
        boardLayer.getChildren().addAll(boardCanvas, stoneCanvas);

        GridPane OutBoard = GameLayout.outBoard(x, y);
        OutBoard.setAlignment(Pos.CENTER);
        OutBoard.getChildren().addAll(
                // 종속
                boardLayer,
                GameLayout.GameBoard(15)
        );

        // 사이드보드
        VBox sideBar = SideBarLayout.createSideBar(y);
        sideBar.setAlignment(Pos.TOP_RIGHT);
        sideBar.getChildren().addAll(
                // 종속
                MenuOpen
        );

        // 루트
        HBox root = new HBox(){{
            setPrefSize(x, y);
            setAlignment(Pos.CENTER_LEFT);
            getChildren().addAll(sideBar, OutBoard);
        }};

        return root;
    }
}
