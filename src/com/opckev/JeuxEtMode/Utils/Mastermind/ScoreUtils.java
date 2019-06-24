package com.opckev.JeuxEtMode.Utils.Mastermind;

import java.util.Arrays;

public class ScoreUtils {

    /**
     * Programme permettant de vérifier si un chiffre est bien placé
     * @param chiffres proposition du joueur
     * @param solution nombre qu'il doit deviner
     * @return tableau rempli de 1 (chiffre bien placé) et de 0 (chiffre mal placé)
     */
    public static int[] comptage(int chiffres[], int solution[]) {

        int vrai[] = new int[chiffres.length];
        int i;
        boolean bonChiffre;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                vrai[i] = 1;
            } else {
                vrai[i] = 0;
            }
        }
        return vrai;
    }

    /**
     * Permet de vérifier combien de chiffres sont présents et mal placés dans la proposition du joueur
     * @param chiffres proposition du joueur
     * @param solution nombre qu'il doit deviner
     * @param vrai tableau de 1 et de 0 permettant de savoir si un chiffre est bien placé
     * @return nombre de chiffre présents et mal placés
     */
    public static int present(int chiffres[], int solution[], int vrai[]) {
        int bienPlace = 0;
        for (int i = 0; i < chiffres.length; i++) {
            if (vrai[i] == 1) {
                bienPlace++;
            }
        }
        int nouvelleTaille = chiffres.length - bienPlace;
        int chiffresbis[] = new int[nouvelleTaille];
        int solutionbis[] = new int[nouvelleTaille];
        int i;
        int a = 0;
        for (i = 0; i < chiffres.length; i++) {
            if (vrai[i] == 0) {
                chiffresbis[a] = chiffres[i];
                solutionbis[a] = solution[i];
                a++;
            }
        }
        return comptage2(chiffresbis, solutionbis);
    }

    /**
     * Programme permettant de vérifier si un chiffre est dans la solution
     * @param chiffres proposition du joueur
     * @param solution nombre qu'il doit deviner
     * @return nombre de chiffres présents
     */
    public static int comptage2(int chiffres[], int solution[]) {
        int present = 0;
        int i;
        int a;
        boolean chiffreici;
        boolean suite;

        for (i = 0; i < chiffres.length; i++) {
                for (a = 0; a < chiffres.length; a++) {
                    chiffreici = chiffres[i] == solution[a];
                    if (chiffreici) {
                        suite = solution[a]<10|chiffres[i]<10;
                        if (suite){
                            present++;
                            solution[a]=10;
                            chiffres[i]=10;
                        }
                    }

                }
            }
        return present;
    }

            /*
        int present =0;
        int i;
        int a;
        boolean bonChiffre;
        boolean chiffreici;
        for (i = 0; i < chiffres.length; i++) {
        bonChiffre = chiffres[i] == solution[i];
        if (!bonChiffre) {
        for (a = 0; a < chiffres.length; a++) {
        chiffreici = chiffres[i] == solution[a];
        if (chiffreici) {
        present++;
        }
        }
        }

        }
        return present;
    }
    */

    /**
     * Programme donnant le nombre total de chiffre bien placé pour ensuite le comparer à la taille de la solution
     * @param vrai tableau de 1 et de 0 permettant de savoir si un chiffre est bien placé
     * @return nombre de chiffres bien placés
     */
    public static int bienPlace(int vrai[]) {
        int bienPlace = 0;
        for (int i = 0; i < vrai.length; i++) {
            if (vrai[i] == 1) {
                bienPlace++;
            }
        }
        return bienPlace;
    }

    /**
     * Programme permettant d'écrire les phrases pour le joueur, indiquant la présence des éléments
     * @param vrai tableau de 1 et de 0 permettant de savoir si un chiffre est bien placé
     * @param present Nombre de chiffres présent dans la solution mais mal placés
     * @param nombreSaisi proposition du joueur
     * @return phrase récapitulative avec proposition du joueur + chiffres bien placés + chiffres présents
     */

    public static String phraseEtape(int vrai[], int present, int nombreSaisi) {
        int bienPlace = bienPlace(vrai);
        boolean vraiPlus = bienPlace >= 2;
        boolean vraiVide = bienPlace == 0;
        boolean vraiUn = vrai[0] == 1;
        boolean presentPlus = present >= 2;
        boolean presentVide = present == 0;
        boolean presentUn = present == 1;
        String phraseDeFin;

        if (vraiPlus && presentPlus) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placés, " + present + " présents";
        } else if (vraiUn && presentUn) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placé, " + present + " présent";
        } else if (vraiPlus && presentVide) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placés, " + present + " présent";
        } else if (vraiPlus && presentUn) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placés, " + present + " présent";
        } else if (vraiUn && presentPlus) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placé, " + present + " présents";
        } else if (vraiUn && presentVide) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placé, " + present + " présent";
        } else if (vraiVide && presentPlus) {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placé, " + present + " présents";
        } else {
            phraseDeFin = "Proposition : " + nombreSaisi + " -> Réponse : " + bienPlace + " bien placé, " + present + " présent";
        }
        return phraseDeFin;
    }
}