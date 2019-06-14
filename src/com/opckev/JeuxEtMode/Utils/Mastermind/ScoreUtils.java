package com.opckev.JeuxEtMode.Utils.Mastermind;

import java.util.Arrays;

public class ScoreUtils {

    //Programme permettant de vérifier si un chiffre est bien placé
    public static int[] comptage(int chiffres[], int solution[]) {

        System.out.println("la solution est "+ Arrays.toString(solution));
        System.out.println("vous avez proposé "+Arrays.toString(chiffres));
        int vrai[] = new int[chiffres.length];
        int i;
        boolean bonChiffre;

        for (i = 0; i < chiffres.length; i++) {
            bonChiffre = chiffres[i] == solution[i];
            if (bonChiffre) {
                vrai[i]=1;
            }
            else{
                vrai [i]=0;
            }
        }
        return vrai;
    }

    public static int present(int chiffres[],int solution[], int vrai[]){
        int bienPlace=0;
        for (int i = 0; i < chiffres.length; i++) {
            if (vrai[i] == 1) {
                bienPlace++;
            }
        }
        int nouvelleTaille=chiffres.length-bienPlace;
        int chiffresbis[]=new int [nouvelleTaille];
        int solutionbis[]=new int [nouvelleTaille];
        int i;
        int a=0;
        for (i = 0; i < chiffres.length; i++){
            if (vrai[i]==0){
               chiffresbis[a]=chiffres[i];
               solutionbis[a]=solution[i];
               a++;
            }
        }
    return comptage2(chiffresbis,solutionbis);
    }

    //Programme permettant de vérifier si un chiffre est dans la solution
    public static int comptage2(int chiffres[], int solution[]) {
        int present=0;
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

    public static int bienPlace(int vrai[]){
        int bienPlace=0;
        for (int i = 0; i < vrai.length; i++) {
            if (vrai[i] == 1) {
                bienPlace++;
            }
        }
        return bienPlace;
    }



    //Programme permettant d'écrire les phrases pour le joueur
    //Phrases indiquant la présence des éléments
    public static String phraseEtape(int vrai[],int present,int nombreSaisi){
        int bienPlace=bienPlace(vrai);
        boolean vraiPlus = bienPlace>=2;
        boolean vraiVide = bienPlace==0;
        boolean vraiUn = vrai[0]==1;
        boolean presentPlus=present>=2;
        boolean presentVide=present==0;
        boolean presentUn=present==1;
        String phraseDeFin;

        if (vraiPlus&&presentPlus){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placés, " +present+" présents";
        }
        else if(vraiUn&&presentUn){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placé, " +present+" présent";
        }
        else if (vraiPlus&&presentVide){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placés, " +present+" présent";
        }
        else if (vraiPlus&&presentUn){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placés, " +present+" présent";
        }
        else if (vraiUn&&presentPlus){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placé, " +present+" présents";
        }
        else if (vraiUn&&presentVide){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placé, " +present+" présent";
        }
        else if (vraiVide&&presentPlus){
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placé, " +present+" présents";
        }
        else {
            phraseDeFin="Proposition : "+nombreSaisi+" -> Réponse : "+bienPlace+" bien placé, " +present+" présent";
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