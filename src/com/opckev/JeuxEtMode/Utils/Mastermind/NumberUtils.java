package com.opckev.JeuxEtMode.Utils.Mastermind;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NumberUtils {

    //Programme permettant de lire le fichier properties et de récupérer le nombre max de chiffres
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
    //Programme permettant de lire le fichier properties et de récupérer le nombre min de chiffres
    public static int min(){
        int nbMin =-1;
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            nbMin = Integer.parseInt(prop.getProperty("mincasesM"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return nbMin;
    }
    //Programme permettant de lire le fichier properties et de récupérer le nombre d'essais
    public static int essai(){
        int essaisMax =-1;
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            essaisMax = Integer.parseInt(prop.getProperty("nbtries"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return essaisMax;
    }
}
