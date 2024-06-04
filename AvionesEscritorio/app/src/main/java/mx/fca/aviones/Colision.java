package mx.fca.aviones;

public class Colision {

    int x;

    int y;

    public int image() {
        return R.mipmap.collision;
    }

    public Colision(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
