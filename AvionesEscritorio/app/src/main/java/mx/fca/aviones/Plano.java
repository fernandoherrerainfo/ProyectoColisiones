package mx.fca.aviones;

import java.util.ArrayList;

public class Plano {
    //Cambio parcialmente
    public ArrayList<Avion> aviones;

    public ArrayList<Colision> colisiones;

    public int col;
    public int row;
    public int noPaso;

    public Plano(int noPaso, ArrayList<Avion> aviones, ArrayList<Colision> colisiones) {
        this.noPaso = noPaso;
        this.aviones = aviones;
        this.colisiones = colisiones;

        // MAXIMOS
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
        noPaso += 1;
        return Analizador.next(noPaso, this);
    }

    public Plano prev() {
        noPaso -= 1;
        return Analizador.prev(noPaso);
    }

    public int gridSize() {
        return col * row;
    }

    public Avion getAvion(int x, int y) {
        for (Avion avion: aviones) {
            if (avion.getX() == x && avion.getY() == y){
                return avion;
            }
        }
        return null;
    }
}
