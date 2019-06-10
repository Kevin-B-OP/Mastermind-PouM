package com.opckev.JeuxEtMode.Utils.Mastermind;

import java.util.Arrays;

public class ScoreUtils {

    //Programme permettant de vérifier si un chiffre est bien placé
    public static int[] comptage(int chiffres[], int solution[]) {

        System.out.println("la solution est "+ Arrays.toString(solution));
        System.out.println("vous avez proposé "+Arrays.toString(chiffres));
        int vrai[] = new int[]{0, 0};
        int i;
        boolean bonChiffre;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                vrai[0] = vrai[0] + 1;
            }
        }
        return vrai;
    }

    //Programme permettant de vérifier si un chiffre est dans la solution
    public static int[] comptage2(int chiffres[], int solution[]) {
        int present[] = new int[]{0, 0};
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
                        present[0] = present[0] + 1;
                    }
                }
            }

        }
        return present;
    }



    //Programme permettant d'écrire les phrases pour le joueur
    //Phrases indiquant la présence des éléments
    public static String phraseEtape(int vrai[],int present[],int nombreSaisi){
        boolean vraiPlus = vrai[0]>=2;
        boolean vraiVide = vrai[0]==0;
        boolean vraiUn = vrai[0]==1;
        boolean presentPlus=present[0]>=2;
        boolean presentVide=present[0]==0;
        boolean presentUn=present[0]==1;
        String phraseDeFin;

        if (vraiPlus&&presentPlus){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placés, " +present[0]+" présents";
        }
        else if(vraiUn&&presentUn){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présent";
        }
        else if (vraiPlus&&presentVide){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placés, " +present[0]+" présent";
        }
        else if (vraiPlus&&presentUn){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placés, " +present[0]+" présent";
        }
        else if (vraiUn&&presentPlus){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présents";
        }
        else if (vraiUn&&presentVide){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présent";
        }
        else if (vraiVide&&presentPlus){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présents";
        }
        else {
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présent";
        }
        return phraseDeFin;
    }
    public static String phraseOrdi(int vrai[],int present[],int chiffres[]){
        boolean vraiPlus = vrai[0]>=2;
        boolean vraiVide = vrai[0]==0;
        boolean vraiUn = vrai[0]==1;
        boolean presentPlus=present[0]>=2;
        boolean presentVide=present[0]==0;
        boolean presentUn=present[0]==1;
        String phraseDeFin;

        if (vraiPlus&&presentPlus){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placés, " +present[0]+" présents";
        }
        else if(vraiUn&&presentUn){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présent";
        }
        else if (vraiPlus&&presentVide){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placés, " +present[0]+" présent";
        }
        else if (vraiPlus&&presentUn){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placés, " +present[0]+" présent";
        }
        else if (vraiUn&&presentPlus){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présents";
        }
        else if (vraiUn&&presentVide){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présent";
        }
        else if (vraiVide&&presentPlus){
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présents";
        }
        else {
            phraseDeFin="Proposition : "+Arrays.toString(chiffres)+" -> Réponse : "+vrai[0]+" bien placé, " +present[0]+" présent";
        }
        return phraseDeFin;
    }
}