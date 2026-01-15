    #include <stdio.h>
    #include <stdlib.h>
    #include <time.h>
    #include <limits.h>

    /* Génère un tableau de longueur n avec des entiers 32 bits signés */
    int* generer_donnees(int n) {
    int* t = malloc(n * sizeof(int));
    if (t == NULL) return NULL;

    for (int i = 0; i < n; i++) {
        /* On combine deux rand (15 ou 31 bits) pour remplir les 32 bits de l'entier */
        /* Cela génère naturellement des nombres positifs et négatifs */
        t[i] = (rand() << 16) ^ rand();
    }

    return t;
}

    /* Tri à bulle */
    void tri_a_bulle(int* t, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (t[j - 1] > t[j]) {
                    int tmp = t[j - 1];
                    t[j - 1] = t[j];
                    t[j] = tmp;
                }
            }
        }
    }

    int main() {    
        int n = 25000;

        /* Initialisation du générateur aléatoire */
        srand(time(NULL));

        int* ma_liste = generer_donnees(n);
        if (ma_liste == NULL) {
            return 1;
        }

        tri_a_bulle(ma_liste, n);

        /* Affichage (attention : très long !) */
        for (int i = 0; i < n; i++) {
            printf("%d ", ma_liste[i]);
        }
        printf("\n");

        free(ma_liste);
        return 0;
    }
