package mx.fca.aviones;

import java.util.ArrayList;
import java.util.HashMap;
public class Planificador {
    private HashMap<Integer, Plano> memoria;
    private int pasoActual;

    public Planificador() {
        memoria = new HashMap<>();
        pasoActual = 0;
    }

    public static Plano crearRutaInicial() {
        ArrayList<Avion> avionesIniciales = Aerolineas.AEROMEXICO(); // O cualquier otra aerolínea o método de generación de aviones inicial
        return new Plano(0, avionesIniciales); // Comienza en el paso 0
    }


    public void inicializarPlanos(Plano planoInicial) {

        memoria.put(0, planoInicial);
    }

    public void avanzar() {
        pasoActual++;
        if (!memoria.containsKey(pasoActual)) {
            Plano nuevoPlano = Analizador.next(pasoActual, getPlanoActual());
            memoria.put(pasoActual, nuevoPlano);
        }
    }

    public void retroceder() {
        if (pasoActual > 0) {
            pasoActual--;
        }
    }

    public Plano getPlanoActual() {
        return memoria.get(pasoActual);
    }

    public int contarColisiones(Plano plano) {
        int colisiones = 0;
        ArrayList<Avion> aviones = plano.getAviones();
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
