package com.opckev.JeuxEtMode.PouM;

import com.opckev.Appli;
import com.opckev.JeuxEtMode.Utils.ConsoleUtils;

public class PouMDuel {
    public void mode3 (){
        System.out.println("Coucou3");
        System.out.println("Que souhaitez vous faire maintenant ?");
        System.out.println("1 - Rejouer une partie");
        System.out.println("2 - Revenir au menu de sélection");
        System.out.print("3 - Quitter l'application");
        int nbfin3= ConsoleUtils.afficherMenu("",3);
        if (nbfin3==1){
            mode3();
        }
        else if (nbfin3==2){
            Appli Menu = new Appli();
            Menu.partieUn();
        }
        else {
            System.out.println("Au revoir");
        }
    }
}
