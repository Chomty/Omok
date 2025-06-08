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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SideBarLayout{
/**
 * 윗 주석을 절 대 무시하지 마시오.
 *
 * 파라미터와 리턴값을 위주로 작성하시오.
 *
 * 이를 지키지 못하면, 코드를 또 갈아엎을지도 모릅니다.
 * */

    /**
     * @param y_value : (int) root의 y값임
     * @return : (VBox) sidebar를 생성해서 리턴함
     * */
    public static VBox createSideBar(int y_value){

        VBox mainSideBar = new VBox(){{
            setAlignment(Pos.TOP_LEFT);
            setPrefHeight(y_value);
            setPrefWidth(120);
            setStyle("-fx-background-color: #171717;");
        }};

        return mainSideBar;
    }
    /**
     * @param icon : (String) css file에서 아이콘을 가져옴
     * @param size : (int) 하나의 정수로 정사각형을 만듦
     * @param text : (String) 텍스트를 넣음
     * @param action : (Runnable) 버튼의 동작을 정의함
     *
     * @return : 만들어진 버튼을 리턴함
     * */
    public  static Button createButton(
            // param
            String icon,
            int size,
            String text,
            Runnable action){

        Button sideButton = new Button(){{
            getStyleClass().add(icon);

            // 가로, 세로 맞춰서 정사각형임
            setPrefHeight(size);
            setPrefWidth(size);

            if (text.equals("null")){
                //pass
            }else{
                setText(text);
            }

            setOnAction(e -> action.run());
        }};

        return sideButton;
    }
}
