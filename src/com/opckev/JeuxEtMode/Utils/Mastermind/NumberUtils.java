package com.opckev.JeuxEtMode.Utils.Mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NumberUtils {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());
    /**
     * Programme permettant de lire le fichier properties
     * @return nombre max de chiffres
     */
    public static int max() {
        int nbMax = -1;
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            nbMax = Integer.parseInt(prop.getProperty("maxcasesM"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return nbMax;
    }

    /**
     * Programme permettant de lire le fichier properties
     * @return nombre min de chiffres
     */
    public static int min(){
        int nbMin =-1;
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            nbMin = Integer.parseInt(prop.getProperty("mincasesM"));
        }
        catch (IOException ex) {
            logger.info("Problème avec le fichier properties");
            ex.printStackTrace();
        }
        return nbMin;
    }
    /**
     * Programme permettant de lire le fichier properties
     * @return nombre d'essais
     */
    public static int essai(){
        int essaisMax =-1;
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            essaisMax = Integer.parseInt(prop.getProperty("nbtries"));
        }
        catch (IOException ex) {
            logger.info("Problème avec le fichier properties et le nombre d'essais");
            ex.printStackTrace();
        }
        return essaisMax;
    }
}
