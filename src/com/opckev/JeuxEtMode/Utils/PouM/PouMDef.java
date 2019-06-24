package com.opckev.JeuxEtMode.Utils.PouM;

import java.util.Arrays;

public class PouMDef {
    /**
     * Mode défenseur du jeu Plus ou moins
     * @param solution Nombre que doit deviner l'ordinateur. Il est donné par le joueur
     * @param essais nombre de tentatives disponibles
     * @return gagnant de la manche
     */
    public static boolean ordiPouM(int solution[], int essais) {
        boolean victoire = false;

        int r1[] = new int[solution.length];
        int r2[] = new int[solution.length];
        int c1[] = new int[solution.length];
        int max[] = new int [solution.length];
        int min[] = new int [solution.length];
        int count = 0;

        for (int g = 0; g < solution.length; g++){
            max[g]=9;
        }
        for (int g = 0; g <solution.length; g++){
            min[g]=0;
        }

        for (int i = 0; i < solution.length; i++) {
            r1[i] = 0+(int) (Math.random() * ((9 - 0) + 1));
        }
        count++;
        int vrai = Score2Utils.verification(r1, solution);
        if (vrai == solution.length) {
            victoire = true;
            System.out.println("Proposition de l'ordinateur : " + Arrays.toString(r1));
            System.out.println("L'ordinateur a gagné en " + count + " tentative");

        } else {
            System.out.println("Proposition de l'ordinateur pour la tentative " + count + " : " + Arrays.toString(r1));
            for (int i = 0; i < solution.length; i++) {
                if (solution[i] == r1[i]) {
                    c1[i] = r1[i];
                } else if (solution[i] < r1[i]) {
                    max[i] = r1[i]-1;
                    c1[i]=10;
                } else if (solution[i] > r1[i]) {
                    min[i] = r1[i]+1;
                    c1[i]=10;
                }
            }
            do {
                for (int y = 0; y < solution.length; y++) {
                    if (c1[y]==10){
                    r2[y] = min[y] + (int) (Math.random() * ((max[y] - min[y]) + 1));
                    }
                    else{
                        r2[y]=c1[y];
                    }
                }
                count++;
                int vrai2 = Score2Utils.verification(r2, solution);
                if (vrai2 == solution.length) {
                    victoire = true;
                    System.out.println("Proposition de l'ordinateur : " + Arrays.toString(r2));
                    System.out.println("L'ordinateur a gagné en " + count + " tentative");

                } else {
                    System.out.println("Proposition de l'ordinateur pour la tentative " + count + " : " + Arrays.toString(r2));
                    for (int u = 0; u < solution.length; u++) {
                        if (solution[u] == r2[u]) {
                            c1[u] = r2[u];
                        } else if (solution[u] < r2[u]) {
                            max[u] = r2[u]-1;
                            c1[u]=10;
                        } else if (solution[u] > r2[u]) {
                            min[u] = r2[u]+1;
                            c1[u]=10;
                        }
                    }
                }
            }
            while (!victoire && count < essais);
        }
        return victoire;
    }
}
