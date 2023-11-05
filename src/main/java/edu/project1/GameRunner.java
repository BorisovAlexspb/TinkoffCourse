package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class GameRunner {

    private static void main(String[] args) {  // to run game change private to public
        Dictionary dict = new Dictionary();
        Scanner sc = new Scanner(System.in);
        final Logger LOGGER = LogManager.getLogger();

        char[] getRandomWord = dict.makeRandomWord();
        LOGGER.info("> Hi, Let's start!");
        Session session = new Session(getRandomWord, sc, LOGGER);
        session.play();
        LOGGER.info("> The game is over");
    }
}
