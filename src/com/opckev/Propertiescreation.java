package com.opckev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertiescreation {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    /**
     * Permet de créer le fichier properties et de changer les caractéristiques de ce dernier si besoin est
     */

    public static void main(String[] args) {
        try {
            FileOutputStream output = new FileOutputStream("config.properties");

            try {
                Properties prop = new Properties();
                prop.setProperty("nbcasesP", "4");
                prop.setProperty("nbtries", "5");
                prop.setProperty("maxcasesM", "10");
                prop.setProperty("mincasesM","4");
                prop.store(output, (String)null);
                System.out.println(prop);
            } catch (Throwable var5) {
                try {
                    output.close();
                } catch (Throwable var4) {
                    logger.info ("Erreur de saisie dans le fichier properties",var4);
                    var5.addSuppressed(var4);
                }

                throw var5;
            }

            output.close();
        } catch (IOException var6) {
            logger.info ("Erreur fichier properties",var6);
            var6.printStackTrace();
        }

    }
}

