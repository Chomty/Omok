package Layout;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OmokCanvas {
    /**
     * @param size : (int) 격자 갯수
     * @param cellSize : (int) 버튼 사이즈(기준)
     *
     * @return 격자 Canvas를 리턴함
     * */
    public static Canvas createBoard(int size, double cellSize) {
        double boardSize = cellSize * (size - 1);  // 격자 수 기준으로 크기 설정
        Canvas canvas = new Canvas(boardSize + 43, boardSize + 43); // 여유 여백
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.web("#E3C16F"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setStroke(Color.rgb(0,0,0,1.0));
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
