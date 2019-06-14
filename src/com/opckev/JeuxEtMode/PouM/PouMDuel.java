package com.opckev.JeuxEtMode.PouM;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.FinUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.AskNumberUtils;
import com.opckev.JeuxEtMode.Utils.Mastermind.Beginner;
import com.opckev.JeuxEtMode.Utils.PouM.Duel.PChall;
import com.opckev.JeuxEtMode.Utils.PouM.Duel.PDef;

public class PouMDuel {
    public void mode3 (){
        System.out.println("Bienvenue sur le mode duel");
        System.out.println("Votre but est d'atteindre le score de 3 avant l'ordinateur.");
        System.out.println("A vos marques, prêt, partez !!!");
        System.out.println();
        System.out.println("Pour commencer veuillez choisir la taille des nombres avec lesquels vous allez jouer");

        //Permet au joueur de définir la taille des nombres qu'il faudra deviner.
        int NB_CHIFFRES = AskNumberUtils.mastermind1();
        int scoreJoueur = 0;
        int scoreOrdi = 0;
        boolean victoire;
        //Tirage au sort pour savoir qui commence.
        int deroulement = Beginner.mastermindDuel();
        int manche = 1;

        //Si le joueur gagne le tirage au sort, il commence en attaque
        if (deroulement == 1) {

            //Boucle alertnant entre joueur et ordi en attaque
            //Seuls les attaquants peuvent marquer des points
            do {
                System.out.println("Manche " + manche + " round 1");
                if (PChall.modeDuel(NB_CHIFFRES) == true) {
                    scoreJoueur++;
                }
                System.out.println("Manche " + manche + " round 2");
                if (PDef.modeDuel(NB_CHIFFRES) == true) {
                    scoreOrdi++;
                }
                manche++;
                System.out.println("");
                System.out.println("Votre score est de " + scoreJoueur + " et celui de l'ordinateur " + scoreOrdi);
                System.out.println("");
                victoire = scoreJoueur == 3 || scoreOrdi == 3;
            }
            //Le mode duel s'arrête dès qu'un joueur a un score de 3
            while (!victoire);
            if (scoreJoueur == 3) {
                System.out.println("Bravo vous avez gagné, n'hésitez pas à remettre en jeu votre trophé si vous en avez le courage");
            } else {
                System.out.println("L'ordinateur a été meilleur cette fois mais ne vous en faites pas, c'est en persévérant que l'on devient meilleur ! Courage !!!");
            }
        }
        //Si le joueur perd le tirage, l'ordi commence
        else {
            //Boucle alternant entre ordi et joueur en attaque
            do {
                System.out.println("Manche " + manche + " round 1");
                if (PDef.modeDuel(NB_CHIFFRES) == true) {
                    scoreOrdi++;
                }
                System.out.println("Manche " + manche + " round 2");
                if (PChall.modeDuel(NB_CHIFFRES) == true) {
                    scoreJoueur++;
                }
                System.out.println("");
                System.out.println("Votre score est de " + scoreJoueur + " et celui de l'ordinateur " + scoreOrdi);
                System.out.println("");
                victoire = scoreJoueur == 3 || scoreOrdi == 3;
            }
            while (!victoire);
            if (scoreJoueur == 3) {
                System.out.println("Bravo vous avez gagné, n'hésitez pas à remettre en jeu votre titre si vous en avez le courage !");
            } else {
                System.out.println("L'ordinateur a été meilleur cette fois mais ne vous en faites pas, c'est en persévérant que l'on devient meilleur ! Courage !!!");
            }
        }
        fin();
    }

    public void fin() {
        int nbfin6 = FinUtils.finMenu();
        if (nbfin6 == 1) {
            System.out.println("");
            mode3();
        } else if (nbfin6 == 2) {
            System.out.println("");
            Appli Menu = new Appli();
            Menu.partieUn();
        } else {
            System.out.println("");
            System.out.println("Au revoir");
        }
    }
}
