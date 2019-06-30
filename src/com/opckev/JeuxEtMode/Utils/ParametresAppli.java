package com.opckev.JeuxEtMode.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParametresAppli {

    private static final Logger logger = LogManager.getLogger(Logger.class.getName());
    private int nbMax;
    private int nbMin;
    private int essaisMax;
    private boolean modeDev;

    public ParametresAppli(){

            /**
             * Programme permettant de lire le fichier properties
             * @return nombre max de chiffres
             */
                try (InputStream input = new FileInputStream("config.properties")) {
                    Properties prop = new Properties();
                    prop.load(input);

                    nbMax = Integer.parseInt(prop.getProperty("maxcasesM"));
                    nbMin = Integer.parseInt(prop.getProperty("mincasesM"));
                    essaisMax = Integer.parseInt(prop.getProperty("nbtries"));
                    modeDev = Boolean.parseBoolean(prop.getProperty("modeDevelopper"));

                } catch (IOException ex) {
                    logger.info("Problème avec le fichier properties");
                    ex.printStackTrace();
                }
    }
    public int getNbMax() {
        return nbMax;
    }
    public int getNbMin() {
        return nbMin;
    }
    public int getEssaisMax() {
        return essaisMax;
    }
    public void setModeDev(boolean modeDev) {
        this.modeDev = modeDev;
    }
    public boolean isModeDev() {
        return modeDev;
    }
}
