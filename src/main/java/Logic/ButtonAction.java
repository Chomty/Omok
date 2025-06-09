package Logic;

import Main.MainApp;

public class ButtonAction {
    public static void MenuAction(){
        System.out.println(1);

    }
    public static void MenuOffAction(){
        System.out.println(2);
    }
    public static void pressTable(int x, int y){
        if (GameController.getStone(x, y) == Stone.EMPTY) {
            GameController.setStone(x, y, GameController.currentStone;);
            GameController.switchTurn();

    }
}
