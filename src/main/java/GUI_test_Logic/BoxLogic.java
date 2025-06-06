package GUI_test_Logic;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BoxLogic extends Application {

    int x_value = 800;
    int y_value = 450;

    @Override
    public void start(Stage stage) {
        // root 부분 (바닥 스크린 담당)
        HBox root = new HBox();
        root.setPrefWidth(x_value);
        root.setPrefHeight(y_value);
        Scene scene = new Scene(root); // scene으로 사용
        // GameBoard 부분 (오목을 할 공간)
        HBox GameBoard = new HBox();
        GameBoard.prefWidth(x_value);
        GameBoard.prefHeight(y_value);
        GameBoard.setAlignment(Pos.CENTER);
        // SideBar 부분 (버튼을 종속 하는 메뉴 선택 바)
        VBox SideTab = SideBar();
        SideTab.setAlignment(Pos.CENTER_LEFT);
        // 버튼 정의
        Button MenuButton = SideButton("실험용", () ->
                System.out.println(1)
        );
        // 사이드탭에 버튼을 종속
        SideTab.getChildren().addAll(MenuButton);
        // root에 Boxs를 종속
        root.getChildren().addAll(SideTab,GameBoard);




        stage.setTitle("Omok V 0.1");
        stage.setScene(scene);
        stage.show();
    }

    public VBox SideBar(){
        VBox Menu = new VBox();
        Menu.setSpacing(10);
        Menu.setPrefHeight(y_value);
        Menu.setPrefWidth(x_value/7);

        return Menu;
    }

    public Button SideButton(String Text, Runnable Action){
        Button ChButton = new Button();
        ChButton.setText(Text);
        ChButton.setPrefWidth(50);
        ChButton.setPrefHeight(50);
        ChButton.setOnAction(e -> Action.run());



        return ChButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
