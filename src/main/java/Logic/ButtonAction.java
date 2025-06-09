package Logic;

public class ButtonAction {
    public static void MenuAction(){
        System.out.println(1);

    }
    public static void MenuOffAction(){
        System.out.println(2);
    }

    // 여기서 GamController로 신호를 보냄
    public static void pressTable(int x, int y){
        GameController.actButton = true;
        GameController.setStone(x, y);
    }
}
