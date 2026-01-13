// package janv2026;

import java.util.Arrays;
import java.util.Random;

public class SAé2 {


    public static void main(String[] args) {
        //   int[] données = générerDonnéesEntreBornes(50, 0, 20);
        // System.out.println(Arrays.toString(données));

        int[] données = générerDonnées(10000000);

        Arrays.sort(données); // trie le tableau en utilisant un algorithme de type Quicksort

        //  System.out.println(Arrays.toString(données));
    }

    /*
        Retourne un tableau de int de la longueur demandée rempli avec des valeurs aléatoires
        (valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */
    public static int[] générerDonnées(int longueur) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aléatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }

    /*
        Retourne un tableau de int de la longueur demandée rempli avec des valeurs aléatoires comprises entre min et max inclus.
    */
    public static int[] générerDonnéesEntreBornes(int longueur, int min, int max) {
        Random random = new Random();
        int[] t = new int[longueur];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(max-min+1)+min; // nextInt(borne) retourne un int compris entre 0 inclus et borne exclus.
        return t;
    }

}
