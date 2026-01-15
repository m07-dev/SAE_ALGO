import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SAé2Test {

    @Test
    void testTriABulle() {
        // Cas ou le tableau est desordonnée
        int[] tab = {12, 1, 8, 6, 18, 9};
        int[] attendu = {1, 6, 8, 9, 12, 18};
        assertArrayEquals(attendu, SAé2.triABulle(tab), "Le tableau devrait être trié par ordre croissant.");

        // Cas ou le tableau est deja trié
        int[] dejaTrie = {1, 2, 3, 4, 5};
        int[] attenduTrie = {1, 2, 3, 4, 5};
        assertArrayEquals(attenduTrie, SAé2.triABulle(dejaTrie), "Un tableau déjà trié ne devrait pas changer.");

        // Cas ou le tableau est triée a l'envers
        int[] envers = {5, 4, 3, 2, 1};
        int[] attenduEnvers = {1, 2, 3, 4, 5};
        assertArrayEquals(attenduEnvers, SAé2.triABulle(envers), "Un tableau trié à l'envers devrait être remis dans l'ordre.");

        // Cas ou le tableau est vide
        int[] vide = {};
        assertArrayEquals(new int[]{}, SAé2.triABulle(vide), "Un tableau vide devrait rester vide.");

        int[] unElement = {42};
        assertArrayEquals(new int[]{42}, SAé2.triABulle(unElement), "Un seul élément devrait rester comme il est .");
    }
    @Test
    void testALenvers() {
        // Cas ou le tableau est impai
        int[] impair = {1, 2, 3, 4};
        int[] attenduimPair = {4, 3, 2, 1};
        assertArrayEquals(attenduimPair, SAé2.aLenvers(impair), "Le tableau impair devrait être inversé.");

        // Cas ou le tableau est pair
        int[] pair = {10, 20, 30};
        int[] attendupair = {30, 20, 10};
        assertArrayEquals(attendupair, SAé2.aLenvers(pair), "Le tableau pair devrait être inversé.");

        // Cas ou il n'y a que un seul element dans le tableau
        int[] seul = {5};
        assertArrayEquals(new int[]{5}, SAé2.aLenvers(seul), "Un seul élément reste identique.");
    }
    @Test
    void testPlusProcheVal() {
        // Cas ou la valeur est dans le tableau
        int[] tab1 = {10, 20, 30};
        assertEquals(20, SAé2.plusProcheVal(tab1, 20), "doit retourne 20 car valeur presente dans le tableau.");

        // Cas ou la valeur plus proche est inferieur
        assertEquals(10, SAé2.plusProcheVal(tab1, 12), "doit retourner 10 pour une valeur de 12.");

        // Cas ou la valeur plus proche est superieur
        assertEquals(30, SAé2.plusProcheVal(tab1, 28), "doit retourner 30 pour une valeur de 28.");

        // Cas ou c'est egalite donc on prend la plus grande
        assertEquals(20, SAé2.plusProcheVal(tab1, 15), "En cas d'égalité (10 et 20 pour valeur 15), on prend le plus grand.");

        // Cas ou les valeurs recherche sont au extremités
        assertEquals(10, SAé2.plusProcheVal(tab1, -5), "valeur très petite : doit retourner le premier élément (10).");
        assertEquals(30, SAé2.plusProcheVal(tab1, 100), "valeur très grande : doit retourner le dernier élément (30).");

        // Cas ou les valeurs sont negatifs
        int[] tabNeg = {-50, -20, -10};
        assertEquals(-20, SAé2.plusProcheVal(tabNeg, -22), "Des valeurs negatif ");

        // Cas ou il y a un seul element dans le tableau
        int[] seul = {42};
        assertEquals(42, SAé2.plusProcheVal(seul, 10), "Un seul element.");
    }
    @Test
    void testRechercheDichoPlusProche() {
        // on crée un tableau deja triée
        int[] tableau = {2, 5, 10, 20, 30};

        // Cas ou la valeur existe
        assertEquals(10, SAé2.rechercheDichoPlusProche(tableau, 10), "elle doit retournée 10 .");

        // Cas ou la valeur plus proche est inferieur
        assertEquals(5, SAé2.rechercheDichoPlusProche(tableau, 6), "Pour la valeur 6, le plus proche est 5.");

        // Cas ou la valeur plus proche est superieur
        assertEquals(30, SAé2.rechercheDichoPlusProche(tableau, 28), "Pour la valeur 28, le plus proche est 30.");

        // Cas ou la valeur plus proche est a egalité
        assertEquals(30, SAé2.rechercheDichoPlusProche(tableau, 25), "En cas d'égalité entre 20 et 30 pour la valeur 25, on choisit 30.");

        // Cas ou la valeur est en dehors du tableau
        assertEquals(2, SAé2.rechercheDichoPlusProche(tableau, 0), "Doit retourné 2");
        assertEquals(30, SAé2.rechercheDichoPlusProche(tableau, 100), "Doit retourné 30 .");

        // Cas ou le tableau n'a qu'un seul elements
        int[] unElement = {15};
        assertEquals(15, SAé2.rechercheDichoPlusProche(unElement, 50), "Doit fonctionner si le tableau ne contient qu'un seul élément.");

        // Cas avec des valeurs negatifs
        int[] tabNeg = {-20, -10, 0, 10};
        assertEquals(-10, SAé2.rechercheDichoPlusProche(tabNeg, -12), "Doit fonctionner avec des valeurs négatives.");
    }
}
