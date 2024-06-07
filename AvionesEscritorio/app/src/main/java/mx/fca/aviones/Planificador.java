package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;
public class Planificador {

    //No se necesita ningun cambio

    public static Plano crearRutaInicial() {
        ArrayList<Avion> avionesIniciales = Aerolineas.AEROMEXICO();
        Plano inicial = new Plano(0, avionesIniciales, new ArrayList<>());
        Analizador.init(inicial);
        return inicial;
    }
}
