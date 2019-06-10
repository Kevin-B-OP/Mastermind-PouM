package com.opckev.JeuxEtMode.PouM;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.ConsoleUtils;

public class PouMDefenseur {
    public void mode2 (){
        System.out.println("Coucou2");
        System.out.println("Que souhaitez vous faire maintenant ?");
        System.out.println("1 - Rejouer une partie");
        System.out.println("2 - Revenir au menu de sélection");
        System.out.print("3 - Quitter l'application");
        int nbfin2= ConsoleUtils.afficherMenu("",3);
        if (nbfin2==1){
            mode2();
        }
        else if (nbfin2==2){
            Appli Menu = new Appli();
            Menu.partieUn();
        }
        else {
            System.out.println("Au revoir");
        }
    }
}
