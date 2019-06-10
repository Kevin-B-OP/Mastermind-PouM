package com.opckev;

import com.opckev.JeuxEtMode.Mastermind.MastermindChallenger;
import com.opckev.JeuxEtMode.Mastermind.MastermindDefenseur;
import com.opckev.JeuxEtMode.Mastermind.MastermindDuel;
import com.opckev.JeuxEtMode.PouM.PouMChallenger;
import com.opckev.JeuxEtMode.PouM.PouMDefenseur;
import com.opckev.JeuxEtMode.PouM.PouMDuel;
import com.opckev.JeuxEtMode.Utils.ConsoleUtils;

public class Appli {

    public static void partieUn(){
        System.out.println("Bonjour et bienvenue sur cette plateforme de jeux");
        System.out.println("Que souhaitez vous faire ?");
        System.out.println("1 - Jouer au + ou -");
        System.out.println("2 - Jouer au Mastermind");
        System.out.print("3 - Sortir de l'application");
        int nbresponse= ConsoleUtils.afficherMenu("",3);
        System.out.println(" ");
        if (nbresponse==1){
            System.out.println("A quel mode de jeu voulez vous jouer ?");
            System.out.println("1 - Mode challenger");
            System.out.println("2 - Mode défenseur");
            System.out.println("3 - Mode duel");
            System.out.print("4 - Revenir au menu");
            int nbmenu=ConsoleUtils.afficherMenu("",4);
            System.out.println(" ");
            if (nbmenu==1){
                PouMChallenger Jeu = new PouMChallenger();
                Jeu.mode1();
            }
            else if (nbmenu==2){
                PouMDefenseur Jeu = new PouMDefenseur();
                Jeu.mode2();

            }
            else if (nbmenu==3){
                PouMDuel Jeu = new PouMDuel();
                Jeu.mode3();
            }
            else{
                partieUn();
            }
        }

        else if (nbresponse==2){
            System.out.println("A quel mode de jeu voulez vous jouer ?");
            System.out.println("1 - Mode challenger");
            System.out.println("2 - Mode défenseur");
            System.out.println("3 - Mode duel");
            System.out.print("4 - Revenir au menu");
            int nbmenu=ConsoleUtils.afficherMenu("",4);
            System.out.println(" ");
            if (nbmenu==1){
                MastermindChallenger Jeu = new MastermindChallenger();
                Jeu.mode4();
            }
            else if (nbmenu==2){
                MastermindDefenseur Jeu = new MastermindDefenseur();
                Jeu.mode5();
            }
            else if (nbmenu==3){
                MastermindDuel Jeu = new MastermindDuel();
                Jeu.mode6();
            }
            else{
                partieUn();
            }
        }

        else {
            System.out.println("Au revoir et merci pour votre visite");
        }
    }
}