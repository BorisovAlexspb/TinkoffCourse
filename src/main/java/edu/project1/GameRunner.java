package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class GameRunner {
    private final static Logger LOGGER = LogManager.getLogger();

    private static void main(String[] args) {  // to run game change private to public
        LOGGER.info("> Hi, Let's start!");
        Session session = new Session();
        session.play();
        LOGGER.info("> The game is over");
    }
}
