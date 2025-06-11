package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OmokDrawer {
    private static GraphicsContext gc;

    public static void setGraphicsContext(GraphicsContext context) {
        gc = context;
    }
    /**
     * 동그라미 그리기 셔틀
     * @param col : (int) 너비
     * @param row :: (int) 높이
     * @param stone : (Stone) 돌 색
     **/
    public static void drawStone(int col, int row, Stone stone) {
        double cellSize = 43.0;
        double size = cellSize * 0.9;

        double x = col * cellSize;
        double y = row * cellSize;

        if (stone == Stone.black) {
            gc.setFill(Color.BLACK);
        } else if (stone == Stone.white) {
            gc.setFill(Color.WHITE);
        } else {
            return;
        }
        System.out.println("그림 그리기 시도: " + col + ", " + row + " / 색: " + stone);

        gc.fillOval(x, y, size, size);
    }
}
