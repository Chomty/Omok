/** (폐기)
* 오목판을 제외한 레이아웃들을 배치함
* 사이드바랑 게임바로 나뉘어있음
* 구성요소
*   root : 맨 밑에 깔리는 창임
*       기본적인 틀 크기를 제한하고 여기에 큰 레이아웃들을 배치함
*   GameBoard : 게임 보드임
*       그래프의 레이아웃을 따로 만들어서 종속하고, 왼쪽에 닫힘 버튼을 종속해서 사이드바를 닫을거임
*   SideBar : 메뉴판임
*       AI 봇전, 오프라인 대전 이런거 만들어서 유동적으로 이동할 수 있게 만들거임
*       열림 버튼을 Hbox인 버튼컨테이너에 종속시키고, 버튼 컨테이너는 사이드바에 종속시켜서,
*       오른쪽으로 열림 버튼이 위치할 수 있도록 하고, 누르면 게임판은 오른쪽으로 이동, 그리고
*       사이드 바는 오른쪽으로 커지면서 텍스트바가 되게 할거임
*
*
*   TODO
*    이 ㅈ나 더러운 함수들 다 싹 이니셜라이저로 쳐내서 제발 깔끔하게 만들자.
*    + 레이아웃 생성이랑 배치가 같이 있고, 동작도 붙어있으니까 너무 복잡하고 더러움
*    """""""""""""""추후 해당 파일은 폐기."""""""""""""""""""
*/


package bin;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
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


        // GameBoard 부분 (오목을 할 공간) 이니셜라이저 씀 너무 더러워
        HBox GameBoard = new HBox(){{
            setPrefWidth(x_value);
            setPrefHeight(y_value);
            setAlignment(Pos.CENTER);
            setSpacing(20);
            setStyle("-fx-background-color: #212121;");
        }};

        // SideBar 부분 (버튼을 종속 하는 메뉴 선택 바)
        VBox SideTab = SideBar();



        // 버튼 정의
        Button MenuButton = SideButton("null", () ->{
            toggleSidebar(SideTab, GameBoard);
            }, "MenuButton"
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

    private boolean isExpanded = false;

    // 사이드바 애니메이션 적용
    private void toggleSidebar(VBox sideTab, HBox gameBoard) {
        double startWidth = sideTab.getPrefWidth();
        double endWidth = isExpanded ? 120 : 240; // 너비 토글

        double startTranslateX = gameBoard.getTranslateX();
        double endTranslateX = isExpanded ? 0 : endWidth;

        KeyValue widthValue = new KeyValue(
                sideTab.prefWidthProperty(), endWidth);

        KeyValue moveGameBoard = new KeyValue(
                gameBoard.translateXProperty(), endTranslateX);

        KeyFrame frame = new KeyFrame(
                Duration.millis(300),
                widthValue,
                moveGameBoard);

        Timeline timeline = new Timeline(frame);
        timeline.play();

        isExpanded = !isExpanded;
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
        // null이면 택스트 안씀
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
