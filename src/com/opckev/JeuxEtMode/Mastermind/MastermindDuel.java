package com.opckev.JeuxEtMode.Mastermind;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.FinUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.AskNumberUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.Beginner;
import com.opckev.JeuxEtMode.Utils.Mastermind.MChall;
import com.opckev.JeuxEtMode.Utils.Mastermind.MDef;

public class MastermindDuel {
    public void mode6 (){
        System.out.println("Bienvenue sur le mode duel");
        System.out.println("Votre but est d'atteindre le score de 3 avant l'ordinateur.");
        System.out.println("A vos marques, prêt, partez !!!");
        System.out.println();
        System.out.println("Pour commencer veuillez choisir la taille des nombres avec lesquels vous allez jouer");
        int NB_CHIFFRES= AskNumberUtils.mastermind1();
        int scoreJoueur = 0;
        int scoreOrdi=0;
        boolean victoire;
        int deroulement = Beginner.mastermindDuel();

        if (deroulement==1) {

            do {
                if (MChall.modeChallenger(NB_CHIFFRES) == true) {
                    scoreJoueur++;
                }

                if (MDef.modeDefenseur(NB_CHIFFRES) == true) {
                    scoreOrdi++;
                }
                System.out.println("");
                System.out.println("Votre score est de " + scoreJoueur + " et celui de l'ordinateur " + scoreOrdi);
                System.out.println("");
                victoire=scoreJoueur == 3 || scoreOrdi == 3;
            }
            while (!victoire);
            if (scoreJoueur==3){
                System.out.println("Bravo vous avez gagné, n'hésitez pas à remettre en jeu votre trophé si vous en avez le courage");
            }
            else{
                System.out.println("L'ordinateur a été meilleur cette fois mais ne vous en faites pas, c'est en persévérant que l'on devient meilleur ! Courage !!!");
            }
        }
        else {
            do {
                if (MDef.modeDefenseur(NB_CHIFFRES) == true) {
                    scoreOrdi++;
                }
                System.out.println("Votre score est de " + scoreJoueur + " et celui de l'ordinateur " + scoreOrdi);
                if (MChall.modeChallenger(NB_CHIFFRES) == true) {
                    scoreJoueur++;
                }
                System.out.println("");
                System.out.println("Votre score est de " + scoreJoueur + " et celui de l'ordinateur " + scoreOrdi);
                System.out.println("");
                victoire=scoreJoueur == 3 || scoreOrdi == 3;
            }
            while (!victoire);
            if (scoreJoueur==3){
                System.out.println("Bravo vous avez gagné, n'hésitez pas à remettre en jeu votre trophé si vous en avez le courage");
            }
            else{
                System.out.println("L'ordinateur a été meilleur cette fois mais ne vous en faites pas, c'est en persévérant que l'on devient meilleur ! Courage !!!");
            }
        }

        int nbfin6= FinUtils.finMenu();
        if (nbfin6==1){
            mode6();
        }
        else if (nbfin6==2){
            Appli Menu = new Appli();
            Menu.partieUn();
        }
        else {
            System.out.println("Au revoir");
        }
    }
}

