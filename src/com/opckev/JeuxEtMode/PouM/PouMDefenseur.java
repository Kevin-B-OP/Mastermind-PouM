package com.opckev.JeuxEtMode.PouM;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.Mastermind.AskNumberUtils;
import com.opckev.JeuxEtMode.Utils.FinUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.NumberUtils;
import com.opckev.JeuxEtMode.Utils.PouM.PouMDef;

public class PouMDefenseur {

    int scoreOrdi = 0;

    //Mode de jeu Plus ou Moins ou l'ordi doit trouver le choix du joueur
    public void mode2 () {

        int ESSAIS_MAX=NumberUtils.essai();
        final int MAX = 9;
        //Le choix de la taille du nombre est définie par le joueur qui devra choisir entre les deux valeurs extrêmes
        int NB_CHIFFRES= AskNumberUtils.mastermind1();
        System.out.println("");

        final int[] solution = new int[NB_CHIFFRES];

        //Permet au joueur de donner son chiffre
        String nbInitial = AskNumberUtils.mastermind2(NB_CHIFFRES);
        int nombreSaisi = Integer.parseInt(nbInitial);

        //Permet de rentrer le nombre donné par le joueur dans un tableau
        for (int i = 0; i < NB_CHIFFRES; i++)
            solution[i] = (int) (nombreSaisi / (Math.pow(10, (NB_CHIFFRES - i - 1)))) % 10;

        //Partie Ordinateur
        System.out.println("Mastermind mode défenseur : l'ordinateur va essayer de trouver votre combinaison de chiffres" + MAX + ".");
        System.out.println("Il a le droit à " + ESSAIS_MAX + " essais");
        System.out.println("----------------------------");

        //On récupère le fait que l'ordinateur ait gagné ou non
        //Toute la partie proposition se passe dans cette class
        boolean victoire= PouMDef.ordiPouM(solution,ESSAIS_MAX);

        //Message si l'ordi perd
            if (!victoire) {
                System.out.println("Bravo, vous avez réussie à épuiser les " + ESSAIS_MAX + " essais dont l'ordinateur disposait.");
            }
            //Message si l'ordi gagne
            else if (victoire) {
                scoreOrdi++;
                System.out.println("Pas de chance, l'ordinateur a relevé le défi.");
                System.out.println("Le score de l'ordinateur est de " + scoreOrdi + " point(s)");
            }
        System.out.println(" ");
        fin();
    }
    public void fin() {
        //Menu de fin de jeu
        int nbfin5= FinUtils.finMenu();
        System.out.println(" ");
        if (nbfin5==1){
            System.out.println(" ");
            mode2();
        }
        else if (nbfin5==2){
            System.out.println(" ");
            Appli Menu = new Appli();
            Menu.partieUn();
        }
        else {
            System.out.println("Au revoir");
        }
    }
}