package com.opckev.JeuxEtMode.Utils.PouM;

import java.util.Arrays;
import java.util.Random;

public class PouMDef {
    public static boolean ordiPouM(int solution[], int essais) {
        boolean victoire = false;
        Random r = new Random();
        int r1[] = new int[solution.length];
        int r2[] = new int[solution.length];
        int c1[] = new int[solution.length];
        int c2[] = new int[solution.length];
        int max = 9;
        int min = 0;
        int count = 0;

        for (int i = 0; i < solution.length; i++) {
            r1[i] = min + (int) (Math.random() * ((max - min) + 1));
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
                    max = r1[i]-1;
                    c1[i]=10;
                } else if (solution[i] > r1[i]) {
                    min = r1[i]+1;
                    c1[i]=10;
                }
            }
            do {
                for (int y = 0; y < solution.length; y++) {
                    if (c1[y]==10){
                    r2[y] = min + (int) (Math.random() * ((max - min) + 1));
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
                            max = r2[u]-1;
                            c1[u]=10;
                        } else if (solution[u] > r2[u]) {
                            min = r2[u]+1;
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
