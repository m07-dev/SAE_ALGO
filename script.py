import random


def generer_donnees(longueur):
    # Bornes d'un entier 32 bits signé (comme le int de Java)
    min_int = -2 ** 31
    max_int = 2 ** 31 - 1

    # Création de la liste avec une boucle (compréhension de liste)
    t = [random.randint(min_int, max_int) for _ in range(longueur)]

    return t

def tri_a_bulle(t):
    n = len(t)
    for i in range(n - 1):
        for j in range(1, n - i):
            if t[j - 1] > t[j]:
                t[j - 1], t[j] = t[j], t[j - 1]

    return t

wma_liste = generer_donnees(25000)
liste_triee = tri_a_bulle(ma_liste)
print(liste_triee)