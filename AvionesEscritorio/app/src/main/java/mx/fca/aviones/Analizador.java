package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;

public class Analizador {

    static HashMap<Integer, Plano> memoria = new HashMap<>();

    public static void init(Plano plano){

        memoria.put(0, plano);
    }

    public static Plano next(int noPaso, Plano plano) {
        if (memoria.containsKey(noPaso)) {
            return memoria.get(noPaso);
        } else {
            ArrayList<Avion> nuevosAviones = new ArrayList<>();
            for (Avion avion : plano.getAviones()) {
                Avion nuevoAvion = new Avion(avion.getDireccion(), avion.getX(), avion.getY());
                nuevoAvion.mover();
                nuevosAviones.add(nuevoAvion);
            }

             /// Aqui calculamos colisiones
            ArrayList<Colision> colisiones = new ArrayList<>();
            for (int i = 0; i < nuevosAviones.size(); i++) {
                for (int j = i + 1; j < nuevosAviones.size(); j++) {
                    if (nuevosAviones.get(i).colisionaCon(nuevosAviones.get(j))) {
                        colisiones.add(new Colision(nuevosAviones.get(j).getX(), nuevosAviones.get(j).getY()));
                    }
                }
            }
            Plano planoNuevo = new Plano(noPaso, nuevosAviones, colisiones);
            memoria.put(noPaso, planoNuevo);
            return planoNuevo;
        }
    }

    public static Plano prev(int noPaso) {

        return memoria.get(noPaso);
    }
    public static int contarColisiones(Plano plano) {

        int colisiones = 0;
        ArrayList<Avion> aviones = plano.aviones;
        for (int i = 0; i < aviones.size(); i++) {
            for (int j = i + 1; j < aviones.size(); j++) {
                if (aviones.get(i).getX() == aviones.get(j).getX() && aviones.get(i).getY() == aviones.get(j).getY()) {
                    colisiones++;
                }
            }
        }
        return colisiones;
    }
}

