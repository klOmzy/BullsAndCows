import java.util.*;

public class GameControl {
    private static GameControl instance;

    private GameControl(){
        //
    }
    public static GameControl getInstance() {
        if (instance == null) {
            instance = new GameControl();
        }
        return instance;
    }

    public void startGame() throws InterruptedException {
        RepeatAndOptionCheck repeatAndOptionCheck = new RepeatAndOptionCheck();
        repeatAndOptionCheck.numberOptCheck();
        GuessAndResultCheck guessAndResultCheck = new GuessAndResultCheck();
        guessAndResultCheck.guessNumbers(repeatAndOptionCheck.getRepeat());
    }
}