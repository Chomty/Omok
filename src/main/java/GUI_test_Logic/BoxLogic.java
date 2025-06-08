package GUI_test_Logic;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;


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

        // css 스타일 아이콘 적용
        scene.getStylesheets().add(
                Objects.requireNonNull(
                        getClass().getResource("/Style.css")
                        ).toExternalForm());


        // GameBoard 부분 (오목을 할 공간)
        HBox GameBoard = new HBox();
        GameBoard.setPrefWidth(x_value);
        GameBoard.setPrefHeight(y_value);
        GameBoard.setAlignment(Pos.CENTER);
        GameBoard.setSpacing(20);
        GameBoard.setStyle("-fx-background-color: #212121;");

        // SideBar 부분 (버튼을 종속 하는 메뉴 선택 바)
        VBox SideTab = SideBar();
        SideTab.setAlignment(Pos.TOP_LEFT);
        SideTab.setPrefHeight(y_value);
        SideTab.setPrefWidth(120);
        // SideTab.getStyleClass().add("SideTab"); //실패...
        SideTab.setStyle("-fx-background-color: #171717;");


        // 버튼 정의
        Button MenuButton = SideButton("null", () ->{
                GameBoard.setTranslateX(120);


                }
                , "MenuButton"
        );
        MenuButton.setAlignment(Pos.TOP_RIGHT);

        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.TOP_RIGHT); // 오른쪽 정렬
        buttonContainer.setPrefWidth(120); // SideTab과 동일한 너비
        buttonContainer.getChildren().add(MenuButton);

        SideTab.getChildren().add(buttonContainer); // HBox를 추가


        // root에 Boxs를 종속
        root.getChildren().addAll(SideTab, GameBoard);




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

    public Button SideButton(String Text, Runnable Action, String icon){
        Button ChButton = new Button();
        if(Text.equals("null")){
            // pass
        }else{
            ChButton.setText(Text);
        }
        ChButton.setPrefWidth(28);
        ChButton.setPrefHeight(28);
        ChButton.setOnAction(e -> Action.run());
        ChButton.getStyleClass().add(icon);


        return ChButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
