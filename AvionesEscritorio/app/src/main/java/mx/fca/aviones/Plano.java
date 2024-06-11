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
        int size = Analizador.maximo();
        return (size) * (size);
    }

    public Avion getAvion(int x, int y) {
        for (Avion avion: aviones) {
            if (avion.getX() == x && avion.getY() == y){
                return avion;
            }
        }
        return null;
    }

    public Colision getColision(int x, int y) {
        for (Colision colision: colisiones) {
            if (colision.getX() == x && colision.getY() == y){
                return colision;
            }
        }
        return null;
    }
}
