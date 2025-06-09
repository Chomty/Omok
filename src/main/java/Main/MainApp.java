package Main;

import Layout.RootLayout;
import Logic.GameController;
import Logic.OmokDrawer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Objects;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(RootLayout.createRoot(1280, 720));
        // css 스타일 아이콘 적용
        scene.getStylesheets().add(
                Objects.requireNonNull(
                        getClass().getResource("/Style.css")
                ).toExternalForm());

        stage.setTitle("Omok V1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // 오목 돌 그리려고 초기화
        Canvas canvas = new Canvas();
        // 도구 쥐어주기
        OmokDrawer.setGraphicsContext(canvas.getGraphicsContext2D());
        // 테이블 초기화
        GameController.setOmokTable();
        launch(args);
    }

}
