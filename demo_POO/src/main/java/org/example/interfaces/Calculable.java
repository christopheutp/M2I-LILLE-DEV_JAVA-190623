package org.example.interfaces;

public interface Calculable {
    double calculerAire();

    // Méthode par défaut pour calculer le périmetre
    default double calculerPerimetre(){
        return 0.0;
    }
}
