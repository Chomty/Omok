package Layout;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OmokCanvas {

    public static Canvas createBoard(int size, double cellSize) {
        double boardSize = cellSize * (size - 1);  // 격자 수 기준으로 크기 설정
        Canvas canvas = new Canvas(boardSize + 43, boardSize + 43); // 여유 여백
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.web("#212121"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setStroke(Color.rgb(255, 255, 255, 0.2)); // 흐릿한 흰색
        gc.setLineWidth(1);

        double offset = 20; // 바깥 여백
        for (int i = 0; i < size; i++) {
            double pos = offset + i * cellSize;
            // 수평선
            gc.strokeLine(offset, pos, offset + boardSize, pos);
            // 수직선
            gc.strokeLine(pos, offset, pos, offset + boardSize);
        }

        return canvas;
    }
}
