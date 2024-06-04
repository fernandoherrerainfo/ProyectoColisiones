package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;
public class Planificador {

    public static Plano crearRutaInicial() {
        ArrayList<Avion> avionesIniciales = Aerolineas.AEROMEXICO(); // O cualquier otra aerolínea o método de generación de aviones inicial
        Plano inicial = new Plano(0, avionesIniciales, new ArrayList<>()); // Comienza en el paso 0
        Analizador.init(inicial);
        return inicial;
    }
}
