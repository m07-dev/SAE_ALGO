import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SAé2Test {

    @Test
    void testPlusProcheVal() {
        // Préparation des données
        int[] tableau = new int[]{12, 1, 8, 6, 18, 9};

        // Exécution et Vérification
        // On s'attend à ce que pour la valeur 8, le résultat soit 8
        assertEquals(8, SAé2.plusProcheVal(tableau, 8), "Le test devrait retourner 8 car la valeur exacte existe.");

        // Test d'un cas différent (valeur proche mais pas exacte)
        assertEquals(12, SAé2.plusProcheVal(tableau, 13), "Le test devrait retourner 12 pour une cible de 13.");


    }
}