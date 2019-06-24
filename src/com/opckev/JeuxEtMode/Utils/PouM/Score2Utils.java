package com.opckev.JeuxEtMode.Utils.PouM;

public class Score2Utils {

    /**
     * Programme permettant de vérifier si un chiffre est bien placé
     * @param chiffres Proposition du joueur
     * @param solution nombre qu'il doit deviné, donné par l'ordinateur
     * @return tableau contenant la comparaison pour chaque chiffre des deux précédents nombres
     */
    public static String comptage(int chiffres[], int solution[]) {

        String retour[] = new String[chiffres.length];
        int i;
        boolean bonChiffre;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                retour[i] = "= ";
            } else if (chiffres[i] < solution[i]) {
                retour[i] = "+ ";
            } else if (chiffres[i] > solution[i]) {
                retour[i] = "- ";
            }
        }
        String rep = "";
        for (i = 0; i < chiffres.length; i++) {
            rep = rep + retour[i];
        }
        return rep;
    }

    /**
     * Compte le nombre de chiffres bien placés
     * @param chiffres proposition du joueur
     * @param solution nombre choisit par l'ordinateur qu'il doit deviner
     * @return nombre de chiffres bien placés
     */
    public static int verification(int[] chiffres, int[] solution) {
        int i;
        boolean bonChiffre;
        int vrai = 0;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                vrai++;
            }
        }
        return vrai;
    }
    /*
    public static int[][] poumOrdi (int [][]chiffres, int[] solution){
        String retour[] = new String[chiffres.length];
        int i;
        boolean bonChiffre;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i][0] == solution[i];
            if (bonChiffre) {
                chiffres[i][1] = 0;
            } else if (chiffres[i][0] < solution[i]) {
                chiffres[i][1] = 1;
            } else if (chiffres[i][0] > solution[i]) {
                chiffres[i][1] = 2;
            }
        }
        return chiffres;
    }
     */
}