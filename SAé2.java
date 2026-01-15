import java.util.Arrays;
import java.util.Random;

public class SAé2 {


    public static void main(String[] args) {
        //   int[] données = générerDonnéesEntreBornes(50, 0, 20);
        // System.out.println(Arrays.toString(données));

        int[] données = générerDonnées(10000000);

        Arrays.sort(données);
        rechercheDichoPlusProche(données,13);
        // System.out.println(rechercheDichoPlusProche(tableau,13));



        // Arrays.sort(données); // trie le tableau en utilisant un algorithme de type Quicksort

        // System.out.println(Arrays.toString(données));
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
    // Trie a bullé qui trie le tableau donné en ordre croissant
    public static int[] triABulle(int[] t) {
        int n = t.length;
        for (int i = 0; i < n - 1; i++) {
            int temp = 0;
            for (int j = 1; j < n - i; j++) {
                if (t[j - 1] > t[j]) {
                    temp = t[j - 1];
                    t[j - 1] = t[j];
                    t[j] = temp;
                }
            }
        }
        return t;
    }
    // fonction qui retourne un tableau a l'envers
    public static int[] aLenvers(int[] t) {
        int n = t.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = t[i];
            t[i] = t[n - i - 1];
            t[n - i - 1] = temp;
        }
        return t;
    }
     /*Recherche dans un tableau de int de longueur > 0 la valeur la plus proche d’une valeur donnée (si deux
    valeurs sont à égale distance de la valeur cherchée, on prend la plus grande).*/
    public static int plusProcheVal(int[] t, int val) {
        int proche = t[0];
        for (int i = 0; i < t.length; i++) {
            int distanceActuelle = Math.abs(t[i] - val);
            int distanceMeilleure = Math.abs(proche - val);
            if (distanceActuelle < distanceMeilleure) {
                proche = t[i];
            }
            else if(distanceActuelle == distanceMeilleure) {
                if(t[i] > proche) {
                    proche = t[i];
                }
            }
        }
        return proche;
    }
    // Cette fonction recherche l'indice d'une valeur dans un tableau trié par dichotomie et retourne -1 si la valeur n'est pas trouvée
    public static int rechercheDicho(int[] t, int val) {
        int indDebut = 0;
        int indFin = t.length - 1;
        // On boucle tant que la zone de recherche est valide
        while (indDebut <= indFin) {
            // On calcule le milieu DANS la boucle
            int indMoyen = (indDebut + indFin) / 2;
            // 2. Si on trouve la valeur, on retourne l'index immédiatement
            if (t[indMoyen] == val) {
                return indMoyen;
            }
            // Si la valeur cherchée est plus grande, on regarde la moitié droite
            else if (val > t[indMoyen]) {
                indDebut = indMoyen + 1;
            }
            // Sinon, on regarde la moitié gauche
            else {
                indFin = indMoyen - 1;
            }
        }
        // Si on sort de la boucle, c'est que la valeur n'est pas dans le tableau
        return -1;
    }
    /* recherche par dichotomie de la plus proche valeur d’une valeur de type int dans un tableau de
    int.*/
    public static int rechercheDichoPlusProche(int[] t, int val) {
        if (t == null || t.length == 0) return 0;
        int indDebut = 0;
        int indFin = t.length - 1;
        // On initialise le plus proche avec la première case
        int plusProche = t[0];
        while (indDebut <= indFin) {
            int indMoyen = (indDebut + indFin) / 2;
            int valMoyen = t[indMoyen];
            // Si on tombe sur la valeur, c'est la plus proche
            if (valMoyen == val) {
                return valMoyen;
            }
            int distActuelle = Math.abs(valMoyen - val);
            int distMeilleure = Math.abs(plusProche - val);
            // Si la valeur du milieu est plus proche que l'actuelle
            if (distActuelle < distMeilleure) {
                plusProche = valMoyen;
            }
            // si egalité
            else if (distActuelle == distMeilleure) {
                if (valMoyen > plusProche) {
                    plusProche = valMoyen;
                }
            }
            // deplacement dichotomique
            if (val > valMoyen) {
                indDebut = indMoyen + 1; // On cherche à droite
            } else {
                indFin = indMoyen - 1;   // On cherche à gauche
            }
        }
        return plusProche;
    }
}
