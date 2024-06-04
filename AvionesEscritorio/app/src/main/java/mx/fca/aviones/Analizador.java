package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;

public class Analizador {

    static HashMap<Integer, Plano> memoria = new HashMap<>();

    public static Plano next(int noPaso, Plano plano) {
        int siguientePaso = noPaso + 1;
        if (memoria.containsKey(siguientePaso)) {
            return memoria.get(siguientePaso);
        } else {
            ArrayList<Avion> nuevosAviones = new ArrayList<>();
            for (Avion avion : plano.getAviones()) {
                Avion nuevoAvion = new Avion(avion.getDireccion(), avion.getX(), avion.getY());
                nuevoAvion.mover();
                nuevosAviones.add(nuevoAvion);
            }
            Plano planoNuevo = new Plano(siguientePaso, nuevosAviones);
            memoria.put(siguientePaso, planoNuevo);
            return planoNuevo;
        }
    }

    public static Plano prev(int noPaso) {
        int pasoAnterior = noPaso - 1;
        return memoria.get(pasoAnterior);
    }
}

