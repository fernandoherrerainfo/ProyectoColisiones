package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class Analizador {

    // Memoria utiliza un hashmap
    // Llave = numero de paso
    // Valor = plano
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
            // Por mejorar algoritmo
            ArrayList<Colision> colisiones = new ArrayList<>();
            for (int i = 0; i < nuevosAviones.size(); i++) {
                for (int j = i + 1; j < nuevosAviones.size(); j++) {
                    if (nuevosAviones.get(i).colisionaCon(nuevosAviones.get(j))) {
                        colisiones.add(new Colision(nuevosAviones.get(j).getX(), nuevosAviones.get(j).getY()));
                    }
                }
            }
            Plano planoNuevo = new Plano(noPaso, nuevosAviones, colisiones);
            for (Colision colision: colisiones) {
                Avion avion = planoNuevo.getAvion(colision.x, colision.y);
                if (avion != null){
                    planoNuevo.aviones.removeIf(p -> p.getX() == avion.getX() && p.getY() == avion.getY() );
                }
            }
            memoria.put(noPaso, planoNuevo);
            return planoNuevo;
        }
    }

    public static Plano prev(int noPaso) {
        return memoria.get(noPaso);
    }
    public static int contarColisiones(Plano plano) {
        return plano.colisiones.size();
    }

    public static int maximo() {
        // MAXIMOS
        Plano plano = memoria.get(0);
        if (plano == null) { return 0; }
        int tmp = 0;
        for (Avion avion : plano.getAviones()) {
            if (avion.getX() > tmp) {
                tmp = avion.getX();
            }
        }
        return tmp + 1;
    }
}

