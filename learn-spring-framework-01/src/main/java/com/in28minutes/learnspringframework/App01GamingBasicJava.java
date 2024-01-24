package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.*;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        GamingConsole marioGame = new MarioGame();
        GamingConsole superContraGame = new SuperContraGame();
        GamingConsole pacManGame = new PacManGame();

        GameRunner gameRunner1 = new GameRunner(superContraGame);
        GameRunner gameRunner2 = new GameRunner(marioGame);
        GameRunner gameRunner3 = new GameRunner(pacManGame);

        gameRunner1.run();
        gameRunner2.run();
        gameRunner3.run();
    }
}
