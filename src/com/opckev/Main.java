package com.opckev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    public static void main(String[] args) {
        logger.error("lancement");
        Appli loterie = new Appli();
        loterie.partieUn();
    }
}
