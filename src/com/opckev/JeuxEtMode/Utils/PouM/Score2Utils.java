package com.opckev.JeuxEtMode.Utils.PouM;

import java.util.Arrays;

public class Score2Utils {

    //Programme permettant de vérifier si un chiffre est bien placé
    public static String comptage(int chiffres[], int solution[]) {

        System.out.println("la solution est " + Arrays.toString(solution));
        System.out.println("vous avez proposé " + Arrays.toString(chiffres));
        String retour[] = new String[chiffres.length];
        int i;
        boolean bonChiffre;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                retour[i] = "=";
            } else if (chiffres[i] < solution[i]) {
                retour[i] = "+";
            } else if (chiffres[i] > solution[i]) {
                retour[i] = "-";
            }
        }
        String rep = "";
        for (i = 0; i < chiffres.length; i++) {
            rep = rep + retour[i];
        }
        return rep;
    }

    public static int[] verification(int[] chiffres, int[] solution) {
        int i;
        boolean bonChiffre;
        int vrai[] = new int[]{0, 0};

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                vrai[0] = vrai[0] + 1;
            }
        }
        return vrai;
    }
}