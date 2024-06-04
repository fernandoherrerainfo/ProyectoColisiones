package mx.fca.aviones;

import java.util.ArrayList;

public class Plano {
    //Cambio parcialmente
    public ArrayList<Avion> aviones;
    public int col;
    public int row;
    public int noPaso;

    public Plano(int noPaso, ArrayList<Avion> aviones) {
        this.noPaso = noPaso;
        this.aviones = aviones;

        int tmpX = 0;
        int tmpY = 0;
        for (Avion avion : aviones) {
            if (avion.getX() > tmpX) {
                tmpX = avion.getX();
            }
            if (avion.getY() > tmpY) {
                tmpY = avion.getY();
            }
        }
        col = tmpX;
        row = tmpY;
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public Plano next() {
        return Analizador.next(noPaso + 1, this);
    }

    public Plano prev() {
        return Analizador.prev(noPaso - 1);
    }

    public int contarColisiones() {
        int colisiones = 0;
        for (int i = 0; i < aviones.size(); i++) {
            for (int j = i + 1; j < aviones.size(); j++) {
                if (aviones.get(i).colisionaCon(aviones.get(j))) {
                    colisiones++;
                }
            }
        }
        return colisiones;
    }
}
