package com.opckev;

import com.opckev.JeuxEtMode.Utils.ParametresAppli;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    public static void main(String[] args) {
        if (args.length>0) {
            String modeDev = args[0];
            ParametresAppli appli = new ParametresAppli();
            appli.setModeDev(Boolean.parseBoolean(modeDev));
            System.out.println(appli.isModeDev());
        }

        logger.error("lancement");
        Appli loterie = new Appli();
        loterie.partieUn();
    }
}
